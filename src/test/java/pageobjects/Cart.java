package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Cart extends BasePage {

	@FindBy(css = ".checkout_button")
	private WebElement clickCheckOut;
	@FindBy(css = "#cart_contents_container div:nth-child(6) button")
	private WebElement removeBtn;
	@FindBy(css = ".inventory_item_name")
	private List<WebElement> list;
	@FindBy(css = ".inventory_item_price")
	private List<WebElement> listPrice;
	@FindBy(css = ".inventory_item_name")
	private WebElement nameItem;
	@FindBy(css = ".inventory_details_back_button")
	private WebElement backBtn;
	@FindBy(css = "#cart_contents_container div.cart_footer > a.btn_secondary")
	private WebElement continueBtn;
	@FindBy(css = ".fa-layers-counter.shopping_cart_badge")
	private WebElement valueOfItems;
	@FindBy(css = ".product_label")
	private WebElement loginsuccess;
	@FindBy(css = ".cart_desc_label")
	private WebElement backToCart;

	public Cart(WebDriver driver) {
		super(driver);
	}

	public void checkout() {
		click(clickCheckOut);
	}

	public void removeItem() {
		click(removeBtn);
	}

	public void continueShopping() {
		click(continueBtn);
	}

	public void numOfItems() throws InterruptedException {
		Thread.sleep(1000);
		String num = valueOfItems.getText();
		double a = Double.valueOf(num);
		System.out.println("The number of the items is: " + a);
	}

	public String valueOfItems() {
		String noi = valueOfItems.getText();
		return noi;
	}

	public String loginSuccess() {
		String losc = loginsuccess.getText();
		return losc;
	}

	public String backToCart() {
		String btc = backToCart.getText();
		return btc;
	}
}
