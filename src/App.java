import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Shop> shops = List.of(
                new RemoteShop("BestPrice-1"),
                new RemoteShop("LetsSaveBig-2"),
                new RemoteShop("MyFavoriteShop-3"),
                new RemoteShop("BuyItAll-4"),
                new RemoteShop("ShopEasy-5")
        );

        var finder = new BestPriceFinder(shops);

        System.out.println("Invoking Async Price Finder...");
        var start = System.nanoTime();

        var tmp = finder.findPrices();

        var duration = (System.nanoTime() - start) / 1_000_000;

//        quotes.forEach(System.out::println);
        System.out.println("Done in " + duration + " msecs");

    }
}
