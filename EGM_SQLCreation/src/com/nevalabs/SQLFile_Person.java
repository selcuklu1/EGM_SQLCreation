package com.nevalabs;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class SQLFile_Person {
	public static void main(String[] args) throws FileNotFoundException {		
	    
		// Creating Isim Indexi
	    String adsoyad = "";
	    String sehir = "";

	    // create Scanner inFile1
	    Scanner sadsoyad = new Scanner(new File("adsoyad.txt"));
	    Scanner ssehir = new Scanner(new File("sehir.txt"));
	    List<String> temps = new ArrayList<String>();
	    List<String> temps1 = new ArrayList<String>();
	    
	    while (sadsoyad.hasNext()) {
	    	adsoyad = sadsoyad.next();
		    temps.add(adsoyad);
	    }
	    
	    while (ssehir.hasNext()) {
	    	sehir = ssehir.next();
		    temps1.add(sehir);
	    }
	    
	    sadsoyad.close();
	    ssehir.close();
	    System.out.println("Total name adedi: " + temps.size());
	    System.out.println("Total sehir adedi: " + temps1.size());
	    
	    //Random Isim Generator
	    Random randomGenerator = new Random();

	    
//	    Random rnd = new Random();
//	    long tcid = 10000000000l + rnd.nextInt(900000000);
//	    System.out.println("tc id: " + n);
	    
	    // SQL Generation
		try {
			String sql = "USE [ARVTEM]\n";
			sql = sql + "GO\n";
			sql = sql + "SET IDENTITY_INSERT [dbo].[GSS_KISI] ON \n";
			
		    for (int idx = 90001; idx <= 100000; ++idx){
		    	int randomInt = randomGenerator.nextInt(temps.size());
		    	int randomInt1 = randomGenerator.nextInt(temps1.size());
		    	long tcid = 10000000000l + randomGenerator.nextInt(900000000);
				sql = sql + "GO\n";
				sql = sql + "INSERT [dbo].[GSS_KISI] ([ksi_id], [ksi_adi], [ksi_soyadi], [ksi_tckn], [ksi_dogumyeri], [ksi_uyruk], [ksi_medenihali], [ksi_ogrenimdurumu], [ksi_dogumtarihi_gun], [ksi_eskalbilgileri], [ksi_fizikidurumu], [ksi_anaadi], [ksi_babaadi], [ksi_nufusyeri_il], [ksi_aciklama], [ksi_orgutu], [ksi_katilimgun], [ksi_katilimay], [ksi_katilimyil], [ksi_neredenkatildigi], [ksi_kodadi], [ksi_orgutgorevi], [ksi_egitimaldigikamp], [ksi_gorevbolgesi], [ksi_fraksiyonu], [ksi_ozelbecerileri], [ksi_arayanmakam], [ksi_aidiyetno], [ksi_cezaevi], [ksi_cinsiyet], [ksi_yasiyormu], [ksi_kartacmasebebi], [ksi_yetki_il], [ksi_gizlimi], [ksi_kts_id], [ksi_yakalandimi], [ksi_hukukidurumu], [ksi_sicilno], [ksi_onaydurumu], [ksi_faaliyetalani], [ksi_kirsaldurumu], [ksi_dogumtarihi_ay], [ksi_dogumtarihi_yil], [ksi_nufusyeri_ilce], [ksi_nufusyeri_mahalle], [ksi_sabitaciklama], [ksi_tarih], [ksi_sontarih], [ksi_aktarimid], [ksi_pasaportno], [ksi_yetkili_sicilno], [ksi_temasaktarimid]) VALUES ";
				sql = sql + "(" + idx + ", N'" + temps.get(randomInt) + "', N'" + temps.get(randomInt) + "', " + tcid + ", N'" + temps1.get(randomInt1) + "', 1, 1, 1, 1, N'eskal', N'fiziksel', N'anne', N'bABa', N'il', N'aciklama', 1, 4, 9, 2012, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'yeni giris', NULL, 1, 1, 1, 1, NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, CAST(N'2012-06-18 10:34:09.000' AS DateTime), CAST(N'2015-09-28 10:34:09.000' AS DateTime), NULL, NULL, NULL, NULL)" + "\n";
			
		    }
			sql = sql + "GO\n";
			sql = sql + "SET IDENTITY_INSERT [dbo].[GSS_KISI] OFF\n";
			sql = sql + "GO\n";
			
			File file = new File("C:\\Users\\serdarmars_nevalabs\\EGM_SQLCreation\\sql\\person10.sql");

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
