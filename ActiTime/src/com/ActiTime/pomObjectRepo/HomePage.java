package com.ActiTime.pomObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
//Declaration
	@FindBy (xpath="//div[.='Tasks']")
			private WebElement tasklink;
	
	@FindBy (xpath="//div[.='Reports']")
	private WebElement reportlink;
	
	@FindBy (xpath="//div[.='Users']")
	private WebElement userslink;
	
	@FindBy (id="logoutLink")
	private WebElement logoutlink;
	
	//INITIZATION
	public HomePage(WebDriver driver) {  // PARAMETERIZED CONSTRUCTOR
		PageFactory.initElements(driver, this);
	}

	
	//UTILIZATION

	public WebElement getTasklink() {
		return tasklink;
	}

	public WebElement getReportlink() {
		return reportlink;
	}

	public WebElement getUserslink() {
		return userslink;
	}

	public WebElement getLogoutlink() {
		return logoutlink;
	}
}
