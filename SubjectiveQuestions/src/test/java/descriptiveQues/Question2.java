package descriptiveQues;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Question2 {
	public static void main(String[] args) throws InterruptedException {

		File file = new File("./src/main/resources/chromedriver.exe");
		String filePath = file.getAbsolutePath();
		System.out.println(filePath);
		System.setProperty("webdriver.chrome.driver", filePath);
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("start-maximized");
		WebDriver driver = new ChromeDriver(chromeOptions);
		driver.navigate().to("https://cosmocode.io/automation-practice-webtable/");

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='countries']")));
		driver.findElement(By.xpath("//table/tbody/tr[1]/td"));
		driver.findElements(By.xpath("//table[@id='countries']/tbody/tr"));

		List<WebElement> lstRowWebelements = driver.findElements(By.xpath("//table[@id='countries']/tbody/tr"));
		List<WebElement> lstColWebelements = driver.findElements(By.xpath("//table[@id='countries']/tbody/tr[1]/td"));

		int rowCount = lstRowWebelements.size();
		int colCount = lstColWebelements.size();
		int row = 0;
		int col = 0;
		boolean brkFlag = false;
		for (row = 0; row < rowCount; row++) {
			for (col = 0; col < colCount; col++) {
				String values = driver.findElement(By.xpath("//table[@id='countries']/tbody/tr[" + (row + 1) + "]/td[" + (col + 1) + "]")).getText();
				System.out.println(driver.findElement(By.xpath("//table[@id='countries']/tbody/tr[" + (row + 1) + "]/td[" + (col + 1) + "]")).getText());
				if (values.contains("Australia")) {
					brkFlag = true;
					break;
				}
			}
			if (brkFlag)
				break;
		}
		System.out.println("Row" + row);
		System.out.println("Col" + col);
		System.out.println();
		row = row + 1;
		col = col + 1;
		System.out.println(driver.findElement(By.xpath("//table[@id='countries']/tbody/tr[" + row + "]/td[" + (col + 1) + "]")).getText());
		
		System.out.println(driver.findElement(By.xpath("//strong[contains(text(),'Belarus')]")).getText());
		driver.findElement(By.xpath("//tbody/tr[17]/td[1]/input[1]")).click();
		Thread.sleep(5000);
		
		driver.quit();
	}
}
