package org.camaleon.framework.pages.admin.view;

import org.camaleon.framework.pages.admin.common.LeftMenu;
import org.camaleon.framework.utilities.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {
	WebDriver  driver;
	LeftMenu menu;
	
	@FindBy (xpath = ".//*[@id='admin_content']/ol/li") 
	private WebElement dashboard_Label;

	public DashboardPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getDashboardLabel(){
		(new WebDriverWait(driver, 60)).until(ExpectedConditions.visibilityOf(dashboard_Label));
		String label = dashboard_Label.getText();
		LogManager.info("Dashboard label: <"+ label +">" + "was retrieved");
		return label;
	}
	
	public LeftMenu LeftMenu(){
		if(menu == null){
			menu = new LeftMenu(driver);
		}
		return menu;
	}
}
