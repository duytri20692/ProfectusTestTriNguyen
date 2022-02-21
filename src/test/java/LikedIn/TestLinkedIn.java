package LikedIn;

import org.testng.annotations.Test;

import Utils.Helper;
import pages.LikedInHomePage;
import pages.LinkedInLoginPage;
import pages.LinkedInSearchPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class TestLinkedIn {
	final static String driverPath = System.getProperty("user.dir")
			+ "\\src\\test\\resources\\driver\\chromedriver.exe";
	final static String baseUrl = "https://www.linkedin.com/";
	WebDriver driver;
	LinkedInLoginPage objLogin;
	LikedInHomePage objHomePage;
	LinkedInSearchPage objSearchPage;
	String loginUser;
	String loginPass;		

	@Test(dataProvider = "dp")
	public void testSendMessageLinkedIn(String searchText, String sendMessage) throws InterruptedException {
		User user = Helper.readData();
		// Create Login Page object
		objLogin = new LinkedInLoginPage(driver);

		// login to LinkedIn
		objLogin.loginToLinkedIn(user.getEmail(), user.getPassword());

		// On Homepage, Search out 'Profectus Kamaljeet'
		// Create Home Page object
		objHomePage = new LikedInHomePage(driver);
		Assert.assertTrue(objHomePage.IsThisHomePage());
		objHomePage.searchUser(searchText);

		// Create Search Page object
		objSearchPage = new LinkedInSearchPage(driver);
		Assert.assertTrue(objSearchPage.IsThisSearchPage());
		// Send a message
		objSearchPage.clickMessageButton();
		objSearchPage.inputMessage(sendMessage);
		objSearchPage.clickSendButton();
		objSearchPage.clickCloseChatButton();
		// Sign out
		objSearchPage.signOut();
		Assert.assertTrue(objLogin.IsThisLoginPage());
	}

	@DataProvider
	public Object[][] dp() {
		return new Object[][] { { "Profectus Kamaljeet", "Hello, Kamaljeet. This is the auto message from Tri Nguyen" } };
	}

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get(baseUrl);
		driver.manage().window().maximize();
	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
