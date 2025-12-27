package herokuApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HyperlinkTest {

    @Test
    void VerifyHyperlink() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/status_codes");
        driver.findElement(By.linkText("200")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://the-internet.herokuapp.com/status_codes/200");
        String content2 = driver.findElement(By.id("content")).getText();
        Assert.assertTrue(content2.contains("This page returned a 200 status code."));

        driver.navigate().back();
        driver.findElement(By.linkText("301")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://the-internet.herokuapp.com/status_codes/301");
        String content3 = driver.findElement(By.id("content")).getText();
        Assert.assertTrue(content3.contains("This page returned a 301 status code."));

        driver.navigate().back();
        driver.findElement(By.linkText("404")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://the-internet.herokuapp.com/status_codes/404");
        String content4 = driver.findElement(By.id("content")).getText();
        Assert.assertTrue(content4.contains("This page returned a 404 status code."));

        driver.navigate().back();
        driver.findElement(By.linkText("500")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://the-internet.herokuapp.com/status_codes/500");
        String content5 = driver.findElement(By.id("content")).getText();
        Assert.assertTrue(content5.contains("This page returned a 500 status code."));

        driver.quit();

    }

}
