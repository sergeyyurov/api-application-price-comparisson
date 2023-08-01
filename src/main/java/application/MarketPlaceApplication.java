package application;

import commonData.ApplicationMethod;
import util.ApplicationSetup;

/**
 * The class provides methods to work with the Marketplace application.
 */
public class MarketPlaceApplication extends ApplicationMethod implements ApplicationSetup {
    private String protocol;
    private String domainName;

    public MarketPlaceApplication(String protocol, String domainName){
        this.protocol = protocol;
        this.domainName = domainName;
    }

    /**
     * Gets the item price.
     *
     * @param itemName The item number.
     * @return The price of the item as a double value.
     */
    @Override
    public double getPrice(String itemName) {
        double price = 0;
        price = super.getItemPrice(this.protocol, this.domainName, itemName);
        return price;
    }

}
