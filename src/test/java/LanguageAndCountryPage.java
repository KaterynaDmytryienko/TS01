import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

    public class LanguageAndCountryPage {
        private WebDriver driver;

        public LanguageAndCountryPage(WebDriver driver) {
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
        public void openLanguageAndCountryForm() {
            WebElement languageForm = driver.findElement(By.xpath("//*[@id=\"nav\"]/div[2]/div[1]/div/div/div/button"));
            languageForm.click();
        }

        public void selectCountry(String country) {
            WebElement selectCountry = driver.findElement(By.xpath("//*[@id=\"popup\"]/div/div/div[1]/div[1]/select"));
            selectCountry.click();

            WebElement countryOption = driver.findElement(By.xpath("//*[@id=\"popup\"]/div/div/div[1]/div[1]/select/option[contains(text(),'" + country + "')]"));
            countryOption.click();
        }

        public void selectLanguage(String language) {
            WebElement selectLanguage = driver.findElement(By.xpath("//*[@id=\"popup\"]/div/div/div[1]/div[2]/select"));
            selectLanguage.click();

            WebElement languageOption = driver.findElement(By.xpath("//*[@id=\"popup\"]/div/div/div[1]/div[2]/select/option[contains(text(),'" + language + "')]"));
            languageOption.click();
        }

        public void submitLanguageAndCountry() {
            WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"popup\"]/div/div/div[1]/button"));
            submitButton.click();
        }
    }

