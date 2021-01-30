import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JqueryTest {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
        driver.get("http://classic.crmpro.com/");
        
        JavascriptExecutor jse =  ((JavascriptExecutor)driver);
		
		String text = jse.executeScript("return $(\"div.navbar-collapse li:nth-of-type(2) a\").text();").toString();
		System.out.println(text);
		
		
	}

}
