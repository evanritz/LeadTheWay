package org.evan.LeadTheWay.server;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Logger;

import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;

public class requestservice extends TimerTask{
	
	private ArrayList<client> clients;
	private hostname serv_hostname;
	private HttpHost proxy;
	
	public requestservice(hostname serv_hostname, ArrayList<client> clients) {
		proxy 					= new HttpHost("127.0.0.1", 8118, "http");
		this.serv_hostname 		= serv_hostname;
		this.clients 			= clients;
	}
	
	public void callClients()
	{
		
			System.out.printf(" REQUESTING ALL CLIENTS... \n");
			for (client client : clients) 
			{
				String url = "http://" + client.hostname + "/ping";
				System.out.printf("\t -> Requesting Client - %s for status... ", client.hostname); 
				try (CloseableHttpClient client_connection = HttpClientBuilder.create().setProxy(proxy).build())
				{
					HttpResponse response = client_connection.execute(new HttpGet(url));
					if (response.getStatusLine().getStatusCode() == 200)
					{
						client.online = true;
						client.requests++;
					}
					else
						client.online = false;
				}
				catch (IOException ioe) { ioe.printStackTrace(); }	
			}
			System.out.printf(" ALL CLIENTS HAVE BEEN REQUESTED!\n");
		
	}
	
	public void updateClients()
	{
		System.out.printf(" UPDATE ALL CLIENTS TO NEW SERVER ADDRESS...\n");
		System.out.printf("\t -> Updating all Clients to new server hostname. NEW_SERV_ADDR=%s\n", serv_hostname.hostname);
		for (client client : clients)
		{
			String url = "http://" + client.hostname + "/updateserver";
			System.out.printf("\t -> Updating client - %s to new server hostname... ", client.hostname);
			try (CloseableHttpClient client_connection = HttpClientBuilder.create().setProxy(proxy).build())
			{
				List<NameValuePair> params = new ArrayList<NameValuePair>(); 
				params.add(new BasicNameValuePair("server_hostname", serv_hostname.hostname));
				HttpPost post_request = new HttpPost(url);
				post_request.setEntity(new UrlEncodedFormEntity(params));
				HttpResponse response = client_connection.execute(post_request);
				int statuscode = response.getStatusLine().getStatusCode();
				if (statuscode == 200) { System.out.printf("SUCCESSFUL! STATUSCODE=%d\n", statuscode); }
				else { System.out.printf("FAILED! STATUSCODE=%d\n", statuscode); }
				
			}
			catch (IOException ioe) { ioe.printStackTrace(); }
		}
		System.out.printf(" ALL CLIENTS HAVE BEEN UPDATED.\n");
	}
	
	public void run()
	{
		callClients();
	}
}
