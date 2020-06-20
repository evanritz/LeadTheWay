package org.evan.LeadTheWay.server;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class smssender {

	private static final String ACCOUNT_ID = "ACfef82b91852adc9f89eaa698665bbfe7";
	private static final String AUTH_TOKEN = "7d1e81970ed24a9c1ab4f7cc6e87b76d";
	
	public smssender()
	{
		Twilio.init(ACCOUNT_ID, AUTH_TOKEN);
	}
	
	public void sendMessage(String client, String msg)
	{
		System.out.printf(" LTW SERVER: SENDING ALERT TO ADMIN... \n");
		String full_msg = "LTW SERVICE - CLIENT: " + client + " MSG: " + msg;
		Message message = Message.creator(new PhoneNumber("+14132376470"), new PhoneNumber("+14138873298"), full_msg).create();
		System.out.printf(" \t -> Message sent! OUTPUT: %s \n", full_msg);
	}
	
	
	
}
