package org.evan.LeadTheWay.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.logging.Logger;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class filehandler extends dir{
	
	private EnumMap<FILENAMES, File> serv_files = new EnumMap<FILENAMES, File>(FILENAMES.class);
	private Gson json_convert					= new Gson();
	
	public filehandler(String dir_name) { super(dir_name); serv_files = this.getServFiles(); }
	
	public void writeHostname(hostname hostname_obj)
	{
		File file = selectFile(FILENAMES.hostname);
		String formatted_str = json_convert.toJson(hostname_obj);
		System.out.printf("\t -> Writing Hostname to hostname.json... ");
		writeFile(file, formatted_str);
	}
	
	public void writeClients(ArrayList<client> client_objs)
	{
		File file = selectFile(FILENAMES.clients);
		String formatted_str = json_convert.toJson(client_objs);
		System.out.printf("\t -> Writing Clients to clients.json... ");
		writeFile(file, formatted_str);
	}
	
	private void writeFile(File file, String formatted_str)
	{
		if (file != null && formatted_str != null)
		{
			try (BufferedWriter BW = new BufferedWriter(new FileWriter(file)))
			{
				BW.write(formatted_str);
				BW.close();
				System.out.printf("SUCCESSFUL!\n");
			} 
			catch (IOException ioe)
			{
				System.out.printf("FAILED!, QUITTING!\n");
				ioe.printStackTrace();
				System.exit(-1);
			}
		}
	}
	
	public hostname readHostname() 
	{
		File file = selectFile(FILENAMES.hostname);
		System.out.printf("\t -> Reading hostname into memory... ");
		String formatted_str = readFile(file);
		return json_convert.fromJson(formatted_str, hostname.class);
	}
	
	public void readClients(ArrayList<client> empty_clients)
	{
		File file = selectFile(FILENAMES.clients);
		System.out.printf("\t -> Reading clients into memory... ");
		String formatted_str = readFile(file);
		ArrayList<client> clients = json_convert.fromJson(formatted_str, new TypeToken<ArrayList<client>>(){}.getType());
		for (client client : clients)
			empty_clients.add(client);
	}
	
	private String readFile(File file)
	{
		String formatted_str = new String();
		if (file != null)
		{
			try (BufferedReader BR = new BufferedReader(new FileReader(file)))
			{
				String line;
				while ((line = BR.readLine()) != null)
					formatted_str += line;
				BR.close();
				System.out.printf("SUCCESSFUL!\n");
			}
			catch (IOException ioe)
			{
				System.out.printf("FAILED!, QUITTING!\n");
				ioe.printStackTrace();
				System.exit(-1);
			}
		}
		return formatted_str;
	}
	
	
	public File selectFile(FILENAMES file_name) 
	{
		switch (file_name)
		{
			case hostname: return serv_files.get(FILENAMES.hostname);
			case clients: return serv_files.get(FILENAMES.clients);
			default: return null;
		}
	}
}

