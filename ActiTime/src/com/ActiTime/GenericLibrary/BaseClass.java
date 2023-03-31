package com.ActiTime.GenericLibrary;

import java.io.IOException;
import java.sql.Driver;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.ActiTime.pomObjectRepo.LoginPage;

public class BaseClass {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	public static WebDriver driver;
	FileLibrary f= new FileLibrary();
@BeforeSuite
public void databaseconnected() {
	Reporter.log("database is connected",true);
}

@AfterSuite
public void databasedisconnected() {
	Reporter.log("database is disconnected",true);
}

@BeforeClass
public void launchbrowser() throws IOException {
	ChromeOptions option = new ChromeOptions();
	option.addArguments("--remote-allow-origins=*");
	WebDriver driver = new ChromeDriver(option);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	String URL = f.ReadDataFromProperty("url");
	driver.get(URL);
	Reporter.log("browser is launched",true);
}
@AfterClass
public void closebrowser() {
	driver.close();
	Reporter.log("browser closed",true);
}

@BeforeMethod
public void login() throws IOException {
	String un = f.ReadDataFromProperty("username");
	String pw = f.ReadDataFromProperty("password");
	LoginPage lp = new LoginPage(driver);

	//driver.findElement(By.id("username")).sendKeys();
	lp.getUntbx().sendKeys(un);
	//driver.findElement(By.name("pwd")).sendKeys(pw);
	lp.getPwtbx().sendKeys(pw);
	//driver.findElement(By.xpath("//div[.='Login ']")).click();
	lp.getLgbtn().click();
	
	Reporter.log("logg in successfully",true);
}
@AfterMethod
public void logout() {
	driver.findElement(By.id("logoutLink")).click();
	Reporter.log("logout is done",true);
}
}