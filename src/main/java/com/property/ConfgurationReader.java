package com.property;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;

public class ConfgurationReader {
	public  static Properties p;
	public ConfgurationReader() throws IOException {

		File f = new File(
				"C:\\Users\\lenovo\\eclipse-workspace\\Amazon_Project\\src\\main\\java\\com\\property\\Amazon.properties");

		FileInputStream fi = new FileInputStream(f); // read

		p = new Properties(); //local

		p.load(fi);

	}
	
	public static String getBrowser() {

		String browser = p.getProperty("browser");
		return browser;
		
	}
	
	public static String getURL() {
		String url = p.getProperty("url");
		return url;
	}

	public static String getSheet() {
		String sheetName = p.getProperty("sheet");
		return sheetName;
	}
	 
	public static String getSheetPath() {
		String path = p.getProperty("sheetpath");
		return path;
	}
	
}
