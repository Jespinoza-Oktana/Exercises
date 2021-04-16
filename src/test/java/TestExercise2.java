import org.testng.Assert;
import pageObjects.MainPage;
import io.qameta.allure.Description;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.ContactPage;

public class TestExercise2 extends Base{
    private MainPage mainPage;
    private ContactPage contactPage;

    @BeforeTest
    public void initialize(){
        driver=initializeDriver();
        mainPage = new MainPage(driver);
        contactPage = new ContactPage(driver);
        driver.get(mainPage.getUrl());
    }

    @Test(dataProvider = "contact message", dataProviderClass = DataProvider.class)
    @Description("Test of the Exercise 2")
    public void testExercise2(String email, String reference, String message){
        mainPage.contact();
        contactPage.message(email,reference,message);
        Assert.assertTrue(contactPage.successIsDisplayed());
    }

    @AfterTest
    public void closeDriver(){
        driver.quit();
    }
}
