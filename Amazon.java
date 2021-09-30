package week4day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;
import java.util.logging.FileHandler;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		options.addArguments("--disable-notifications");
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro "+Keys.ENTER);
		
		String Price = driver.findElement(By.xpath("//span[text()='69,999']")).getText();
		System.out.println("Price of the product: Rs."+Price);
		
		String Rating = driver.findElement(By.xpath("//span[@class='a-size-base']")).getText();
		System.out.println("Total Rating: "+Rating);
		
		driver.findElement(By.xpath("//a[@class='a-popover-trigger a-declarative']/i")).click();
		Thread.sleep(4000);
		
		String ofReviews = driver.findElement(By.xpath("(//a[@title='65% of reviews have 5 stars'])[3]")).getText();
		System.out.println("percentage:" +ofReviews);
		
		driver.findElement(By.xpath("//img[@class='s-image']")).click();
		Set<String> totalWindows = driver.getWindowHandles();
		for(String eachWindow:totalWindows) {
			driver.switchTo().window(eachWindow);
		}
		File src = driver.getScreenshotAs(OutputType.FILE);
		File dstn = new File("./snaps/amazon.png");
		 FileUtils.copyFile(src, dstn);
		
		 driver.findElement(By.id("add-to-cart-button")).click();
		Thread.sleep(5000);
		String  subTotal= driver.findElement(By.id("attach-accessory-cart-subtotal")).getText();
		
		if (subTotal.contains(Price)){
			System.out.println("Price Matched!");
		}
		driver.quit();
		
		
		
	}

}
