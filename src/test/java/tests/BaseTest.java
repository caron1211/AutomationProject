package tests;

import static io.restassured.RestAssured.*;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseTest {
	WebDriver driver;

	@BeforeClass
	public void setup(ITestContext testContext) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		testContext.setAttribute("WebDriver", this.driver);
		driver.get("https://www.saucedemo.com/");
	}

	@Test
	public void getResponseTime() {
		RequestSpecification requestSpec = RestAssured.given();
		Response responseTime = requestSpec.get("https://www.saucedemo.com/");

		// Print response time
		System.out.println("Response Time: " + responseTime.getTime());
	}

	@Test
	public void getStatusCode() {
		given().log().ifValidationFails().when().get("https://www.saucedemo.com/").then().statusCode(200);
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
		Reporter.log("======# Browser Test End #======", true);
	}
}
