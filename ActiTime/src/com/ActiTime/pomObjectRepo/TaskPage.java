package com.ActiTime.pomObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TaskPage {
	//declaration
	@FindBy(xpath = "//div[.='Add New']")		//dont give semicolon in @
	private WebElement addNewBtn;
	
	@FindBy(xpath="//div[.='New Customer']")
	private WebElement newcust;
	
	@FindBy(xpath = "(//input[@placeholder='Enter Customer Name'])[2]")
	private WebElement custname;
	
	@FindBy(xpath="//textarea[@placeholder='Enter Customer Description']")
	private WebElement custdesp;
	
	@FindBy(xpath="//div[.='Create Customer']")
	private WebElement createcust;
		
	//getters method to get private data

	public WebElement getAddNewBtn() {
		return addNewBtn;
	}

	public WebElement getNewcust() {
		return newcust;
	}

	public WebElement getCustname() {
		return custname;
	}

	public WebElement getCustdesp() {
		return custdesp;
	}

	public WebElement getCreatecust() {
		return createcust;
	}
	
	//utilization
	public TaskPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
