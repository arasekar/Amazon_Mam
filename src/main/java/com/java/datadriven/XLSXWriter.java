package com.java.datadriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLSXWriter {
	private static void submethod() throws InvalidFormatException, IOException {

		File f = new File("C:\\Users\\lenovo\\OneDrive\\Desktop\\DataDriven.xlsx");

		FileInputStream fi = new FileInputStream(f);

		Workbook w = new XSSFWorkbook(fi);

		Sheet s = w.createSheet("Amazon Write");
		Row r = s.createRow(2);
		Cell c = r.createCell(2);
		c.setCellValue("data");

		w.getSheet("Amazon Write").createRow(3).createCell(3).setCellValue("driven");

		FileOutputStream fo = new FileOutputStream(f);
		w.write(fo);
		w.close();

	}

	public static void main(String[] args) throws InvalidFormatException, IOException {
		submethod();
	}
}
