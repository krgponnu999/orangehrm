package datadriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Datadriven_class
{

	public XSSFWorkbook wb =  null;
	public XSSFSheet sh = null;
	public XSSFRow row = null;
	public XSSFCell cell = null;

	public Datadriven_class(String data2 ) throws IOException 
	{
		File f = new File(data2);
		FileInputStream fis = new FileInputStream(f);
		wb = new XSSFWorkbook(fis);
	}
	public int rowcount (int index) 
	{
		int row = wb.getSheetAt(index).getLastRowNum();
		row++;
		return row;
	}
	public String getdata (int shno,int row,int col) 
	{
		try 
		{
			cell = wb.getSheetAt(shno).getRow(row).getCell(col);
			if(cell.getCellType()==CellType.STRING) 
		
				return cell.getStringCellValue();
			else if (cell.getCellType()==CellType.NUMERIC || cell.getCellType()==CellType.FORMULA) 
			{
				String cellvalue =  String.valueOf(cell.getNumericCellValue());
				if(DateUtil.isCellDateFormatted(cell))
				{
					DateFormat df = new SimpleDateFormat("DD-MM-YYYY");
					Date date = cell.getDateCellValue();
		        	 cellvalue = df.format(date);
				}return cellvalue;
			}else if (cell.getCellType()==CellType.BLANK)
			
				return " " ;
	
			else 
				return String.valueOf(cell.getBooleanCellValue());
			} 

		catch (Exception e) 
		{
			e.printStackTrace();
			return +row+ "and" +cell+ "row and column does not exit in excel";
		}
	}
}
