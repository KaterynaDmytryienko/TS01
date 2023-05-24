import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

    public class AddToChartTest {
        private WebDriver driver;
        private SearchPage searchPage;
        private ProductPage productPage;
        private ChartPage chartPage;

        @Before
        public void setUp() {
            driver = new ChromeDriver();
            driver.get("https://www.myprotein.cz/");
            searchPage = new SearchPage(driver);
            productPage = new ProductPage(driver);
            chartPage = new ChartPage(driver);
        }

        @Test
        public void addToCartTest() {
            searchPage.acceptCookies();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            searchPage.closeAd();
            searchPage.clickSearchButton();
            searchPage.enterSearchKeyword("Whey Protein");

            // Click on a product
            productPage.clickOnProduct();

            // Add the product to the cart
            productPage.addToCart();

            // Continue
            searchPage.continueBuying();

            // Verify the cart contents
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            chartPage.goToCart();
            chartPage.showCart();

            assertTrue("Product is found in cart.", chartPage.isProductInCart("Whey Protein"));
        }

        @After
        public void tearDown() {
            driver.quit();
        }
    }

