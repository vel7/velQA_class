import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TrelloLoginTest extends TestBase{

    @Test
    public void LoginTest() throws InterruptedException {
        //dick login button
        dickLoginButton();
        fillLoginForm("lag2@email.su", "fixedskil1");
        pauseThred(3000);
        confirmLlogin();
    }

}
