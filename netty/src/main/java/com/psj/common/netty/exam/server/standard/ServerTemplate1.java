package com.psj.common.netty.exam.server.standard;

import java.net.InetSocketAddress;

import com.psj.common.netty.exam.server.standard.handler.ServerTemplate1Handler;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class ServerTemplate1 {
	private int port;
	
	public void start() throws Exception {
		ServerTemplate1Handler handler = new ServerTemplate1Handler();
        EventLoopGroup group = new NioEventLoopGroup();
        
        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            
            bootstrap.group(group)
                .channel(NioServerSocketChannel.class)
                .localAddress(new InetSocketAddress(this.port))
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel channel) throws Exception {
                        channel.pipeline().addLast(handler); // ChannelHandler 등록
                    }
                });
            
            ChannelFuture future = bootstrap.bind().sync();
            
            future.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully().sync();
        }
    }
}