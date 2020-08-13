package tests;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.Cart;
import pageobjects.Checkout;
import pageobjects.Finish;
import pageobjects.Login;
import pageobjects.Overview;
import pageobjects.Products;
import pageobjects.Thanks;

public class Thanks_test extends BaseTest {

	@Test
	public void t01_loginSucceed() throws InterruptedException {
		Login lp = new Login(driver);
		lp.login("standard_user", "secret_sauce");
		Cart ca = new Cart(driver);
		String actualMsg = ca.loginSuccess();
		Assert.assertEquals(actualMsg, "Products");
	}

	@Test
	public void t02_addListItems() {
		Products item = new Products(driver);
		item.chooseToItemsList("Sauce Labs Bike Light");
		item.chooseToItemsList("Test.allTheThings() T-Shirt (Red)");
		item.chooseToItemsList("Sauce Labs Bolt T-Shirt");
		item.chooseToItemsList("Sauce Labs Onesie");
		item.openCart();
		Cart ca = new Cart(driver);
		String actualMsg = ca.valueOfItems();
		Assert.assertEquals(actualMsg, "4");
	}

	@Test
	public void t03_clickCheckOut() {
		Cart ca = new Cart(driver);
		ca.checkout();
		Checkout co = new Checkout(driver);
		String actualMsg = co.titleCheckout();
		Assert.assertEquals(actualMsg, "Checkout: Your Information");
	}

	@Test
	public void t04_personalCorrectDetails() throws InterruptedException {
		Checkout co = new Checkout(driver);
		co.fillDetails("Biran", "Varon", "7530249");
		Overview ov = new Overview(driver);
		String actualMsg = ov.titleOverview();
		Assert.assertEquals(actualMsg, "Checkout: Overview");
	}

	@Test
	public void t05_finish() {
		Overview ov = new Overview(driver);
		ov.finish();
		Finish fs = new Finish(driver);
		String val = fs.titleFinish();
		Assert.assertEquals(val, "Finish");
	}

	@Test
	public void t06_printMessage() {
		Thanks ty = new Thanks(driver);
		ty.printHeader();
		ty.printText();
	}

	@Test
	public void t07_finishOrder() {
		Thanks valid = new Thanks(driver);
		valid.finishMsg();
	}

	@Test // screenshot
	public void t08_captureScreenshot() throws IOException {

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		org.openqa.selenium.io.FileHandler.copy(scrFile, new File("./Screenshots/done_successfully.png"));
	}

	@Test
	public void t09_logOut() {
		Thanks ty = new Thanks(driver);
		ty.logOut();
	}
}
