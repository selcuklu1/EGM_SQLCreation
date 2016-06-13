package com.nevalabs;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;



public class SQLFile_PictureResource {
	public static void main(String[] args) throws FileNotFoundException {	
		
		File folder = new File("C:\\TestPictures\\old\\5000");
		File[] listOfFiles = folder.listFiles();
		System.out.println("size of folder:" + listOfFiles.length);
//		rm = new ReportManager();
//		rm.dropReports();
		for (File file : listOfFiles) {
		    if (file.isFile()) {
		    	if(file.getName().contains("jpg"))
		    	{
		    		System.out.println(file.getName());
		    	}
		    }
		}
		System.out.println("size of folder:" + listOfFiles.length);
	    
	    // SQL Generation
		try {
			String sql="";
//			String sql = "USE [ARVTEM]\n";
//			sql = sql + "GO\n";
//			sql = sql + "SET IDENTITY_INSERT [dbo].[GSS_RESIM_KAYNAK] ON \n";
			
//		    for (int idx = 1; idx <= 10; ++idx){
			for (File file : listOfFiles) {
			    if (file.isFile()) {
			    	if(file.getName().contains("jpg"))
			    	{

//						sql = sql + "GO\n";
						sql = sql + "INSERT INTO [dbo].[GSS_RESIM_KAYNAK] ([rsm_imaj], [kyk_durum]) ";
						sql = sql + "SELECT BulkColumn,1 ";
						sql = sql + "FROM Openrowset( Bulk ";
						sql = sql + "'" + "C:\\TestPictures\\old\\5000\\" + file.getName() + "'";
						sql = sql + ", Single_Blob) as image\n";
			    	}
			    }
		    }
//			sql = sql + "GO\n";
//			sql = sql + "SET IDENTITY_INSERT [dbo].[GSS_RESIM_KAYNAK] OFF\n";
//			sql = sql + "GO\n";
			
			File file = new File("C:\\Users\\serdarmars_nevalabs\\EGM_SQLCreation\\sql\\pictureresource.sql");

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(sql);
			bw.close();

			System.out.println("Done");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
