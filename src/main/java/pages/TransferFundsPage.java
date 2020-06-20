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

public class TransferFundsPage extends MenuPage{
	
	
	@When("Select from in Transfer Funds")
	public TransferFundsPage selectFrom() {
		selectDropDownUsingIndex(getDriver().findElement(By.id("fromAccount")), 0);
		return this;
	}

	@When("Select to in Transfer Funds")
	public TransferFundsPage selectTo() {
		selectDropDownUsingIndex(getDriver().findElement(By.id("toAccount")), 1);
		return this;
	}
	
	@When("Type the amount to transfer in Transfer Funds")
	public TransferFundsPage typeAmount(String amount) {
		type(getDriver().findElement(By.id("amountTransferred")), amount);
		return this;
	}
	
	@When("The Review is clicked in Transfer Funds")
	public TransferFundsPage clickReview() {
		click(getDriver().findElement(By.xpath("//button[text()='Review']")));
		return this;
	}
	
	@When("The Confirm Transfer is clicked in Transfer Funds")
	public TransferFundsPage clickConfirmTransfer() {
		click(getDriver().findElement(By.xpath("//button[text()='Confirm Transfer']")));
		return this;
	}	
	
	@When("Verify the transfer success")
	public TransferFundsPage verifyTransferSuccess() {
		verifyPartialText(getDriver().findElement(By.xpath("//h1")),"successful");
		return this;
	}
	
	
	
}
