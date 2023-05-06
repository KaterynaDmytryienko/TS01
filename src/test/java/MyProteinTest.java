import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertTrue;


public class MyProteinTest {  private static final String[] DOMAINS = {"gmail.com", "yahoo.com", "hotmail.com", "outlook.com"};
    private static final String[] NAMES = {"john", "jane", "bob", "alice", "dave", "susan"};
    private static final String[] SUFFIXES = {"007", "123", "999", "2022", "2023", "test"};
    public static String generate() {
        Random rand = new Random();
        String name = NAMES[rand.nextInt(NAMES.length)];
        String suffix = SUFFIXES[rand.nextInt(SUFFIXES.length)];
        String domain = DOMAINS[rand.nextInt(DOMAINS.length)];
        int num = rand.nextInt(9999) + 1;
        return name + suffix + num + "@" + domain;
    }

     public String email = MyProteinTest.generate();


    private WebDriver driver;

    @Test
    public void searchBarTest(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.myprotein.cz/");

        WebElement acceptCookies = driver.findElement(By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]"));
        acceptCookies.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement closeAdd = driver.findElement(By.xpath("//*[@id=\"home\"]/div[5]/div/div[2]/button"));
        closeAdd.click();

        WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"nav\"]/div[2]/div[2]/div[2]/div/button"));
        searchButton.click();


        WebElement searchBox = driver.findElement(By.xpath("//*[@id=\"header-search-input\"]"));
        searchBox.sendKeys("Whey Protein");
        searchBox.submit();

        // Wait for the search results page to load
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains("Whey Protein"));

        // Validate that the search results page displays with the appropriate search results
        WebElement searchResults = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/div/p"));
        int resultCount = Integer.parseInt(searchResults.getText().split("\\s")[0]);
        if (resultCount > 0) {
            System.out.println("Search functionality test passed.");
        } else {
            System.out.println("Search functionality test failed.");
        }

        // Close the browser
        driver.quit();
    }

    @Test
    public void addToChartTest() throws InterruptedException {
        // Create an instance of Chrome WebDriver
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.myprotein.cz/");

        // Search for a product

        WebElement acceptCookies = driver.findElement(By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]"));
        acceptCookies.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement closeAdd = driver.findElement(By.xpath("//*[@id=\"home\"]/div[5]/div/div[2]/button"));
        closeAdd.click();

        WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"nav\"]/div[2]/div[2]/div[2]/div/button"));
        searchButton.click();


        WebElement searchBox = driver.findElement(By.xpath("//*[@id=\"header-search-input\"]"));
        searchBox.sendKeys("Whey Protein");
        searchBox.submit();

        // Click on a product
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[3]/ul/li[1]/div/div[1]/a/img")).click();


        //         Add the product to the cart
        WebElement addtoChart = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[4]/div[2]/div/div[4]/div[2]/div[2]/span/span/button"));
        addtoChart.click();

        //Continue
        WebElement continueBuying = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/div/div[5]/div[2]/div[3]/div[2]/button"));
        continueBuying.click();


        // Verify the cart contents
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement goToChartButton = driver.findElement(By.xpath("//*[@id=\"responsiveFlyoutBasket_openBasketButtonMobile\"]"));
        goToChartButton.click();

        WebElement showChart = driver.findElement(By.xpath("//*[@id=\"nav\"]/div[2]/div[2]/div[4]/div/div[1]/div/div/div[1]/div[3]/a"));
        showChart.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"10529807\"]/div[2]/a/div[2]/p")));
        assert driver.findElement(By.xpath("//*[@id=\"10529807\"]/div[2]/a/div[2]/p"))
                .getText()
                .contains("Whey Protein");

        // Close the browser
        driver.quit();

    }

    @Test
    public void correctLoginTest(){

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.myprotein.cz/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement acceptCookies = driver.findElement(By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]"));
        acceptCookies.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement closeAdd = driver.findElement(By.xpath("//*[@id=\"home\"]/div[5]/div/div[2]/button"));
        closeAdd.click();

        //Click to a personal account icon
        WebElement personalAccount = driver.findElement(By.xpath("//*[@id=\"responsiveAccountHeader_openAccountButtonMobile_rightSection\"]"));
        personalAccount.click();

        //Click Sign Up
        WebElement signup = driver.findElement(By.xpath("//*[@id=\"nav\"]/div[2]/div[2]/div[3]/div/div[1]/div/nav/ul/li[2]/a"));
        signup.click();



        //Enter name
        WebElement enterNameSurname = driver.findElement(By.xpath("//*[contains(@id, 'jméno-a-příjmení-input-element-id')]"));
        enterNameSurname.sendKeys("Kate Lale");

        //Enter email
        WebElement enterEmail = driver.findElement(By.xpath("//*[contains(@id, 'e-mailová-adresa-input-element-id')]"));
        enterEmail.sendKeys(email);

        //Repeat email
        WebElement repeatEmail = driver.findElement(By.xpath("//*[contains(@id, 'potvrdit-e-mailová-adresa-input-element-id')]"));
        repeatEmail.sendKeys(email);

        //Enter password
        WebElement password = driver.findElement(By.xpath("//*[contains(@id, 'heslo-input-element-id')]"));
        password.sendKeys("Qwerty1234");

        //Repeat password
        WebElement repeatPassword = driver.findElement(By.xpath("//*[contains(@id, 'potvrdit-heslo-input-element-id')]"));
        repeatPassword.sendKeys("Qwerty1234");

        //Enter mobile number
        WebElement enterPhone = driver.findElement(By.xpath("//*[contains(@id, 'číslo-mobilního-telefonu-input-element-id')]"));
        enterPhone.sendKeys("+420567839409");

        WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"cookie-modal-container\"]/section/div/div/div[2]/div/button"));
        submitButton.click();

        WebElement notAgree = driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div/section/div[2]/form/div[7]/div/div[3]/div/div/div/div/div[2]"));
        notAgree.click();

        WebElement continueButton = driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div/section/div[2]/form/div[8]/div[1]/div/button"));
        continueButton.click();

    }


    @Test
    public void incorrectLoginTest(){

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.myprotein.cz/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement acceptCookies = driver.findElement(By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]"));
        acceptCookies.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement closeAdd = driver.findElement(By.xpath("//*[@id=\"home\"]/div[5]/div/div[2]/button"));
        closeAdd.click();

        //Click to a personal account icon
        WebElement personalAccount = driver.findElement(By.xpath("//*[@id=\"responsiveAccountHeader_openAccountButtonMobile_rightSection\"]"));
        personalAccount.click();

        //Click Sign Up
        WebElement signup = driver.findElement(By.xpath("//*[@id=\"nav\"]/div[2]/div[2]/div[3]/div/div[1]/div/nav/ul/li[2]/a"));
        signup.click();



        //Enter name
        WebElement enterNameSurname = driver.findElement(By.xpath("//*[contains(@id, 'jméno-a-příjmení-input-element-id')]"));
        enterNameSurname.sendKeys("Kate Lale7868");

        //Enter email
        WebElement enterEmail = driver.findElement(By.xpath("//*[contains(@id, 'e-mailová-adresa-input-element-id')]"));
        enterEmail.sendKeys(email);

        //Repeat email
        WebElement repeatEmail = driver.findElement(By.xpath("//*[contains(@id, 'potvrdit-e-mailová-adresa-input-element-id')]"));
        repeatEmail.sendKeys(email);

        //Enter password
        WebElement password = driver.findElement(By.xpath("//*[contains(@id, 'heslo-input-element-id')]"));
        password.sendKeys("12");

        //Repeat password
        WebElement repeatPassword = driver.findElement(By.xpath("//*[contains(@id, 'potvrdit-heslo-input-element-id')]"));
        repeatPassword.sendKeys("23");

        //Enter mobile number
        WebElement enterPhone = driver.findElement(By.xpath("//*[contains(@id, 'číslo-mobilního-telefonu-input-element-id')]"));
        enterPhone.sendKeys("+4205678");

        WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"cookie-modal-container\"]/section/div/div/div[2]/div/button"));
        submitButton.click();

    }

    @Test
    public void changeLanguageAndCountry(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.myprotein.cz/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement acceptCookies = driver.findElement(By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]"));
        acceptCookies.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement closeAdd = driver.findElement(By.xpath("//*[@id=\"home\"]/div[5]/div/div[2]/button"));
        closeAdd.click();

        WebElement languageForm = driver.findElement(By.xpath("//*[@id=\"nav\"]/div[2]/div[1]/div/div/div/button/span[1]/span"));
        languageForm.click();

        WebElement selectCountry = driver.findElement(By.xpath("//*[@id=\"popup\"]/div/div/div[1]/div[1]/select"));
        selectCountry.click();

        WebElement austria = driver.findElement(By.xpath("//*[@id=\"popup\"]/div/div/div[1]/div[1]/select/option[8]"));
        austria.click();

        WebElement selectLanguage = driver.findElement(By.xpath("//*[@id=\"popup\"]/div/div/div[1]/div[2]/select"));
        selectLanguage.click();

        WebElement slovenija = driver.findElement(By.xpath("//*[@id=\"popup\"]/div/div/div[1]/div[2]/select/option[3]"));
        slovenija.click();

        WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"popup\"]/div/div/div[1]/button"));
        submitButton.click();

    }

    @Test
   public void productSearch() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.myprotein.cz/");
       // Search for a product
       WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"nav\"]/div[2]/div[2]/div[2]/div/button"));
       searchButton.click();

       WebElement searchBox = driver.findElement(By.xpath("//*[@id=\"header-search-input\"]"));
       searchBox.sendKeys("Whey Protein");
       searchBox.submit();

       //Click on the filter option = "Ananas"
       WebElement proteinsCategory = driver.findElement(By.xpath("/html/body/div[4]/div[1]/aside/div/div/div[2]/div/div[9]/div[2]/fieldset/label[1]/input"));
       proteinsCategory.click();

       Thread.sleep(1000);

       // Verify that the filtered results contain the selected

       List<WebElement> products = driver.findElements(By.xpath("//ul[@class='productListProducts_products']/li"));

       for (int i = 0; i < products.size(); i++) {
           WebElement product = products.get(i);
           // Click on the link to the product page
           product.findElement(By.cssSelector("a")).click();
           Thread.sleep(1000);

           // Check if the product has the selected option value
           WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"athena-product-variation-dropdown-5\"]"));
           List<WebElement> options = dropdown.findElements(By.tagName("option"));
           boolean hasOption = false;
           for (WebElement option : options) {
               if (option.getAttribute("value").equals("10428")) {
                   hasOption = true;
                   break;
               }
           }
           assertTrue(hasOption);

           // Go back to the previous page and refresh it
           driver.navigate().back();
           driver.navigate().refresh();

           // Get the updated list of products
           products = driver.findElements(By.xpath("//ul[@class='productListProducts_products']/li"));
       }
   }

    @Test
    public void filterTest() throws InterruptedException {
        driver = new ChromeDriver();

        // Go to the MyProtein website
        driver.get("https://www.myprotein.cz/");

        WebElement acceptCookies = driver.findElement(By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]"));
        acceptCookies.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement closeAdd = driver.findElement(By.xpath("//*[@id=\"home\"]/div[5]/div/div[2]/button"));
        closeAdd.click();

        // Search for a product
        WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"nav\"]/div[2]/div[2]/div[2]/div/button"));
        searchButton.click();

        WebElement searchBox = driver.findElement(By.xpath("//*[@id=\"header-search-input\"]"));
        searchBox.sendKeys("Whey Protein");
        searchBox.submit();

        //Click on the filter option = "Ananas"
        WebElement proteinsCategory = driver.findElement(By.xpath("/html/body/div[4]/div[1]/aside/div/div/div[2]/div/div[9]/div[2]/fieldset/label[1]/input"));
        proteinsCategory.click();

        Thread.sleep(1000);

        // Verify that the filtered results contain the selected

        List<WebElement> products = driver.findElements(By.xpath("//ul[@class='productListProducts_products']/li"));

        for (int i = 0; i < products.size(); i++) {
            WebElement product = products.get(i);
            // Click on the link to the product page
            product.findElement(By.cssSelector("a")).click();
            Thread.sleep(1000);

            // Check if the product has the selected option value
            WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"athena-product-variation-dropdown-5\"]"));
            List<WebElement> options = dropdown.findElements(By.tagName("option"));
            boolean hasOption = false;
            for (WebElement option : options) {
                if (option.getAttribute("value").equals("10428")) {
                    hasOption = true;
                    break;
                }
            }
            assertTrue(hasOption);

            // Go back to the previous page and refresh it
            driver.navigate().back();
            driver.navigate().refresh();

            // Get the updated list of products
            products = driver.findElements(By.xpath("//ul[@class='productListProducts_products']/li"));
        }
    }

}
