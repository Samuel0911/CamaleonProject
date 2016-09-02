package org.camaleon.framework.pages.admin.common;

import org.camaleon.framework.pages.admin.view.CreateUserPage;
import org.camaleon.framework.pages.admin.view.DashboardPage;
import org.camaleon.framework.utilities.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LeftMenu {
	WebDriver  driver;
	
	@FindBy (xpath = "//span[contains(.,'Users')]") 
	private WebElement Users;
	
	@FindBy (xpath = "//a[contains(.,' Add User ')]") 
	private WebElement AddUser;

	public LeftMenu(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public LeftMenu clickUsersMenu(){
		(new WebDriverWait(driver,30)).until(ExpectedConditions.visibilityOf(Users));
		Users.click();
		LogManager.info("Users menu was clicked");
		return this;
	}
	
	public CreateUserPage clickAddUserMenu(){
		(new WebDriverWait(driver,30)).until(ExpectedConditions.visibilityOf(AddUser));
		AddUser.click();
		LogManager.info("Add User menu was clicked");
		return new CreateUserPage(driver);
	}
}
