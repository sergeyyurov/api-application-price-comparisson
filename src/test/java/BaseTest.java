import commonData.ApplicationData;
import mockServer.ApplicationMocData;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import application.ApplicationFactory;
import application.ApplicationItemPriceComparator;
import report.TestListener;
import util.ApplicationSetup;


@Listeners(TestListener.class)
public class BaseTest {
    private ApplicationMocData applicationMocData = new ApplicationMocData();
    private ApplicationFactory applicationFactory = new ApplicationFactory();
    protected ApplicationItemPriceComparator comparator;
    protected ApplicationSetup marketPlacePlatform;
    protected ApplicationSetup webSitePlatform;
    protected ApplicationSetup mobilePlatform;


    @BeforeClass
    public void setUp() {
        marketPlacePlatform = applicationFactory.setupApplication(ApplicationData.MARKETPLACE);
        webSitePlatform = applicationFactory.setupApplication(ApplicationData.WEBSITE);
        mobilePlatform = applicationFactory.setupApplication(ApplicationData.MOBILE);

        applicationMocData.start();
        comparator = new ApplicationItemPriceComparator();
    }

    @AfterClass
    public void teardown() {
        applicationMocData.stop();
    }
}

