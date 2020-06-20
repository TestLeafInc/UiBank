package tests;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import hooks.TestNgHooks;
import pages.HomePage;


public class TC001_TransferFunds extends TestNgHooks{
	
	@BeforeTest(alwaysRun=true)
	public void setData() {
		testCaseName = "TC001";
		testDescription = "Verify Transfer Amount";
		category = "smoke";
		authors = "Babu";  
		dataSheetName = "TC001";
		nodes = "Funds";
	}	

	@Test(dataProvider="fetchData")
	public void createLead(String amount) {
		new HomePage()
		.clickTransferFunds()
		.selectFrom()
		.selectTo()
		.typeAmount(amount)
		.clickReview()
		.clickConfirmTransfer()
		.verifyTransferSuccess()
		.clickLogOut();
	}
	
	
}
