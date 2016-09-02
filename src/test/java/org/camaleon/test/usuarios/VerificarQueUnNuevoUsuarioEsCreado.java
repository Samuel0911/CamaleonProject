package org.camaleon.test.usuarios;

import org.camaleon.framework.pages.admin.login.LoginPage;
import org.camaleon.framework.pages.admin.view.CreateUserPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ISuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class VerificarQueUnNuevoUsuarioEsCreado {
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
	public void VerifyUserIsCreated(){
		  
		  String dashboardLabelEsperado = "Dashboard";  
		  
		  LoginPage login = new LoginPage(driver);
		  
		  login.setUserName("admin")
		  .setPassword("admin")
		  .clickSignInButton()
		  .LeftMenu()
		  .clickUsersMenu()
		  .clickAddUserMenu()
		  .setFirstName("Samuel")
		  .setLastName("Vargas")
		  .setLogin("test01")
		  .setEmail("test@test.com")
		  .setPassword("test")
		  .clickCreateButton();
		  
	
		  /*Assert.assertEquals(actualDashboardLabel,dashboardLabelEsperado,
				  "Dashboard label invalido");*/

	}
}
