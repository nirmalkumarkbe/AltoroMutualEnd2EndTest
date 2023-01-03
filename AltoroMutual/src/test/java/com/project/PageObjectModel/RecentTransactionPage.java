package com.project.PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RecentTransactionPage {
	
	public static void validateTransactions(WebDriver driver)
	{
		WebElement FirstAccountID = driver.findElement(By.xpath("//*[@id=\"_ctl0__ctl0_Content_Main_MyTransactions\"]/tbody/tr[2]/td[3]"));
		WebElement SecondAccountID = driver.findElement(By.xpath("//*[@id=\"_ctl0__ctl0_Content_Main_MyTransactions\"]/tbody/tr[3]/td[3]"));
		
		WebElement FirstAction = driver.findElement(By.xpath("//*[@id=\"_ctl0__ctl0_Content_Main_MyTransactions\"]/tbody/tr[2]/td[4]"));
		WebElement SecondAction = driver.findElement(By.xpath("//*[@id=\"_ctl0__ctl0_Content_Main_MyTransactions\"]/tbody/tr[3]/td[4]"));
				
		WebElement FirstAmount = driver.findElement(By.xpath("//*[@id=\"_ctl0__ctl0_Content_Main_MyTransactions\"]/tbody/tr[2]/td[5]"));
		WebElement SecondAmount = driver.findElement(By.xpath("//*[@id=\"_ctl0__ctl0_Content_Main_MyTransactions\"]/tbody/tr[3]/td[5]"));
		
		if(FirstAccountID.getText().equalsIgnoreCase("800001"))
		{
			if(FirstAction.getText().equalsIgnoreCase("Deposit"))
			{
				if(FirstAmount.getText().equalsIgnoreCase("$9876.00"))
				{
					System.out.println("Deposit Transaction is displayed correctly");
				}
			}
		}
		
		if(SecondAccountID.getText().equalsIgnoreCase("800000"))
		{
			if(SecondAction.getText().equalsIgnoreCase("Withdrawal"))
			{
				if(SecondAmount.getText().equalsIgnoreCase("-$9876.00"))
				{
					System.out.println("Withdrawal Transaction is displayed correctly");
				}
			}
		}

	}
	
	public static void clickContactUs(WebDriver driver)
	{
		WebElement ContactUS = driver.findElement(By.xpath("//*[contains(text(),'Contact Us')]"));
		ContactUS.click();
	}

}
