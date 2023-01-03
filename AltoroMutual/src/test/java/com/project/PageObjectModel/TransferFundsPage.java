package com.project.PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TransferFundsPage {
	
	public static void selectFromAccount(WebDriver driver, String FromAccount)
	{
		WebElement fromAccount_WebList = driver.findElement(By.id("fromAccount"));
		Select s = new Select(fromAccount_WebList);
		s.selectByVisibleText(FromAccount);
	}
	
	public static void selectToAccount(WebDriver driver, String ToAccount)
	{
		WebElement toAccount_WebList = driver.findElement(By.id("toAccount"));
		Select s = new Select(toAccount_WebList);
		s.selectByVisibleText(ToAccount);
	}
	
	public static void enterAmounttoEnter(WebDriver driver, String Amount)
	{
		WebElement AmountToEnter_WebEdit = driver.findElement(By.id("transferAmount"));
		AmountToEnter_WebEdit.sendKeys(Amount);
	}
	
	public static void clickTranferMoney(WebDriver driver)
	{
		WebElement TransferMoney_WebBtn = driver.findElement(By.id("transfer"));
		TransferMoney_WebBtn.click();
	}
	
	public static String getTransferFundMessage(WebDriver driver)
	{
		WebElement TransferMoneyMessage = driver.findElement(By.xpath("//*[@id=\'_ctl0__ctl0_Content_Main_postResp\']/span"));
		return TransferMoneyMessage.getText();
	}

	public static void clickViewRecentTransactions(WebDriver driver)
	{
		WebElement viewRecentTransactions_WebLink = driver.findElement(By.xpath("//*[contains(text(),'View Recent Transactions')]"));
		viewRecentTransactions_WebLink.click();
	}
}
