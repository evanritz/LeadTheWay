package org.evan.LeadTheWay.server;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.logging.Logger;

import fi.iki.elonen.NanoHTTPD;

public class main extends NanoHTTPD{

	private static ArrayList<client> clients 			= new ArrayList<client>();
	private static responseservice responseservice 		= null;
	private static requestservice requestservice		= null;
	private static hostname serv_hostname 				= null;
	
	public main(int httpport, String dir_name) throws IOException
	{
		super(httpport);
		System.out.printf(" LTW SERVER : STARTING UP...\n");
		start(NanoHTTPD.SOCKET_READ_TIMEOUT, false);
		System.out.printf(" -> Spawning http server on localhost. PORT=%d\n", httpport);
		
		responseservice 	= new responseservice(serv_hostname, clients, dir_name);
		requestservice		= new requestservice(serv_hostname, clients);
		Timer timer 		= new Timer(); timer.schedule(requestservice, 0, 15000);
		
		System.out.printf(" LTW SERVER : STARTUP COMPLETE!\n");
	}
	
	public static void main(String[] args)
	{
		int httpport = 0; String dir_name = null; 
		if (args.length == 2) { httpport = Integer.parseInt(args[0]); dir_name = args[1]; }
		else if (args.length == 3 ) { httpport = Integer.parseInt(args[0]); dir_name = args[1]; serv_hostname = new hostname(args[2]); }
		else { System.out.printf("LTW SERVER : args -> httpport, serverdirectory, .onion hostname OR httpport, serverdirectory\n"); System.exit(0); }
		try { new main(httpport, dir_name); } catch (IOException ioe) { ioe.printStackTrace(); }
	}
	
	public Response serve(IHTTPSession session)
	{
		HashMap<String, String> session_map 	= new HashMap<String, String>();
		Map<String, String> params    			= session.getParms(); 
		Method method                 			= session.getMethod();
		String uri 					  			= session.getUri();
		try {
			session.parseBody(session_map);
			if (Method.GET.equals(method)) 
			{
				switch (uri)
				{
					case "/dashboard": return responseservice.html();
					case "/ping": return responseservice.ok();
					default: return responseservice.not_found();
				}
			}
			else if (Method.POST.equals(method)) 
			{
				switch (uri)
				{
					case "/addclient": return responseservice.addClient(params); // adds client to client array/call list
					case "/status": return responseservice.setStatus(params); // changes the status of provided client
					// admin uris
					case "/name": responseservice.setCustomName(params); 
					default: return responseservice.not_found();
				}
			}
			else
			{
				return responseservice.bad_request();
			}
		} 
		catch (IOException ioe) { ioe.printStackTrace(); }
		catch (ResponseException re) { re.printStackTrace(); }
		return responseservice.not_found();
	}	
}
