package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pageobjects.Cart;
import pageobjects.Login;
import utilities.DataProviders;

public class Login_test extends BaseTest {

	@Test(dataProvider = "getData", dataProviderClass = DataProviders.class, description = "use from table information")
	public void t01_loginFailedFromTable(String user, String password) throws InterruptedException {
		Login lp = new Login(driver);
		lp.login(user, password);

		String actualMsg = lp.errorMsg();
		Assert.assertEquals(actualMsg, "Epic sadface: Username and password do not match any user in this service");
	}

	@Severity(SeverityLevel.NORMAL)
	@Test(description = "Login with wrong password and match assert")
	public void t02_loginFailedMatchAssert() throws InterruptedException {
		Login lp = new Login(driver);
		lp.login("standard_user", "secretsauce"); // wrong password

		String actualMsg = lp.errorMsg();
		Assert.assertEquals(actualMsg, "Epic sadface: Username and password do not match any user in this service"); // match
	}

	@Severity(SeverityLevel.NORMAL)
	@Test(description = "Login with wrong password with unmatch assert")
	public void t03_loginFailedNoMatchAssert() throws InterruptedException {
		Login lp = new Login(driver);
		lp.login("standard_user", "secretsauce"); // wrong password

		String expected = "Sorry! Epic sadface: Username and password do not match any user in this service";
		String actualMsg = lp.errorMsg();
		Assert.assertEquals(actualMsg, expected); // no match
	}

	@Severity(SeverityLevel.CRITICAL)
	@Test(description = "Login with right username and password")
	public void t04_loginSucceed() throws InterruptedException {
		Login lp = new Login(driver);
		lp.login("standard_user", "secret_sauce");
		Cart ca = new Cart(driver);
		String actualMsg = ca.loginSuccess();
		Assert.assertEquals(actualMsg, "Products");

	}

}
