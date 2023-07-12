package debugger;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Debugger_Random_Test {
	
	public static WebDriver driver;
	public static void main(String[] agrs) throws IOException
	{
		ChromeOptions option  = new ChromeOptions();
		option.setExperimentalOption("debuggerAddress", "localhost:9898");
		driver = new ChromeDriver(option);
		//driver.get("baseUrl = https://p360dev.vercel.app/");
		List<WebElement> holdername = (List<WebElement>) driver.findElements(By.xpath("//ul[@class='MuiList-root MuiMenu-list MuiList-padding']//li"));
		System.out.println(holdername.size());
		Select text = new Select((WebElement) holdername);
		text.selectByIndex(0);
	
	
	}
}
