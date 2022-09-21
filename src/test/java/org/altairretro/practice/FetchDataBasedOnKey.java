package org.altairretro.practice;

import java.io.IOException;

import genericUtility.ExcelUtility;
import genericUtility.IConstantPath;

public class FetchDataBasedOnKey {
	//conflict by engineer 2

	public static void main(String[] args) throws IOException {
		ExcelUtility excelUtility=new ExcelUtility();
		excelUtility.openExcel(IConstantPath.EXCEL_PATH);
		
//		String FirstName=excelUtility.getDataFromExcelInKey("Supplier", "SUPPLIER NAME");
//		System.out.println(FirstName);
//		String sup = excelUtility.getDataFromExcelInKey("Supplier", "SUPPLIER PROVINCE");
//		System.out.println(sup);
//		String sc = excelUtility.getDataFromExcelInKey("Supplier", "SUPPLIER  CITY");
//		System.out.println(sc);
//		String phn = excelUtility.getDataFromExcelInKey("Supplier", "SUPPLIER  PHONE NUMBER");
//		System.out.println(phn);
//		
		
//		 String productcode=excelUtility.getDataFromExcelInKey("Product", "PRODUCTCODE");
//		 System.out.println(productcode);
		 String productname=excelUtility.getDataFromExcelInKey("Product", "PRODUCTNAME");
		 System.out.println(productname);
		 String productdescription=excelUtility.getDataFromExcelInKey("Product", "PRODUCTDESCRIPTION");
		 System.out.println(productdescription);
		 String productquantity=excelUtility.getDataFromExcelInKey("Product", "PRODUCTQUANTITY");
		 System.out.println(productquantity);
		 String productonhand=excelUtility.getDataFromExcelInKey("Product", "PRODUCTONHAND");
		 System.out.println(productonhand);
		 String productprice=excelUtility.getDataFromExcelInKey("Product", "PRODUCTPRICE");
		 System.out.println(productprice);
		 String productdateinstock=excelUtility.getDataFromExcelInKey("Product", "PRODUCTDATEINSTOCK");
		 System.out.println(productdateinstock);
		

	}

}
