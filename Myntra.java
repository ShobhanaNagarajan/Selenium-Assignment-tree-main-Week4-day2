package week4day2;

import java.util.List;
import java.io.File;
import java.io.IOException;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Myntra {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		options.addArguments("--disable-notifications");
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver(options);
		Actions builder = new Actions(driver);
		driver.get("https://www.myntra.com/");
		WebElement men = driver.findElement(By.xpath("//a[@data-group='men']"));
		builder.moveToElement(men).perform();
		driver.findElement(By.xpath("//a[@data-reactid='40']")).click();
        // print count of jackets
		WebElement jackets = driver.findElement(By.xpath("(//span[@class='categories-num'])[1]"));
		String jacketCount = jackets.getText();
		System.out.println("Total Count of Jackets: " +jacketCount);
		jackets.click();
		driver.findElement(By.className("brand-more")).click();
		driver.findElement(By.xpath("//label[text()='Duke']")).click();
		driver.findElement(By.xpath("//div[@class='FilterDirectory-titleBar']//span[1]")).click();
		List<WebElement> brandsList = driver.findElements(By.tagName("h3"));
		for(int i =1; i<brandsList.size()-1;i++) {
			String brand = brandsList.get(i).getText();
			if(brand.equals("Duke")) {
				continue;
			}else {
				driver.quit();
			}
		}
		System.out.println("Title Verified");
		//Sort
		WebElement sortBy =driver.findElement(By.className("sort-sortBy"));
		builder.moveToElement(sortBy).perform();
		WebElement betterDiscount = driver.findElement(By.xpath("//label[text()='Better Discount']"));
		builder.moveToElement(betterDiscount).perform();
		builder.click().perform();
		//print price
		WebElement priceJk= driver.findElement(By.xpath("(//div[@class='product-price']//span)[2]"));
		String price= priceJk.getText();
		System.out.println("The price of the first product: "+price);
		priceJk.click();
		//Windows Switch
				Set<String> totalWindows = driver.getWindowHandles();
				for(String eachWindow:totalWindows) {
					driver.switchTo().window(eachWindow);
				}
				//ScreenShot
				File imgsrc = driver.getScreenshotAs(OutputType.FILE);
				File imgdstn = new File("./snaps/myntra.png");
				FileUtils.copyFile(imgsrc, imgdstn);
				//Wish List
				driver.findElement(By.xpath("//span[contains(@class,'myntraweb-sprite pdp-notWishlistedIcon')]")).click();
				driver.close();
				driver.quit();
		

}
}
