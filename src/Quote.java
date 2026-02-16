public class Quote {
    private String shopName;
    private double price;

    public Quote(String shopName, double price) {
        this.shopName = shopName;
        this.price = price;

    }
    @Override
    public String toString() {
        return String.format("Quote{site='%s', price=%.2f}", shopName, price);
    }
}
