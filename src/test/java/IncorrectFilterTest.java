import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertTrue;

public class IncorrectFilterTest {
    @Test
    public void incorrectfilterTest() throws InterruptedException {
        WebDriver driver;
        driver = new ChromeDriver();

        // Go to the MyProtein website
        driver.get("https://www.myprotein.cz/");

        WebElement acceptCookies = driver.findElement(By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]"));
        acceptCookies.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement closeAdd = driver.findElement(By.xpath("//*[@id=\"home\"]/div[5]/div/div[2]/button"));
        closeAdd.click();

        // Search for a product
        WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"nav\"]/div[2]/div[2]/div[2]/div/button"));
        searchButton.click();

        WebElement searchBox = driver.findElement(By.xpath("//*[@id=\"header-search-input\"]"));
        searchBox.sendKeys("Whey Protein");
        searchBox.submit();

        //Click on the filter option = "Ananas"
        WebElement proteinsCategory = driver.findElement(By.xpath("/html/body/div[4]/div[1]/aside/div/div/div[2]/div/div[9]/div[2]/fieldset/label[1]/input"));
        proteinsCategory.click();

        Thread.sleep(1000);

        // Verify that the filtered results contain the selected

        List<WebElement> products = driver.findElements(By.xpath("//ul[@class='productListProducts_products']/li"));

        for (int i = 0; i < products.size(); i++) {
            WebElement product = products.get(i);
            // Click on the link to the product page
            product.findElement(By.cssSelector("a")).click();
            Thread.sleep(1000);

            // Check if the product has the selected option value
            WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"athena-product-variation-dropdown-5\"]"));
            List<WebElement> options = dropdown.findElements(By.tagName("option"));
            boolean hasOption = false;
            for (WebElement option : options) {
                if (option.getAttribute("value").equals("10428")) {
                    hasOption = true;
                    break;
                }
            }
            assertTrue(hasOption);

            // Go back to the previous page and refresh it
            driver.navigate().back();
            driver.navigate().refresh();

            // Get the updated list of products
            products = driver.findElements(By.xpath("//ul[@class='productListProducts_products']/li"));
        }
    }
}
