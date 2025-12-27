package herokuApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckboxesTest {
    WebDriver driver;

    @BeforeMethod
    void setUp(){
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/checkboxes");
    }

    @Test
    void successfullyCheckCheckboxes() {
        check(By.cssSelector("#checkboxes > input:nth-child(1)"));
        Assert.assertTrue(driver.findElement(By.cssSelector("#checkboxes > input:nth-child(1)")).isSelected());

        check(By.cssSelector("#checkboxes > input:nth-child(3)"));
        Assert.assertTrue(driver.findElement(By.cssSelector("#checkboxes > input:nth-child(3)")).isSelected());
    }

    @Test
    void successfullyUncheckCheckboxes() {
        uncheck(By.cssSelector("#checkboxes > input:nth-child(1)"));
        Assert.assertFalse(driver.findElement(By.cssSelector("#checkboxes > input:nth-child(1)")).isSelected());

        uncheck(By.cssSelector("#checkboxes > input:nth-child(3)"));
        Assert.assertFalse(driver.findElement(By.cssSelector("#checkboxes > input:nth-child(3)")).isSelected());
    }

    @AfterMethod
    void tearDown(){
        driver.quit();
    }

    public void check(By locator){
        WebElement checkbox1 = driver.findElement(locator);
        if (!checkbox1.isSelected()) {
            checkbox1.click();
        }
    }

    public void uncheck(By locator){
        WebElement checkbox1 = driver.findElement(locator);
        if (checkbox1.isSelected()) {
            checkbox1.click();
        }
    }
}