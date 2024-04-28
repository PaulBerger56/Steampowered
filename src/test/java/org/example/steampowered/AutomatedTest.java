package org.example.steampowered;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class AutomatedTest {

    private static WebDriver driver;
    private static final String username = "BasedTester";
    private static final String password = "Ty?PX?:78*=vMN2";

    private static final String steamLoginUrl = "https://steamcommunity.com/openid/loginform/?goto=%2Fopenid%2Flogin%3Fopenid.ns%3Dhttp%253A%252F%252Fspecs.openid.net%252Fauth%252F2.0%26openid.claimed_id%3Dhttp%253A%252F%252Fspecs.openid.net%252Fauth%252F2.0%252Fidentifier_select%26openid.identity%3Dhttp%253A%252F%252Fspecs.openid.net%252Fauth%252F2.0%252Fidentifier_select%26openid.mode%3Dcheckid_setup%26openid.ns.ext1%3Dhttp%253A%252F%252Fopenid.net%252Fsrv%252Fax%252F1.0%26openid.ext1.mode%3Dfetch_request%26openid.ext1.type.email%3Dhttp%253A%252F%252Faxschema.org%252Fcontact%252Femail%26openid.ext1.type.fullname%3Dhttp%253A%252F%252Faxschema.org%252FnamePerson%26openid.ext1.type.language%3Dhttp%253A%252F%252Faxschema.org%252Fpref%252Flanguage%26openid.ext1.type.firstname%3Dhttp%253A%252F%252Faxschema.org%252FnamePerson%252Ffirst%26openid.ext1.type.lastname%3Dhttp%253A%252F%252Faxschema.org%252FnamePerson%252Flast%26openid.ext1.type.gender%3Dhttp%253A%252F%252Faxschema.org%252Fperson%252Fgender%26openid.ext1.required%3Demail%252Cfullname%252Clanguage%252Cfirstname%252Clastname%252Cgender%26openid.return_to%3Dhttp%253A%252F%252Flocalhost%253A8080%252Findex%26openid.assoc_handle%3Dnull%26openid.realm%3Dhttp%253A%252F%252Flocalhost%253A8080%3Fopenid.ns%3Dhttp%253A%252F%252Fspecs.openid.net%252Fauth%252F2.0%26openid.claimed_id%3Dhttp%253A%252F%252Fspecs.openid.net%252Fauth%252F2.0%252Fidentifier_select%26openid.identity%3Dhttp%253A%252F%252Fspecs.openid.net%252Fauth%252F2.0%252Fidentifier_select%26openid.mode%3Dcheckid_setup%26openid.ns_ext1%3Dhttp%253A%252F%252Fopenid.net%252Fsrv%252Fax%252F1.0%26openid.ext1_mode%3Dfetch_request%26openid.ext1_type_email%3Dhttp%253A%252F%252Faxschema.org%252Fcontact%252Femail%26openid.ext1_type_fullname%3Dhttp%253A%252F%252Faxschema.org%252FnamePerson%26openid.ext1_type_language%3Dhttp%253A%252F%252Faxschema.org%252Fpref%252Flanguage%26openid.ext1_type_firstname%3Dhttp%253A%252F%252Faxschema.org%252FnamePerson%252Ffirst%26openid.ext1_type_lastname%3Dhttp%253A%252F%252Faxschema.org%252FnamePerson%252Flast%26openid.ext1_type_gender%3Dhttp%253A%252F%252Faxschema.org%252Fperson%252Fgender%26openid.ext1_required%3Demail%252Cfullname%252Clanguage%252Cfirstname%252Clastname%252Cgender%26openid.return_to%3Dhttp%253A%252F%252Flocalhost%253A8080%252Findex%26openid.assoc_handle%3Dnull%26openid.realm%3Dhttp%253A%252F%252Flocalhost%253A8080";

    private static final String wheelPage = "http://localhost:8080/index?openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&openid.mode=id_res&openid.op_endpoint=https%3A%2F%2Fsteamcommunity.com%2Fopenid%2Flogin&openid.claimed_id=https%3A%2F%2Fsteamcommunity.com%2Fopenid%2Fid%2F76561199679158223&openid.identity=https%3A%2F%2Fsteamcommunity.com%2Fopenid%2Fid%2F76561199679158223&openid.return_to=http%3A%2F%2Flocalhost%3A8080%2Findex&openid.response_nonce=2024-04-28T11%3A56%3A15ZjbetB5sUC3W22JJPR5Kxw8iARgk%3D&openid.assoc_handle=1234567890&openid.invalidate_handle=null&openid.signed=signed%2Cop_endpoint%2Cclaimed_id%2Cidentity%2Creturn_to%2Cresponse_nonce%2Cassoc_handle%2Cinvalidate_handle&openid.sig=EJicm8po9GCKsJ5LJbpRvyEb%2FDs%3D";

    @BeforeAll
    public static void setUp(){
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void homePageTest() {
        driver.get("http://127.0.0.1:8080/");

        String URL = driver.getCurrentUrl();
        Assertions.assertTrue(URL.contains("8080"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @Test
    public void steamLoginPageTest() {
        driver.get("http://127.0.0.1:8080/");

        WebElement homeTitle = driver.findElement(By.xpath("/html/body/div/h1"));

        WebElement login = driver.findElement(By.xpath("/html/body/div/div/a"));
        login.click();

        String URL = driver.getCurrentUrl();
        Assertions.assertTrue(URL.contains("steam"));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @Test
    public void loginTest() {
        driver.get("http://127.0.0.1:8080/");

        WebElement homeTitle = driver.findElement(By.xpath("/html/body/div/h1"));

        WebElement login = driver.findElement(By.xpath("/html/body/div/div/a"));
        login.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        WebElement userNameField = driver.findElement(By.className("_2eKVn6g5Yysx9JmutQe7WV"));
        userNameField.sendKeys(username);

        WebElement passwordField = driver.findElement(By.xpath("/html/body/div[1]/div[7]/div[4]/div[1]/div[1]/div/div/div/div[2]/div/form/div[2]/input"));
        passwordField.sendKeys(password);

        WebElement signIn = driver.findElement(By.xpath("/html/body/div[1]/div[7]/div[4]/div[1]/div[1]/div/div/div/div[2]/div/form/div[4]/button"));
        signIn.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        WebElement greenSignIn = driver.findElement(By.id("imageLogin"));
        greenSignIn.click();

        String URL = driver.getCurrentUrl();
        Assertions.assertTrue(URL.contains("localhost:8080/index"));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    @Test
    public void wheelTest() {
        driver.get("http://127.0.0.1:8080/");

        WebElement homeTitle = driver.findElement(By.xpath("/html/body/div/h1"));

        WebElement login = driver.findElement(By.xpath("/html/body/div/div/a"));
        login.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        WebElement greenSignIn = driver.findElement(By.id("imageLogin"));
        greenSignIn.click();

        WebElement spinWheel = driver.findElement(By.xpath("/html/body/div[2]/button"));
        spinWheel.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

    }

    @Test
    public void profilePageTest() {
        driver.get("http://127.0.0.1:8080/");

        WebElement homeTitle = driver.findElement(By.xpath("/html/body/div/h1"));

        WebElement login = driver.findElement(By.xpath("/html/body/div/div/a"));
        login.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));


        WebElement greenSignIn = driver.findElement(By.id("imageLogin"));
        greenSignIn.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        WebElement profile = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/a"));
        profile.click();

        assertEquals("http://localhost:8080/profile", driver.getCurrentUrl());
    }

    @Test
    public void profileShowMoreTest() {
        driver.get("http://127.0.0.1:8080/");

        WebElement homeTitle = driver.findElement(By.xpath("/html/body/div/h1"));

        WebElement login = driver.findElement(By.xpath("/html/body/div/div/a"));
        login.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        WebElement greenSignIn = driver.findElement(By.id("imageLogin"));
        greenSignIn.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        WebElement profile = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/a"));
        profile.click();

        WebElement showMore = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/button"));
        showMore.click();
    }

    @Test
    public void logoutTest() {
        driver.get("http://127.0.0.1:8080/");

        WebElement homeTitle = driver.findElement(By.xpath("/html/body/div/h1"));

        WebElement login = driver.findElement(By.xpath("/html/body/div/div/a"));
        login.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));


        WebElement greenSignIn = driver.findElement(By.id("imageLogin"));
        greenSignIn.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        WebElement logout = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/span/a"));
        logout.click();

        String URL = driver.getCurrentUrl();
        Assertions.assertEquals("http://localhost:8080/", URL);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }
}
