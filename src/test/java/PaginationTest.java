import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class PaginationTest {

        private WebDriver driver;
        private PaginationPage paginationPage;

        @Before
        public void setUp() {
            driver = new ChromeDriver();
            driver.get("https://www.myprotein.cz/");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            paginationPage = new PaginationPage(driver);
        }

        @Test
        public void paginationTest() {
            paginationPage.performSearch("Whey Protein");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.titleContains("Whey Protein"));

            paginationPage.goToPage(2);

            if (paginationPage.isPageDisplayed(2)) {
                System.out.println("TEST PASSED!");
            }
        }

        @After
        public void tearDown() {
            driver.quit();
        }
    }

