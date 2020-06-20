package org.evan.LeadTheWay.server;

import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Logger;

import fi.iki.elonen.NanoHTTPD.Response;

public class responseservice extends httpresponseservice{
	
	private ArrayList<client> clients;
	private hostname serv_hostname;
	private filehandler filehandler;
	private smssender smssender;
	
	public responseservice(hostname serv_hostname, ArrayList<client> clients, String dir_name)
	{
		filehandler 		= new filehandler(dir_name);
		smssender			= new smssender();
		this.serv_hostname 	= serv_hostname;
		this.clients 		= clients;
		if (serv_hostname == null) { serv_hostname = filehandler.readHostname(); filehandler.readClients(clients); }
		else { filehandler.writeHostname(serv_hostname); }
	}
	
	public Response addClient(Map<String, String> params)
	{
		if (params.containsKey("client_hostname"))
		{
			String client_hostname = params.get("client_hostname");
			
			System.out.printf(" CLIENT - %s REQUESTING TO ADD ITSELF... \n", client_hostname);
			
			for (client client : clients)
			{
				if (client.hostname.equals(client_hostname))
					System.out.printf("\t -> Duped Client found, removing...\n"); return bad_request();
			}
			
			clients.add(new client(client_hostname));
			System.out.printf("\t -> Added new Client - %s to Client Array.\n", client_hostname);
			saveClients();
			System.out.printf(" CLIENT - %s WAS SUCCESSFULLY ADDED!\n", client_hostname);
			return ok();
		}
		return bad_request();
	}
	
	public Response setStatus(Map<String, String> params)
	{
		if (params.containsKey("client_hostname") && params.containsKey("status")) 
		{
			for (client client : clients)
			{ 
				String client_hostname = params.get("client_hostname");
				boolean status = Boolean.valueOf(params.get("status"));
				
				if (client.hostname.equals(client_hostname))
				{ 
					System.out.printf("SUCCESSFUL!\n");
					String status_response;
					
					if (status)
						status_response = "Smoke Detected! Possible Fire!";
					else
						status_response = "No Smoke Detected! All Clear!";
					
					client.status = status_response;
					
					System.out.printf("\t -> Changing status of Client - %s to %s\n", client.hostname, status_response);
					saveClients();
					
					if (status)
						smssender.sendMessage(client_hostname, status_response);
					
					return ok();
				}
				else { System.out.printf("FAILED!\n"); }
			}
		}
		return bad_request();
	}
		
	public Response setCustomName(Map<String, String> params)
	{
		if (params.containsKey("client_hostname") && params.containsKey("name"))
		{
			for (client client : clients) 
			{ 
				String client_hostname = params.get("client_hostname");
				if (client.hostname.equals(client_hostname))
				{
					client.name = params.get("name"); 
					return ok();
				}
			}
		}
		return bad_request();
	}
	
	public void saveClients()
	{
		filehandler.writeClients(clients);
	}
	
	
	public Response html()
	{
		return ok(gen(clients));
	}
	
}
