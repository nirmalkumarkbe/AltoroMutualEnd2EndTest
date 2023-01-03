package com.project.Testcases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.project.PageObjectModel.AccountHistoryPage;
import com.project.PageObjectModel.AccountPage;
import com.project.PageObjectModel.LoginPage;
import com.project.PageObjectModel.RecentTransactionPage;
import com.project.PageObjectModel.TransferFundsPage;

public class Testcaseflow1 {
	
	public WebDriver driver = null;
	Properties prop = readPropertiesFile("F:\\Project\\AltoroMutual\\SupportingFiles\\Config.properties");
	
	public static Properties readPropertiesFile(String fileName)  {
	      FileInputStream fis = null;
	      Properties prop = null;
	      try {
	         fis = new FileInputStream(fileName);
	         prop = new Properties();
	         prop.load(fis);
	      } catch(FileNotFoundException fnfe) {
	         fnfe.printStackTrace();
	      } catch(IOException ioe) {
	         ioe.printStackTrace();
	      } 
	      return prop;
	   }
	
	@BeforeMethod
	public void launchURL()
	{
		System.out.println(System.getProperty("user.dir"));
		System.setProperty("webdriver.chrome.driver", "F:\\Project\\AltoroMutual\\SupportingFiles\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(prop.getProperty("URL"));
		driver.manage().window().maximize();
		
	}
	
	@Test
	public void testcaseflow(){
		
		//Clicking on Online Banking Login link
		LoginPage.clickLogin(driver);
		//Entering Username
		LoginPage.enterUsername(driver, prop.getProperty("Invalid_Username"));
		//Entering Password
		LoginPage.enterPassword(driver, prop.getProperty("Invalid_Password"));
		//Click Login
		LoginPage.clickLoginBtn(driver);
		
		//Validating the Error message for invalid credentials
		String ExpectedErrorDetails = "Login Failed: We're sorry, but this username or password was not found in our system. Please try again.";
		String ActualErrorDetails = LoginPage.getLoginErrorMessage(driver);
		SoftAssert s = new SoftAssert();
		s.assertEquals(ActualErrorDetails, ExpectedErrorDetails,"Error message displayed for invalid credentials is correct");
		
		// Retrying with Correct Credentials
		//Entering Username
		LoginPage.enterUsername(driver, prop.getProperty("Username"));
		//Entering Password
		LoginPage.enterPassword(driver, prop.getProperty("Password"));
		//Click Login
		LoginPage.clickLoginBtn(driver);
		
		//Getting the WelcomeMessage for the logged user
		String ActualWelcomeMessage = AccountPage.getAccountUserLabelWelcomeMessage(driver);
		String ExpectedWelcomeMessage = "Hello Admin User";
		s.assertEquals(ActualWelcomeMessage, ExpectedWelcomeMessage, "Validating the welcome Message");
		
		//Clicking View Account Summary
		AccountPage.clickAccountSummary(driver);
		AccountPage.selectAccount(driver, "800001 Checking");
		AccountPage.clickGo(driver);
		Assert.assertTrue(true, AccountHistoryPage.getAccountBalance(driver));
		
		//Click on Transfer Funds
		AccountHistoryPage.clickTransferFund(driver);
		
		// Select From and To Account
		TransferFundsPage.selectFromAccount(driver, "800000 Corporate");
		TransferFundsPage.selectToAccount(driver, "800001 Checking");
		TransferFundsPage.enterAmounttoEnter(driver, "9876");
		TransferFundsPage.clickTranferMoney(driver);
		
		//Getting the transfer fund message
		String ExpectedTransferMessage = "9876.0 was successfully transferred from Account 800000 into Account 800001";
		String ActualTransferMessage = TransferFundsPage.getTransferFundMessage(driver);
		
		//Validating the Fund Transfer message
		String arr[] = new String[2];
		arr = ActualTransferMessage.split("at");
		s.assertEquals(arr[0].trim(), ExpectedTransferMessage.trim());
		//Clicking on View Recent Transactions
		TransferFundsPage.clickViewRecentTransactions(driver);
		RecentTransactionPage.validateTransactions(driver);
		//Submitting the feedback form
		AccountPage.clickContactUs(driver);
		AccountPage.clickOnlineForm(driver);
		AccountPage.fillFeedback(driver, "test@gmail.com", "Test Subject","Test Questions/Comments");
		String ActualThankYouMessage = AccountPage.getThankYouMessage(driver);
		String ExpectedThankYouMessage = "Thank You";
		s.assertEquals(ActualThankYouMessage, ExpectedThankYouMessage);
		AccountPage.clickSignOff(driver);
		s.assertAll();
		
	}

}
