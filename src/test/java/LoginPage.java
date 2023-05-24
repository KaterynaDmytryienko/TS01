import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
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

    public void goToPersonalAccount(){
        WebElement personalAccount = driver.findElement(By.xpath("//*[@id=\"responsiveAccountHeader_openAccountButtonMobile_rightSection\"]"));
        personalAccount.click();
    }

    public void clickLoginButton(){
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"nav\"]/div[2]/div[2]/div[3]/div/div[1]/div/nav/ul/li[1]/a"));
        loginButton.click();
    }

    public void enterEmail(String email){

        WebElement emailInput = driver.findElement(By.xpath("//*[contains(@id, 'e-mailová-adresa-input-element-id')]"));
        emailInput.sendKeys(email);
    }

    public void enterPassword(String password){
        WebElement passwordInput = driver.findElement(By.xpath("//*[contains(@id, 'heslo-input-element-id')]"));
        passwordInput.sendKeys(password);
    }

    public void clickSubmitButton(){

        WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div[1]/section/div/div[1]/div/form/div[5]/div/button"));
        submitButton.click();
    }
}
