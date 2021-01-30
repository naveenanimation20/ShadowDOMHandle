import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoibiboTestReact {

	public static void main(String[] args) throws InterruptedException {

		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
        driver.get("https://www.goibibo.com/");
        driver.findElement(By.id("gosuggest_inputSrc")).sendKeys("Goa");
        Thread.sleep(5000);
        driver.findElements(By.cssSelector("ul#react-autosuggest-1 div.clearfix span"))
        .stream().forEach(ele-> System.out.println(ele.getText()));
        
        
        
		
		
	}

}
