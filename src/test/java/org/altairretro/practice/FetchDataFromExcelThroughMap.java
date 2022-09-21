package org.altairretro.practice;

import java.io.IOException;
import java.util.Map;

import genericUtility.ExcelUtility;
import genericUtility.IConstantPath;

public class FetchDataFromExcelThroughMap {

	public static void main(String[] args) throws IOException {
		ExcelUtility excelUtility=new ExcelUtility();
		excelUtility.openExcel(IConstantPath.EXCEL_PATH);
		Map<String,String> map=excelUtility.getDataFromExcelInMap("Form", "NAME");
		System.out.println(map.get("Email"));

	}

}
