package Hackathon.IdentifyCourses3;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class OutputExcel 
{

	public void writeLevels(int r,String a,String b) throws IOException
	{	
		File file=new File("C:\\Users\\Aayush\\eclipse-workspace\\IdentifyCourses\\ExcelFile\\Output.xlsx");
		FileInputStream read=new FileInputStream(file);
		XSSFWorkbook workbook=new XSSFWorkbook(read);
		XSSFSheet sheet=workbook.getSheet("Levels");
		XSSFCellStyle cellstyle=workbook.createCellStyle();
		XSSFFont font=workbook.createFont();
		font.setBold(true);
		cellstyle.setFont(font);

		Row row=sheet.createRow(0);
		Cell cell=null;
		cell=row.createCell(0);
		cell.setCellStyle(cellstyle);
		cell.setCellValue("Levels");  //Defined heading Manually
		cell=row.createCell(1);
		cell.setCellStyle(cellstyle);
		cell.setCellValue("Number of Courses Available");	//Defined heading Manually
		
		row=sheet.createRow(r);
		row.createCell(0).setCellValue(a);
		row.createCell(1).setCellValue(b);
		
		FileOutputStream write=new FileOutputStream(file);
		workbook.write(write);
		workbook.close();	
	}
	
	public void writeLanguage(int r,String a,String b) throws IOException
	{
		File file=new File("C:\\Users\\Aayush\\eclipse-workspace\\IdentifyCourses\\ExcelFile\\Output.xlsx");
		FileInputStream read=new FileInputStream(file);
		XSSFWorkbook workbook=new XSSFWorkbook(read);
		XSSFSheet sheet=workbook.getSheet("Languages");
		XSSFCellStyle cellstyle=workbook.createCellStyle();
		XSSFFont font=workbook.createFont();
		font.setBold(true);
		cellstyle.setFont(font);

		Row row=sheet.createRow(0);
		Cell cell=null;
		cell=row.createCell(0);
		cell.setCellStyle(cellstyle);
		cell.setCellValue("Languages");  //Defined heading Manually
		cell=row.createCell(1);
		cell.setCellStyle(cellstyle);
		cell.setCellValue("Number of Courses Available");	//Defined heading Manually
		
		row=sheet.createRow(r);
		row.createCell(0).setCellValue(a);
		row.createCell(1).setCellValue(b);
		
		FileOutputStream write=new FileOutputStream(file);
		workbook.write(write);
		workbook.close();	
	}
	
	
	public void writeCoursesDetail(int r,String a,String b) throws IOException
	{
		File file=new File("C:\\Users\\Aayush\\eclipse-workspace\\IdentifyCourses\\ExcelFile\\Output.xlsx");
		FileInputStream read=new FileInputStream(file);
		XSSFWorkbook workbook=new XSSFWorkbook(read);
		XSSFSheet sheet=workbook.getSheet("Courses");
		XSSFCellStyle cellstyle=workbook.createCellStyle();
		XSSFFont font=workbook.createFont();
		font.setBold(true);
		cellstyle.setFont(font);

		Row row=sheet.createRow(0);
		Cell cell=null;
		cell=row.createCell(0);
		cell.setCellStyle(cellstyle);
		cell.setCellValue("Course Name");  //Defined heading Manually
		cell=row.createCell(1);
		cell.setCellStyle(cellstyle);
		cell.setCellValue("Course Time");	//Defined heading Manually
		
		row=sheet.createRow(r);
		row.createCell(0).setCellValue(a);
		row.createCell(1).setCellValue(b);
		
		FileOutputStream write=new FileOutputStream(file);
		workbook.write(write);
		workbook.close();
		
	}
	
}

