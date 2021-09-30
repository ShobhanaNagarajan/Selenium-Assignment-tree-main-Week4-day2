package week4day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selectable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		Actions builder = new Actions(driver);
		driver.get("https://jqueryui.com/selectable/");
		
		driver.switchTo().frame(0);
		WebElement from = driver.findElement(By.xpath("//ol[@id='selectable']/li[1]"));
		WebElement to= driver.findElement(By.xpath("//ol[@id='selectable']/li[5]"));
		builder.clickAndHold(from).perform();
		builder.moveToElement(to);
		builder.click().perform();
	}

}
