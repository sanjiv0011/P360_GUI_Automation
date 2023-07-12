package debugger;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Debugger_JavaSript_Test {
	
	public static WebDriver driver;
	public static void main(String[] args)
	{
	
		ChromeOptions option  = new ChromeOptions();
		//option.addArguments("--headless=Chrome");
		option.setExperimentalOption("debuggerAddress", "localhost:9898");
		driver = new ChromeDriver(option);
		WebElement holdername = driver.findElement(By.xpath("//input[@name='holderName']"));
		holdername.clear();
		holdername.sendKeys("john");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementsByName('cardnumber')[0].value = '42424242'");


	}

}
