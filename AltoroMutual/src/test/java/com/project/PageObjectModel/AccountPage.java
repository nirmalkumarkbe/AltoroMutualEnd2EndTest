package com.project.PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AccountPage {

	public static String getAccountUserLabelWelcomeMessage(WebDriver driver)
	{
		WebElement UserLabelWelcomeMessage = driver.findElement(By.xpath("//h1"));
		String WelcomeMessage =UserLabelWelcomeMessage.getText();
		return WelcomeMessage;
	}
	
	public static void clickAccountSummary(WebDriver driver)
	{
		WebElement AccountSummary_WebLink = driver.findElement(By.xpath("//*[contains(text(),'View Account Summary')]"));
		AccountSummary_WebLink.click();
	}
	
	public static void selectAccount(WebDriver driver,String AccountName)
	{
		WebElement viewAccount_WebList = driver.findElement(By.xpath("//*[contains(text(),'View Account Details')]//following::select"));
		Select s = new Select(viewAccount_WebList);
		s.selectByVisibleText(AccountName);
	}
	
	public static void clickGo(WebDriver driver)
	{
		WebElement Go_WebBtn = driver.findElement(By.xpath("//*[contains(text(),'View Account Details')]//following::input"));
		Go_WebBtn.click();
	}
	
	public static void clickContactUs(WebDriver driver)
	{
		WebElement ContactUS = driver.findElement(By.xpath("//*[contains(text(),'Contact Us')]"));
		ContactUS.click();
	}
	
	public static void clickOnlineForm(WebDriver driver)
	{
		WebElement onlineform = driver.findElement(By.xpath("//*[contains(text(),'online form')]"));
		onlineform.click();
	}
	
	public static void fillFeedback(WebDriver driver, String Email, String Subject, String Questions)
	{
		WebElement EmailAddress_WebEdit = driver.findElement(By.xpath("//*[contains(text(),'Your Email Address')]//following::input"));
		WebElement Subject_WebEdit = driver.findElement(By.xpath("//*[contains(text(),'Subject')]//following::input"));
		WebElement Questions_WebEdit = driver.findElement(By.xpath("//*[contains(text(),'Question/Comment:')]//following::TEXTAREA"));
		EmailAddress_WebEdit.sendKeys(Email);
		Subject_WebEdit.sendKeys(Subject);
		Questions_WebEdit.sendKeys(Questions);
		WebElement submit_btn = driver.findElement(By.name("submit"));
		submit_btn.click();
		
	}
	
	public static String getThankYouMessage(WebDriver driver)
	{
		WebElement ThankYouMessage = driver.findElement(By.xpath("//h1"));
		String ThanksMessage =ThankYouMessage.getText();
		return ThanksMessage;
	}
	
	public static void clickSignOff(WebDriver driver)
	{
		WebElement SignOff = driver.findElement(By.xpath("//*[contains(text(),'Sign Off')]"));
		SignOff.click();
	}
	
}
