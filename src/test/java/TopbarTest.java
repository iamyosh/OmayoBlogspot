import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TopbarTest extends BaseTest{
    private TopbarPage topbarPage;
    private HomePage homePage;

    @BeforeMethod
    public void initPage() {
        homePage = new HomePage(driver);
    }

    @Test
    public void testTopBar(){
        //Homepage -> TopbarPage
        topbarPage = homePage.topbarPage();
        topbarPage.searchBar();
    }
}
