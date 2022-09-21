package org.altairretro.practice;
import static org.testng.Assert.assertEquals;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;
import genericUtility.BaseClass;
public class ProductAddTest extends BaseClass {

	@Test
	public void addProduct() throws EncryptedDocumentException, IOException {

		String productcode = excelUtility.getDataFromExcelInKey("Product", "PRODUCTCODE");
		String productname = excelUtility.getDataFromExcelInKey("Product", "PRODUCTNAME");
		String productdescription = excelUtility.getDataFromExcelInKey("Product", "PRODUCTDESCRIPTION");
		String productquantity = excelUtility.getDataFromExcelInKey("Product", "PRODUCTQUANTITY");
		String productonhand = excelUtility.getDataFromExcelInKey("Product", "PRODUCTONHAND");
		String productprice = excelUtility.getDataFromExcelInKey("Product", "PRODUCTPRICE");
		String productdateinstock = excelUtility.getDataFromExcelInKey("Product", "PRODUCTDATEINSTOCK");

		webDriverUtility.handlePopup(driver);
		p.ProductPageAction(productcode, productname, productdescription, productquantity, productonhand, productprice,
		productdateinstock);
		p.selectcat();
		p.saveAction();

		String producttext = p.ProductText();
		System.out.println(producttext);
		assertEquals(producttext, "Product ");

		//Diamomd conflict

//Diamomd conflict
		

		
		
	}

}
