package application;

import commonData.ApplicationData;
import util.ApplicationSetup;

/**
 * Factory class for creating different application instances based on the specified data.
 */
public class ApplicationFactory {

    /**
     * Sets up and returns the application instance based on the specified data.
     *
     * @param applicationType Enum representing the type of application to be set up.
     * @return An instance of the predefined type application.
     * @throws IllegalArgumentException If an unsupported application type is provided.
     */
    public ApplicationSetup setupApplication(ApplicationData applicationType) {
        String protocol;
        String domainName;

        if ((ApplicationData.MOBILE.toString()).equalsIgnoreCase(applicationType.toString())) {
            protocol = ApplicationData.MOBILE.getProtocol();
            domainName = ApplicationData.MOBILE.getDomainName();
            return new MobileApplication(protocol, domainName);
        } else if ((ApplicationData.WEBSITE.toString()).equalsIgnoreCase(applicationType.toString())) {
            protocol = ApplicationData.WEBSITE.getProtocol();
            domainName = ApplicationData.WEBSITE.getDomainName();
            return new WebApplication(protocol, domainName);
        } else if ((ApplicationData.MARKETPLACE.toString()).equalsIgnoreCase(applicationType.toString())) {
            protocol = ApplicationData.MARKETPLACE.getProtocol();
            domainName = ApplicationData.MARKETPLACE.getDomainName();
            return new MarketPlaceApplication(protocol, domainName);
    } else {
            throw new IllegalArgumentException("Unsupported application type: " + applicationType);
        }
    }
}
