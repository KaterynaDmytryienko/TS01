import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class DataProviderTestLogin {
    @Test
    public void MyProteinLoginTest () {
        WebDriver driver;
        driver = new ChromeDriver();

        // Go to the MyProtein website
        driver.get("https://www.myprotein.cz/");

        WebElement acceptCookies = driver.findElement(By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]"));
        acceptCookies.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement closeAdd = driver.findElement(By.xpath("//*[@id=\"home\"]/div[4]/div/div[2]/button"));
        closeAdd.click();


        // Read the login credentials from a CSV file
        String csvFile = "resources/data2.csv";
        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                // Split the line by comma
                String[] credentials = line.split(cvsSplitBy);

                // Get the username and password from the CSV
                String username = credentials[0];
                String password = credentials[1];

                WebElement userButton = driver.findElement(By.xpath("//*[@id=\"responsiveAccountHeader_openAccountButtonMobile_rightSection\"]"));
                userButton.click();
                // Click on the login button
                WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"nav\"]/div[2]/div[2]/div[3]/div/div[1]/div/nav/ul/li[1]/a"));
                loginButton.click();

                // Enter the username and password
                WebElement usernameField = driver.findElement(By.xpath("//*[@id=\"e-mailová-adresa-input-element-id-2cff7387-3446-4bd4-963e-370fdc713847\"]"));
                WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"heslo-input-element-id-2ee43d74-da50-4d60-980e-6e1239991fe5\"]"));

                usernameField.sendKeys(username);
                passwordField.sendKeys(password);

                // Submit the login form
                WebElement loginForm = driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div[1]/section/div/div[1]/div/form/div[5]/div/button"));
                loginForm.submit();

                // Wait for the page to load or perform any necessary assertions

                // Clear the username and password fields for the next iteration
                usernameField.clear();
                passwordField.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
