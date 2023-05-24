import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class IncorrectSignUpTest {
    private WebDriver driver;
    private SignUpPage signUpPage;
    public String email = SignUpPage.generate();

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.myprotein.cz/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        signUpPage = new SignUpPage(driver);
    }

    @Test
    public void incorrectSignUpTest() {
        signUpPage.acceptCookies();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        signUpPage.closeAd();
        signUpPage.goToPersonalAccount();
        signUpPage.clickOnSignUp();
        signUpPage.enterNameSurname("Kate Lale7868");
        signUpPage.enterEmail(email);
        signUpPage.repeatEmail(email);
        signUpPage.enterPassword("12");
        signUpPage.repeatPassword("23");
        signUpPage.enterPhone("+4205678");
        signUpPage.submitForm();
        signUpPage.notAgreeToTerms();
        signUpPage.continueSignUp();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
