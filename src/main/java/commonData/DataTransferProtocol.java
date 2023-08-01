package commonData;

/**
 * Enumeration representing data transfer protocols.
 */
public enum DataTransferProtocol {
    HTTP("http://"),
    HTTPS("https://");
    private String protocol;

    DataTransferProtocol(String protocol){
        this.protocol = protocol;
    }

    public String getProtocol(){ return protocol;}
}
