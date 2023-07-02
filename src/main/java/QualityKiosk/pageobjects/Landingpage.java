package QualityKiosk.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import QualityKiosk.AbstractComponent.Abstractcomp;

public class Landingpage extends Abstractcomp {

	WebDriver driver;
	
	public Landingpage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="userEmail")
	WebElement useremail;
	
	@FindBy(id="userPassword")
	WebElement pass;
	
	@FindBy(id="login")
	WebElement submit;

	public ProCatalogue loginApplication(String uname, String password) {
		useremail.sendKeys(uname);
		pass.sendKeys(password);
		submit.click();
		ProCatalogue catalogue = new ProCatalogue(driver);
		return catalogue;
	}

	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");		
	}
	
	
	
}
