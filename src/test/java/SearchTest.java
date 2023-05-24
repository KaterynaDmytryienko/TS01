import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class SearchTest {
    private WebDriver driver;
    private SearchPage searchPage;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.myprotein.cz/");
        searchPage = new SearchPage(driver);
    }

    @Test
    public void searchBarTest() {
        searchPage.acceptCookies();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        searchPage.closeAd();
        searchPage.clickSearchButton();
        searchPage.enterSearchKeyword("Whey Protein");

        // Wait for the search results page to load
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains("Whey Protein"));

        // Validate that the search results page displays with the appropriate search results
        String searchResultsText = searchPage.getSearchResultsText();
        int resultCount = Integer.parseInt(searchResultsText.split("\\s")[0]);
        assertTrue("Search functionality test passed.", resultCount > 0);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
