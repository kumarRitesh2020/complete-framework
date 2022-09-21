package org.altairretro.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class fetchDataToExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/Testdata.xlsx");
		 Workbook wb=WorkbookFactory.create(fis);
		 
		 Sheet sheet=wb.getSheet("organization");
		// Row row=sheet.createRow(18);
		 Row row=sheet.getRow(1);
		 Cell cell=row.createCell(1);
		 cell.setCellValue("skip");
		 FileOutputStream fos=new FileOutputStream("./src/test/resources/Testdata.xlsx");
		 wb.write(fos);
		 System.out.println("Data updated successfully");
		 wb.close();

	}

}
