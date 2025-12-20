package herokuApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {
    /**
     *
     Open browser

     Navigate to https://the-internet.herokuapp.com/login

     Fill in username with tomsmith

     Fill in the password with SuperSecretPassword!

     Click on Login button

     And the home page is appear
     */
    @Test
    void successfullywithValidCredential(){

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://the-internet.herokuapp.com/login");
        // Fill in username with tomsmith
        /**
         * tagName:input
         * Attribute:
         * type: text //<== generic value ==> remove
         * id: username
         * name: username
         * Text:n/a
         * E[A=t] if (A==id) ==> E#t
         * //E[@A='t']  if (A==id) ==> //*[@id='t']
         * //E[contains(@A, 't')]
         * id > name > tagname > css > xpath
         * runable > visibility in UI > sort by length
         */
       driver.findElement(By.tagName("input")).sendKeys("tomsmith");
//       driver.findElement(By.id("username")).sendKeys("tomsmith");
//       driver.findElement(By.name("username")).sendKeys("tomsmith");
//
//       driver.findElement(By.cssSelector("input")).sendKeys("tomsmith");
//       driver.findElement(By.cssSelector("[type=text]")).sendKeys("tomsmith");
//       driver.findElement(By.cssSelector("input[type=text]")).sendKeys("tomsmith");
//       driver.findElement(By.cssSelector("[id=username]")).sendKeys("tomsmith");  //  driver.findElement(By.cssSelector("[#username]")).sendKeys("tomsmith");
//       driver.findElement(By.cssSelector("input[id=username]")).sendKeys("tomsmith");
//       driver.findElement(By.cssSelector("[name=username]")).sendKeys("tomsmith");
//       driver.findElement(By.cssSelector("input[name=username]")).sendKeys("tomsmith");
//
//       driver.findElement(By.xpath("//input")).sendKeys("tomsmith");
//       driver.findElement(By.xpath("//*[@id='username']")).sendKeys("tomsmith");
//
//        driver.findElement(By.xpath("//ipnut")).sendKeys("tomsmith");
//        driver.findElement(By.xpath("//*[@type='text']")).sendKeys("tomsmith");
//        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("tomsmith");
//        driver.findElement(By.xpath("//*[@id='username']")).sendKeys("tomsmith");
//        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith");
//        driver.findElement(By.xpath("//*[@name='username']")).sendKeys("tomsmith");
//        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("tomsmith");

        // Fill in the password with SuperSecretPassword!
        /**
         * tagName:input
         * Attribute:
         * type: password
         * id: password
         * name: password
         * Text:n/a
         */
            driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");

        //click on Login button
        /**
         * tagname:button
         * Attribute:
         * class: radius
         * type: submit
         * Text: n/a
         */
//          driver.findElement(By.className("radius")).click();
//          driver.findElement(By.cssSelector(".radius")).click();
//          driver.findElement(By.tagName("button")).click();
//          driver.findElement(By.cssSelector("button")).click();
          driver.findElement(By.cssSelector("[type=submit]")).click();
//          driver.findElement(By.cssSelector("button[type=submit]")).click();
//          driver.findElement(By.xpath("//button")).click();

        //And the home page is appear
        /**
         * tagname: div
         * Attribute:
         * id: flash
         * class: flash success
         * Text: You logged into a secure area!
         */
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Assert.assertTrue(driver.findElement(By.className("success")).getText().contains("You logged into a secure area!"));

        // And the home page is appear
          driver.quit();
    }
    @Test
    void unsuccessfullywithInvalidUsername() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://the-internet.herokuapp.com/login");
        // Fill in username with invalidUser
        driver.findElement(By.tagName("input")).sendKeys("invalidUser");
        // Fill in the password with SuperSecretPassword!
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        //click on Login button
        driver.findElement(By.cssSelector("[type=submit]")).click();
        //And the error message is appear
        Assert.assertTrue(driver.findElement(By.className("error")).getText().contains("Your username is invalid!"));

        // And the home page is appear
        driver.quit();
    }

    @Test
    void unsuccessfullywithInvalidPassword() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://the-internet.herokuapp.com/login");

        driver.findElement(By.tagName("input")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SecretPassword!");
        driver.findElement(By.cssSelector("[type=submit]")).click();

        //And the error message is appear
        Assert.assertTrue(driver.findElement(By.className("error")).getText().contains("Your password is invalid!"));

        driver.quit();
    }

}
