
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class myTaskClass {
	WebDriver driver = new EdgeDriver();
	String URL = "https://www.saucedemo.com/";
	String UserName = "standard_user";
	String Password = "secret_sauce";
	
	//testing changes
	
	@BeforeTest
	public void MySetup() {
		driver.manage().window().maximize();
		driver.get(URL);
	}
	
	@Test (priority = 1)
	public void Login() {
		WebElement UserNameInput = driver.findElement(By.id("user-name"));
		
		WebElement PasswordInput = driver.findElement(By.id("password"));
		
		WebElement LoginBtn = driver.findElement(By.id("login-button"));

		
		UserNameInput.sendKeys(UserName);
		PasswordInput.sendKeys(Password);
		LoginBtn.click();
	}
	
	@Test (priority = 2, enabled = false)
	public void AddAllItemsToCart () throws InterruptedException {
		List<WebElement> AddToCartButtons = driver.findElements(By.className("btn"));
		
		for (int i = 0; i < AddToCartButtons.size(); i++) {
			AddToCartButtons.get(i).click();
			Thread.sleep(1000);
		}
	} 
	@Test (priority = 3, enabled = false)
	public void RemoveAllItemsFromCart () throws InterruptedException {
		List<WebElement> RemoveButton = driver.findElements(By.className("btn_secondary"));
		for (int i = 0; i<RemoveButton.size(); i++ ){
			RemoveButton.get(i).click();
			Thread.sleep(1000);
		}
	}
	@Test (priority = 4)
	public void PrintItemsFirstLetter () {
		List<WebElement> ItemsName = driver.findElements(By.className("inventory_item_name"));
		
		for (int i = 0; i < ItemsName.size(); i++) {
			
		 String ItemName = ItemsName.get(i).getText();
		 char FirstLetter = ItemName.charAt(0);
		 
		 System.out.println(FirstLetter);
		}
	}

	
//	@Test (priority = 2)
//	public void AddItemToCart() throws InterruptedException {
//		WebElement AddSauceLabItem = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
//		AddSauceLabItem.click();
//		Thread.sleep(2000);
//	}
//	@Test (priority = 3)
//	public void RemoveItemFromCart() {
//		WebElement RemoveSauceLabItem = driver.findElement(By.id("remove-sauce-labs-backpack"));
//		RemoveSauceLabItem.click();
//	}
	
	@AfterTest
	public void DoNothing() {
		
	}


}
