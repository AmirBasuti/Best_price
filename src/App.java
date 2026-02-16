import java.util.List;

public class App {
    public static void main(String[] args) {
        var shops = List.of(
                new Shop("BestPrice-1"),
                new Shop("LetsSaveBig-2"),
                new Shop("MyFavoriteShop-3"),
                new Shop("BuyItAll-4"),
                new Shop("ShopEasy-5")
        );

        var finder = new BestPriceFinder(shops);

        System.out.println("Invoking Async Price Finder...");
        var start = System.nanoTime();

        finder.findPrices(); // This blocks until all are done

        var duration = (System.nanoTime() - start) / 1_000_000;

        System.out.println("\n--- Results ---");
//        quotes.forEach(System.out::println);
        System.out.println("Done in " + duration + " msecs");

    }
}
