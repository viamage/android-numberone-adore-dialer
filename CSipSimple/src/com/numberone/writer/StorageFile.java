package com.numberone.writer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;


public class StorageFile {
	
	


	public String writeStorageFile(String filepath, String content ) {
		
		String msg="";
		/*File devfile = new File(filepath);
		if (!devfile.exists()){
			devfile.mkdir();
		}
		
		System.out.println("Hemant "+devfile.getAbsolutePath());*/
		
		// Create file output stream
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(filepath);
			// Write a line to the file
			fos.write(content.getBytes());
			
			// Close the file output stream
			fos.close();
			msg = "success";
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			msg = e.toString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			msg = e.toString();
		}
		
		return msg;
		   
	}
		
	public String readStorageFile(String filepath){
		String strr = "";
		
		 BufferedReader in;
			try {
				
				in = new BufferedReader(new InputStreamReader(new FileInputStream(filepath)));
				// BufferedReader bred = new BufferedReader(in);
				 //System.out.println("DEVTADIYAL "+in);
				 String line;
				    StringBuffer buffer = new StringBuffer();
				    while ((line = in.readLine()) != null) {
				        buffer.append(line);
				    }
				 
				    System.out.println( "Hemant String  "+buffer.toString());
				    
				    strr = buffer.toString();
				    in.close();
				    
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				strr= e.toString();
			} catch (IOException e) {
			
				// TODO Auto-generated catch block
				e.printStackTrace();
				strr= e.toString();
			}
			
			return strr;
	}
		
		
	
}
