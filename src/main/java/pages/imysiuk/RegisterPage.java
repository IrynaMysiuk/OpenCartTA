package pages.imysiuk;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

    @FindBy(xpath = "//*[@id=\"content\"]/h1")
    private WebElement content;

    WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getContent() {
        return content.getText();
    }


    public RegisterPage goToRegisterPage() {
        return new PageFactory().initElements(driver, RegisterPage.class);
    }

}
