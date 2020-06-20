package org.evan.LeadTheWay.client;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import fi.iki.elonen.NanoHTTPD;
import fi.iki.elonen.NanoHTTPD.Method;

public class main extends NanoHTTPD{
	
	private static responseservice responseservice		= null;
	private static requestservice requestservice		= null;
	private static hostname client_hostname				= null;	
	private static server server						= null;	
	
	public main(int httpport, String dir_name) throws IOException
	{
		super(httpport);
		System.out.printf(" LTW CLIENT : STARTING UP.... \n");
		start(NanoHTTPD.SOCKET_READ_TIMEOUT, false);
		System.out.printf(" -> Spawning http server on localhost. PORT=%d\n", httpport);
		
		responseservice 	= new responseservice(client_hostname, server, dir_name);
		requestservice 		= new requestservice(client_hostname, server);
		
		if (server.firsttime) { requestservice.initServer(); server.firsttime = false; responseservice.saveServer(); }
		
		System.out.printf(" LTW CLIENT : STARTUP COMPLETE!\n");
	}
	
	public static void main(String[] args)
	{
		int httpport = 0; String dir_name = null;
		if (args.length == 2) { httpport = Integer.parseInt(args[0]); dir_name = args[1]; client_hostname = new hostname(); server = new server(); }
		else if (args.length == 4) { httpport = Integer.parseInt(args[0]); dir_name = args[1]; client_hostname = new hostname(args[2]); server = new server(args[3]); }
		else { System.out.printf(" LTW CLIENT : args -> httpport, serverdirectory, .onion hostname, .onion server hostname OR httpport, serverdirectory"); System.exit(0); }
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
					case "/ping": requestservice.sendData(); return responseservice.ok();
					default: return responseservice.not_found();
				}
			}
			else if (Method.POST.equals(method)) 
			{
				switch (uri)
				{
					case "/updateserver": return responseservice.changeServerAddress(params);
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
