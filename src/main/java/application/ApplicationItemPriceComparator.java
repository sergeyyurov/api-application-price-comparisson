package application;

import util.PriceComparator;

/**
 * Implementation of the PriceComparator interface for comparing item prices across different applications.
 */
public class ApplicationItemPriceComparator implements PriceComparator {

    /**
     * Compares the prices of items from different application and checks if they are all the same.
     *
     * @param applicationItemPrices The item prices from different applications.
     * @return true if all the item prices are the same, false otherwise.
     */
    @Override
    public boolean compareItemPrices(double... applicationItemPrices) {
        if (applicationItemPrices.length == 1) {
            return true;
        }

        double firstApplicationItemPrice = applicationItemPrices[0];

        for (int i = 1; i < applicationItemPrices.length; i++) {
            if (applicationItemPrices[i] != firstApplicationItemPrice) {
                return false;
            }
        }
        return true;
    }
}
