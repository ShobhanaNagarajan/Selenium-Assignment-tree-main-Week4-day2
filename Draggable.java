package week4day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Draggable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		Actions builder = new Actions(driver);
		driver.get("https://jqueryui.com/draggable/");
		driver.switchTo().frame(0);
		//Locating Element
		WebElement draggable = driver.findElement(By.id("draggable"));
		//Action methods
		builder.clickAndHold(draggable).perform();
		builder.moveByOffset(100, 150).perform();
		builder.release().perform();
		
		

	}

}
