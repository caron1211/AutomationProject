package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.Cart;
import pageobjects.Checkout;
import pageobjects.Finish;
import pageobjects.Login;
import pageobjects.Overview;
import pageobjects.Products;

public class Overview_test extends BaseTest {

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
	public void t05_printSauceCard() {

		Overview ov = new Overview(driver);
		ov.numSaurceCard();
		String val = ov.valSaurceCard();
		Assert.assertEquals(val, "SauceCard #31337");
	}

	@Test
	public void t06_printItemTotal() {
		Overview ov = new Overview(driver);
		ov.itemTotal();
		String val = ov.valItemTotal();
		Assert.assertEquals(val, "Item total: $105.96000000000001");	
	}

	@Test
	public void t07_printTax() {
		Overview ov = new Overview(driver);
		ov.tax();
		String val = ov.valTax();
		Assert.assertEquals(val, "Tax: $8.48");	
	}

	@Test
	public void t08_printTotal() {
		Overview ov = new Overview(driver);
		ov.total();
		String val = ov.valTotal();
		Assert.assertEquals(val, "Total: $114.44");	
	}
	
	@Test
	public void t09_finish() {
		Overview ov = new Overview(driver);
		ov.finish();
		Finish fs = new Finish(driver);
		String val = fs.titleFinish();
		Assert.assertEquals(val, "Finish");	
	}
	
}
