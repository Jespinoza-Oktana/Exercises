package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
    private final WebDriver driver;

    @FindBy(xpath = "//option[contains(text(), 'Webmaster')]")
    WebElement enterSubject;

    @FindBy(id = "email")
    WebElement enterEmail;

    @FindBy(id = "id_order")
    WebElement enterReference;

    @FindBy(id = "message")
    WebElement enterMessage;

    @FindBy(xpath = "//span[contains(text(), 'Send')]")
    WebElement submitButton;

    @FindBy(xpath = "//p[contains(@class, 'success')]")
    WebElement successMessage;

    public ContactPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void message(String email, String reference,String message){
        enterSubject.click();
        enterEmail.sendKeys(email);
        enterReference.sendKeys(reference);
        enterMessage.sendKeys(message);
        submitButton.click();
    }

    public boolean successIsDisplayed(){
        return successMessage.isDisplayed();
    }
}
