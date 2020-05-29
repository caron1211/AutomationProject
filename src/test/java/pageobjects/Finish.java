package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Finish extends BasePage{

	@FindBy(css = ".complete-header")
	private WebElement completeText;
	@FindBy(css = ".subheader")
	private WebElement titleFinishPage;

	public Finish(WebDriver driver) {
		super(driver);
	}

	public String finishMsg() {
		return completeText.getText();
	}
	
	public String titleFinish() {
		String tf = titleFinishPage.getText();
		return tf;
	} 
}
