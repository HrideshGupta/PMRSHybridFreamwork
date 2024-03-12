package qa.utils;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class Utilities {

	@Test
	public static Object[][] readExcel() throws Exception {

		String excelPath = "D:\\Selenium\\RTS_LMD\\src\\main\\java\\qa\\testdata\\TestData.xlsx";
		String fileNameString = "TestData";
		String sheetName = "Sheet1";
		File file = new File(excelPath);

		FileInputStream fis = new FileInputStream(file);

		XSSFWorkbook wb = new XSSFWorkbook(fis);

		XSSFSheet sheet = wb.getSheet(sheetName);

		int rowCount = sheet.getLastRowNum();
		System.out.println("Total Rows : " + rowCount);

		String data = sheet.getRow(0).getCell(1).getStringCellValue();
		System.out.println(data);

		for (int i = 0; i <= rowCount; i++) {
			Row row = sheet.getRow(i);
			for (int j = 0; j < row.getLastCellNum(); j++) {

				String data1 = sheet.getRow(i).getCell(j).getStringCellValue();
				System.out.print(data1 + "     ");
			}
			System.out.println();

		}
		return null;

	}	
}
