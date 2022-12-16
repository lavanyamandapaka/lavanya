package test;
import org.testng.annotations.Test;

import testCase.demoShopping;
import Utility.DriverClass;

import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginTest {
	WebDriver driver;
  
  @BeforeMethod
  public void beforeMethod() {
	  driver = DriverClass.openBrowser("chrome", "https://demowebshop.tricentis.com/");
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
  }

  @AfterMethod
  public void afterMethod() {
  }
  
  @Test
  public void verifyLogin() {
	  
	  demoShopping login = new demoShopping(driver);
	  login.doLogin("email@lavanya.test", "abcd123");
	  String text = driver.findElement(By.linkText("Log out")).getText();	  
	  Assert.assertEquals(text, "Log out");
	  if(text.equalsIgnoreCase("Log out"))
	  {
		  System.out.println("Successful Login!");
	  }
	  else
	  {
		  System.out.println("Invalid Login");
	  }
  }

}
