package pages.imysiuk;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    @FindBy(xpath = "//span[@class=\"caret\"]")
    private WebElement buttonMyAccount;

    @FindBy(css = ".dropdown-menu > li:nth-child(1) > a")
    private WebElement buttonRegister;

    WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickMyAccountButton() {
        buttonMyAccount.click();
    }

    public void clickButtonRegister() {
        buttonRegister.click();
    }

    public MainPage goToMainPage() {
        return new PageFactory().initElements(driver, MainPage.class);
    }

}
