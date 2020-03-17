package com.chenws.netty.tcp.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author chenws
 * @date 2020/03/17 14:57:34
 */
@ChannelHandler.Sharable
public class TCPNettyHandler extends SimpleChannelInboundHandler<ByteBuf> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
        byte[] bytes = new byte[msg.readableBytes()];
        msg.readBytes(bytes);
        String message = new String(bytes);
        System.out.println(message);
        //把消息写到缓冲区
        ctx.write("I get the message " + message);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        //刷新缓冲区，把消息发出去
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        //异常处理，如果该handler不处理，将会传递到下一个handler
        cause.printStackTrace();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush("connect success!");
    }
}
