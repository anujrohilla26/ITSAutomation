package utility.masterdata;

import utility.FileManager;
import utility.constants.Constants;

public interface ModuleData {
	
	
	//MODULE TEST DATA
	
		String DedicatedOpportunitiesModule=getModuleData("DedicatedOpportunitiesModule");
		String CurrentLoadsModule =getModuleData("CurrentLoadsModule");
		String PreferredLaneSubscriptionsModule =getModuleData("PreferredLaneSubscriptionsModule");

		
		
		
		/**METHOD**/
		 
		 /*
		  * fetch Module Data
		  */
		public static String getModuleData(String key) {
			return FileManager.readColumnValueUsingKeyFromExcel(Constants.TESTDATA_PATH, "MasterData.xlsx", "ModuleNames", key);
		}

}
