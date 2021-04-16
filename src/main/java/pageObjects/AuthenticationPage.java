package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.StringFunctions;

public class AuthenticationPage {

    private final WebDriver driver;
    public WebDriverWait wait;

    @FindBy(id = "email_create")
    WebElement sendEmail;

    @FindBy(id = "SubmitCreate")
    WebElement submitButton;

    @FindBy(id = "customer_firstname")
    WebElement enterFirstName;

    @FindBy(id = "customer_lastname")
    WebElement enterLastName;

    @FindBy(id = "passwd")
    WebElement enterPassword;

    @FindBy(id = "address1")
    WebElement enterAddress;

    @FindBy(id = "city")
    WebElement enterCity;

    @FindBy(id = "postcode")
    WebElement enterPostalCode;

    @FindBy(xpath = "//option[contains(text(), 'Rhode Island')]")
    WebElement enterState;

    @FindBy(id = "phone_mobile")
    WebElement enterMobilePhone;

    @FindBy(id = "alias")
    WebElement enterAlias;

    @FindBy(id = "submitAccount")
    WebElement registerAccount;

    public AuthenticationPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver,10);
    }

    public void toSignIn(String email, String firstName, String lastName, String password, String address,String city,String postalCod,String mobilePhone,String alias){
        sendEmail.sendKeys(email);
        submitButton.click();
        wait.until(ExpectedConditions.visibilityOf(enterFirstName));
        enterFirstName.sendKeys(firstName);
        enterLastName.sendKeys(lastName);
        enterPassword.sendKeys(password);
        enterAddress.sendKeys(address);
        enterCity.sendKeys(city);
        enterState.click();
        enterPostalCode.sendKeys(postalCod);
        enterMobilePhone.sendKeys(mobilePhone);
        enterAlias.sendKeys(alias);
        registerAccount.click();
    }
}
