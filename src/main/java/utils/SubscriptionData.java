package utils;

public class SubscriptionData {
    private String packageName;
    private String price;
    private String currency;

    public SubscriptionData(String packageName, String price, String currency) {
        this.packageName = packageName;
        this.price = price;
        this.currency = currency;
    }

    public String getPackageName() {
        return packageName;
    }

    public String getPrice() {
        return price;
    }

    public String getCurrency() {
        return currency;
    }
}
