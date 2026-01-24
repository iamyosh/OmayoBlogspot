import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TopbarTest extends BaseTest{

    @Test
    public void testTopBar(){
        //Homepage -> TopbarPage
        //no need to reassign homepage.topbarpage bcz its there in basetest
        topbarPage.searchBar();
        topbarPage.backToHome();
    }
}
