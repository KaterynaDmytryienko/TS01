import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertTrue;

public class FilterPriceTest {
    @Test
    public void filterPrice() throws InterruptedException {
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

        //Click on the filter option = "Tyčinky a snacky"

        WebElement snacksCategory = driver.findElement(By.xpath("//*[@id=\"nav\"]/div[2]/div[2]/div[5]/nav/div[1]/div[2]/ul/li[3]/a"));
        snacksCategory.click();

        Thread.sleep(100);

        //Click on the filter option = "Tyčinky"
        WebElement proteinsCategory = driver.findElement(By.xpath("//*[@id=\"home\"]/div[5]/div[1]/aside/div/div/div[2]/div/div[1]/div[2]/fieldset/label[16]"));
        proteinsCategory.click();

        Thread.sleep(1000);

        //Click on the filter relevance "Cena: Od nejnižšího k nejvyššímu"
        WebElement filterElement = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[2]/div[1]/div/select/option[3]"));
        filterElement.click();

        Thread.sleep(1000);

        List<WebElement> productPrices = driver.findElements(By.xpath("//ul[@class='productListProducts_products']/li"));
        double previousPrice = Double.MAX_VALUE;

        for (WebElement productPrice : productPrices) {
            System.out.println("yes");
            // Get the price element of the product
            productPrice = driver.findElement(By.xpath(".//span[@class='athenaProductBlock_priceValue']"));

            // Check if the price element has the class "athenaProductBlock_priceValue"
            if (productPrice.getAttribute("class").contains("athenaProductBlock_priceValue")) {
                // Extract the price value from the text of the price element
                double currentPrice = Double.parseDouble(productPrice.getText().replaceAll("\\D+", ""));
                assertTrue(currentPrice <= previousPrice);
                previousPrice = currentPrice;
            }
        }
    }
}