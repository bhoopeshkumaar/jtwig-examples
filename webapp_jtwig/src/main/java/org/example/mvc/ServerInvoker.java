package org.example.mvc;

public class ServerInvoker
{
	public static void main(String... anArgs) throws Exception {
        new ServerInvoker().start();
    }
	
	private WebServer server;
    
    public ServerInvoker()
    {
        server = new WebServer(8080);        
    }
    
    public void start() throws Exception
    {
        server.start();        
        server.join();
    }
}
