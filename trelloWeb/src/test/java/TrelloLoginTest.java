import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TrelloLoginTest {
    WebDriver wd;
    @BeforeMethod
    public void setUp(){
        wd=new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    wd.get("https://trello.com/");
    }
    @Test
    public void LoginTest(){
        //dick login button
        wd.findElement(By.cssSelector("[href='/login]'")).click();
        //type email
        wd.findElement(By.id("user")).sendKeys("lag2@email.su");
        //type password
        wd.findElement(By.name("password")).sendKeys("f");
        Thread.sleep(3000);
        //confirmLlogin
        wd.findElement(By.id("login")).click();
    }

@AfterMethod
    public void tearDown(){
        wd.quit();
}
}
