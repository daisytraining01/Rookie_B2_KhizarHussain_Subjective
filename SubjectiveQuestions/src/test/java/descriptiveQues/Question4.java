package descriptiveQues;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Question4 {
	public static void main(String[] args)throws InterruptedException, IOException, NoAlertPresentException {

		WebDriver driver = null;

		driver = new ChromeDriver();
		driver.navigate().to("https://www.google.com/");
		System.out.println("Navigated successfully to Google");

		//When using sleep InterruptedException is created and handled
		//Wait Method sleep is used
		Thread.sleep(3000);

		//While Taking Screenshot IOException is created and Handled
		System.out.println("Take Screenshot");
		TakesScreenshot ts =((TakesScreenshot)driver);
		File srcFile=ts.getScreenshotAs(OutputType.FILE);
		File destFile=new File("./target/Snp/GooglePage.png");
		FileUtils.copyFile(srcFile, destFile);  

		//IMPLICIT WAIT METHOD EXAMPLE
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//While Taking Alert NoAlertPresentException is created and Handled 
		try{
			driver.switchTo().alert().accept();
		}
		catch (NoAlertPresentException E){
			E.printStackTrace();
		}

		//While Taking Alert InternetExplorerDriver is created and Handled
		driver = new InternetExplorerDriver();
		driver.navigate().to("https://www.google.com/");
		driver.findElement(By.name("fake")).click();

		driver.close();
	}
}