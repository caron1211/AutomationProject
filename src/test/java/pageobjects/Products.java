package pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class Products extends BasePage {
	
	@FindBy(css = ".inventory_item_name")
	private List<WebElement> list;
	@FindBy(css = "#shopping_cart_container > a > svg > path")
	private WebElement clickOpenCart;
	@FindBy(css = ".btn_primary.btn_inventory")
	private WebElement addToCartBtn;
	@FindBy(css = "#item_4_title_link > div")
	private WebElement nameOfItem;
	@FindBy(css = ".product_sort_container")
	private WebElement sortBtn;
	@FindBy(css = ".bm-burger-button")
	private WebElement menuBtn;
	@FindBy(css = "#about_sidebar_link")
	private WebElement aboutBtn;
	@FindBy(css = "#logout_sidebar_link")
	private WebElement logOutBtn;
	@FindBy(css = ".inventory_details_back_button")
	private WebElement clickBack;

	public Products(WebDriver driver) {
		super(driver);
	}

	public void chooseToItemsList(String name) {
		for (WebElement el : list) {
			if (el.getText().equalsIgnoreCase(name)) {
				click(addToCartBtn);
				break;
			}
		}
	}

	public void nameOfItem() {
		click(nameOfItem);
	}

	public void addToCart() {
		click(addToCartBtn);
	}

	public void sortLowToHigh() {
		Select s = new Select(sortBtn);
		s.selectByValue("lohi");
	}

	public void sortHighToLow() {
		Select s = new Select(sortBtn);
		s.selectByValue("hilo");
	}

	public void sortZToA() {
		Select s = new Select(sortBtn);
		s.selectByValue("za");
	}

	public void about() {
		click(menuBtn);
		click(aboutBtn);
	}

	public void openCart() {
		click(clickOpenCart);
	}

	public void logOut() {
		click(menuBtn);
		click(logOutBtn);
	}

	public void back() {
		click(clickBack);
	}
}
