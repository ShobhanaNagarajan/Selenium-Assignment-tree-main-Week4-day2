package week4day2;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		//options.addArguments("--disable-notifications");
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Actions builder= new Actions(driver);
		
		driver.get("https://www.nykaa.com/");
		//mousehover Search
		WebElement brandsTab =	driver.findElement(By.xpath("//a[text()='brands']"));
		builder.moveToElement(brandsTab).perform();
		driver.findElement(By.id("brandSearchBox")).sendKeys("L'Oreal Paris"+Keys.ENTER);
		driver.findElement(By.xpath("(//a[text()=\"L'Oreal Paris\"])[1]")).click();
		
		//Get title 
		if(driver.getTitle().contains("L'Oreal Paris")) {
			System.out.println("GetTitle Sucessfull");
		}
		else
		{
			System.out.println("GetTitle Unsucessfull");
			driver.quit();
		}
		//Applying Filters
		driver.findElement(By.xpath("//span[@title='POPULARITY']")).click();
		driver.findElement(By.xpath("//div[@for='3']//div[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[text()='Category']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@class='category-title-text']")).click();
		driver.findElement(By.xpath("//span[text()='Hair Care']")).click();
		WebElement filter1 =driver.findElement(By.xpath("//span[text()='Shampoo']"));
		String filtertext1 = filter1.getText();
		filter1.click();
		driver.findElement(By.xpath("//div[text()='Concern']")).click();
		WebElement filter2 = driver.findElement(By.xpath("//span[text()='Color Protection']"));
		String filtertext2 = filter2.getText();
		filter2.click();
		String firstFilter = driver.findElement(By.xpath("//ul[@class='pull-left applied-filter-lists']//li[1]")).getText();
		String secondFilter = driver.findElement(By.xpath("//ul[@class='pull-left applied-filter-lists']//li[2]")).getText();
		
		if((firstFilter.contains(filtertext1)) && (secondFilter.contains(filtertext2))) {
			System.out.println("Filters are applied!");
		} else {
			System.out.println("Filters not applied!");
			driver.quit();
		}				
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//img[@class='listing-img']")).click();
		Set<String>totalWindows = driver.getWindowHandles();
		for(String eachWindow:totalWindows) {
			driver.switchTo().window(eachWindow);
		}
			driver.findElement(By.xpath("//span[text()='175ml']")).click();
			driver.findElement(By.xpath("(//span[@class='post-card__content-price-offer'])[1]")).getText(); 
			driver.findElement(By.xpath("(//button[text()='ADD TO BAG'])[1]")).click();
			driver.findElement(By.xpath("//div[@class='cursor-hand arrowup-tooltip']//div[1]")).click();
			driver.findElement(By.xpath("//button[@class='btn full fill']")).click();
			String grandTotalStr = driver.findElement(By.xpath("//div[@class='value medium-strong']")).getText();
			Thread.sleep(5000);
			driver.findElement(By.xpath("(//span[@class='vernacular-string'])[13]")).click();
			Thread.sleep(7000);
			driver.findElement(By.xpath("//button[@class='btn full big']")).click();
			String grandTotalCheckOutStr =driver.findElement(By.xpath("(//div[@class='value'])[2]")).getText();
			//GrandTotal Check
			if(grandTotalStr.equals(grandTotalCheckOutStr)) {
				System.out.println("Costs are same!");
			}
			driver.quit();
		
	}

}

