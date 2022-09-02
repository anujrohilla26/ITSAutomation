package utility.masterdata;

import utility.FileManager;
import utility.constants.Constants;

public interface PreferredLaneData {
	
	//MODULE TEST DATA
	
			String Origin=getPreferredLaneData("Origin");
			String Destination =getPreferredLaneData("Destination");
			String EquipmentType=getPreferredLaneData("EquipmentType");
			String TransitTypes =getPreferredLaneData("TransitTypes");
			String ModeType=getPreferredLaneData("ModeType");
			String SelectDay =getPreferredLaneData("SelectDay");
 			String ServiceTypes =getPreferredLaneData("SelectDay");
			String TransactionTypes=getPreferredLaneData("ModeType");
			String EQUIP =getPreferredLaneData("SelectDay");			
			
			/**METHOD**/
			 
			 /*
			  * fetch Module Data
			  */
			public static String getPreferredLaneData(String key) {
				return FileManager.readColumnValueUsingKeyFromExcel(Constants.TESTDATA_PATH, "MasterData.xlsx", "PreferredLaneData", key);
			}


}
