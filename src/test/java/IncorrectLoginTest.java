import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class IncorrectLoginTest {
    private WebDriver driver;
    private LoginPage loginPage;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.myprotein.cz/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        loginPage = new LoginPage(driver);
    }

    @Test
    public void incorrectLoginTest() {
        loginPage.acceptCookies();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        loginPage.closeAd();
        loginPage.goToPersonalAccount();
        loginPage.clickLoginButton();
        loginPage.enterEmail("kat.dmitryenko@gmail.com");
        loginPage.enterPassword("Abbra");
        loginPage.clickSubmitButton();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        WebElement textContainer = driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div[1]/section/div/div[1]/div/div[1]/div/div[1]/div[2]/div"));
        String text = textContainer.getText();

        String desiredText = "Zadaná e-mailová adresa nebo heslo je neplatné.";
        if (text.equals(desiredText)) {
            System.out.println("TEST PASSED!");
        }
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
