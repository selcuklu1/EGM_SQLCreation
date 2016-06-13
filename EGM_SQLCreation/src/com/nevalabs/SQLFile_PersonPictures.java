package com.nevalabs;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;



public class SQLFile_PersonPictures {
	public static void main(String[] args) throws FileNotFoundException {	

	    // SQL Generation
		try {
			String sql="";
			
		    for (int idx = 80001; idx <= 100000; ++idx){
				sql = sql + "INSERT INTO [dbo].[GSS_KISI_RESIM] ([ksr_ksi_id], [ksr_rsm_id], [ksr_cerceve_x], [ksr_cerceve_y], [ksr_cerceve_en], [ksr_cerceve_boy], [ksr_goz1_x], [ksr_goz1_y], [ksr_goz2_x], [ksr_goz2_y], [ksr_thumbnail], [ksr_secili], [ksr_durum], [ksr_sicilno], [ksr_tarih], [ksr_fir]) ";
				sql = sql + "VALUES (" +  idx  + "," + idx + ",10,10,200,200,20,20,20,20,null,0,0,null,null,null" + ")\n";
		    }
			
			File file = new File("C:\\Users\\serdarmars_nevalabs\\EGM_SQLCreation\\sql\\personpictures5.sql");

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
