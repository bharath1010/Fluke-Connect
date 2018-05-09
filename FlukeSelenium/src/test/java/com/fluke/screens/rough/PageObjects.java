package com.fluke.screens.rough;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObjects {

@FindBy(how=How.ID, using = "emailAddr")
static WebElement emailId;

@FindBy(how=How.ID, using = "password")
static WebElement passWd;

@FindBy(how=How.CSS, using = ".common-button.yellow-rectangular-button.login-account-submit-button")
static WebElement signIn;

@FindBy(how=How.ID, using = "user-login-actions")
static WebElement currUserAction;

@FindBy(how=How.XPATH, using = "//span[text()='Sign out']")
static WebElement signOutBtn;

@FindBy(how=How.XPATH, using = "//div[@data-page=\"team\"]")
static WebElement teamTab;

@FindBy(how=How.ID, using = "createInviteButton")
static WebElement inviteWindow;

@FindBy(how=How.ID, using = "team-send-invite-button")
static WebElement inviteBtn;

@FindBy(how=How.ID, using = "inviteeEmail")
static WebElement emailField;

@FindBy(how=How.CSS, using = "p#validationErrors>label")
static WebElement errorEle;

@FindBy(how=How.XPATH, using = "//a[@class=\"common-button white-button team-invite-modal-button autosized-button\"][text()='Cancel']")
static WebElement cancelBtn;

static String status;
static String curURL;
static String error;
static WebDriverWait wait;
static int expWaitTime = 10;
static String teamUrl = "https://connect.fluke.com/en/team";

	
	//Define Explicit Wait
	public static WebDriverWait expWait(WebDriver driver, int expWait) {
		return wait = new WebDriverWait(driver, expWait);
	}
	
	//Sign-In Function
	public static void Login(WebDriver driver, String Url, String login, String passwd) throws InterruptedException {
	if(!driver.getCurrentUrl().equals(Url)) {
		driver.get(Url);
	}
	emailId.clear();
	passWd.clear();
	emailId.sendKeys(login);
	passWd.sendKeys(passwd);
	signIn.click();
	try {
	if(currUserAction.isEnabled()) {
	System.out.println("Login Successful for Valid Credential");
	status =  "Login Sucess";
	} 			
	} catch(NoSuchElementException e) {
	System.out.println("Login Failed for Invalid Credential");
	status =  "Login Fail";
	}
	}

	//Sign-Out Function			
	public static void SignOut(WebDriver driver) {
	if(currUserAction.isEnabled()) {
	currUserAction.click();
	signOutBtn.click();
	System.out.println("Successfully Signed-Out" );
	} else {
	System.out.println("Not Signed-In" );
	}
	}
	
	
	//Invite New Team Member Function
	public static void inviteTeam(WebDriver driver, String emailID) throws InterruptedException {
	if(!driver.getCurrentUrl().equals(teamUrl)) {
	teamTab.click();
	}
	Thread.sleep(5000);
	inviteWindow.click();
	emailField.sendKeys(emailID);
	inviteBtn.click();
	try {
		error = errorEle.getText();
	} catch (NoSuchElementException e) {
		System.out.println("Invite Succeeded");
	}
	if(!error.equals(null)) {
		System.out.println("Invite Failed due to the Error : " + error);
		cancelBtn.click();
	}
	}
}
