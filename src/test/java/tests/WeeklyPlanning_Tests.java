package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class WeeklyPlanning_Tests extends BaseTest{
	private SoftAssert softAssert;
String startDate = "Start Date";
String endDate = "Start Date";
String origin = "Origin Location";
String radius = "O-Radius (mi)";
String destination = "Destination Location";
String equipment = "Equipment Type";
String transitType = "Transit Type";
String startDateValue = "8";
String endDateValue = "13";
String originValue = " DPO, AA";
String oRadius = "150";
String destinationValue = " APO, AA";
String equipmentValue = " Dry Van";
String transiType = "Any"; 


	@Test(description="Verify for 'Weekly Planning' section --> Validation Messages")
	public void verifyValidationMessagesForWeeklyPlanning() throws InterruptedException{
		softAssert = new SoftAssert();	
		login.loginIntoApplication();
		weeklyPlanning.clickWeeklyPlanning();
		weeklyPlanning.verifyStartDateFieldText(startDate, softAssert);
		weeklyPlanning.verifyEndDateFieldText(endDate, softAssert);
		weeklyPlanning.verifyOrigin(origin, softAssert);
		weeklyPlanning.verifyRadius(radius, softAssert);
		weeklyPlanning.verifyDestination(destination, softAssert);
		weeklyPlanning.verifyEquipment(equipment, softAssert);
		weeklyPlanning.verifyTransitType(transitType, softAssert);
		weeklyPlanning.clickPlan();
		weeklyPlanning.verifyStartDateRequiredValidation();
		weeklyPlanning.verifyEndDateRequiredValidation();
		weeklyPlanning.verifyOriginRequiredValidation();
		weeklyPlanning.verifyDestinationRequiredValidation();
		weeklyPlanning.verifyEquipmentRequiredValidation();
		weeklyPlanning.verifyTransitRequiredValidation();
		weeklyPlanning.selectStartDate(startDateValue);
		weeklyPlanning.selectEndDate(endDateValue);
		weeklyPlanning.selectOriginLocation(originValue);
		weeklyPlanning.selectOradius(oRadius);
		weeklyPlanning.selectDestination(destinationValue);
		weeklyPlanning.selectEquipmentTypeDropdown(equipmentValue);
		weeklyPlanning.selectTransitType(transiType);
		weeklyPlanning.verifyStartDateRequiredValidationNotDisplayed();
		weeklyPlanning.verifyEndDateRequiredValidationNotDisplayed();
		weeklyPlanning.verifyOriginRequiredValidationNotDisplayed();
		weeklyPlanning.verifyEquipmentRequiredValidationNotDisplayed();
		weeklyPlanning.verifyDestinationRequiredValidationNotDisplayed();
		weeklyPlanning.verifyTransitRequiredValidationNotDisplayed();
		softAssert.assertAll();
	}
		
		
		
		
		
		
	}
	

