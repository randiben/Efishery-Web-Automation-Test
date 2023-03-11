package com.saucedemo;


import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
	
	WebDriver driver = null;
	String baseUrl = "https://www.saucedemo.com/";
	String expectedResult = "Products";
	String loginFailed = "Epic sadface: Username and password do not match any user in this service";
	
	@Given("User has accessed demosauce site")
	public void user_has_accessed_demosauce_site() {
//		System.setProperty("webdriver.chrome.driver", "C:\\webdriver\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		this.driver = new ChromeDriver();
		driver.navigate().to(this.baseUrl);
		driver.manage().window().maximize();
	}
	
	@When("User input username {string}")
	public void user_input_username(String username) {
		driver.findElement(By.id("user-name")).sendKeys(username);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@When("User input password {string}")
	public void user_input_password(String password) throws InterruptedException {
		driver.findElement(By.id("password")).sendKeys(password);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Thread.sleep(2000);
	}
	
	@When("User input invalid password {string}")
	public void user_input_invalid_password(String password) throws InterruptedException {
		driver.findElement(By.id("password")).sendKeys(password);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Thread.sleep(2000);
	}
	
	@When("Click on login button")
	public void click_on_login_button() {
		driver.findElement(By.id("login-button")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@Then("Validation message will be displayed")
	public void Validation_message_will_be_displayed() {
		
		WebElement header = driver.findElement(By.xpath("//h3[@data-test='error']"));
		String warning = header.getText();
		assertEquals(warning, loginFailed);
	}
	
	@Then("Validate homepage is displayed")
	public void validate_homepage_is_displayed() {
		
		WebElement title = driver.findElement(By.xpath("//span[@class='title']"));
		String header = title.getText();
		assertEquals(header, expectedResult);
	}

}
