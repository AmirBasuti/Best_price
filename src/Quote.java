public class Quote {
    private String shopName;
    private double price;

    public Quote(String shopName, double price) {
        this.shopName = shopName;
        this.price = price;

    }
    public String getShopName() {
        return shopName;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("Quote{site='%s', price=%.2f}", shopName, price);
    }
}
