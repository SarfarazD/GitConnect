package utility;

import org.testng.annotations.DataProvider;

public class TestNG 
{
	private static JavaHelpers Read1 = new JavaHelpers();

	
	//Boat-Ed
	
		//RegistrationTest - Test 1
		@DataProvider(name ="Trip")
		public static Object[][] Registration() throws Exception
			{
			        Object[][] retObjArr=
			        		Read1.GetTableArray(Constants.TestDataFileLocation, "CT","Trip");
			        // Excel File must be of Word 97-2003 format as jxl support that only
			        return(retObjArr);
			}
		
	//FeedBackForm
		@DataProvider(name ="Feedback")
		public static Object[][] FeedbackForm() throws Exception
			{
			        Object[][] retObjArr=
			        		Read1.GetTableArray(Constants.TestDataFileLocation, "CT","Feedback");
			        // Excel File must be of Word 97-2003 format as jxl support that only
			        return(retObjArr);
			}
}
