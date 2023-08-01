package commonData;

import io.restassured.RestAssured;
import io.restassured.response.Response;

/**
 * Utility class to work with different applications to get item prices.
 */
public class ApplicationMethod {

    /**
     * Gets the price of an item from a specific application using REST API calls.
     *
     * @param networkProtocol The network protocol.
     * @param domainName      The domain name of the platform.
     * @param itemName        The item name.
     * @return The price of the item as a double value.
     */
    public double getItemPrice(String networkProtocol, String domainName, String itemName) {
        float priceFloat = 0;
        int statusCode = 0;

        RestAssured.baseURI = networkProtocol + domainName;
        Response response = RestAssured.given().get("/checkPrice/" + itemName);
        statusCode = response.getStatusCode();

        if (statusCode == 200) {
            priceFloat = response.jsonPath().getFloat("price");
        }
        return priceFloat;
    }
}
