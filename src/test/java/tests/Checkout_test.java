package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.Cart;
import pageobjects.Checkout;
import pageobjects.Login;
import pageobjects.Overview;
import pageobjects.Products;

public class Checkout_test extends BaseTest {
	
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
	public void t04_personalWrongFirstName() throws InterruptedException {
		Checkout co = new Checkout(driver);
		co.fillDetails("", "Varon", "7530249");
		String expected = "Error: First Name is required";
		String actual = co.errorMsg();

		Assert.assertEquals(actual, expected);
		Thread.sleep(2000);
	}

	@Test
	public void t05_personalCorrectDetails() throws InterruptedException {
		Checkout co = new Checkout(driver);
		co.fillDetails("Biran", "Varon", "7530249");
		Overview ov = new Overview(driver);
		String actualMsg = ov.titleOverview();
		Assert.assertEquals(actualMsg, "Checkout: Overview");
	}

} 
