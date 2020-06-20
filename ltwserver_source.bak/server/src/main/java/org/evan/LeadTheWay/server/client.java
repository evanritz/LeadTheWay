package org.evan.LeadTheWay.server;

public class client extends hostname{

	public int requests    = 0;
	public boolean online  = false;
	public String status   = null;
	public String name     = null;
	
	public client(String hostname) 
	{
		super(hostname);
		name = hostname;
	}
	
}
