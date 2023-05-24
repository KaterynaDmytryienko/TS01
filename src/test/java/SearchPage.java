import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

    public class SearchPage {
        private WebDriver driver;

        public SearchPage(WebDriver driver) {
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

        public void clickSearchButton() {
            WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"nav\"]/div[2]/div[2]/div[2]/div/button"));
            searchButton.click();
        }

        public void enterSearchKeyword(String keyword) {
            WebElement searchBox = driver.findElement(By.xpath("//*[@id=\"header-search-input\"]"));
            searchBox.sendKeys(keyword);
            searchBox.submit();
        }

        public String getSearchResultsText() {
            WebElement searchResults = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/div/p"));
            return searchResults.getText();
        }

        public void continueBuying(){
            WebElement continueBuying = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/div/div[5]/div[2]/div[3]/div[2]/button"));
            continueBuying.click();
        }
    }

