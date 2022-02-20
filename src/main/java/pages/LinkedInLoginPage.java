package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedInLoginPage {
	WebDriver driver;
	String LoginTitle = "LinkedIn: Log In or Sign Up";
	@FindBy(className = "nav__button-secondary")
	WebElement loginBtn;	
	@FindBy(id = "username")
	WebElement emailTxt;
	@FindBy(id = "password")
	WebElement passTxt;
	@FindBy(xpath = "//button[@class=\"btn__primary--large from__button--floating\"]")
	WebElement signInBtn;
	
	//contractor
	public LinkedInLoginPage(WebDriver driver) {
		this.driver = driver;
		//This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
	}
	
	//click on Longin button
	public void clickLogin() throws InterruptedException {
		loginBtn.click();
		Thread.sleep(1000);
	}
	
	//Set email
	public void setEmail(String user) {
		emailTxt.sendKeys(user);
	}
	
	//Set pass
	public void setPass(String pass) {
		passTxt.sendKeys(pass);
	}
	
	//Click on Signn button
	public void clickSignIn() {
		signInBtn.click();
	}
	
	/**

     * This POM method will be exposed in test case to login in the application

     * @param strUserName

     * @param strPasword

     * @return
	 * @throws InterruptedException 

     */
	public void loginToLinkedIn(String strUserName, String strPassword) throws InterruptedException {
		//Click Login
		this.clickLogin();
		//Input email
		this.setEmail(strUserName);
		//Input pass
		this.setPass(strPassword);
		//Click SignIn
		this.clickSignIn();
		Thread.sleep(5000);
	}
	
	public boolean IsThisLoginPage() {
		return driver.getTitle().equals(LoginTitle);
	}
}
