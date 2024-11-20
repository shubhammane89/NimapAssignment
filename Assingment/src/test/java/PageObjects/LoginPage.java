package PageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='mat-input-0']")
	WebElement usernameField;

	@FindBy(xpath = "//input[@id='mat-input-1']")
	WebElement passwordField;

	@FindBy(xpath = "//button[@id='kt_login_signin_submit']")
	WebElement loginButton;

	@FindBy(xpath = "//div[@class='toast-message']") 
	WebElement toastMessage;

	@FindBy(xpath = "//span[normalize-space()='72']")
	WebElement punchedInMessage;

	public void enterEmail(String emailId) {
		usernameField.sendKeys(emailId);
	}

	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}

	public void clickLoginButton() throws InterruptedException {
		Thread.sleep(1000);
		loginButton.click();
	}
	
	public boolean isPunchedInMessageDisplayed() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		return wait.until(ExpectedConditions.visibilityOf(punchedInMessage)).isDisplayed();
	}
}
