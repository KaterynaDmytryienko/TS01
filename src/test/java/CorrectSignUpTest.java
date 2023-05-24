import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class CorrectSignUpTest {

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
        public void correctSignUpTest() {
            signUpPage.acceptCookies();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            signUpPage.closeAd();
            signUpPage.goToPersonalAccount();
            signUpPage.clickOnSignUp();
            signUpPage.enterNameSurname("Kate Lale");
            signUpPage.enterEmail(email);
            signUpPage.repeatEmail(email);
            signUpPage.enterPassword("Qwerty1234");
            signUpPage.repeatPassword("Qwerty1234");
            signUpPage.enterPhone("+420567839409");
            signUpPage.submitForm();
            signUpPage.notAgreeToTerms();
            signUpPage.continueSignUp();
        }

        @After
        public void tearDown() {
            driver.quit();
        }
    }

