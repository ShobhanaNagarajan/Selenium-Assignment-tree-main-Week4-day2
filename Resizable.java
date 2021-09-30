package week4day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Resizable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/resizable/");
		String title =  driver.getTitle();
		System.out.println("Main Window Title:" + title);
		driver.switchTo().frame(0);
		WebElement resize = driver.findElement(By.xpath("//div[@id='resizable']/div[3]"));
		Actions builder = new Actions(driver);
		builder.clickAndHold(resize).perform();
		builder.moveToElement(resize,2,85).perform();
		builder.click().perform();
	}

}
