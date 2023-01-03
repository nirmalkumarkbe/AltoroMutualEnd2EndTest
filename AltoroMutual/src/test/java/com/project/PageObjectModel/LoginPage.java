package com.project.PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public static void clickLogin(WebDriver driver)
	{
		WebElement OnlineBankingLogin_WebLink = driver.findElement(By.xpath("//*[contains(text(),'ONLINE BANKING LOGIN')]"));
		OnlineBankingLogin_WebLink.click();
	}
	
	public static void enterUsername(WebDriver driver, String Username)
	{
		WebElement Username_WebEdit = driver.findElement(By.id("uid"));
		Username_WebEdit.sendKeys(Username);
	}
	
	public static void enterPassword(WebDriver driver, String Password)
	{
		WebElement Password_WebEdit = driver.findElement(By.id("passw"));
		Password_WebEdit.sendKeys(Password);
	}
	
	public static void clickLoginBtn(WebDriver driver)
	{
		WebElement Login_WebBtn = driver.findElement(By.name("btnSubmit"));
		Login_WebBtn.click();
	}
	
	public static String getLoginErrorMessage(WebDriver driver)
	{
		WebElement Login_ErrorMessage = driver.findElement(By.xpath("//h1[contains(text(),'Online Banking Login')]//following::span[1]"));
		String ErrorDetails =Login_ErrorMessage.getText();
		return ErrorDetails;
	}
	

}
