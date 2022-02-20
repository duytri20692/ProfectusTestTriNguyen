package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LikedInHomePage {
	WebDriver driver;
	String HomeTitle = "Feed | LinkedIn";
	@FindBy(xpath = "//*[@class=\"search-global-typeahead__input always-show-placeholder\"]")
	WebElement searchTxt;

	//contractor
	public LikedInHomePage(WebDriver driver) {
		this.driver = driver;
		//This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
	}

	// Search user
	public void searchUser(String searchKey) throws InterruptedException {
		searchTxt.sendKeys(searchKey);
		searchTxt.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
	}
	
	public boolean IsThisHomePage() {
		return driver.getTitle().contains(HomeTitle);
	}
}
