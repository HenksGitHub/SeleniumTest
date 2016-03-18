package com.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;

@SpringBootApplication
public class SeleniumApplication {

	public static void main(String[] args) throws InterruptedException {
		//SpringApplication.run(SeleniumApplication.class, args);
		
		WebDriver driver = new FirefoxDriver();

		// A "base url", used by selenium to resolve relative URLs
		 String baseUrl = "http://www.google.com";

		// Create the Selenium implementation
		Selenium selenium = new WebDriverBackedSelenium(driver, baseUrl);

		// Perform actions with selenium

		selenium.open("http://www.w3schools.com/html/html_forms.asp");
		selenium.type("name=firstname", "Dan");
		selenium.type("name=lastname", "Vega");

		// Get the underlying WebDriver implementation back. This will refer to the
		// same WebDriver instance as the "driver" variable above.
		WebDriver driverInstance = ((WebDriverBackedSelenium) selenium).getWrappedDriver();

		// Pause 10 sec
		Thread.sleep(10000);

		//Finally, close the browser. Call stop on the WebDriverBackedSelenium instance
		//instead of calling driver.quit(). Otherwise, the JVM will continue running after
		//the browser has been closed.
		
		selenium.close();
	}
}
