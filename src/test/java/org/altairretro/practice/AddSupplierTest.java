package org.altairretro.practice;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.sdet40.objectRepositiry.SupplierAddPage;
import org.sdet40.objectRepositiry.TabNames;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import genericUtility.IConstantPath;

public class AddSupplierTest extends BaseClass{
	@Test
	public void SupplierAction() throws EncryptedDocumentException, IOException {

	String sn=excelUtility.getDataFromExcelInKey("Supplier", "SUPPLIER NAME");
	System.out.println(sn);
	String sup = excelUtility.getDataFromExcelInKey("Supplier", "SUPPLIER PROVINCE");
	String sc = excelUtility.getDataFromExcelInKey("Supplier", "SUPPLIER  CITY");
	String phn = excelUtility.getDataFromExcelInKey("Supplier", "SUPPLIER  PHONE NUMBER");
	
	webDriverUtility.handlePopup(driver);
	cp.clickRequiredTab(TabNames.SUPPLIER, webDriverUtility);
	//SupplierAddPage sap=new SupplierAddPage(driver);
	sap.supplierCompany();
	sap.supplierPageAction(sn);
	sap.selectSupplierProvince(sup);
	sap.selectSupplierCity(sc);
	sap.supplierPhoneNumber(phn);
	sap.saveSupplier();
	
	
	String suppliertext=sap.SupplierText();
	System.out.println(suppliertext);
	assertEquals(suppliertext, "Supplier ");

}}
