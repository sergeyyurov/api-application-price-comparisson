import commonData.ApplicationData;
import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MocApplicationItemComparisonTest extends BaseTest{

    @DataProvider(name = "itemName")
    public Object[][] itemName() {
        return new Object[][]{
                {"1010"},
                {"1011"}
        };
    }

    @Test(dataProvider = "itemName")
    public void testApplicationItemPriceComparison(String itemName) {
        String marketPlaceURL = ApplicationData.MARKETPLACE.getDomainName() + "/product/" + itemName;
        String mobileURL = ApplicationData.MOBILE.getDomainName() + "/product/" + itemName;
        String websiteURL = ApplicationData.WEBSITE.getDomainName() + "/product/" + itemName;
        double marketPlaceItemPrice = RestAssured.given().when().get(marketPlaceURL).jsonPath().getDouble("price");
        double mobileItemPrice = RestAssured.given().when().get(mobileURL).jsonPath().getDouble("price");
        double websiteItemPrice = RestAssured.given().when().get(websiteURL).jsonPath().getDouble("price");
        boolean comparatorResult = comparator.compareItemPrices(marketPlaceItemPrice, mobileItemPrice, websiteItemPrice);
        Assert.assertTrue(comparatorResult, "Item name: '" + itemName + "' has different price for some application.");
    }
}