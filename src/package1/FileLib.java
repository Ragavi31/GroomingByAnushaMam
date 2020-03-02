package package1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileLib {
	String filePath = "";

	public String getExcelData(String sheetName, int rowNum, int cellNum)
			throws EncryptedDocumentException, IOException {

		FileInputStream fis = new FileInputStream(filePath);

		Workbook wb = WorkbookFactory.create(fis);
		Cell cl = wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum);
		String value = cl.getStringCellValue();
		wb.close();
		return value;
	}

	public void setExcelData(String sheetName, int rowNum, int cellNum, String data)
			throws EncryptedDocumentException, IOException {

		FileInputStream fis = new FileInputStream(filePath);
		Workbook wb = WorkbookFactory.create(fis);
		Row row = wb.getSheet(sheetName).getRow(rowNum);
		Cell cl = row.createCell(cellNum);
		cl.setCellValue(data);
		FileOutputStream fos = new FileOutputStream(filePath);
		wb.write(fos);
		wb.close();
	}

	public int getRowCount(String sheetName) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(new File("filePath"));
		Workbook wb = WorkbookFactory.create(fis);
		int rowIndex = wb.getSheet(sheetName).getLastRowNum();
		return rowIndex;
	}
	
	public String propertyKeyValue(String key) throws IOException
	{
		FileInputStream fis=new FileInputStream("./config.properties");
		Properties prop=new Properties();
		prop.load(fis);
		return prop.getProperty(key);
		
	}
}
