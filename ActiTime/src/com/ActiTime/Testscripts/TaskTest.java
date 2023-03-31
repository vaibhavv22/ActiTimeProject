package com.ActiTime.Testscripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.ActiTime.GenericLibrary.BaseClass;
import com.ActiTime.GenericLibrary.FileLibrary;
import com.ActiTime.pomObjectRepo.HomePage;
import com.ActiTime.pomObjectRepo.TaskPage;

public class TaskTest extends BaseClass{
@Test
public void createcustomer() throws EncryptedDocumentException, IOException {
	HomePage hp=new HomePage(driver);
	hp.getTasklink().click();
	
	TaskPage tp=new TaskPage(driver);
	tp.getAddNewBtn().click();
	tp.getNewcust().click();
	FileLibrary f= new FileLibrary();
	String name = f.ReadDataFromExcelFile("Sheet1", 4, 1);
	tp.getCustname().sendKeys(name);
	String desc = f.ReadDataFromExcelFile("Sheet1", 4, 2);
	tp.getCustdesp().sendKeys(desc);
	tp.getCreatecust().click();
}
}
