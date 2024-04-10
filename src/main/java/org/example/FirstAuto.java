package org.example;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class FirstAuto {

    //creating object of type Webdriver
    private static WebDriver driver;

    //expected registration confirmation message
    static String expected = "Your registration completed";

    public static void main(String[] args)
    {
        //instantiating object of chromedriver class
        driver = new ChromeDriver();

        //implicitly wait up to 20 seconds to find each element throughout the script
        //before throwing NoSuchElementFound exception
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        //open URL (using get() abstract method of Webdriver interface)
        driver.get("https://demo.nopcommerce.com/");

        //click on register option (using click() abstract method of Webdriver interface)
        driver.findElement(By.className("ico-register")).click();

        //choose male or female
        driver.findElement(By.id("gender-male")).click();

        //Type first name (Using sendKeys() abstract method of Webdriver interface)
        driver.findElement(By.id("FirstName")).sendKeys("Dhruvesh");

        //Type last name
        driver.findElement(By.id("LastName")).sendKeys("Patel");

        //Type email
        driver.findElement(By.id("Email")).sendKeys("djfk@gmail.com");

        //Type password
        driver.findElement(By.id("Password")).sendKeys("282905");

        //Type confirm password
        driver.findElement(By.id("ConfirmPassword")).sendKeys("282905");

        //click on Register button
        driver.findElement(By.id("register-button")).click();

        //Capture text of confirmation message (Using getText() abstract method of Webdriver interface)
        String actual = driver.findElement(By.className("result")).getText();

        //compare with requirement
        if(actual.equals(expected)) //comparing two Strings using inbuilt equal() String method
        {
            System.out.println("The test is PASS");
        } else
        {
            System.out.println("The test is FAIL");
        }

        //close the browser (Using close() abstract method of Webdriver interface,
        // because only one browser to close)
        // if there are more than one browser to close then quit() abstract method to be used
        driver.close();

    }
}
