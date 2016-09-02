package org.camaleon.framework.pages.admin.login;

import org.camaleon.framework.pages.admin.view.DashboardPage;
import org.camaleon.framework.utilities.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	WebDriver  driver;
	
	@FindBy (xpath = "//*[@id='login_user']/div[5]/div[2]/button") 
	private WebElement login_Button;
	
	@FindBy (id = "user_username") 
	private WebElement username_TextField;
	
	@FindBy (id = "user_password") 
	private WebElement password_TextField;
	
	@FindBy (xpath = "//div[@class='alert alert-danger']") 
	private WebElement alerts_Label;
	

	public LoginPage(WebDriver driver){
		this.driver = driver;
		driver.get("http://localhost:3000/admin/login");
		driver.navigate().refresh();
		PageFactory.initElements(driver, this);
	}
	
	public DashboardPage clickSignInButton(){
		(new WebDriverWait(driver,30)).until(ExpectedConditions.visibilityOf(login_Button));
		login_Button.click();
		LogManager.info("SigIn Button was clicked");
		return new DashboardPage(driver);
		
	}
	
	public LoginPage clickSignInButtonWithInvalidCredentials(){
		(new WebDriverWait(driver,30)).until(ExpectedConditions.visibilityOf(login_Button));
		login_Button.click();
		LogManager.info("SigIn Button was clicked");
		return this;
		
	}
	
	public LoginPage setUserName(String username){
		(new WebDriverWait(driver, 60)).until(ExpectedConditions.visibilityOf(username_TextField));
		username_TextField.clear();
		username_TextField.sendKeys(username);
		LogManager.info("Username: <"+ username +">" + "was entered");
		return this;
	}
	
	public LoginPage setPassword(String password){
		(new WebDriverWait(driver, 60)).until(ExpectedConditions.visibilityOf(password_TextField));
		password_TextField.clear();
		password_TextField.sendKeys(password);
		LogManager.info("Password: <"+ password +">" + "was entered");
		return this;
	}
	
	public String getAlertMessage(){
		(new WebDriverWait(driver, 60)).until(ExpectedConditions.visibilityOf(alerts_Label));
		String message = alerts_Label.getText();
		LogManager.info("Aler message: <"+ message +">" + "was retrieved");
		return message;
	}
}
