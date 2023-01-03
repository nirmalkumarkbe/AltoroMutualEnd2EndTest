package com.project.PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountHistoryPage {
	
	public static String getAccountBalance(WebDriver driver)
	{
		WebElement AvailableBalance = driver.findElement(By.xpath("//*[contains(text(),'Available balance')]//following::td[1]"));
		String strAvailableBalance =AvailableBalance.getText();
		return strAvailableBalance;
	}
	
	public static void clickTransferFund(WebDriver driver)
	{
		WebElement TransferFunds_WebLink = driver.findElement(By.xpath("//*[contains(text(),'Transfer Funds')]"));
		TransferFunds_WebLink.click();
	}

}
