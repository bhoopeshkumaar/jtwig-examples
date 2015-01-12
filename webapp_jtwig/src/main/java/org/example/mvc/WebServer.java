package org.example.mvc;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerCollection;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.nio.SelectChannelConnector;
import org.eclipse.jetty.webapp.WebAppContext;

public class WebServer
{
	private static final String WEBAPP_PATH = "src/main/java/META-INF/webapp";
	
	private Server server;
	private int port;

	public WebServer(int aPort){
		port = aPort;
	}
	public void start() throws Exception
	{
		server = new Server();
		server.addConnector(createConnector());
		server.setHandler(createHandlers());        
		server.setStopAtShutdown(true);
		server.start();       
	}

	public void join() throws InterruptedException
	{
		server.join();
	}

	public void stop() throws Exception
	{        
		server.stop();
	}

	private SelectChannelConnector createConnector()
	{
		SelectChannelConnector connector = new SelectChannelConnector();
		connector.setPort(port);       
		return connector;
	}

	private HandlerCollection createHandlers()
	{                
		WebAppContext ctx = new WebAppContext();
		
		ctx.setContextPath("/");
		ctx.setWar(WEBAPP_PATH);
		
		List<Handler> handlers = new ArrayList<Handler>();
		handlers.add(ctx);

		HandlerList contexts = new HandlerList();
		contexts.setHandlers(handlers.toArray(new Handler[0]));

		HandlerCollection result = new HandlerCollection();
		result.setHandlers(new Handler[] {contexts});
		return result;
	}
}
