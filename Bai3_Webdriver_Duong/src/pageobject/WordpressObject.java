package pageobject;

import org.openqa.selenium.By;

public class WordpressObject {
	//setup
	public static By btnContinue = By.id("language-continue");
	
	public static By btnLetsgo = By.cssSelector(".wp-core-ui p:nth-child(7) a");

	public static By txtDbName = By.id("dbname");
	public static By txtUname = By.id("uname");
	public static By txtPasswd = By.id("pwd");
	public static By btnSubmit = By.name("submit");

	public static By btnRuntheinstall = By.cssSelector(".step a.button.button-large");
	
	
	
	
	//admin
	
	public static By txtSite = By.id("weblog_title");
	public static By txtLogin = By.id("user_login");
	public static By txtPasswdadmin = By.name("pass1-text");
	public static By cbxHint = By.className(".button.button-secondary.wp-hide-pw");
	public static By cbxPasswdadmin = By.name("pw_weak");
	
	//public static By cbxPasswd = By.id("pass-strength-result");
	//public static By cbxPasswdadmin = By.cssSelector(".pw-checkbox");
	public static By txtEmailadmin = By.id("admin_email");
	public static By btnSubmitadmin = By.id("submit");
	public static By btnInstallwordps = By.name("Submit");
	
	//public static By btnLoginfirst = By.cssSelector(".step a.button.button-large");
	//public static By btnLoginfirst = By.linkText("Log In");
	
	public static By btnLogin = By.cssSelector("a.button.button-large");
	
	//login
	
	public static By txtUserlogin = By.name("log");
	public static By txtPasswdlogin = By.name("pwd");
	public static By btnSubmitlogin = By.name("wp-submit");
	public static By actualMess = By.cssSelector(".welcome-panel-content h2");

}
