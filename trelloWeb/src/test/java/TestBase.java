import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {
    WebDriver wd;

    @BeforeMethod
    public void setUp(){
        init();
    }

    public void init() {
        wd=new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.get("https://trello.com/");
    }

    @AfterMethod
        public void tearDown(){
        stop();
    }

    public void stop() {
        wd.quit();
    }

    public void pauseThred(int millis) throws InterruptedException {
        Thread.sleep(millis);
    }

    public void confirmLlogin() {
        click(By.id("login"));
    }

    public void click(By Locator) {
        wd.findElement(Locator).click();
    }

    public void fillLoginForm(String email, String password) {
        //type email
        type(By.id("user"), email);
        //type password
        type(By.name("password"), password);
    }

    public void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    public void dickLoginButton() {
        click(By.cssSelector("[href='/login]'"));
    }

    public void Login(String email, String pwd)throws InterruptedException{
        click(By.cssSelector("[href='/login]'"));

        wd.findElement(By.id("user")).sendKeys("lag2@email.su");

        wd.findElement(By.name("password")).sendKeys("f");
        pauseThred(3000);

        click(By.id("login"));
    }

    public void confirmBoardCreation()
    {
        click(By.cssSelector("[data-test-id=header-create-board-button]"));
    }

    public void typeBoardName(String typeBoardName) {
            wd.findElement(By.cssSelector("[data-test-id=header-create-board-button]"));
            wd.findElement(By.cssSelector("[data-test-id=header-create-board-button]")).clear();
            wd.findElement(By.cssSelector("[data-test-id=header-create-board-button]")).sendKeys(typeBoardName);
        }

    public void selectCreateBoardFromDropDown() {
        click(By.cssSelector("[data-test-id=header-create-board-button]"));
    }

    public void clickOnButtonOnHeader() {
        click(By.cssSelector("name add"));
    }

    public boolean iselementpresent(By locator){
        try {
            wd.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    public boolean iselementpresent2(By locator){
        return wd.findElements(locator).size()>0;
    }
}
