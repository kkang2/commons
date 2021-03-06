package com.psj.common.avro.avdl;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.avro.AvroRemoteException;
import org.apache.avro.ipc.NettyServer;
import org.apache.avro.ipc.NettyTransceiver;
import org.apache.avro.ipc.Server;
import org.apache.avro.ipc.specific.SpecificRequestor;
import org.apache.avro.ipc.specific.SpecificResponder;
import org.apache.avro.util.Utf8;

import avro.shaded.com.google.common.collect.Lists;
import avro.shaded.com.google.common.collect.Maps;

/* http://debop.blogspot.kr/2013/04/apache-avro-idl-rpc.html */
public class SearchServiceServer {
	public static class SearchServiceImpl implements SearchService {

        @Override
        public CharSequence ping() throws AvroRemoteException {
            return new Utf8("PONG");
        }

        @Override
        public int persist(CharSequence id, Entity entity) throws AvroRemoteException {
            System.out.printf("\nPersist entity. id=%s, entity=%s", id, entity);
            return 1;
        }

        @Override
        public int persistAll(List<Entity> entities) throws AvroRemoteException {
            System.out.printf("\nPersist entities. entity count=%d", entities.size());
            return entities.size();
        }

        @Override
        public SearchResult search(CharSequence queryString, int pageNo, int pageSize) throws AvroRemoteException {
            System.out.printf("\nsearch... queryString=%s, pageNo=%d, pageSize=%d", queryString, pageNo, pageSize);

            // 검색된 엔티티들
            List<Entity> entities = Lists.newArrayListWithCapacity(pageSize);
            Map<String, String> attrs = Maps.newHashMap();
            attrs.put("SR-NO", "00001");
            attrs.put("SR-TYPE", "장비 불량");

            for (int i = 0; i < pageSize; i++) {
                entities.add(createSampleEntity(i, attrs));
            }

            return SearchResult.newBuilder()
                    .setPageNo(pageNo)
                    .setPageSize(pageSize)
                    .setPageCount(12)
                    .setTotalItemCount(pageSize * 12)
                    .setEntities(entities)
                    .build();
        }

    }

    public static Entity createSampleEntity(int i, Map attrs) {
        return Entity.newBuilder()
                .setRowId("ROW-" + i)
                .setCreatedAt(new Date().toString())
                .setText("entity")
                .setAttrs(attrs)
                .build();
    }

    private static Server searchServer;

    private static final int SEARCH_SERVER_PORT = 65123;

    private static void startServer() throws IOException {
        searchServer = new NettyServer(new SpecificResponder(SearchService.class, new SearchServiceImpl()),
                                       new InetSocketAddress("localhost", SEARCH_SERVER_PORT));
    }


    public static void main(String[] args) throws Exception {
        System.out.println("Starting server...");
        startServer();
        System.out.println("Server started");

        NettyTransceiver searchClient = new NettyTransceiver(new InetSocketAddress("localhost", SEARCH_SERVER_PORT));
        SearchService searchService = (SearchService) SpecificRequestor.getClient(SearchService.class, searchClient);

        System.out.println("Client built, get proxy");
        System.out.println("ping()=> " + searchService.ping());

        Map<String, String> attrs = Maps.newHashMap();
        attrs.put("SR-NO", "00001");
        attrs.put("SR-TYPE", "장비 불량");

        searchService.persist("ROW-1", createSampleEntity(1, attrs));

        List<Entity> entities = Lists.newArrayListWithCapacity(1000);
        for (int i = 0; i < 1000; i++) {
            entities.add(createSampleEntity(i, attrs));
        }

        int count = searchService.persistAll(entities);
        System.out.println("\nPersist count=" + count);

        SearchResult searchResult = searchService.search("en*", 1, 10);
        System.out.println("\nSearchResult=" + searchResult);


        searchClient.close();
        searchServer.close();
    }
}
