package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedInSearchPage {
	WebDriver driver;
	String SearchTitle = "Search | LinkedIn";
	String signOutURL = "https://www.linkedin.com/m/logout";
	@FindBy(xpath = "(//button[@class=\"artdeco-button artdeco-button--2 artdeco-button--secondary ember-view\"])[1]")
	WebElement messageBtn;
	@FindBy(xpath = "//*[contains(@class,\"msg-form__contenteditable\")]")
	WebElement messageTxt;
	@FindBy(xpath = "//*[@class=\"msg-form__send-button artdeco-button artdeco-button--1\"]")
	WebElement sendBtn;
	@FindBy(xpath = "//button[@class=\"global-nav__primary-link artdeco-dropdown__trigger artdeco-dropdown__trigger--placement-bottom ember-view\"]")
	WebElement avatarImg;
	@FindBy(xpath = "//*[contains(text(),'Sign Out')]")
	WebElement signOutBtn;
	@FindBy(xpath = "//*[@data-control-name=\"overlay.close_conversation_window\"]")
	WebElement closeChatButton;
	
	//contractor
	public LinkedInSearchPage(WebDriver driver) {
		this.driver = driver;
		//This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
	}

	// Click message Button
	public void clickMessageButton() throws InterruptedException {
		messageBtn.click();
		Thread.sleep(4000);
	}
	
	//Send message to the user
	public void inputMessage(String message) throws InterruptedException {
		messageTxt.sendKeys(message);
		Thread.sleep(2000);
	}
	
	//Click on Send button
	public void clickSendButton() throws InterruptedException {
		sendBtn.click();
		Thread.sleep(3000);
	}
	
	//Click on Close chat button
	public void clickCloseChatButton() throws InterruptedException {
		closeChatButton.click();
		Thread.sleep(1000);
	}
	
	//Click on user avatar
	public void clickAvatarImage() throws InterruptedException {
		avatarImg.click();
		Thread.sleep(2000);
	}
	
	//Click on SignOut button
	public void clickSignOutButton() throws InterruptedException {
		signOutBtn.click();
		Thread.sleep(3000);
		driver.close();
	}
	
	//Signout by URL
	public void signOut() throws InterruptedException {
		driver.get(signOutURL);
		Thread.sleep(3000);
	}
	
	public boolean IsThisSearchPage() {
		return driver.getTitle().contains(SearchTitle);
	}
}
