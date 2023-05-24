import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage {
    private WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnProduct() {
        WebElement productImage = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[3]/ul/li[1]/div/div[1]/a/img"));
        productImage.click();
    }

    public void addToCart() {
        WebElement addToCartButton = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[4]/div[2]/div/div[4]/div[2]/div[2]/span/span/button"));
        addToCartButton.click();
    }
}
