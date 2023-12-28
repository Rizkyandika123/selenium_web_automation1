package yopmail;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class yopmailtest {

    WebDriver driver;

    @Test
    public void openweb() {
        //open browser
        WebDriverManager.chromedriver();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://yopmail.com/");
        //<------------------------------------>

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //login
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("logoacc")));
        driver.findElement(By.id("login")).sendKeys("automation");
        driver.findElement(By.xpath("//*[@id=\"refreshbut\"]")).click();

        //switching the box frame by ID
        driver.switchTo().frame("ifinbox");

        System.out.println("********We are switch to the box iframe*******");
        driver.findElement(By.xpath("//*[@id=\"e_ZwZkZwV4ZGN0ZmZlZQNjZwx0AQt1At==\"]/button/div[2]")).click();
        //Clicks the iframe

        System.out.println("*********get the box mail***************");

        // validate box clicked
        String txtExpectedBoxClicked = driver.findElement(By.xpath("//*[@id=\"e_ZwZkZwV4ZGN0ZmZlZQNjZwx0AQt1At==\"]/button/div[2]")).getText();
        System.out.println(txtExpectedBoxClicked);
        String txtActualBoxClicked = "Support request rejected – 1650993 - رفض طلب الدعم";

        Assert.assertEquals(txtActualBoxClicked, txtExpectedBoxClicked);

        //leaving a frame
        driver.switchTo().defaultContent();

        //switching the mail frame by ID
        driver.switchTo().frame("ifmail");

        System.out.println("********We are switch to the mail iframe*******");
        driver.findElement(By.xpath("/html/body/header/div[3]/div[1]")).getText();

        System.out.println("*********get the mail iframe***************");
        // validate
        String txtExpectedMailOpen = driver.findElement(By.xpath("/html/body/header/div[3]/div[1]")).getText();
        System.out.println(txtExpectedMailOpen);
        String txtActualMailOpen = "Support request rejected – 1650993 - رفض طلب الدعم";

        Assert.assertEquals(txtActualMailOpen, txtExpectedMailOpen);

        driver.quit();
    }
}
