import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardCreationTest extends TestBase{
   @BeforeMethod
   public void ensurePreconditions() throws InterruptedException

   {
       Login("lag2@email.su", "fixedskil1");
   }

   @Test
    public void testBoardCreationFromHeader()
    {
        int befor= getPersonalBoardCount();

        //clickOnButtonOnHeader
        clickOnButtonOnHeader();
        //selectCreateBoardFromDropDown
        selectCreateBoardFromDropDown();
        typeBoardName("qa20"+System.currentTimeMillis());
        pause(5000);
        returnToHomePage();
        confirmBoardCreation();
        //return toHomePage
        int after=getPersonalBoardCount();
        Assert.assertEquals(after, befor + 1);
    }

    private void returnToHomePage() {
       click(By.cssSelector("//span[@name='house']"));
    }

    private void pause(int i) {
    }

    public int getPersonalBoardCount()
    {
        return wd.findElements(By.xpath("//div[@class='board-tile-details is-badged']")).size()-1;
    }


}
