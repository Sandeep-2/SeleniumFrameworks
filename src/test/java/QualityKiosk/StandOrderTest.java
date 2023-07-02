package QualityKiosk;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import QualityKiosk.pageobjects.CartPage;
import QualityKiosk.pageobjects.ConfirmationPg;
import QualityKiosk.pageobjects.Landingpage;
import QualityKiosk.pageobjects.ProCatalogue;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StandOrderTest {
	public static void main(String[] args) {
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver = new ChromeDriver();
		WebDriver driver = WebDriverManager.chromedriver().capabilities(new ChromeOptions()
				.addArguments("--remote-allow-origins=*")).create();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		Landingpage landpage = new Landingpage(driver);
		landpage.goTo();
		ProCatalogue catalogue = landpage.loginApplication("sandeepsadanand@gmail.com","Sadanand@21");
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		
		
		List<WebElement> product = catalogue.getpro();
		catalogue.AddPro2Cart("ZARA COAT 3");
		CartPage cartPage = catalogue.gotocartde();
		
		Boolean val = cartPage.VerifyProductDisplay("ZARA COAT 3");
		
//		driver.get("https://rahulshettyacademy.com/client");
//		driver.findElement(By.id("userEmail")).sendKeys("sandeepsadanand@gmail.com");
//		driver.findElement(By.xpath("//input[@id='userPassword']")).sendKeys("Sadanand@21");
//		driver.findElement(By.name("login")).click();
//
//		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
//
//		List<WebElement> product = driver.findElements(By.cssSelector(".mb-3"));
//		WebElement prod =	product.stream().filter(products->products.findElement(By.cssSelector("b"))
//				.getText().equals("ZARA COAT 3")).findFirst().orElse(null);
//		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		//ng-animating
//		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
//		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
	
//		List<WebElement> cartPro = driver.findElements(By.xpath("//*[@class='cartSection']/h3"));
//		Boolean val = cartPro.stream().anyMatch(cartde->cartde.getText().equalsIgnoreCase("Zara coat 3"));
		Assert.assertTrue(val);
		
		cartPage.goToCheckout();
		driver.findElement(By.cssSelector("//button[@class='btn btn-custom']")).click();
		
//		Actions a = new Actions(driver);
//		a.sendKeys(driver.findElement(By.xpath("/html/body/app-root/app-order/section/div/div/div[2]/div/div/div[3]/div[2]/div[2]/div/div[1]/div/input")),"india").build().perform();
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
//		driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/app-order/section/div/div/div[2]/div/div/div[3]/div[2]/div[2]/div/div[2]/a"))).click();
		
		
		
//		a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "india")
//		.build().perform();
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
//		driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
//		try {
//			driver.findElement(By.cssSelector(".action__submit")).click();
//		} catch (Exception e) {
//			WebElement m = driver.findElement(By.cssSelector(".action__submit"));
//			JavascriptExecutor j = (JavascriptExecutor) driver;
//		    j.executeScript("arguments[0].click();", m);
//		}
		
		
//		String disMess = driver.findElement(By.cssSelector(".hero-primary")).getText();
//		Assert.assertTrue(disMess.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
//		System.out.println(driver.findElement(By.cssSelector(".hero-primary")).getText());
		ConfirmationPg conmess = new ConfirmationPg(driver);
		
		Assert.assertTrue((conmess.verifyConfirm()).equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		driver.close();
	}
	
}
