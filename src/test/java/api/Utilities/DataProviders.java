package api.Utilities;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	// Returns a 2-D array
	@DataProvider(name = "AllData")
	public String[][] AllDataProvider(){
		
		String fileName = System.getProperty("user.dir")+"//TestData//TestData.xlsx";
		
		// Get total rows count
		int totalRowCount = ReadExcelFile.getRowCount(fileName, "Sheet1");
		
		// Get total columns count
		int totalColumnCount = ReadExcelFile.getColCount(fileName, "Sheet1");
		
		String userData[][] = new String[totalRowCount-1][totalColumnCount];
		
		for(int rowNo = 1; rowNo < totalRowCount; rowNo++) {
			
			for(int colNo = 0; colNo < totalColumnCount; colNo++) {
				
				userData[rowNo-1][colNo] = ReadExcelFile.getCellValue(fileName, "TestData", rowNo, colNo);
				
			}
			
		}
		
		return userData;
		
	}
	
	@DataProvider(name = "UserNamesData")
	public String[] UserNamesDataProvider(){
		
		String fileName = System.getProperty("user.dir")+"//TestData//TestData.xlsx";
		
		// Get total rows count
		int totalRowCount = ReadExcelFile.getRowCount(fileName, "TestData");
		
		String userNamesData[] = new String[totalRowCount];
		
		for(int rowNo = 1; rowNo < totalRowCount; rowNo++) {
				
				userNamesData[rowNo-1] = ReadExcelFile.getCellValue(fileName, "TestData", rowNo, 1);
			
		}
		
		return userNamesData;
		
	}
	
}
