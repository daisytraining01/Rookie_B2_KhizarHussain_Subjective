package descriptiveQues;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Question3 {
	public static void main(String[] args) throws InterruptedException, IOException{
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");

		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("start-maximized");
		WebDriver driver =  new ChromeDriver(chromeOptions);
		driver.navigate().to("https://wordpress.com/?aff=58022&cid=8348279");

		System.out.println("Navigated successfully to WordPress");
		driver.findElement(By.xpath("//button[@role='menuitem']")).click();
		driver.findElement(By.xpath("//a[@href='https://wordpress.com/create-blog/?aff=58022&cid=8348279']")).click();

		if(driver.findElement(By.xpath("//span[contains(text(),'Create a blog and share')]")).isDisplayed()) {
			System.out.println("'https://wordpress.com/create-blog/?aff=58022&cid=8348279'");
		}

		driver.findElement(By.xpath("//a[@title='Features']")).click();
		driver.findElement(By.xpath("//a[@href='//wordpress.com/themes/']")).click();

		if(driver.findElement(By.xpath("//span[contains(text(),'Themes')]")).isDisplayed()) {
			System.out.println("'//a[@href='//wordpress.com/themes/'");
		}

		driver.findElement(By.xpath("//a[@href='https://wordpress.com/support/?aff=58022&cid=8348279\']")).click();
		if(driver.findElement(By.xpath("//span[contains(text(),'Create a blog and share')]")).isDisplayed()) {
			System.out.println("https://wordpress.com/support/?aff=58022&cid=8348279\\'");
		}
	}
}
