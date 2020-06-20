package org.evan.LeadTheWay.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;

public class requestservice extends pythonhandler{

	private server server;
	private hostname client_hostname;
	private HttpHost proxy;
	
	public requestservice(hostname client_hostname, server server)
	{
		proxy 					= new HttpHost("127.0.0.1", 8118, "http");
		this.client_hostname 	= client_hostname;
		this.server 			= server;
	}
	
	public void sendData()
	{
		String url = "http://" + server.hostname + "/status";	
		boolean status;
	
		System.out.println();
		System.out.printf(" SMOKE TEST RUNNING... \n");
		
		if (smokeDetector(10)) { System.out.printf("\t -> RESULTS: SMOKE HAS BEEN DETECTED!\n"); status = true; }
		else { System.out.printf("\t -> RESULTS: NO SMOKE HAS BEEN DETECTED!\n"); status = false; }
		
		System.out.printf(" UPDATING SERVER WITH RESULTS... ");
		
		try (CloseableHttpClient server_connection = HttpClientBuilder.create().setProxy(proxy).build())
		{
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			params.add(new BasicNameValuePair("client_hostname", client_hostname.hostname));
			params.add(new BasicNameValuePair("status", String.valueOf(status)));
			HttpPost post_request = new HttpPost(url);
			post_request.setEntity(new UrlEncodedFormEntity(params));
			HttpResponse response = server_connection.execute(post_request);
			int statuscode = response.getStatusLine().getStatusCode();
			if (statuscode == 200) { System.out.printf("SUCCESSFUL! STATUSCODE=%d\n", statuscode); }
			else { System.out.printf("FAILED! STATUSCODE=%d\n", statuscode); }
			System.out.println();
		}
		catch (IOException ioe) { ioe.printStackTrace(); }
	}
	
	
	public void initServer()
	{
		String url = "http://" + server.hostname + "/addclient";
		System.out.printf(" -> Initiating first request sent to server... ");
		try (CloseableHttpClient server_connection = HttpClientBuilder.create().setProxy(proxy).build())
		{
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			params.add(new BasicNameValuePair("client_hostname", client_hostname.hostname));
			HttpPost post_request = new HttpPost(url);
			post_request.setEntity(new UrlEncodedFormEntity(params));
			HttpResponse response = server_connection.execute(post_request);
			int statuscode = response.getStatusLine().getStatusCode();
			if (statuscode == 200) { System.out.printf("SUCCESSFUL! STATUSCODE=%d\n", statuscode); }
			else { System.out.printf("FAILED! STATUSCODE=%d\n", statuscode); }
		}
		catch (IOException ioe) { ioe.printStackTrace(); }
	}
	
	public void changeLED(Map<String, String> params)
	{
		String status = params.get("status");
		if (status.contains("ALL CLEAR!")) { led("green"); }
		else { led("red"); }
	}
}
