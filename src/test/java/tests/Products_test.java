package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.Cart;
import pageobjects.Login;
import pageobjects.Products;

public class Products_test extends BaseTest{
	
	@Test
	public void t01_loginSucceed() throws InterruptedException {
		Login lp = new Login(driver);
		lp.login("standard_user", "secret_sauce");
		Cart ca = new Cart(driver);
		String actualMsg = ca.loginSuccess();
		Assert.assertEquals(actualMsg, "Products");
		Thread.sleep(1000);
	}

	@Test
	public void t02_addOneItemAndBack() {
		Products item = new Products(driver);
		item.nameOfItem();
		item.addToCart();
		item.back();
		Cart ca = new Cart(driver);
		String actualMsg = ca.loginSuccess();
		Assert.assertEquals(actualMsg, "Products");
	}

	@Test
	public void t03_addListItems() {
		Products item = new Products(driver);
		item.chooseToItemsList("Sauce Labs Bike Light");
		item.chooseToItemsList("Test.allTheThings() T-Shirt (Red)");
		item.chooseToItemsList("Sauce Labs Bolt T-Shirt");
		item.chooseToItemsList("Sauce Labs Onesie");
		Cart ca = new Cart(driver);
		String actualMsg = ca.valueOfItems();
		Assert.assertEquals(actualMsg, "5");
	}

	@Test
	public void t04_lowToHigh() {
		Products item1 = new Products(driver);
		item1.sortLowToHigh();
	}

	@Test
	public void t05_highToLowh() {
		Products item1 = new Products(driver);
		item1.sortHighToLow();
	}

	@Test
	public void t06_ZToA() {
		Products item1 = new Products(driver);
		item1.sortZToA();
	}

	@Test
	public void t07_logOut() {
		Products item1 = new Products(driver);
		item1.logOut();
		Login lg = new Login(driver);
		String actualMsg = lg.loginAfterLogout();
		Assert.assertEquals(actualMsg, "Accepted usernames are:");
		
	}

}
