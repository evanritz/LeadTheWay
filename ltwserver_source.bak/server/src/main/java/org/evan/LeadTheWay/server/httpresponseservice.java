package org.evan.LeadTheWay.server;

import fi.iki.elonen.NanoHTTPD.Response;

import java.util.logging.Logger;

import fi.iki.elonen.NanoHTTPD;

public class httpresponseservice extends htmlgenerator {

	public Response not_found()
	{
		return NanoHTTPD.newFixedLengthResponse(Response.Status.NOT_FOUND, "application/json", "");
	}
	
	public Response bad_request()
	{
		return NanoHTTPD.newFixedLengthResponse(Response.Status.BAD_REQUEST, "application/json", "{\"status\":\"400\"}\n");
	}
	
	public Response ok()
	{
		return NanoHTTPD.newFixedLengthResponse(Response.Status.OK, "application/json", "{\"status\":\"200\"}\n");
	}
	
	public Response ok(String html)
	{
		return NanoHTTPD.newFixedLengthResponse(Response.Status.OK, "text/html", html);
	}
}
