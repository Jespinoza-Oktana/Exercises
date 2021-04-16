package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    private final WebDriver driver;
    private final String url ="http://automationpractice.com/index.php";


    @FindBy(xpath = "//a[contains(text(), 'Sign in')]")
    WebElement signInButton;

    @FindBy(xpath = "//a[contains(text(), 'Contact us')]")
    WebElement contactUsButton;

    public MainPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void toSignIn(){
        signInButton.click();
    }

    public void contact(){
        contactUsButton.click();
    }

    public String getUrl() {
        return url;
    }
}
