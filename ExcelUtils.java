package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DecimalFormat;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;
	private static XSSFRow Row;

	// This method is to set the File path and to open the Excel file, Pass Excel
	// Path and Sheetname as Arguments to this method
	public static void setExcelFile(String Path, String SheetName) throws Exception {
		try {
			// Open the Excel file
			File resultExcel = new File(Path);
			FileInputStream ExcelFile = new FileInputStream(resultExcel);
			System.out.println(Path);
			// Access the required test data sheet
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(SheetName);
			Log.info("Excel sheet opened");
		} catch (Exception e) {
			throw (e);
		}
	}

	// This method is to read the test data from the Excel cell, in this we are
	// passing parameters as Row num and Col num
	public static String getCellData(int RowNum, int ColNum) throws Exception {
		try {
			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			String CellData;
			if (Cell.getCellTypeEnum() == CellType.NUMERIC) {
				CellData = new DecimalFormat("##").format(Cell.getNumericCellValue());
			} 
			else {
				CellData = Cell.getStringCellValue();
			}
			return CellData;
		} catch (Exception e) {
			return "";
		}
	}
	
	public static boolean getCellDataBoolean(int RowNum, int ColNum) throws Exception {
		
		boolean CellData1 = false;
		try {
			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			
			if (Cell.getCellTypeEnum() == CellType.BOOLEAN) {
				CellData1 = Cell.getBooleanCellValue();
			} 
			else {
				
			}
		} catch (Exception e) {
			
		}
		return CellData1;
	}

	
	// This method is to write in the Excel cell, Row num and Col num are the
	// parameters

	// @SuppressWarnings("static-access")
	public static void setCellData(String Result, String SheetName, String Path_Result, int RowNum, int ColNum) throws Exception {
		try {
			File resultExcel = new File(Path_Result);
			FileInputStream ExcelFile = new FileInputStream(resultExcel);
			System.out.println(Path_Result);
			//Access the required test data sheet
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			System.out.println(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(SheetName);
			Log.info("Excel sheet opened");
			Row = ExcelWSheet.getRow(RowNum);
			System.out.println(Row);
			Cell = Row.getCell(ColNum);
			;
			//Cell = Row.getCell(ColNum, null);
			if (Cell == null) {
				Cell = Row.createCell(ColNum);
				Cell.setCellValue(Result);
			} else {
				Cell.setCellValue(Result);
			}
			///////Make Font Bold//////
			//XSSFFont font= ExcelWBook.createFont();
			Font font = ExcelWBook.createFont();
		    font.setBold(true);
		    CellStyle style = ExcelWBook.createCellStyle();
		    style.setFont(font);
		    Cell.setCellStyle(style);
		    
			// Constant variables Test Data path and Test Data file name
			FileOutputStream fileOut = new FileOutputStream(Constant.Path_Result + Constant.File_Result);
			ExcelWBook.write(fileOut);
			fileOut.flush();
			fileOut.close();
		} catch (Exception e) {
			throw (e);
		}
	}

	
	
	public static int getRowContains(String sTestCaseName, int colNum) throws Exception {
		int i;
		try {
			int rowCount = ExcelUtils.getRowUsed();
			for (i = 0; i < rowCount; i++) {
				if (ExcelUtils.getCellData(i, colNum).equalsIgnoreCase(sTestCaseName)) {
					break;
				}
			}
			return i;
		} catch (Exception e) {
			Log.error("Class ExcelUtil | Method getRowContains | Exception desc : " + e.getMessage());
			throw (e);
		}
	}
	
	
	public static void setCellColor(String Color, String SheetName, String Path_Result, int RowNum, int ColNum) throws Exception {
		try {
			File resultExcel = new File(Path_Result);
			FileInputStream ExcelFile = new FileInputStream(resultExcel);
			System.out.println(Path_Result);
			//Access the required test data sheet
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			//System.out.println(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(SheetName);
			Log.info("Excel sheet opened");
			Row = ExcelWSheet.getRow(RowNum);
			Cell = Row.getCell(ColNum);
			
			CellStyle style = ExcelWBook.createCellStyle();
			
		///////Make Font Bold//////
					//XSSFFont font= ExcelWBook.createFont();
					Font font = ExcelWBook.createFont();
				    font.setBold(true);
				    
				    
				   
			
			
			
			if(Color=="GREEN") {
		    style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		    style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		    style.setFont(font);
		    
		    Cell.setCellStyle(style);
			}
			else if(Color=="RED"){
				style.setFillForegroundColor(IndexedColors.RED.getIndex());
			    style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			    style.setFont(font);
			    
			    Cell.setCellStyle(style);			
			}
			
			// Constant variables Test Data path and Test Data file name
						FileOutputStream fileOut = new FileOutputStream(Constant.Path_Result + Constant.File_Result);
						ExcelWBook.write(fileOut);
						fileOut.flush();
						fileOut.close();
			
		} catch (Exception e) {
			Log.error("Class ExcelUtil | Method setRowColor | Exception desc : " + e.getMessage());
			System.out.println(e.getMessage());
			throw (e);
		}

	}
	
	/*public static int setRowGreen() throws Exception {
		try {
			int RowCount = ExcelWSheet.getLastRowNum();
			Log.info("Total number of Row used return as < " + RowCount + " >.");
			return RowCount;
		} catch (Exception e) {
			Log.error("Class ExcelUtil | Method getRowUsed | Exception desc : " + e.getMessage());
			System.out.println(e.getMessage());
			throw (e);
		}

	}*/

	public static int getRowUsed() throws Exception {
		try {
			int RowCount = ExcelWSheet.getLastRowNum();
			Log.info("Total number of Row used return as < " + RowCount + " >.");
			return RowCount;
		} catch (Exception e) {
			Log.error("Class ExcelUtil | Method getRowUsed | Exception desc : " + e.getMessage());
			System.out.println(e.getMessage());
			throw (e);
		}

	}
}