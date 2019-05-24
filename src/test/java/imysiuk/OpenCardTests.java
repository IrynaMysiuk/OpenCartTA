package imysiuk;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.imysiuk.LoginPage;
import pages.imysiuk.MainPage;
import pages.imysiuk.RegisterPage;

import java.util.Random;

public class OpenCardTests {

    public static final String DRIVERPATH = "C:\\Users\\Asus\\Downloads\\chromedriver.exe";
    public static final String URL = "https://demo.opencart.com/";

    WebDriver driver = null;

    @BeforeClass
    public void openPage() {
        System.setProperty("webdriver.chrome.driver", DRIVERPATH);
        driver = new ChromeDriver();
        driver.get(URL);
    }

    @Test
    public void checkRegistrationWithValidData() throws InterruptedException {
        MainPage mainPage = new MainPage(driver).goToMainPage();
        mainPage.clickMyAccountButton();
        mainPage.clickButtonRegister();
        LoginPage loginPage = new LoginPage(driver).goToLoginPage();
        Assert.assertEquals(driver.getCurrentUrl(), URL.concat("index.php?route=account/register"),
                "URL is incorrect");
        String firstName = String.valueOf(new Random().nextInt());
        loginPage.inputFirstName(firstName);
        loginPage.inputLastName(String.valueOf(new Random().nextInt()));
        loginPage.inputEmailName(String.valueOf(new Random().nextInt()).concat("@gmail.com"));
        loginPage.inputTelehone(String.valueOf(new Random().nextInt()));
        String password = String.valueOf(new Random().nextInt());
        loginPage.inputPassword(password);
        loginPage.inputConfirmPassword(password);
        loginPage.selectSubscribe(true);
        loginPage.selectPrivacyPolicy(true);
        Assert.assertEquals(loginPage.getSubmitButton(), "submit", "Button has incorrect name");
        loginPage.clickSubmit();
        Thread.sleep(2000);
        RegisterPage registerPage = new RegisterPage(driver).goToRegisterPage();
        Assert.assertEquals(registerPage.getContent(), "Your Account Has Been Created!",
                "Registration wasn't successfully!");
    }

    @Test
    public void checkRegistrationWithDuplicatedPassword() throws InterruptedException {
        MainPage mainPage = new MainPage(driver).goToMainPage();
        mainPage.clickMyAccountButton();
        mainPage.clickButtonRegister();
        LoginPage loginPage = new LoginPage(driver).goToLoginPage();
        Assert.assertEquals(driver.getCurrentUrl(), URL.concat("index.php?route=account/register"),
                "URL is incorrect");
        String firstName = String.valueOf(new Random().nextInt());
        loginPage.inputFirstName(firstName);
        loginPage.inputLastName(String.valueOf(new Random().nextInt()));
        loginPage.inputEmailName(String.valueOf(new Random().nextInt()).concat("@gmail.com"));
        loginPage.inputTelehone(String.valueOf(new Random().nextInt()));
        loginPage.inputPassword(String.valueOf(new Random().nextInt()));
        loginPage.inputConfirmPassword(String.valueOf(new Random().nextInt()));
        loginPage.selectSubscribe(true);
        loginPage.selectPrivacyPolicy(true);
        Assert.assertEquals(loginPage.getSubmitButton(), "submit", "Button has incorrect name");
        loginPage.clickSubmit();
        Thread.sleep(2000);
        RegisterPage registerPage = new RegisterPage(driver).goToRegisterPage();
        Assert.assertEquals(registerPage.getContent(), "Your Account Has Been Created!",
                "Registration was successfully!");
    }
    @AfterMethod
    public void closePage() {
        driver.close();
    }
}
