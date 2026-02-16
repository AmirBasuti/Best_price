import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class BestPriceFinder {
    private final List<Shop> shops;


    public BestPriceFinder(List<Shop> shops) {
        this.shops = shops;
    }

    public List<Quote> findPrices() {
        List<CompletableFuture<Quote>> futures =  shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(shop::getPrice))
                .toList();

        return futures.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
    }
}
