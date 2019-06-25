package com.telran.qa20;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class Trello {
    WebDriver driver;
   @BeforeMethod
    public void setU(){
        driver = new ChromeDriver();
        driver.get("https://www.Trello.com/");
    }
    @Test
    public void TestTrello(){
        System.out.println("Trello opened.");
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
