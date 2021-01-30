import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserWindowHandle {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		driver.findElement(By.xpath("//img[@alt='LinkedIn OrangeHRM group']")).click();
		
		Set<String> handles = driver.getWindowHandles();
		
		Iterator<String> it = handles.iterator();
		
		String parent = it.next();
		System.out.println(parent);
		
		String child = it.next();
		System.out.println(child);
		
		driver.switchTo().window(child);
		System.out.println(driver.getTitle());
		
		driver.close();
		
		driver.switchTo().window(parent);
		
		System.out.println(driver.getTitle());

		driver.close();
		
		
		
		
		
	}
	
	public void test(){
		System.out.println("title");
		System.out.println("remote title");

		
	}

}
