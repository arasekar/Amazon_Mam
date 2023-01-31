package com.java.datadriven;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.property.Configurationhelper;

public class XLXSXReader {
	static String value;
	
	public static String singleData(String name,int row,int cell) throws Exception {
		
		String path = Configurationhelper.getInstanceCR().getSheetPath();
		File f = new File(path);

		FileInputStream fi = new FileInputStream(f);

		Workbook w = new XSSFWorkbook(fi);

		Sheet she = w.getSheet(name);

		Row r = she.getRow(row);

		Cell c = r.getCell(cell);

		CellType ce = c.getCellType();

		if (ce.equals(CellType.STRING)) {
			 value = c.getStringCellValue();
		} else if (ce.equals(CellType.NUMERIC)) {
			double nV = c.getNumericCellValue();
			
			int a = (int) nV;
			
			 value = String.valueOf(a);
		}
		return value;
	}

	private static void allData() throws Exception {
		String path = Configurationhelper.getInstanceCR().getSheetPath();
		File f = new File(path);

		FileInputStream fi = new FileInputStream(f);

		Workbook w = new XSSFWorkbook(fi);
		
		Sheet s = w.getSheet("Amazon");
		
		int rows = s.getPhysicalNumberOfRows(); //2
		
		for (int i = 0; i < rows ; i++) {
			
			Row r = s.getRow(i); //0 1
			
			int cells  = r.getPhysicalNumberOfCells();//2
			
			for (int j = 0; j < cells; j++) {
				
				Cell c = r.getCell(j); //0  1
				
				CellType ce = c.getCellType();
				if(ce.equals(CellType.STRING)) {
					System.out.print(c.getStringCellValue() +" | ");
				}
			}
			System.out.println();
			
		}
		
		
		
		
	}
	public static void main(String[] args) throws Exception {
		allData();
	}
}
