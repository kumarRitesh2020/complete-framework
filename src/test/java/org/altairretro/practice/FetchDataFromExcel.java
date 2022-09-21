package org.altairretro.practice;



import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import genericUtility.ExcelUtility;
import genericUtility.FileUtility;
import genericUtility.IConstantPath;
import genericUtility.JavaUtility;

public class FetchDataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		int randomNumber=new JavaUtility().getRandomNumber(1000);
		 String data=new ExcelUtility().getDataFromExcel(IConstantPath.EXCEL_PATH,"MakeMyTrip",1,0)+randomNumber;
		 System.out.println(data);
		 System.out.println(data);
		 String browser=new FileUtility().getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH, "browser");
		 System.out.println(browser);
		 
		 String url=new FileUtility().getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH,"url");
		 System.out.println(url);
		
	

/*FileInputStream fis=new FileInputStream("./src/test/resources/Testdata.xlsx");
 Workbook wb=WorkbookFactory.create(fis);
 
 Sheet sheet=wb.getSheet("Sheet1");
 DataFormatter df=new DataFormatter();
 String[][] arr=new String[sheet.getLastRowNum()+1][sheet.getRow(6).getLastCellNum()];
 for(int i=0;i<=sheet.getLastRowNum();i++) {
	 for(int j=0;j<sheet.getRow(6).getLastCellNum();j++) {
		 arr[i][j]=df.formatCellValue(sheet.getRow(i).getCell(j));*/
	 }
 }
 
/*
 * for(int i=0;i<=sheet.getLastRowNum();i++) { for(int
 * j=0;j<sheet.getRow(6).getLastCellNum();j++) { System.out.println(arr[i][j]);
 */
// String username=sheet.getRow(1).getCell(1).getStringCellValue();
  // String password=sheet.getRow(2).getCell(1).getStringCellValue();
// String url=sheet.getRow(0).getCell(1).getStringCellValue();

// System.out.println(username);
// System.out.println(password);
  // System.out.println(url);
	// }
	 
	 

	/*Sheet sheet = wb.getSheet("Sheet1");
	int totalRows = sheet.getLastRowNum();
	System.out.println(totalRows);
	Row rowCells = sheet.getRow(0);
	int totalCols = rowCells.getLastCellNum();
	System.out.println(totalCols);
	DataFormatter format = new DataFormatter();

	String testData[][] = new String[totalRows][totalCols];
	for (int i = 1; i < totalRows; i++) {
		for (int j = 0; j < totalCols; j++) {
			testData[i - 1][j] = format.formatCellValue(sheet.getRow(i).getCell(j));
			System.out.println(testData[i - 1][j]);*/
	/*
	 * } }
	 * 
	 * 
	 * wb.close();
	 * 
	 * 
	 * 
	 * 
	 * 
	 * }
	 * 
	 * }
	 */
