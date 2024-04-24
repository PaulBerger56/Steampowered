package org.example.steampowered;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class AutomatedTest {

    private static WebDriver driver;
    private static final String username = "BasedTester";
    private static final String password = "Ty?PX?:78*=vMN2";

    @BeforeAll
    public static void setUp(){
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void testWheel() {
//        driver.get("http://127.0.0.1:8080/");
//        WebElement login = driver.findElement(By.xpath("/html/body/div/div/a"));
//        login.click();
//
//        WebElement userNameField = driver.findElement(By.className("_2eKVn6g5Yysx9JmutQe7WV"));
//        WebElement passwordField = driver.findElement(By.xpath("/html/body/div[1]/div[7]/div[4]/div[1]/div[1]/div/div/div/div[2]/div/form/div[2]/input"));
//
//        userNameField.sendKeys(username);
//        passwordField.sendKeys(password);
//
//        WebElement submit = driver.findElement(By.xpath("/html/body/div[1]/div[7]/div[4]/div[1]/div[1]/div/div/div/div[2]/div/form/div[4]/button"));
    }
}
