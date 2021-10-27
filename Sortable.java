package week4day2;

import java.awt.Point;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sortable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://jqueryui.com/sortable");
		driver.switchTo().frame(0);
		WebElement from = driver.findElement(By.xpath("//ul[@id='sortable']/li[1]"));
		WebElement to = driver.findElement(By.xpath("//ul[@id='sortable']/li[7]"));
	          org.openqa.selenium.Point tolocation = to.getLocation();
	          int x = (int) tolocation.getX();
	  		int y = (int) tolocation.getY();
	  		Actions builder = new Actions(driver);
	  		builder.clickAndHold(from).perform();
	  		builder.moveByOffset(x, y);
	  		builder.click().perform();
	  		
		
		

	}

}
