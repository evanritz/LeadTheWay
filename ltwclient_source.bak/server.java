package org.evan.LeadTheWay.client;

public class server extends hostname{

	public int requests 		= 0;
	public boolean firsttime 	= true;
	
	public server(String hostname) { super(hostname); }
	
	public server() { super(null); }
	
	public void set(server passed_server)
	{ firsttime = passed_server.firsttime; requests = passed_server.requests; hostname = passed_server.hostname; } 
	
}
