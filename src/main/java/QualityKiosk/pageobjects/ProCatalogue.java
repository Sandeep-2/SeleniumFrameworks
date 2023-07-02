 package QualityKiosk.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import QualityKiosk.AbstractComponent.Abstractcomp;

public class ProCatalogue extends Abstractcomp{

	WebDriver driver;
	
	public  ProCatalogue(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);		
	}
	
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	By product = By.cssSelector(".mb-3");
	By add2cart = By.cssSelector(".card-body button:last-of-type");
	By toastMess = By.cssSelector("#toast-container");

	public List<WebElement> getpro(){
		wait4Ele2app(product);
		return products;
	}
	
	public WebElement getProName(String Productname){
		WebElement prod =	getpro().stream().filter(products->products.findElement(By.cssSelector("b"))
				.getText().equals("ZARA COAT 3")).findFirst().orElse(null);
		return prod;
	}
	
	public void AddPro2Cart(String ProductName){
		WebElement prod = getProName(ProductName);
		prod.findElement(add2cart).click();
		wait4Ele2app(toastMess);
		wait4Ele2dusapp(spinner);
		
	}

	


}
