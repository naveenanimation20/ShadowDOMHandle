import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMyTripTest {

	static WebDriver driver;

	@FindBy(how = How.CSS, using = "div.footerLinks ul:nth-of-type(1) li a")
	static List<WebElement> linksList;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.makemytrip.com/");

		jsWaitForPageToLoad(10);

		PageFactory.initElements(driver, MakeMyTripTest.class);

		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement e = wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Hotels")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", e);
		
		jsWaitForPageToLoad(10);
		
		WebElement e1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Flight Status")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", e1);

		

//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        List<WebElement> linksList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div.footerLinks ul:nth-of-type(1) li a")));        

//		for (WebElement e : linksList) {
//			System.out.println(e.getText());
//
//		}

	}

	public static void jsWaitForPageToLoad(int timeOutInSeconds) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String jsCommand = "return document.readyState";

		// Validate readyState before doing any waits
		if (js.executeScript(jsCommand).toString().equals("complete")) {
			System.out.println("page is loaded completely...");
			return;
		}

		for (int i = 0; i < timeOutInSeconds; i++) {
			Thread.sleep(2000);
			if (js.executeScript(jsCommand).toString().equals("complete")) {
				System.out.println("page is loaded completely...");
				break;
			}
		}
	}

}
