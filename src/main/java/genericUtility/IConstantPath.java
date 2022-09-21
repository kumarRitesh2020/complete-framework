package genericUtility;

public interface IConstantPath {
	
	String PROJECT_PATH=System.getProperty("user.dir");
	String EXCEL_PATH=PROJECT_PATH+"/src/test/resources/Testdata.xlsx";
	String PROPERTY_FILE_PATH=PROJECT_PATH+"/src/test/resources/CommonData.properties";
	String DB_URL="jdbc:mysql://localhost:3306/test";
	

}
