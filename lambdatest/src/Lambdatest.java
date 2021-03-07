//This is maven project



import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;

public class Lambdatest {

	public RemoteWebDriver driver = null;
   String username = "gchourasiya822";
	String accessKey = "sLXVNzPZM7lk0gQFsBr0hRpTExEndIxE9TPk0CSsWr1dCM3UoY";
	
	@BeforeTest
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platform", "Windows 10");
	     capabilities.setCapability("browserName", "Chrome");
	     capabilities.setCapability("version", "85.0"); // If this cap isn't specified, it will just get the any available one
        capabilities.setCapability("resolution","1024x768");
        capabilities.setCapability("build", "First Test");
        capabilities.setCapability("name", "Sample Test");
        capabilities.setCapability("network", true); // To enable network logs
        capabilities.setCapability("visual", true); // To enable step by step screenshot
        capabilities.setCapability("video", true); // To enable video recording
        capabilities.setCapability("console", true); // To capture console logs
    
        try {       
			driver= new RemoteWebDriver(new URL("https://"+username+":"+accessKey+"@hub.lambdatest.com/wd/hub"), capabilities);            
        } catch (MalformedURLException e) {
            System.out.println("Invalid grid URL");
        }
    }

	@Test(priority=0)
	public void testScript2() throws Exception {
				try {
					
					driver.get("https://www.amazon.in/");
					driver.findElement(By.id("twotabsearchtextbox")).sendKeys("LG Washing machine");
					driver.findElement(By.id("nav-search-submit-button")).click();	
					driver.findElement(By.xpath("//span[text()='LG']")).click();
					String names[] = new String[10];
					int prices[] = new int[10];
					for(int i=0; i<10; i++) {
						String name =driver.findElements(By.xpath("//div[@class='a-section a-spacing-medium']//span[@class='a-size-medium a-color-base a-text-normal']")).get(i+2).getText();
						String price =driver.findElements(By.xpath("//div[@class='a-section a-spacing-medium']//span[@class='a-price-whole']")).get(i+2).getText();
						Integer num = Integer.parseInt(price.replaceAll(",",""));
						names[i] = name;
						prices[i]= num;
		
						
					}
					for(int i=0;i<prices.length-1;i++) {
					      for (int j = i+1; j < prices.length; j++) {     
						if(prices[i]>prices[j]) {
							String tempName = names[i]; 
							int tempPrice = prices[i];
							
							names[i] = names[j];
							prices[i] = prices[j];
							names[j] = tempName;
							prices[j] = tempPrice;
							
						}
					      }
					}
					for(int j=0;j<prices.length-1;j++) {
					System.out.println("Name: " + names[j]);
					System.out.println("Price : " + prices[j]);
					}
					
					
					
//					driver.quit();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
	}
	@Test(priority=1)
	public void testScript() throws Exception {
				try {
					
					driver.get("https://www.amazon.in/");
					driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Samsung Washing machine");
					driver.findElement(By.id("nav-search-submit-button")).click();	
					driver.findElement(By.xpath("//span[text()='Samsung']")).click();
					String names[] = new String[10];
					int prices[] = new int[10];
					for(int i=0; i<10; i++) {
						String name =driver.findElements(By.xpath("//div[@class='a-section a-spacing-medium']//span[@class='a-size-medium a-color-base a-text-normal']")).get(i+2).getText();
						String price =driver.findElements(By.xpath("//div[@class='a-section a-spacing-medium']//span[@class='a-price-whole']")).get(i+2).getText();
						Integer num = Integer.parseInt(price.replaceAll(",",""));
						names[i] = name;
						prices[i]= num;
		
						
					}
					for(int i=0;i<prices.length-1;i++) {
					      for (int j = i+1; j < prices.length; j++) {     
						if(prices[i]>prices[j]) {
							String tempName = names[i]; 
							int tempPrice = prices[i];
							
							names[i] = names[j];
							prices[i] = prices[j];
							names[j] = tempName;
							prices[j] = tempPrice;
							
						}
					      }
					}
					for(int j=0;j<prices.length-1;j++) {
					System.out.println("Name: " + names[j]);
					System.out.println("Price : " + prices[j]);
					}
					
					
					
					driver.quit();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
	}
}
