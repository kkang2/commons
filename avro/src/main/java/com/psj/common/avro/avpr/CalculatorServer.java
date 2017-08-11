package com.psj.common.avro.avpr;

import java.io.IOException;
import java.net.InetSocketAddress;

import org.apache.avro.AvroRemoteException;
import org.apache.avro.ipc.NettyServer;
import org.apache.avro.ipc.NettyTransceiver;
import org.apache.avro.ipc.Server;
import org.apache.avro.ipc.specific.SpecificRequestor;
import org.apache.avro.ipc.specific.SpecificResponder;

/*http://debop.blogspot.kr/2013/04/apache-avro-rpc-by-java.html
*/
public class CalculatorServer {
	public static class CalculatorImpl implements Calculator {

        @Override
        public double add(double x, double y) throws AvroRemoteException {
            return x + y;
        }

        @Override
        public double subtract(double x, double y) throws AvroRemoteException {
            return x - y;
        }
    }

    private static Server calcServer;
    private static final int CALC_SERVER_PORT = 65123;

    private static void startServer() throws IOException {
        calcServer = new NettyServer(new SpecificResponder(Calculator.class, new CalculatorImpl()),
                                     new InetSocketAddress(CALC_SERVER_PORT));
    }
    
	public static void main(String[] args) throws Exception {
		System.out.println("Starting server...");
        startServer();
        System.out.println("Server started");

        NettyTransceiver calcClient = new NettyTransceiver(new InetSocketAddress(CALC_SERVER_PORT));
        Calculator proxy = (Calculator) SpecificRequestor.getClient(Calculator.class, calcClient);

        System.out.println("Client built, get proxy");
        System.out.println("add(2, 3)=" + proxy.add(2, 3));
        System.out.println("subtract(5, 1)=" + proxy.subtract(5, 1));
        
        /* 비동기 구현방법(http://debop.blogspot.kr/2013/04/apache-avro-idl-protocol.html)
        NettyTransceiver calcClient = new NettyTransceiver(new InetSocketAddress(CALC_SERVER_PORT));
        Calculator.Callback proxy = (Calculator.Callback) SpecificRequestor.getClient(Calculator.Callback.class, calcClient);

        System.out.println("Client built, get proxy");
        proxy.add(2, 3, new Callback<Double>() {
            @Override
            public void handleResult(Double result) {
                System.out.println("Callback... add(2, 3)=" + result);
            }

            @Override
            public void handleError(Throwable error) {
                System.out.println("예외가 발생했습니다. error=" + error.getMessage());
            }
        });

        CallFuture<Double> asyncResult = new CallFuture<Double>();
        proxy.add(2, 3, asyncResult);

        Thread.sleep(10);

        if (asyncResult.isDone())
            System.out.println("CallFuture... add(2,3)=" + asyncResult.get());*/

        calcClient.close();
        calcServer.close();
	}
}
