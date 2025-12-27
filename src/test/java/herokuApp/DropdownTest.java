package herokuApp;

import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.management.DescriptorKey;

public class DropdownTest {
    WebDriver driver;
    @BeforeClass
    void setUp() {
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dropdown");

    }
        @Test
        @Description("Select a option by visible text")
        void selectOptionFromDropDown() {
            driver.get("https://the-internet.herokuapp.com/dropdown");

            Select select = new Select(driver.findElement(By.id("dropdown")));

            select.selectByVisibleText("Option 1");
            Assert.assertTrue(isSelected(getOption("Option 1")));

        //        select.selectByValue("1");
        //        Assert.assertTrue(driver.findElement(By.cssSelector("option[value='1']")).isSelected());
        }

            @Test
            @Description("Select multiple options")
            void selectMultipleOptions(){
                driver.get("https://output.jsbin.com/osebed/2");

                Select select = new Select(driver.findElement(By.id("fruits")));
                select.selectByVisibleText("Banana");
                select.selectByVisibleText("Apple");
                select.selectByVisibleText("Grape");

                Assert.assertTrue(isSelected(getOption("Banana")));
                Assert.assertTrue(isSelected(getOption("Apple")));
                Assert.assertTrue(isSelected(getOption("Grape")));
                Assert.assertFalse(isSelected(getOption("Orange")));

                select.deselectByValue("Apple");
                Assert.assertTrue(isSelected(getOption("Banana")));
                Assert.assertFalse(isSelected(getOption("Apple")));
                Assert.assertTrue(isSelected(getOption("Grape")));
                Assert.assertFalse(isSelected(getOption("Orange")));

                select.deselectAll();
                Assert.assertFalse(isSelected(getOption("Banana")));
                Assert.assertFalse(isSelected(getOption("Apple")));
                Assert.assertFalse(isSelected(getOption("Grape")));
                Assert.assertFalse(isSelected(getOption("Orange")));
            }

            @AfterMethod
            void tearDown(){
                driver.quit();
            }

            private By getOption(String visibleText){
                return By.xpath(String.format("//option[.='%s']",visibleText));
            }
            public boolean isSelected(By locator){
                return driver.findElement(locator).isSelected();
            }

        }
