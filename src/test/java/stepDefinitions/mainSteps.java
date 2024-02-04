package stepDefinitions;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class mainSteps {
	public WebDriver driver;
	int j;
	@Given("User is on saucedemo page {string}")
	public void user_is_on_saucedemo_page(String string) {
		//System.setProperty("webdriver.chromedriver.driver","C:\\Eclipse\\Browser_Driver\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
	}
	
	@Given("^Login with username (.+) and password (.+)$")
	//@Given("Login with username {string} and password {string}")
	public void login_with_username_and_password(String username, String password) {
		driver.findElement(By.id("user-name")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("login-button")).click();
	}

	
	@When("Select the product and add it to cart")
	public void select_the_product_and_add_it_to_cart() {
		//String productName = "Test.allTheThings() T-Shirt (Red)";
		driver.findElement(By.id("item_3_title_link")).click();
		driver.findElement(By.id("add-to-cart-test.allthethings()-t-shirt-(red)")).click();
		
	}
	
	
	
	@Then("Go to cart and order that product")
	public void go_to_cart_and_order_that_product(List<String> d) {
		driver.findElement(By.cssSelector("a.shopping_cart_link")).click();
		driver.findElement(By.id("checkout")).click();
		driver.findElement(By.id("first-name")).sendKeys(d.get(0));
		driver.findElement(By.id("last-name")).sendKeys(d.get(1));
		driver.findElement(By.id("postal-code")).sendKeys(d.get(2));
		driver.findElement(By.id("continue")).click();		
		driver.findElement(By.id("finish")).click();
		System.out.println(driver.findElement(By.cssSelector("h2.complete-header")).getText());
		
	}
	
	@When("Select all the links on that page")
	public void select_all_the_links_on_that_page() {
		List<WebElement> links = driver.findElements(By.cssSelector("div.inventory_item_name "));
		j = links.size();
		}

	@Then("Click all links one by one")
	public void click_all_links_one_by_one() {
		for(int i=0;i<j;i++) 
		{
			List<WebElement> l = driver.findElements(By.cssSelector("div.inventory_item_name "));
			l.get(i).click();
			driver.findElement(By.id("back-to-products")).click();
		}
		System.out.println("All links are working fine");
	}
	
	
	
	
	
	
	
	
	
	
	
// After works in decrement order, means 1 will run first and 0 will run next
//Before works in increment order, means 0 will run first and 1 will run next
	@After(order=1)
	public void takesScreenshotOnFailure(Scenario scenario) {
		if (scenario.isFailed()) {
			TakesScreenshot ts = (TakesScreenshot)driver;
			byte[] SrcFile=ts.getScreenshotAs(OutputType.BYTES);
			scenario.attach(SrcFile, "image/png", "screenshot");
		}
	}
	
	@After(order =0)
	public void tearDown() {
		driver.close();
	}
	
	}


