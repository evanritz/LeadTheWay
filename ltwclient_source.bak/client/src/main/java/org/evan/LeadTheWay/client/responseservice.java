package org.evan.LeadTheWay.client;

import java.util.Map;
import java.util.logging.Logger;

import fi.iki.elonen.NanoHTTPD.Response;

public class responseservice extends httpresponseservice{

	private server server;
	private filehandler filehandler;
	
	public responseservice(hostname client_hostname, server server, String dir_name)
	{
		filehandler = new filehandler(dir_name);
		this.server = server;
		if (client_hostname.hostname == null || server.hostname == null) { client_hostname.set(filehandler.readHostname()); server.set(filehandler.readServer()); }
		else { filehandler.writeHostname(client_hostname); filehandler.writeServer(server); }
	}
	
	public Response changeServerAddress(Map<String, String> params)
	{
		System.out.printf(" -> Server address request running... \n");
		if (params.containsKey("server_hostname")) 
		{
			String server_hostname = params.get("server_hostname");
			server.hostname = server_hostname;
			System.out.printf("\t -> Server address changed. SERV_ADDR=%s\n", server_hostname);
			saveServer();
			System.out.printf(" -> Server address request done.\n");
			return ok();
		}
		return bad_request();
	}
	
	
	public void saveServer()
	{
		filehandler.writeServer(server);
	}
	
}
