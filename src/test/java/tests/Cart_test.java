package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.Cart;
import pageobjects.Checkout;
import pageobjects.Login;
import pageobjects.Products;

public class Cart_test extends BaseTest{

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
	public void t03_remvoeItem() {
		Cart ca = new Cart(driver);
		ca.removeItem();
		Cart ca_two = new Cart(driver);
		String actualMsg = ca_two.valueOfItems();
		Assert.assertEquals(actualMsg, "3");
	}

	@Test
	public void t04_continueShopping() {
		Cart ca = new Cart(driver);
		ca.continueShopping();
		Products item = new Products(driver);
		item.openCart(); // open cart again for the next test
		Cart ca_two = new Cart(driver);
		String actualMsg = ca_two.backToCart();
		Assert.assertEquals(actualMsg, "DESCRIPTION");
	}

	@Test
	public void t05_numOfItems() throws InterruptedException {
		Cart ca = new Cart(driver);
		ca.numOfItems();
		Cart ca_two = new Cart(driver);
		String actualMsg = ca_two.valueOfItems();
		Assert.assertEquals(actualMsg, "3");
	}

	@Test
	public void t06_clickCheckOut() {
		Cart ca = new Cart(driver);
		ca.checkout();
		Checkout co = new Checkout(driver);
		String actualMsg = co.titleCheckout();
		Assert.assertEquals(actualMsg, "Checkout: Your Information");
	}
}
