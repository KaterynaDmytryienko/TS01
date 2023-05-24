import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Random;

public class SignUpPage {
    private static final String[] DOMAINS = {"gmail.com", "yahoo.com", "hotmail.com", "outlook.com"};
    private static final String[] NAMES = {"john", "jane", "bob", "alice", "dave", "susan"};
    private static final String[] SUFFIXES = {"007", "123", "999", "2022", "2023", "test"};
        private WebDriver driver;

        public SignUpPage(WebDriver driver) {
            this.driver = driver;
        }

    public static String generate() {
        Random rand = new Random();
        String name = NAMES[rand.nextInt(NAMES.length)];
        String suffix = SUFFIXES[rand.nextInt(SUFFIXES.length)];
        String domain = DOMAINS[rand.nextInt(DOMAINS.length)];
        int num = rand.nextInt(9999) + 1;
        return name + suffix + num + "@" + domain;
    }


    public void acceptCookies() {
        WebElement acceptCookies = driver.findElement(By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]"));
        acceptCookies.click();
    }

    public void closeAd() {
        WebElement closeAdd = driver.findElement(By.xpath("//*[@id=\"home\"]/div[4]/div/div[2]/button"));
        closeAdd.click();
    }

    public void goToPersonalAccount(){
        WebElement personalAccount = driver.findElement(By.xpath("//*[@id=\"responsiveAccountHeader_openAccountButtonMobile_rightSection\"]"));
        personalAccount.click();
    }

    public void clickOnSignUp(){
        WebElement signup = driver.findElement(By.xpath("//*[@id=\"nav\"]/div[2]/div[2]/div[3]/div/div[1]/div/nav/ul/li[2]/a"));
        signup.click();
    }

    public void enterNameSurname(String name) {
            WebElement enterNameSurname = driver.findElement(By.xpath("//*[contains(@id, 'jméno-a-příjmení-input-element-id')]"));
            enterNameSurname.sendKeys(name);
        }

        public void enterEmail(String email) {
            WebElement enterEmail = driver.findElement(By.xpath("//*[contains(@id, 'e-mailová-adresa-input-element-id')]"));
            enterEmail.sendKeys(email);
        }

        public void repeatEmail(String email) {
            WebElement repeatEmail = driver.findElement(By.xpath("//*[contains(@id, 'potvrdit-e-mailová-adresa-input-element-id')]"));
            repeatEmail.sendKeys(email);
        }

        public void enterPassword(String password) {
            WebElement enterPassword = driver.findElement(By.xpath("//*[contains(@id, 'heslo-input-element-id')]"));
            enterPassword.sendKeys(password);
        }

        public void repeatPassword(String password) {
            WebElement repeatPassword = driver.findElement(By.xpath("//*[contains(@id, 'potvrdit-heslo-input-element-id')]"));
            repeatPassword.sendKeys(password);
        }

        public void enterPhone(String phone) {
            WebElement enterPhone = driver.findElement(By.xpath("//*[contains(@id, 'číslo-mobilního-telefonu-input-element-id')]"));
            enterPhone.sendKeys(phone);
        }

        public void submitForm() {
            WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"cookie-modal-container\"]/section/div/div/div[2]/div/button"));
            submitButton.click();
        }

        public void notAgreeToTerms() {
            WebElement notAgree = driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div/section/div[2]/form/div[7]/div/div[3]/div/div/div/div/div[2]"));
            notAgree.click();
        }

        public void continueSignUp() {
            WebElement continueButton = driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div/section/div[2]/form/div[8]/div[1]/div/button"));
            continueButton.click();
        }
    }

