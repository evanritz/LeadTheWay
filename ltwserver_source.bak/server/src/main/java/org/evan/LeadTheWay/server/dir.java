package org.evan.LeadTheWay.server;

import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.EnumMap;
import java.util.logging.Logger;
import java.io.File;
import java.io.IOException;

public class dir{

	private EnumMap<FILENAMES, File> serv_files 	= new EnumMap<FILENAMES, File>(FILENAMES.class);
	private Path[] serv_paths                   	= new Path[3];
	
	public dir(String dir_name) 
	{	
		serv_paths[0] = Paths.get(dir_name, "hostname.json"); 
		serv_paths[1] = Paths.get(dir_name, "clients.json");
		
		if (createDir(dir_name)) { System.out.printf("\t -> FILES NOT FOUND! Creating new Files... "); createFileObjects(); createFiles(); }
		else { System.out.printf("\t -> FILES FOUND! Skipping File generation. \n"); createFileObjects(); }
	}

	public EnumMap<FILENAMES, File> getServFiles()
	{
		return serv_files;
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
		 serv_files.put(FILENAMES.hostname, serv_paths[0].toFile());		 
		 serv_files.put(FILENAMES.clients, serv_paths[1].toFile());
	}
	
	public void createFiles()
	{
		try
		{
			serv_files.get(FILENAMES.hostname).createNewFile();
			serv_files.get(FILENAMES.clients).createNewFile();
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


