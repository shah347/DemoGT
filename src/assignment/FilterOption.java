package assignment;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FilterOption {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\SoftwareCenter\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.airbnb.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
	
		WebElement locationInput = driver.findElement(By.xpath("//input[@class='_1xq16jy']"));
		System.out.println(locationInput.getAttribute("placeholder"));
		//locationInput.click();
		locationInput.sendKeys("Blue");
		Thread.sleep(2000);
		Actions ac = new Actions(driver);
		ac.sendKeys(locationInput, Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ENTER).build().perform();
		Thread.sleep(2000);
		
		
		
		String mar = "March 2022";
		boolean b = true;
		
		while(b) {
			WebElement checkInYear = driver.findElement(By.xpath("//div[@class='_1lds9wb'][1]//h2[@class='_116xafi']"));
			String checkInYearText = checkInYear.getText();
			if(mar.equalsIgnoreCase(checkInYearText)) {
				b= false;
			}
			else {
			driver.findElement(By.xpath("//button[@aria-label='Next']")).click();
			Thread.sleep(1000);
			}
		}
		
		System.out.println("It's march");
		driver.findElement(By.xpath("//div[@data-testid='datepicker-day-2022-03-20']//div[@class='_k5mfsv' and text()='20']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@data-testid='datepicker-day-2022-03-26']//div[@class='_k5mfsv' and text()='26']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='_seuyf']//div[@class='_uh2dzp' and text()='Add guests']")).click();
		driver.findElement(By.xpath("//div[@data-testid='search-block-filter-stepper-row-stepper-adults']//div[@class='_3zlfom']//button[@class='_7hhhl3' and @aria-label='increase value']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@class='_m9v25n']")).click();
		Thread.sleep(5000);
		
		
	
		driver.findElement(By.xpath("//div[@class='_7yfwnp']//button[@class='_t6p96s']/span[text()='More filters']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[@aria-label='increase value' and @aria-describedby='title-label-filterItem-rooms_and_beds-stepper-min_beds-0']")).click();
		driver.findElement(By.xpath("//button[@aria-label='increase value' and @aria-describedby='title-label-filterItem-rooms_and_beds-stepper-min_beds-0']")).click();
		driver.findElement(By.xpath("//button[@aria-label='increase value' and @aria-describedby='title-label-filterItem-rooms_and_beds-stepper-min_beds-0']")).click();
		Thread.sleep(3000);

		ac.sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ARROW_DOWN ,Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ARROW_DOWN, Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ARROW_DOWN, Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ARROW_DOWN).build().perform();
		driver.findElement(By.xpath("//span[text()='Show all facilities']//span[@class='_g9s7mk']")).click();
		driver.findElement(By.xpath("//input[@name='EV charger']")).click();
		Thread.sleep(3000);
		ac.sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ARROW_DOWN, Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ARROW_DOWN).build().perform();
		driver.findElement(By.xpath("//input[@name='Apartment']")).click();
		Thread.sleep(2000);
		WebElement showAfterFilter = driver.findElement(By.xpath("//footer[@class='_zgc1p6']//a[@class='_pmpl8qu']"));
		System.out.println("Finding after filters: "+showAfterFilter.getText());
		String[] splitResults = showAfterFilter.getText().split(" ");
		System.out.println(splitResults[1]);
		String filS = splitResults[1];
		Integer iVal = Integer.valueOf(filS);
		int iValIn = iVal;
		Thread.sleep(2000);
		showAfterFilter.click();
		Thread.sleep(3000);
		List<WebElement> lists = driver.findElements(By.xpath("//div[@class='_1xzimiid']"));
		System.out.println("Size in the page: "+lists.size());
		System.out.println("Number of Items showing in the page after filter");
		for(WebElement el:lists) {
			System.out.println(el.getText());
		}
		
		if(iValIn==lists.size()) {
			System.out.println("Test case Passed since number in the button and the results in the result page matches");
		}
		else {
			System.out.println("Test case failed");
		}

		Thread.sleep(500);
		driver.close();
	}

}
