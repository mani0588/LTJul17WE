package seleniumPack;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static void main(String[] args) throws InvalidFormatException, IOException {

		// identify file and convert to workbook
		File excel = new File(
				"C:\\Users\\p7165950\\Documents\\automation\\LTJul17WE\\automation.web.selenium\\resources\\TestData.xlsx");
		XSSFWorkbook book = new XSSFWorkbook(excel);

		// locate sheet
		XSSFSheet sh1 = book.getSheet("Sheet1");

		// locate row and colm and read data
		int rows = sh1.getLastRowNum() + 1;
		int colms = sh1.getRow(0).getLastCellNum();

		List<String> allValues = new ArrayList<>();
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < colms; j++) {
				String value = sh1.getRow(i).getCell(j).getStringCellValue();
				System.out.println(value);
				allValues.add(value);
			}
		}

		Set<String> setValues = new HashSet<>(allValues);
		for (String val : setValues) {
			long repeatCount = allValues.stream().filter(v -> v.equals(val)).count();
			if (repeatCount > 1) {
				System.out.println(val + " - " + repeatCount);
			}
		}

	}

}
