/*
 * Copyright 2012 The Netty Project
 *
 * The Netty Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package com.lee.vrg.socket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpContentCompressor;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * Please refer to the {@link CorsConfig} javadocs for information about all the
 * configuration options available.
 * 
 * Below are some of configuration discussed in this example:
 * <h3>Support only a specific origin</h3> To support a single origin instead of
 * the wildcard use the following:
 * 
 * <pre>
 * CorsConfig corsConfig = CorsConfig.withOrigin("http://domain1.com")
 * </pre>
 * 
 * <h3>Enable loading from the file system</h3> To enable the server to handle
 * an origin specified as 'null', which happens when a web browser loads a file
 * from the local file system use the following:
 * 
 * <pre>
 * corsConfig.isNullOriginAllowed()
 * </pre>
 * 
 * <h3>Enable request headers</h3> To enable additional request headers:
 * 
 * <pre>
 * corsConfig.allowedRequestHeaders(&quot;custom-request-header&quot;)
 * </pre>
 * 
 * <h3>Expose response headers</h3> By default a browser only exposes the
 * following simple header:
 * <ul>
 * <li>Cache-Control</li>
 * <li>Content-Language</li>
 * <li>Content-Type</li>
 * <li>Expires</li>
 * <li>Last-Modified</li>
 * <li>Pragma</li>
 * </ul>
 * Any of the above response headers can be retreived by:
 * 
 * <pre>
 * xhr.getResponseHeader(&quot;Content-Type&quot;);
 * </pre>
 * 
 * If you need to get access to other headers this must be enabled by the
 * server, for example:
 * 
 * <pre>
 * corsConfig.exposedHeaders(&quot;custom-response-header&quot;);
 * </pre>
 */
@Component("socketJsonServerInitializer")
public class SocketJsonServerInitializer extends ChannelInitializer<SocketChannel> {

	@Autowired
	private ChannelHandler socketJsonServerHandler;

	@Value("${is.gzip}")
	private boolean isGzip;

	@Override
	public void initChannel(SocketChannel ch) throws Exception {
		ChannelPipeline pipeline = ch.pipeline();
		pipeline.addLast("http-codec", new HttpServerCodec());
		pipeline.addLast("aggregator", new HttpObjectAggregator(512000));
		pipeline.addLast("deflater", new HttpContentCompressor());
//		pipeline.addLast("handshake", new WebSocketServerProtocolHandler("", "", true));  //websocket的handler部分定义的，它会自己处理握手等操作
		pipeline.addLast("http-chunked", new ChunkedWriteHandler());
		pipeline.addLast("handler", socketJsonServerHandler);

	}

}
