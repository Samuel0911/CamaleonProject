package org.camaleon.test.login;

import java.util.List;

import org.camaleon.framework.pages.admin.login.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ISuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.xml.XmlSuite;
import org.testng.Assert;

public class VerificarDashboardPageEsMostradoConLoginYPassCorrectos {
protected static WebDriver driver = null;
	
	@BeforeTest
	public void onStart() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();;
		//LogManager.info("Browser <" + PropertiesReader.getBrowser() + "> was opened");
    }

	@AfterTest
    public void generateReport() {           
    	driver.close();
    	//LogManager.info("Browser <" + PropertiesReader.getBrowser() + "> was closed");
    }

	public void onFinish(ISuite suite) {

	}
	
	@Test
	public void VerifyErrorMessageLoginUsername(){
		  
		  String dashboardLabelEsperado = "Dashboard";  
		  
		  LoginPage login = new LoginPage(driver);
		  
		  String actualDashboardLabel = login.setUserName("admin")
		  .setPassword("admin")
		  .clickSignInButton()
		  .getDashboardLabel();
		  /*.LeftMenu()
		  .clickUsersMenu()
		  .clickAddUserMenu()
		  .setFirstName("Samuel")
		  .setLastName("Vargas");
		  */
	
		  Assert.assertEquals(actualDashboardLabel,dashboardLabelEsperado,
				  "Dashboard label invalido");

	}
}
