import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ChartPage {

        private WebDriver driver;

        public ChartPage(WebDriver driver) {
            this.driver = driver;
        }

        public void goToCart() {
            WebElement goToCartButton = driver.findElement(By.xpath("//*[@id=\"responsiveFlyoutBasket_openBasketButtonMobile\"]"));
            goToCartButton.click();
        }

        public void showCart() {
            WebElement showCartButton = driver.findElement(By.xpath("//*[@id=\"nav\"]/div[2]/div[2]/div[4]/div/div[1]/div/div/div[1]/div[3]/a"));
            showCartButton.click();
        }

        public boolean isProductInCart(String productName) {
            WebElement description = driver.findElement(By.xpath("//*[@id=\"10529806\"]/div[2]/a/div[2]/p"));
            return description.getText().contains(productName);
        }
    }


