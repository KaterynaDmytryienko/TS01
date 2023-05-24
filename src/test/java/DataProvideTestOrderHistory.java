import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;

public class DataProvideTestOrderHistory {
    @Test(dataProvider = "data")
    public void orderHistoryTest(String orderNumber, String date, String price) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.myprotein.cz/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement acceptCookies = driver.findElement(By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]"));
        acceptCookies.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement closeAdd = driver.findElement(By.xpath("//*[@id=\"home\"]/div[4]/div/div[2]/button"));
        closeAdd.click();

        WebElement personalAccount = driver.findElement(By.xpath("//*[@id=\"responsiveAccountHeader_openAccountButtonMobile_rightSection\"]"));
        personalAccount.click();

        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"nav\"]/div[2]/div[2]/div[3]/div/div[1]/div/nav/ul/li[1]/a"));
        loginButton.click();

        WebElement emailInput = driver.findElement(By.xpath("//*[contains(@id, 'e-mailová-adresa-input-element-id')]"));
        emailInput.sendKeys("kat.dmitryenko@gmail.com");

        WebElement passwordInput = driver.findElement(By.xpath("//*[contains(@id, 'heslo-input-element-id')]"));
        passwordInput.sendKeys("Abbra0753");

        WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div[1]/section/div/div[1]/div/form/div[5]/div/button"));
        submitButton.click();

        WebElement myOrders = driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div[1]/nav/ul[1]/li[2]/a"));
        myOrders.click();

        WebElement cookie = driver.findElement(By.xpath("//*[@id=\"cookie-modal-container\"]/section/div/div/div[2]/div/button"));
        cookie.click();

        WebElement detailsButton = driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div[2]/div[3]/div/ul/li/div/div[2]/div[2]/div"));
        detailsButton.click();

        //CHECKS ORDER NUMBER
        WebElement number = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[5]/div[1]/div/div[1]/p"));
        String text = number.getText();
        String extractedString = text.substring(18);
        assertEquals(orderNumber, extractedString);

        //CHECKS ORDER DATE
        WebElement orderDate = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[5]/div[1]/div/div[2]/p[1]/span[2]"));
        String dateText= orderDate.getText();
        String extractedDate = dateText.substring(0, 8);
        assertEquals(date, extractedDate);

        //CHECKS ORDER PRICE

        WebElement orderPrice = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[5]/div[1]/div/div[2]/p[4]/span[2]"));
        String priceText= orderPrice.getText();
        String extractedPrice = priceText.substring(0, 7);
        assertEquals(price, extractedPrice);


    }
}
