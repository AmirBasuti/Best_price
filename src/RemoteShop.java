public class RemoteShop implements Shop{
    private final String name;

    public RemoteShop(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Quote getPrice() {
        System.out.println("Getting a quote from " + name + "...");
        var price = calculatePrice();
        var quote = new Quote(name, price);
//        System.out.println(quote);
        return quote;
    }

    private double calculatePrice() {
        try {
            Thread.sleep((long)(Math.random()*1000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return Math.random() * 100 + 100;
    }
}
