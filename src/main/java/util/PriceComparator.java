package util;

/**
 * Interface representing a price comparison utility.
 */
public interface PriceComparator {
    boolean compareItemPrices(double... itemPrices);
}
