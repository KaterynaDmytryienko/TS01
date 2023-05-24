import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class CorrectLoginTest {
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
    public void correctLoginTest() {
        loginPage.acceptCookies();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        loginPage.closeAd();
        loginPage.goToPersonalAccount();
        loginPage.clickLoginButton();
        loginPage.enterEmail("kat.dmitryenko@gmail.com");
        loginPage.enterPassword("Abbra0753");
        loginPage.clickSubmitButton();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement p_element = driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div[2]/div[1]/p"));
        String actualText = p_element.getText();

        String desiredText = "Vítejte Kateryna";
        if (actualText.equals(desiredText)) {
            System.out.println("TEST PASSED!");
        } else {
            System.out.println("test didnt pass!");
        }
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
