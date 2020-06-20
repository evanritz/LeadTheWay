package org.evan.LeadTheWay.client;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.EnumMap;
import java.util.logging.Logger;

public class dir {
	
	private EnumMap<FILENAMES, File> client_files 	= new EnumMap<FILENAMES, File>(FILENAMES.class);
	private Path[] client_paths                   	= new Path[2];
	
	public dir(String dir_name) 
	{	
		client_paths[0] = Paths.get(dir_name, "hostname.json"); 
		client_paths[1] = Paths.get(dir_name, "server.json");
		
		if (createDir(dir_name)) { System.out.printf("\t -> FILES NOT FOUND!, Creating new Files... "); createFileObjects(); createFiles(); }
		else { System.out.printf("\t -> FILES FOUND!, Skipping File generation. \n"); createFileObjects(); }
	}

	public EnumMap<FILENAMES, File> getClientFiles()
	{
		return client_files;
	}
	
	public boolean createDir(String dir_name)
	{
		File dir = new File(dir_name);
		System.out.printf(" -> Checking for previous Application Directory... ");
		if (!dir.exists() && dir.mkdir()) { System.out.printf("NOT FOUND!, Creating new Directory... DIR=%s\n", dir_name); return true;}
		else { System.out.printf("FOUND!, Skipping Directory creation. DIR=%s\n", dir_name); return dir.listFiles().length == 0;}
	}
	
	public void createFileObjects() 
	{
		 client_files.put(FILENAMES.hostname, client_paths[0].toFile());		 
		 client_files.put(FILENAMES.server, client_paths[1].toFile());
	}
	
	public void createFiles()
	{
		try
		{
			client_files.get(FILENAMES.hostname).createNewFile();
			client_files.get(FILENAMES.server).createNewFile();
			System.out.printf("FILES CREATED!\n");
		} 
		catch (IOException ioe) 
		{
			System.out.printf("COULD NOT CREATE FILES!... QUITTING!\n");  
			ioe.printStackTrace();     
			System.exit(-1);
		}
	}
}
