package mockServer;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import commonData.ApplicationData;

import java.util.HashMap;
import java.util.Map;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

/**
 * Class is responsible for setting up and managing mock data for different applications.
 */
public class ApplicationMocData {

    private WireMockServer wireMockServer;

    /**
     * Starts the WireMock server and sets up stubs for API responses for each application.
     */
    public void start() {
        wireMockServer = new WireMockServer(WireMockConfiguration.options().port(8080));
        wireMockServer.start();
        WireMock.configureFor("localhost", wireMockServer.port());
        createApplicationsMocData();
    }

    /**
     * Stops the WireMock server.
     */
    public void stop() {
        wireMockServer.stop();
    }

    /**
     * Template method to create mock data for a specific application with two products.
     *
     * @param applicationType The type of application for which the mock data is being created.
     * @param products A map containing product names with corresponding prices.
     */
    private void templateMockApplicationData(ApplicationData applicationType, Map<String, Double> products) {
        String domain = applicationType.getDomainName();
        String itemName;
        double productPrice;

        for (Map.Entry<String, Double> entry : products.entrySet()) {
            itemName = entry.getKey();
            productPrice = entry.getValue();

            stubFor(get(urlEqualTo("/" + domain + "/product/" + itemName))
                    .willReturn(aResponse()
                            .withStatus(200)
                            .withHeader("Content-Type", "application/json")
                            .withBody("{\"price\":" + productPrice + "}")));
        }
    }

    /**
     * Creates mock data for all applications with predefined product names and prices.
     */
    private void createApplicationsMocData() {
        Map<String, Double> websiteApplicationData = new HashMap<>();
        websiteApplicationData.put("1010", 18.0);
        websiteApplicationData.put("1011", 12.0);

        Map<String, Double> mobileApplicationData = new HashMap<>();
        mobileApplicationData.put("1010", 18.0);
        mobileApplicationData.put("1011", 11.0);

        Map<String, Double> marketplaceApplicationData = new HashMap<>();
        marketplaceApplicationData.put("1010", 18.0);
        marketplaceApplicationData.put("1011", 12.0);

        templateMockApplicationData(ApplicationData.WEBSITE, websiteApplicationData);
        templateMockApplicationData(ApplicationData.MOBILE, mobileApplicationData);
        templateMockApplicationData(ApplicationData.MARKETPLACE, marketplaceApplicationData);
    }

}
