//package io.github.kimmking.gateway.outbound.netty4;
////
////import io.netty.channel.ChannelHandlerContext;
////import io.netty.channel.ChannelInboundHandlerAdapter;
////import io.netty.handler.codec.http.FullHttpRequest;
////
////public class NettyHttpClientOutboundHandler  extends ChannelInboundHandlerAdapter {
////
////    @Override
////    public void channelActive(ChannelHandlerContext ctx)
////            throws Exception {
////
////        System.out.println("开始连接");
////    }
////
////    @Override
////    public void channelRead(ChannelHandlerContext ctx, Object msg)
////            throws Exception {
////        FullHttpRequest fullHttpRequest = (FullHttpRequest)msg;
////        System.out.println(fullHttpRequest.uri());
////
////    }
////}