package QualityKiosk.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import QualityKiosk.AbstractComponent.Abstractcomp;

public class CheckoutPage extends Abstractcomp{
	
	WebDriver driver;
	
	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = ".action__submit")
	WebElement submit;	
	
	@FindBy(css="[placeholder='Select Country']")
	WebElement country;
	
	@FindBy(xpath = "(//button[contains(@class,'ta-item')])[2]")
	WebElement selectconbut;
	
	By result = By.cssSelector(".ta-results");
	
	public void SelectCon(String ConName) {
		Actions a = new Actions(driver);
		a.sendKeys(country, ConName).build().perform();
		wait4Ele2app(result);
		selectconbut.click();		
	}
	
	public ConfirmationPg suborder() {
		submit.click();
		return new ConfirmationPg(driver);
	}
	
}
