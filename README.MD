# Best Price Finder - Async Shop Query System

## The Goal (What We Want)
We want the program to query all shops simultaneously and display the results as a single list.

### Requirements:
1. **Total Time**: The program should finish in roughly 1 second (the time of the slowest shop), regardless of how many shops are in the list.
2. **Result Format**: It should print a clean list of Quote objects (Shop Name + Price) to the terminal after all requests are complete.
3. **Async Processing**: All shop queries should run concurrently, not sequentially.

## Example Output:

```
Invoking Async Price Finder...
Getting a quote from BestPrice-1...
Getting a quote from LetsSaveBig-2...
Getting a quote from MyFavoriteShop-3...
Getting a quote from BuyItAll-4...
Getting a quote from ShopEasy-5...
Quote{site='BestPrice-1', price=123.45}
Quote{site='LetsSaveBig-2', price=110.00}
Quote{site='MyFavoriteShop-3', price=145.20}
Quote{site='BuyItAll-4', price=132.75}
Quote{site='ShopEasy-5', price=118.90}



Done in 1024 msecs
```

## Implementation Details:

### Components:
- **Shop** (Interface): Defines contract for shops with `getPrice()` and `getName()` methods
- **RemoteShop** (Implementation): Simulates a remote shop with network delay (random 0-1000ms)
- **Quote**: Represents a price quote from a shop
- **BestPriceFinder**: Uses `CompletableFuture` to query all shops concurrently
- **App**: Main entry point that orchestrates the async price finding

### How It Works:
1. The program creates a list of `RemoteShop` instances
2. `BestPriceFinder.findPrices()` uses `CompletableFuture.supplyAsync()` to query each shop on separate threads
3. All queries run in parallel, so total time ≈ slowest shop, not sum of all shops
4. Results are collected and displayed as a formatted list
