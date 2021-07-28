package Hackathon.IdentifyCourses3;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class InputExcel 
{
	public String getData(String s) throws IOException
	{
		File file=new File("C:\\Users\\Aayush\\eclipse-workspace\\IdentifyCourses3\\ExcelFile\\Input.xlsx");
		FileInputStream read=new FileInputStream(file);
		
		XSSFWorkbook workbook=new XSSFWorkbook(read);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		Row row=null;
		String val=null;
		int flag=0;
		Iterator<Row> rows=sheet.iterator();
		while(rows.hasNext())
		{
			row=rows.next();
			if(row.getCell(0).getStringCellValue().equalsIgnoreCase(s))
			{
				val=row.getCell(1).getStringCellValue();
				flag=1;
			}
			if(flag==1)
			{
				break;
			}
		}
		return val;
	}

}
