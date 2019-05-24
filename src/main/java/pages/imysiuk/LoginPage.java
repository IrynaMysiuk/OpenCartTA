package pages.imysiuk;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    @FindBy(id = "input-firstname")
    private WebElement inputFirstName;

    @FindBy(id = "input-lastname")
    private WebElement inputLastName;

    @FindBy(id = "input-email")
    private WebElement inputEmail;

    @FindBy(id = "input-telephone")
    private WebElement inputTelephone;

    @FindBy(id = "input-password")
    private WebElement inputPassword;

    @FindBy(id = "input-confirm")
    private WebElement inputConfirm;

    @FindBy(css = ".pull-right > input:nth-child(2)")
    private WebElement subscribe;

    @FindBy(css = ".btn-primary")
    private WebElement privacyPolicy;

    @FindBy(css = "#content > form > div > div > input.btn.btn-primary")
    private WebElement submitButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage goToLoginPage() {
        return new PageFactory().initElements(driver, LoginPage.class);
    }

    public String getInputFirstName() {
        return inputFirstName.getText();
    }

    public void inputFirstName(String firstName) {
        inputFirstName.sendKeys(firstName);
    }

    public void inputLastName(String lastName) {
        inputLastName.sendKeys(lastName);
    }

    public void inputEmailName(String email) {
        inputEmail.sendKeys(email);
    }

    public void inputTelehone(String telephone) {
        inputTelephone.sendKeys(telephone);
    }

    public void inputPassword(String password) {
        inputPassword.sendKeys(password);
    }

    public void inputConfirmPassword(String password) {
        inputConfirm.sendKeys(password);
    }

    public void selectSubscribe(boolean isSubscribe) {
        if (isSubscribe)
            subscribe.click();
    }

    public void selectPrivacyPolicy(boolean agree) {
        if (agree)
            privacyPolicy.click();
    }

    public String getPrivacyPolicy() {
        return privacyPolicy.getText();
    }

    public String getSubmitButton() {
        return submitButton.getAttribute("type");
    }

    public void clickSubmit() {
        submitButton.click();
    }
}
