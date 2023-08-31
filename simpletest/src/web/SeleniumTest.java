package web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.LoggerFactory;


public class SeleniumTest {
	
	public static void main(String[] args) {
		
		//browser initialization
		WebDriver driver = new ChromeDriver();
		
		// browser navigate to url
		driver.get("https://magento.softwaretestingboard.com/");
		
		
		// click on the "Shop New Yoga" link to get to category
		driver.findElement(By.partialLinkText("Shop New Yoga")).click();

		
		// click on the product - "selected first one here"
		driver.findElement(By.xpath
				("//*[@id='maincontent']/div[3]/div[1]/div[3]/ol/li[1]/div/a/span/span/img")).click();

		// enter the quantity
		driver.findElement(By.id("qty")).sendKeys("4");

		// add to cart
		driver.findElement(By.id("product-addtocart-button")).click();
		
		//verification declaration
		String errorMsg = "This is a required field.";

		//verify the required field for size selection
		boolean bln = driver.findElement(By.id("super_attribute[143]-error")).getText().contentEquals(errorMsg);
	
		//Verification1 -- it can be written in Assertion format but this repo not set with it for all the tools and simplified the code
		if (bln) {
			System.out.println("verification for size selection completed");
			// this is can be written in logger using slf4j but I just did simply printing for quicker.
			

		}else
		{
			System.out.println("verification for size selection step completed but error not found, step failed");  
		}

		//Verifcation2 
		//verify the required field for color selection  		
		bln = driver.findElement(By.id("super_attribute[93]-error")).getText().contentEquals(errorMsg);
		

		if (bln) {
			System.out.println("verification for color selection completed here..");
			// this is can be written in logger using slf4j but I just did simply printing for quicker.

		}else
		{
			System.out.println("verification for color selection step completed but error not found, step failed..");  
		
		}
		//  Assert.assertTrue(false, null)


		//Web driver - Chrome browser quit / close
		driver.quit();

	}
}
