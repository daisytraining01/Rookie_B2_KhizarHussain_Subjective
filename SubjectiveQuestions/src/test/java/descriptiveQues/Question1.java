package descriptiveQues;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Question1 {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException, IOException{
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");

		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("start-maximized");
		WebDriver driver =  new ChromeDriver(chromeOptions);
		driver.navigate().to("http://demo.guru99.com/test/newtours/register.php");

		System.out.println("Navigated successfully to guru99");

		Select drpCountry = new Select(driver.findElement(By.xpath("//select[@name='country']")));
		drpCountry.selectByValue("AUSTRALIA");
		Thread.sleep(500);

		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Khizar");
		Thread.sleep(500); 
		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("Hussain");
		Thread.sleep(500);
		driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("92757292953");
		Thread.sleep(500);
		driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("khizzzu@gmail.com");
		Thread.sleep(500);
		driver.findElement(By.xpath("//input[@name='address1']")).sendKeys("33/14, jayaram street");
		Thread.sleep(500);
		driver.findElement(By.xpath("//input[@name='city']")).sendKeys("vellore");
		Thread.sleep(500);
		driver.findElement(By.xpath("//input[@name='state']")).sendKeys("Tamil nadu");
		Thread.sleep(500);
		driver.findElement(By.xpath("//input[@name='postalCode']")).sendKeys("632012");
		Thread.sleep(500);
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("khizarhussain");
		Thread.sleep(500);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("qwerty@2132");
		Thread.sleep(500);
		driver.findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys("qwerty@2132");
		Thread.sleep(500);

		System.out.println(driver.findElement(By.xpath("//input[@name='firstName']")).getText());
		
		String output = driver.findElement(By.xpath("//input[@name='firstName']")).getText();
		File DestFile= new File("./target/ExtractedText.txt");
		FileUtils.writeStringToFile(DestFile, output);

		driver.findElement(By.xpath("//input[@name='submit']")).click();
		Thread.sleep(500);

		//System.out.println(driver.findElement(By.xpath("//input[@name='firstName']/tbody/tr[" +("Khizar")+]")).getText());
		//The page accept any kind of inputs
		driver.findElement(By.xpath("//img[@src='images/mast_register.gif']")).isDisplayed();
		driver.close();
	}
}