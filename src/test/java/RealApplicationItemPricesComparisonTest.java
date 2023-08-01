import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RealApplicationItemPricesComparisonTest extends BaseTest {

    @DataProvider(name = "itemName")
    public Object[][] itemName() {
        return new Object[][]{
                {"1010"},
                {"1011"}
        };
    }
    @Test(dataProvider = "itemName")
    public void testApplicationItemPriceComparison(String itemName){
        double marketPlace1011ItemPrice = marketPlacePlatform.getPrice(itemName);
        double webSite1011ItemPrice = webSitePlatform.getPrice(itemName);
        double mobile1011ItemPrice = mobilePlatform.getPrice(itemName);
        boolean comparatorResult = comparator.compareItemPrices(marketPlace1011ItemPrice, webSite1011ItemPrice, mobile1011ItemPrice);
        Assert.assertTrue(comparatorResult, "Item name: '" + itemName + "' has different price for some platform.");
    }
}
