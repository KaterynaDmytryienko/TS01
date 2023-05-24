import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PaginationPage {
        private WebDriver driver;


        public PaginationPage(WebDriver driver) {
            this.driver = driver;
        }

    public void acceptCookies() {
        WebElement acceptCookies = driver.findElement(By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]"));
        acceptCookies.click();
    }

    public void closeAd() {
        WebElement closeAdd = driver.findElement(By.xpath("//*[@id=\"home\"]/div[4]/div/div[2]/button"));
        closeAdd.click();
    }
        public void performSearch(String searchTerm) {
            WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"nav\"]/div[2]/div[2]/div[2]/div/button"));
            searchButton.click();

            WebElement searchBox = driver.findElement(By.xpath("//*[@id=\"header-search-input\"]"));
            searchBox.sendKeys(searchTerm);
            searchBox.submit();
        }

        public void goToPage(int pageNumber) {
            WebElement page = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[2]/div[2]/nav/ul/li[" + pageNumber + "]/a"));
            page.click();
        }

        public boolean isPageDisplayed(int pageNumber) {
            WebElement page = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[2]/div[2]/nav/ul/li[" + pageNumber + "]/a"));
            return page.isDisplayed();
        }
    }


