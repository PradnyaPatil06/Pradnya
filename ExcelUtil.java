package commonUtils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class ExcelUtil {


	public String getDataFromExcel(String Sheetname,int rownum,int Cellnum) throws EncryptedDocumentException, IOException
	{
	
	FileInputStream fis = new FileInputStream("src\\test\\resources\\data.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet(Sheetname);
	Row rw = sh.getRow(rownum);
	Cell cl = rw.getCell(Cellnum);
	String value = cl.getStringCellValue();
	return value;
	

	}

}
