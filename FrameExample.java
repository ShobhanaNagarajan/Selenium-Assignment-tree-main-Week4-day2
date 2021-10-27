package week4day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		//Frame
		driver.switchTo().frame("frame1");
		driver.findElement(By.xpath("//b[@id='topic']//following::input")).sendKeys("Not a Friendly Topic");
		//Nested Frame
		driver.switchTo().frame("frame3");
		driver.findElement(By.id("a")).click();
		driver.switchTo().defaultContent();
		//Drop Down Frame
		driver.switchTo().frame("frame2");
		WebElement dropdowns = driver.findElement(By.id("animals"));
		Select options = new Select(dropdowns);
		options.selectByIndex(3);




	}

}
