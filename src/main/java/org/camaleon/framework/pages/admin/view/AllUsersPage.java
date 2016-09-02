package org.camaleon.framework.pages.admin.view;

import org.camaleon.framework.pages.admin.common.LeftMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AllUsersPage {
	WebDriver  driver;
	LeftMenu menu;
	
	@FindBy (xpath = ".//*[@id='admin_content']/ol/li") 
	private WebElement dashboard_Label;

	public AllUsersPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
