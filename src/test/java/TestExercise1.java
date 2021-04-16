import org.testng.Assert;
import pageObjects.AuthenticationPage;
import pageObjects.MainPage;
import io.qameta.allure.Description;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.MyAccountPage;

public class TestExercise1 extends Base{
    private MainPage mainPage;
    private AuthenticationPage authenticationPage;
    private MyAccountPage myAccountPage;

    @BeforeTest
    public void initialize(){
        driver=initializeDriver();
        mainPage = new MainPage(driver);
        authenticationPage = new AuthenticationPage(driver);
        myAccountPage = new MyAccountPage(driver);
        driver.get(mainPage.getUrl());
    }

    @Test(dataProvider = "send data", dataProviderClass = DataProvider.class)
    @Description("Test of the Exercise 1")
    public void testExercise1(String email, String firstName, String lastName, String password, String address,String city,String postalCod,String mobilePhone,String alias) {
        mainPage.toSignIn();
        authenticationPage.toSignIn(email,firstName,lastName,password,address,city,postalCod,mobilePhone,alias);
        Assert.assertTrue(myAccountPage.checkRegistration());
    }

    @AfterTest
    public void closeDriver(){
        driver.quit();
    }
}
