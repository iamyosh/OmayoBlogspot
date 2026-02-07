import org.testng.annotations.Test;

public class BodyTest extends BaseTest{
    private TopbarPage topbarPage;
    private BodyPage bodyPage;

    @Test
    public void testBody() throws InterruptedException {

        //homepage -> top bar page
        topbarPage = homePage.topbarPage();
        topbarPage.searchBar();
        topbarPage.backToHome();

        //top bar page -> body page
        bodyPage = topbarPage.goToBodyPage();
        bodyPage.multiList();
        bodyPage.selectFromDropdown();
        bodyPage.clickLink();
    }
}
