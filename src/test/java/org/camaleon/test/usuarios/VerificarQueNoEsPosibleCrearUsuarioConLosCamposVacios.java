package org.camaleon.test.usuarios;

import org.camaleon.framework.pages.admin.login.LoginPage;
import org.camaleon.framework.pages.admin.view.CreateUserPage;
import org.camaleon.framework.pages.admin.view.DashboardPage;
import org.camaleon.framework.utilities.common.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class VerificarQueNoEsPosibleCrearUsuarioConLosCamposVacios {

	protected static WebDriver driver = null;
	@BeforeTest
	public void onStart() {
		driver = new FirefoxDriver();
		// driver = new ChromeDriver();
		driver.manage().window().maximize();;
		LogManager.info("Browser <FIREFOX> was opened");
	    }
 
		@AfterTest
	    public void generateReport() {           
	    	driver.close();
	    	LogManager.info("Browser <FIREFOX> was closed");
    }
	
	@Test
	public void VerifyUserIsCreated(){
		  
		String mensajeErrorEsperado = "This field is required.";	
		  
		  LoginPage login = new LoginPage(driver);
		  
		  login.setUserName("admin")
		  .setPassword("admin")
		  .clickSignInButton()
		  .LeftMenu()
		  .clickUsersMenu()
		  .clickAddUserMenu()
		  .setFirstName("")
		  .setLastName("")
		  .setLogin("")
		  .setEmail("")
		  .setPassword("")
		  .clickCreateButton();
		  
		  CreateUserPage cp = new CreateUserPage(driver);
		  
		  Assert.assertTrue(cp.VerifyErrorLoginMessageIsPresent(mensajeErrorEsperado));
		  Assert.assertTrue(cp.VerifyErrorPasswordMessageIsPresent(mensajeErrorEsperado));
		  Assert.assertTrue(cp.VerifyErrorFirstNameMessageIsPresent(mensajeErrorEsperado));
		  Assert.assertTrue(cp.VerifyErrorEmailMessageIsPresent(mensajeErrorEsperado));
		  Assert.assertTrue(cp.VerifyErrorLastNameMessageIsPresent(mensajeErrorEsperado));
	}
}
