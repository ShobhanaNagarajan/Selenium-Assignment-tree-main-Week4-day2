package week4day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Carwale {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.carwale.com/");
		
		Actions builder = new Actions(driver);
		//Clicking of "Used" Option
		driver.findElement(By.xpath("//span[text()='Used']")).click();
		//City Typed
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("Chennai");
		//Drop down located , hovered and selected using Actions 
		WebElement selectable= driver.findElement(By.xpath("//li[@data-citymaskingname='chennai']"));
		builder.moveToElement(selectable).perform();
		builder.click().perform();
		//Seek buttons Minimum cost
		WebElement initialZero = driver.findElement(By.xpath("//button[1]"));
		builder.clickAndHold(initialZero).perform();
		builder.moveByOffset(70, 0).perform();
		builder.click().perform();
		//Seek button Maximum cost
		WebElement initialEnd = driver.findElement(By.xpath("//button[2]"));
		builder.clickAndHold(initialEnd).perform();
		builder.moveByOffset(-125,0 ).perform();
		builder.release().perform();
		//Verification
		String fromValue = driver.findElement(By.xpath("//input[@placeholder='Min']")).getAttribute("value");
		String toValue = driver.findElement(By.xpath("//input[@placeholder='Max']")).getAttribute("value");
		//String->Integer conversion
		int from = Integer.parseInt(fromValue);
		int to = Integer.parseInt(toValue);		
		if(from==4 && to==12) {
			System.out.println("Values are Verified");
		}

}
}
