package utility.masterdata;

import utility.FileManager;
import utility.constants.Constants;

public interface ReloadsData {

	String ReloadsModalTitle = getReloadsData("ReloadsModalTitle");
	
	
	
	
	/**METHOD**/
	 
	 /*
	  * fetch Reloads Data
	  */
	public static String getReloadsData(String key) {
		return FileManager.readColumnValueUsingKeyFromExcel(Constants.TESTDATA_PATH, "MasterData.xlsx", "ReloadsData", key);
	}


	
	
}
