package com.banking.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.banking.pageobjects.LoginPage;
import com.banking.utilities.XLUtils;

public class TC_LoginTest_001 extends BaseClass{
public 	String path=System.getProperty("user.dir") +"/src/test/java/TestData/LoginData.xlsx";
	@Test
	public void LoginTest() throws Exception {
			
	//logger.info("opened url");
	LoginPage lp=new LoginPage(driver);
	lp.setUserName(username);
	//logger.info("entered uname");
	lp.setPassword(password);
	//logger.info("entered password");
	
	lp.clickSubmit();
	if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
		Assert.assertTrue(true);
		XLUtils.setCellData(path,"Sheet1",3,3,"pass");
		//logger.info("loginTest passes");
		
	}
	else {
		captureScreen(driver,"LoginTest" );
		Assert.assertTrue(false);
		XLUtils.setCellData(path,"Sheet1",5,5,"fail");
		//logger.warn("login failed");
	}
	}
}

