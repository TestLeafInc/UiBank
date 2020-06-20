package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.aventstack.extentreports.ExtentTest;

import hooks.TestNgHooks;
import io.cucumber.java.en.When;

public class HomePage extends TestNgHooks{
	
	
	@When("The logout is clicked")
	public LoginPage clickLogOut() {
		click(getDriver().findElement(By.linkText("Logout")));
		return new LoginPage();
	}

	@When("Transfer Funds is clicked")
	public TransferFundsPage clickTransferFunds() {
		click(getDriver().findElement(By.linkText("Transfer Funds")));
		return new TransferFundsPage();
	}

	
	
	
}
