1. List of all Screens
    ==>
2. for each Screen
	==> ScreenObject
	==> ScreenModule
3. Create list of scenarios.
   ==>List of test cases for each scenarios
   
   
 Tasks for team 
 
 For each screen
 1. PageObject ==> Create page object to capture all elements in the webpage
 2. PageModule ==> Create Page Module to perform all the actions that user performs.
 3. TestDataObject==> This is pojo object to hold all the test data for a given testcase
 4. TestDataProvider==> This returns test data after reading from excelsheet. The excel reader and data object creation part is abstracted to base class. Developer will have to only cast the objects returned to data object and send it.
 5. Test data in Excel wotkbook==>This stores the test data to be populated in TestDataObject. The column name in excel should match with variable name in test object. Framework uses java reflection to dynaminaclly populate fields from excel to object.
 6. 
