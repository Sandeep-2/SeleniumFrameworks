package QualityKiosk;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SAT {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
//Invalid Status code=403 text=Forbidden due to chrome version 113 to encouter this error
//		ChromeOptions op = new ChromeOptions();
//		op.addArguments("--remote-allow-origins=*");
//		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Drivers\\chromedriver.exe");
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver = new ChromeDriver();
		
		WebDriver driver = WebDriverManager.chromedriver().capabilities(new ChromeOptions()
				.addArguments("--remote-allow-origins=*")).create();
//		driver.get("https://www.google.com/");
//		for handling promt login website
		driver.get("http://admin:admin@192.168.0.1");
		Thread.sleep(4500303);
	}

}
