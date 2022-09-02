package utility;

import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;


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
	
	public static void cleanDir(String dirName) {
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
	
}
