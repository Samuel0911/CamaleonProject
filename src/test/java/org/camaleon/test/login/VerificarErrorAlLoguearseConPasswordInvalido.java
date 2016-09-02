package org.camaleon.test.login;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ISuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.xml.XmlSuite;
import org.camaleon.framework.pages.admin.login.*;
import org.camaleon.framework.utilities.LogManager;


public class VerificarErrorAlLoguearseConPasswordInvalido 
{
	protected static WebDriver driver = null;
	
	@BeforeTest
	public void onStart() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();;
		LogManager.info("Browser <FIREFOX> was opened");
    }

	@AfterTest
    public void afterTest() {           
    	driver.close();
    	LogManager.info("Browser <FIREFOX> was closed");
    }

	public void onFinish(ISuite suite) {

	}
	
	@Test
	public void VerifyErrorMessageLoginUsername(){
		  String mensajeErrorEsperado = "×\nUsername or Password incorrect";		  
		  
		  LoginPage login = new LoginPage(driver);
		  
		  String mensajeErrorActual = login.setUserName("invalid")
		  .setPassword("invalid")
		  .clickSignInButtonWithInvalidCredentials()
		  .getAlertMessage();
		  
		  Assert.assertEquals(mensajeErrorActual, mensajeErrorEsperado, 
				  "Mensaje de error no mostrado");

	}
}
