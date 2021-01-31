package com.test.netty.http;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ServerChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

public class HttpServerInitializer extends ChannelInitializer<NioSocketChannel> {
    @Override
    protected void initChannel(NioSocketChannel serverChannel) throws Exception {
        serverChannel.pipeline().addLast(new HttpServerCodec());
        serverChannel.pipeline().addLast(new MyHandler());
    }
}
