package QualityKiosk.AbstractComponent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import QualityKiosk.pageobjects.CartPage;

public class Abstractcomp {

	WebDriver driver;
	
	public Abstractcomp(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "[routerlink*='cart']")
	WebElement cartde;
	
	public void wait4Ele2app(By findby) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findby));
	}
	
	public void wait4Ele2dusapp(WebElement ele){
//		Thread.sleep(1000);
//		the below code will wait for 4 sec to load page 
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(ele));
		
	}
	
	public CartPage gotocartde() {
		cartde.click();
		CartPage cartPage = new CartPage(driver);
		return cartPage;
	}
}
