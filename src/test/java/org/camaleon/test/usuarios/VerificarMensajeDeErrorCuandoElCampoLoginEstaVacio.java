package org.camaleon.test.usuarios;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.camaleon.framework.pages.admin.login.*;
import org.camaleon.framework.pages.admin.view.CreateUserPage;
import org.camaleon.framework.utilities.common.LogManager;

public class VerificarMensajeDeErrorCuandoElCampoLoginEstaVacio {
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

	@Test
	public void VerifyErrorMessageLoginFieldtextIsEmpty(){
		  
		String mensajeErrorEsperado = "This field is required.";		  
		  		  
		  LoginPage login = new LoginPage(driver);
		  
		  
		  login.setUserName("admin")
		  .setPassword("admin")
		  .clickSignInButton()		  
		  .LeftMenu()
		  .clickUsersMenu()
		  .clickAddUserMenu()		  
		  .setFirstName("Samuel")
		  .setLastName("Vargas")		  
		  .setLogin("")
		  .setEmail("test@test.com")
		  .setPassword("test")
		  .clickCreateButtonWithEmptyData();
		  
		  // Verifying Error message is present
		  CreateUserPage cp = new CreateUserPage(driver);
		  //Assert.assertTrue(cp.isEmptyMessagePresent());
		  Assert.assertTrue(cp.VerifyErrorLoginMessageIsPresent(mensajeErrorEsperado));
	}
}
