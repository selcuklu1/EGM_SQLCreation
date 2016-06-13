package com.nevalabs;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;



public class SQLFile_Pictures {
	public static void main(String[] args) throws FileNotFoundException {	
			    
	    // SQL Generation
		try {
			String sql="";
			
		    for (int idx = 80001; idx <= 100000; ++idx){
//				sql = sql + "GO\n";
				sql = sql + "INSERT INTO [dbo].[GSS_RESIMLER] ([rsm_aciklama], [rsm_kyk_id]) ";
				sql = sql + "VALUES (" + "'" + "test1" + "'" + "," + idx + ")\n";
		    }

			
			File file = new File("C:\\Users\\serdarmars_nevalabs\\EGM_SQLCreation\\sql\\pictures5.sql");

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
