package org.evan.LeadTheWay.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.logging.Logger;

public class pythonhandler {

	private ArrayList<String> cli(String command)
	{
		ArrayList<String> cli_output = new ArrayList<String>();
		Process cli_proc;
		try
		{
			cli_proc = Runtime.getRuntime().exec(command);
			cli_proc.waitFor();
			BufferedReader BR = new BufferedReader(new InputStreamReader(cli_proc.getInputStream()));
			String line;
			while ((line = BR.readLine()) != null)
				cli_output.add(line);
		} 
		catch (IOException ioe) { ioe.printStackTrace(); }
		catch (InterruptedException ie) { ie.printStackTrace(); }
		return cli_output;
	}
	
	public boolean smokeDetector(int max)
	{
		String command = "python3 gas_detect.py " + max;
		System.out.printf("\t -> Running gas_detect.py for smoke check....\n");
		ArrayList<String> command_output = cli(command);
		String smoke_line = command_output.get(command_output.size()-1);
		if (smoke_line.contains("=")) 
		{ 
			boolean isSmoke = Boolean.parseBoolean(smoke_line.substring(smoke_line.indexOf("=")+1, smoke_line.length()));
			return isSmoke;
		}
		else { return false; }
	}
	
	public void led(String color)
	{
		System.out.printf("Changing LED state to [" + color + "]");
		String command = "python3 led.py " + color;
		cli(command);
	}
	
	
	
	
	
	
	
	
}
