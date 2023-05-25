import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertTrue;

public class SaleChecker {
    @Test
    public void SaleChecker () {
        WebDriver driver;
        driver = new ChromeDriver();

        // Go to the MyProtein website
        driver.get("https://www.myprotein.cz/");

        WebElement acceptCookies = driver.findElement(By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]"));
        acceptCookies.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement closeAdd = driver.findElement(By.xpath("//*[@id=\"home\"]/div[5]/div/div[2]/button"));
        closeAdd.click();

        WebElement menuButton = driver.findElement(By.xpath("//*[@id=\"nav\"]/div[2]/div[2]/button"));
        menuButton.click();

        WebElement selectSale = driver.findElement(By.xpath("//*[@id=\"nav\"]/div[2]/div[2]/div[5]/nav/div[1]/div[2]/ul/li[9]/a"));
        selectSale.click();

        List<WebElement> products = driver.findElements(By.xpath("//ul[@class='productListProducts_products']/li"));

        // Loop through each product in the list

        for (int i = 0; i < products.size(); i++) {
            WebElement product = products.get(i);

            // Get the text of the specified span element within the product
            String sale = product.findElement(By.xpath("//*[@id=\"mainContent\"]/div[3]/ul/li[4]/div/div[3]/div[2]/span[1]")).getText();

            boolean hasOption = false;

            // Check if the text equals "Ušetříte"
            if (sale.equals("Ušetříte")) {
                hasOption = true;
            }
            // Assert that the span element has the expected text
            assertTrue(hasOption);
        }
    }
}
