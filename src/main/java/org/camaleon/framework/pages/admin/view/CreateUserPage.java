package org.camaleon.framework.pages.admin.view;

import org.camaleon.framework.pages.admin.login.LoginPage;
import org.camaleon.framework.utilities.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateUserPage {
	WebDriver  driver;
	
	@FindBy (xpath = "//input[@name='meta[first_name]']") 
	private WebElement FirstNameTextBox;
	
	@FindBy (xpath = "//input[@name='meta[last_name]']")
	private WebElement LastNameTextBox;
	
	@FindBy (id = "user_username")
	private WebElement loginTextbox;
	
	@FindBy (id = "user_email")
	private WebElement emailTextBox;
	
	@FindBy (id = "user_password")
	private WebElement passwordTextBox;
	
	@FindBy (xpath = "//button[contains(.,'Create')]")
	private WebElement createButton;
	
	public CreateUserPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public CreateUserPage setFirstName(String firstName){
		(new WebDriverWait(driver, 60)).until(ExpectedConditions.visibilityOf(FirstNameTextBox));
		FirstNameTextBox.clear();
		FirstNameTextBox.sendKeys(firstName);
		LogManager.info("First Name: <"+ firstName +">" + "was entered");
		return this;
	}
	
	public CreateUserPage setLastName(String lastName){
		(new WebDriverWait(driver, 60)).until(ExpectedConditions.visibilityOf(LastNameTextBox));
		LastNameTextBox.clear();
		LastNameTextBox.sendKeys(lastName);
		LogManager.info("Last Name: <"+ lastName +">" + "was entered");
		return this;
	}
	
	public CreateUserPage setLogin(String login){
		(new WebDriverWait(driver, 60)).until(ExpectedConditions.visibilityOf(loginTextbox));
		loginTextbox.clear();
		loginTextbox.sendKeys(login);
		LogManager.info("login: <"+ login +">" + "was entered");
		return this;
	}
	
	public CreateUserPage setEmail(String email){
		(new WebDriverWait(driver, 60)).until(ExpectedConditions.visibilityOf(emailTextBox));
		emailTextBox.clear();
		emailTextBox.sendKeys(email);
		LogManager.info("Email: <"+ email +">" + "was entered");
		return this;
	}
	
	public CreateUserPage setPassword(String password){
		(new WebDriverWait(driver, 60)).until(ExpectedConditions.visibilityOf(passwordTextBox));
		passwordTextBox.clear();
		passwordTextBox.sendKeys(password);
		LogManager.info("Password: <"+ password +">" + "was entered");
		return this;
	}
	
	public AllUsersPage clickCreateButton(){
		(new WebDriverWait(driver, 60)).until(ExpectedConditions.visibilityOf(createButton));
		createButton.click();
		LogManager.info("Create button was clicked");
		return new AllUsersPage(driver);
	}
}
