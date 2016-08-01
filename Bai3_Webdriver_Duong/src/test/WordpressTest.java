package test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import common.*;
import pageobject.*;

public class WordpressTest {

	public class UserModel {
		public String Dbname;
		public String Uname;
		public String Site;
		public String Namelogin;
		public String Passlogin;
		public String Emaillogin;
		public String Userlogin;
		public String Passwdlogin;
	}

	@BeforeTest
	@Parameters("browser")

	public void setUp(String browser) throws Exception {
		OpenBrowser.multi_browser(browser);
		Common.driver.manage().timeouts().implicitlyWait(Common.TIMEOUTS, TimeUnit.SECONDS);
	}

	@Test(priority = 1, enabled = true)
	public void bai3() throws Exception {

		Common.driver.get(Common.URL);
		Common.driver.findElement(WordpressObject.btnContinue).click();
		Common.driver.findElement(WordpressObject.btnLetsgo).click();

		// setup

		XSSFSheet ExcelWSheetSetup = ExcelCommon_POI.setExcelFile("Bai3_wordpress.xlsx", "Setup");

		String dbname = ExcelCommon_POI.getCellData(1, 1, ExcelWSheetSetup);
		String uname = ExcelCommon_POI.getCellData(1, 2, ExcelWSheetSetup);

		Common.driver.findElement(WordpressObject.txtDbName).clear();
		Common.driver.findElement(WordpressObject.txtDbName).sendKeys(dbname);
		Common.driver.findElement(WordpressObject.txtUname).clear();
		Common.driver.findElement(WordpressObject.txtUname).sendKeys(uname);
		Common.driver.findElement(WordpressObject.txtPasswd).clear();
		Common.driver.findElement(WordpressObject.btnSubmit).click();

		Thread.sleep(3000);
		Common.driver.findElement(WordpressObject.btnRuntheinstall).click();

		// admin

		XSSFSheet ExcelWSheetAdmin = ExcelCommon_POI.setExcelFile("Bai3_wordpress.xlsx", "Admin");

		String userSite = ExcelCommon_POI.getCellData(1, 1, ExcelWSheetAdmin);
		String userNamelogin = ExcelCommon_POI.getCellData(1, 2, ExcelWSheetAdmin);
		String userPasslogin = ExcelCommon_POI.getCellData(1, 3, ExcelWSheetAdmin);
		String userEmaillogin = ExcelCommon_POI.getCellData(1, 4, ExcelWSheetAdmin);

		Common.driver.findElement(WordpressObject.txtSite).clear();
		Common.driver.findElement(WordpressObject.txtSite).sendKeys(userSite);
		Common.driver.findElement(WordpressObject.txtLogin).clear();
		Common.driver.findElement(WordpressObject.txtLogin).sendKeys(userNamelogin);
		// Thread.sleep(3000);
		// Common.driver.findElement(WordpressObject.txtLogin).sendKeys(Keys.TAB);
		Common.driver.findElement(WordpressObject.txtPasswdadmin).clear();
		Common.driver.findElement(WordpressObject.txtPasswdadmin).sendKeys(userPasslogin);
		Thread.sleep(3000);
		Common.driver.findElement(WordpressObject.cbxPasswdadmin).click();

		Common.driver.findElement(WordpressObject.txtEmailadmin).clear();
		Common.driver.findElement(WordpressObject.txtEmailadmin).sendKeys(userEmaillogin);
		Thread.sleep(3000);

		Common.driver.findElement(WordpressObject.btnSubmitadmin).click();
		Thread.sleep(3000);
		Common.driver.findElement(WordpressObject.btnLogin).click();

		// login

		Common.driver.findElement(WordpressObject.txtUserlogin).clear();
		Common.driver.findElement(WordpressObject.txtUserlogin).sendKeys(userNamelogin);
		Common.driver.findElement(WordpressObject.txtPasswdlogin).clear();
		Thread.sleep(3000);
		Common.driver.findElement(WordpressObject.txtPasswdlogin).sendKeys(userPasslogin);
		Common.driver.findElement(WordpressObject.btnSubmitlogin).click();
		try {
			String ActualMessage = Common.driver.findElement(WordpressObject.actualMess).getText();
			String ExpectMessage = "Welcome to WordPress!";
			Assert.assertEquals(ActualMessage, ExpectMessage);
			ExcelCommon_POI.writeDataToExcel(1, 5, "Bai3_wordpress.xlsx", "Admin", "Passed");
			
			System.out.println("Pass");
		} catch (Exception e) {
			ExcelCommon_POI.writeDataToExcel(1, 5, "Bai3_wordpress.xlsx", "Admin", "Failed");
			System.out.println("Fail");

		}

	}

	@AfterTest
	public void tearDown() throws Exception {
		// Common.driver.quit();
	}
}
