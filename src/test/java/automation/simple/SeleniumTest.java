package automation.simple;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SeleniumTest {

    WebDriver driver;

    @Test
    public void openweb() {
        //open browser
        WebDriverManager.chromedriver();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/login");

        driver.quit();
    }
    @Test
    public void logintest(){
        //open browser
        WebDriverManager.chromedriver();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/login");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //login
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("username")));
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.xpath("//*[@id=\"login\"]/button/i")).click();

        String txtActualBerhasillogin = driver.findElement(By.xpath("//*[@id=\"content\"]/div/h2")).getText();
        String txtExpectedBerhasillogin = "Secure Area";

        Assert.assertEquals(txtActualBerhasillogin, txtExpectedBerhasillogin);

        //close browser
        driver.quit();
    }

    @Test
    public void logintestFailedPass(){
        //open browser
        WebDriverManager.chromedriver();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/login");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //login
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("username")));
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("123");
        driver.findElement(By.xpath("//*[@id=\"login\"]/button/i")).click();

        String txtExpectedLoginTestFailedPass = driver.findElement(By.xpath("//*[@id='flash']")).getText();
        System.out.println(txtExpectedLoginTestFailedPass);
        String txtActualLoginTestFailedPass = "Your password is invalid!\n" +
                "×";

        Assert.assertEquals(txtActualLoginTestFailedPass, txtExpectedLoginTestFailedPass);

        //close browser
        driver.quit();
    }

}
