import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class LanguageAndCountryTest {
    private WebDriver driver;
    private LanguageAndCountryPage languageAndCountryPage;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.myprotein.cz/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        languageAndCountryPage = new LanguageAndCountryPage(driver);
    }

    @Test
    public void changeLanguageAndCountry() {
        languageAndCountryPage.acceptCookies();
        languageAndCountryPage.closeAd();
        languageAndCountryPage.openLanguageAndCountryForm();
        languageAndCountryPage.selectCountry("Austria");
        languageAndCountryPage.selectLanguage("Slovenija");
        languageAndCountryPage.submitLanguageAndCountry();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}

