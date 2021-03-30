/**
 * @author      Federico Francia
 * @date        28/03/2021
 * @description This module implements two test cases for Sysdig Login page
 *
 *  PREREQUISITES:
 *  A valid trial account as been created for the 'EU Central' data centre:
 *  username: "fede.francia@gmail.com"
 *  password: "Sysdig01"
 * 
 *  The positive cases ("Happy path")
 * 
 *  1) Successful Logon:: valid username and password
 *     we expect to land to the "Onboarding - Sysdig" page
 * 
 *  2) Successful Logout: The positive case is the "Happy path": valid username and password,
 *     we expect to logout and be redirected to the Login page titled "Sysdig".
 * 
 *  The negative case
 *  3) Failed Logon : valid username, incorrect password,
 *      we expect the system prevent us to logon showing the message: "Credentials are not valid"
 */

package Selenium;

import static org.junit.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SysdigLogin {

    public static final int    TIMEOUT_SECONDS               = 5;
    public static final String APP_URL                       = "https://eu1.app.sysdig.com";
    public static final String LOGIN_PAGE_TITLE              = "Sysdig";
    public static final String ONBOARDING_PAGE_TITLE         = "Onboarding - Sysdig";
    public static final String USERNAME_SELECTOR             = "//*[@data-test='login-username']";
    public static final String PASSWORD_SELECTOR             = "//*[@data-test='login-password']";
    public static final String LOGIN_BUTTON_SELECTOR         = "//*[@data-id='submit-login']";
    public static final String LOGIN_ERROR_MSG_SELECTOR      = "//*[@data-test='login-error-message']";
    public static final String USER_MENU_SELECTOR            = "//*[@data-test='usermenu-icon']";
    public static final String LOGOUT_MENU_SELECTOR          = "//*[@data-test='logout-menu-item']";
    public static final String LOGOUT_MODAL_SELECTOR         = "//*[@data-test='logout-modal-logout']";

    public static final String VALID_USERNAME                = "fede.francia@gmail.com";
    public static final String VALID_PASSWORD                = "Sysdig01";
    public static final String INVALID_PASSWORD              = "Wrong001";
    public static final String CREDENTIALS_ERROR_MSG         = "Credentials are not valid";


    public static void main(final String[] args) {

        // Specify the Chromedriver path
        // System.setProperty("webdriver.chrome.driver",
        // "/Users/federicof/Documents/SeleniumJava");
        final WebDriver driver = new ChromeDriver();
        assert driver != null;
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(APP_URL);
        final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_SECONDS));
        wait.until(ExpectedConditions.titleIs(LOGIN_PAGE_TITLE));

        // *** SUCCESSFUL LOGIN (CORRECT CREDENTIALS) *** //
        sendKeys(wait, USERNAME_SELECTOR, VALID_USERNAME);
        sendKeys(wait, PASSWORD_SELECTOR, VALID_PASSWORD);
        click(wait, LOGIN_BUTTON_SELECTOR);

        // Assertion on page title
        wait.until(ExpectedConditions.titleIs(ONBOARDING_PAGE_TITLE));
        click(wait, USER_MENU_SELECTOR);
        click(wait, LOGOUT_MENU_SELECTOR);
        click(wait, LOGOUT_MODAL_SELECTOR);

        // Assertion on page title
        wait.until(ExpectedConditions.titleIs(LOGIN_PAGE_TITLE));

        // *** UNSUCCESSFUL LOGIN: (VALID USERNAME, WRONG PASSWORD) ***//
        sendKeys(wait, USERNAME_SELECTOR, VALID_USERNAME);
        sendKeys(wait, PASSWORD_SELECTOR, INVALID_PASSWORD);
        click(wait, LOGIN_BUTTON_SELECTOR);
        WebElement errorMsg = 
            new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LOGIN_ERROR_MSG_SELECTOR)));
        // Assertion on page title
        assertEquals (errorMsg.getText(), CREDENTIALS_ERROR_MSG );
        driver.quit();
    }
    // sendkeys method
    public static void sendKeys( WebDriverWait wait, String selector, String text) {
        wait.until(ExpectedConditions
        .visibilityOfElementLocated((By.xpath(selector)))).sendKeys(text);
    }

    // click method
    public static void click( WebDriverWait wait, String selector) {
        wait.until(ExpectedConditions
        .elementToBeClickable((By.xpath(selector)))).click();;
    }

}