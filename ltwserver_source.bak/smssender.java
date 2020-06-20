package org.evan.LeadTheWay.server;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class smssender {

	private static final String ACCOUNT_ID = "";
	private static final String AUTH_TOKEN = "";
	
	public smssender()
	{
		Twilio.init(ACCOUNT_ID, AUTH_TOKEN);
	}
	
	public void sendMessage(String client, String msg)
	{
		System.out.printf(" LTW SERVER: SENDING ALERT TO ADMIN... \n");
		String full_msg = "LTW SERVICE - CLIENT: " + client + " MSG: " + msg;
		Message message = Message.creator(new PhoneNumber("+1234567890"), new PhoneNumber("+123456789"), full_msg).create();
		System.out.printf(" \t -> Message sent! OUTPUT: %s \n", full_msg);
	}
	
	
	
}
