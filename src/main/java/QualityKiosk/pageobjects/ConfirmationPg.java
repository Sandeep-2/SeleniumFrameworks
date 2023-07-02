package QualityKiosk.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import QualityKiosk.AbstractComponent.Abstractcomp;

public class ConfirmationPg extends Abstractcomp {

WebDriver driver;
	
	public ConfirmationPg(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".hero-primary")
	WebElement confirMess;
	
	public String verifyConfirm() {
		return confirMess.getText();
	}
	
}
