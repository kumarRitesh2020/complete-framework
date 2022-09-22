package org_salesandinventory_genericutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.zip.DataFormatException;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.devtools.v102.page.Page;

public class getDataFromExcel

{
	Workbook book=null;
	public  String excelutility(String excel,String getsheet,int getrow,int getcell) {
		FileInputStream  fiss=null;
		try {
			 fiss = new FileInputStream(excel);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			book=WorkbookFactory.create(fiss);
		} catch (EncryptedDocumentException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}

				Sheet sheet= book.getSheet(getsheet);
	String data =new DataFormatter().formatCellValue(sheet.getRow( getrow).getCell(getcell));
		try {
			book.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	return data;
	}
	public Workbook openExcelpage(String excel) 
	{
		FileInputStream file=null;
		
		 try {
			file = new FileInputStream(excel);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return book;
	}
	/**
	 * 
	 * @param sheetName
	 * @param requiredkey
	 * @return
	 */
	public String getDataFromExcelsheet(String sheetName, String requiredkey)
	{
     Sheet sheet=book.getSheet(sheetName);
     String value=null;
     for(int i=0; i<sheet.getLastRowNum();i++)
     {
    	 String actualkey=sheet.getRow(1).getCell(0).getStringCellValue();
    	 if(actualkey.equalsIgnoreCase(requiredkey)) {
    		 value=sheet.getRow(i).getCell(1).getStringCellValue();
    	     break;
    	 }
     }
     return value;
     }
	
/**
 * 
 * @param sheetname
 * @return
 */

public Map<String,String> getDataFromExcelInMap(String sheetname)
{
	Sheet sheet=book.getSheet(sheetname);
	Map<String, String>map=new HashedMap<>();
	DataFormatter df=new DataFormatter();
	for(int i=0; i<=sheet.getLastRowNum();i++)
	{
		map.put(df.formatCellValue(sheet.getRow(i).getCell(0)),df.formatCellValue(sheet.getRow(i).getCell(1)));
	}
	return map;
}
 public void saveData(String path) 
 {
      try {
		book.write(new FileOutputStream(path));
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}	
 public void closeExcelBook()
 {
	 try {
		book.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
 }
 
}