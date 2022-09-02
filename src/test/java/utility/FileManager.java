package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class FileManager {
	    
	 
	public static String readFileAsString(String file)throws Exception
	{
		return new String(Files.readAllBytes(Paths.get(file)));
	}
	

	public static String readProperty(String filepath,String key) {
		String keyvalue = null;
		try {
		FileReader reader = new FileReader(filepath);
		Properties p=new Properties();  
		p.load(reader);
	    keyvalue= p.getProperty(key);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return keyvalue;
	}
	
	public void cleanDir(String dirName) {
		File directory = new File(dirName);

		// Get all files in directory
		File[] files = directory.listFiles();
		for (File file : files) {
			// Delete each file
			if (!file.delete()) {
				// Failed to delete file
				System.out.println("Failed to delete " + file);
			}
		}}	
	
	
	@SuppressWarnings("deprecation")
	public static String readColumnValueUsingKeyFromExcel(String filePath, String fileName,String sheetName,String keyName) {
		File file = new File(filePath + File.separator + fileName);
		String value = null;
		FileInputStream inputStream;
		Workbook workbook = null;
		Row row =null;

		try{
			inputStream = new FileInputStream(file);
			workbook = WorkbookFactory.create(inputStream);
		}
		catch(Exception e){

		}
		Sheet sheet = workbook.getSheet(sheetName);
		Row firstRow = sheet.getRow(0);
		int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
		for (int i = 1; i <=rowCount; i++) {
			row = sheet.getRow(i);
			for (int j = 0; j < firstRow.getLastCellNum(); j++) {
				if(row.getCell(j).getStringCellValue().equals(keyName)) {
					row.getCell(j).setCellType(Cell.CELL_TYPE_STRING);
					if(!row.getCell(j).getStringCellValue().trim().equals("")){
						if(firstRow.getCell(j).getStringCellValue()!=null) {
							//value = row.getCell(j+1).getStringCellValue().trim();
							Cell cell =row.getCell(j+1);
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								value=cell.getRichStringCellValue().getString();
								break;
							case Cell.CELL_TYPE_NUMERIC:
								value=Integer.toString(((int)cell.getNumericCellValue()));
								break;
							}

							break;
						}
					}
				}
				else
					break;
			}


		}

		return value;
  }
}
