import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class MyProteinTest {
    private WebDriver driver;
    @Test
    public void addToChartTest() throws InterruptedException {
        // Create an instance of Firefox WebDriver
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.myprotein.cz/");

        // Search for a product

        WebElement acceptCookies = driver.findElement(By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]"));
        acceptCookies.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement closeAdd = driver.findElement(By.xpath("//*[@id=\"home\"]/div[5]/div/div[2]/button"));
        closeAdd.click();

        WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"nav\"]/div[2]/div[2]/div[2]/div/button"));
        searchButton.click();


        WebElement searchBox = driver.findElement(By.xpath("//*[@id=\"header-search-input\"]"));
        searchBox.sendKeys("Whey Protein");
        searchBox.submit();

        // Click on a product
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[3]/ul/li[1]/div/div[1]/a/img")).click();


        //         Add the product to the cart
        WebElement addtoChart = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[4]/div[2]/div/div[4]/div[2]/div[2]/span/span/button"));
        addtoChart.click();

        //Continue
        WebElement continueBuying = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/div/div[5]/div[2]/div[3]/div[2]/button"));
        continueBuying.click();


        // Verify the cart contents
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement goToChartButton = driver.findElement(By.xpath("//*[@id=\"responsiveFlyoutBasket_openBasketButtonMobile\"]"));
        goToChartButton.click();

        WebElement showChart = driver.findElement(By.xpath("//*[@id=\"nav\"]/div[2]/div[2]/div[4]/div/div[1]/div/div/div[1]/div[3]/a"));
        showChart.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"10529807\"]/div[2]/a/div[2]/p")));
        assert driver.findElement(By.xpath("//*[@id=\"10529807\"]/div[2]/a/div[2]/p"))
                .getText()
                .contains("Whey Protein");

        // Close the browser
        driver.quit();

    }
}
