package me.joshmcfarlin.CryptoCompareAPI;

import me.joshmcfarlin.CryptoCompareAPI.Utils.CallTypes;
import me.joshmcfarlin.CryptoCompareAPI.Utils.OutOfCallsException;
import me.joshmcfarlin.CryptoCompareAPI.Utils.RateLimiting;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Example {
    private static void rateLimitingTest() throws IOException {
        System.out.println("\nRate Limiting APITest:");
        RateLimiting.Rates r = RateLimiting.checkHour();
        System.out.println(r.CallsMade);

        System.out.println("Are any price calls left?");
        System.out.println(RateLimiting.callable(CallTypes.PRICE));
        System.out.println(RateLimiting.checkHour().CallsLeft);
    }

    private static void coinsTest() throws IOException, OutOfCallsException {
        System.out.println("\nCoins APITest:");
        Coins.CoinList coinList = Coins.getCoinList();

        System.out.println("BTC coin name:");
        System.out.println(coinList.coins.get("BTC").name);
    }

    private static void exchangesTest() throws IOException, OutOfCallsException {
        System.out.println("\nExchanges APITest:");
        Exchanges.ExchangeList exchangeList = Exchanges.getAllExchanges();

        System.out.println("Cryptsy Bitcoin info:");
        System.out.println(exchangeList.exchanges.get("Cryptsy").coins.get("BTC").tradingPairs);

        System.out.println("Top BTC-USD Exchange:");
        List<Exchanges.Exchange> topExchanges = Exchanges.getTopExchanges("BTC", "USD");
        System.out.println(topExchanges.get(0).exchange);
    }

    private static void newsTest() throws IOException, OutOfCallsException {
        System.out.println("\nNews APITest:");
        List<News.NewsProvider> newsProviders = News.NewsProviderList();
        System.out.println("First news provider:");
        System.out.println(newsProviders.get(0));

        System.out.println("News List:");
        List<News.NewsStory> newsList = News.NewsList();

        System.out.println("First news story:");
        System.out.println(newsList.get(0));
    }

    private static void socialTest() throws IOException, OutOfCallsException {
        System.out.println("\nSocial APITest:");
        Social.SocialStats socialStats = Social.getStats(1182);
        System.out.println("Facebook likes:");
        System.out.println(socialStats.data.facebook.likes);
    }

    private static void historicTest() throws IOException, OutOfCallsException {
        System.out.println("\nHistoric APITest:");
        Historic.History history = Historic.getDay("BTC", "USD", 30);
        System.out.println("First high price for BTC-USD:");
        System.out.println(history.data.get(0).high);

        System.out.println("Bitcoin price at 1515190000 in USD, EUR, and ETH:");
        Map bitcoinPriceAt = Historic.getPriceAtTime(1515190000, "BTC", "USD", "EUR", "ETH");
        System.out.println(bitcoinPriceAt);
    }

    private static void marketTest() throws IOException, OutOfCallsException {
        System.out.println("\nMarket APITest:");
        double dayAverage = Market.getDayAverage("BTC", "USD");
        System.out.println("Bitcoin day average:");
        System.out.println(dayAverage);

        Market.ExchangeAverage exchangeAverage = Market.getExchangeAverage("BTC", "USD", "Coinbase", "Kraken", "Bitstamp");
        System.out.println("Bitcoin average from Coinbase, Kraken, and Bitstamp:");
        System.out.println(exchangeAverage.high24Hour);

        Map<String, Double> btcPrice = Market.getPrice("BTC", "USD", "EUR");
        System.out.println("Bitcoin price in USD and EUR:");
        System.out.println(btcPrice);

        Map<String, Map<String, Double>> btcETHPrice = Market.getMultiPrice(new String[] {"BTC", "ETH"}, new String[] {"USD", "EUR"});
        System.out.println("Bitcoin and Ethereum price in USD and EUR:");
        System.out.println(btcETHPrice);

        Map<String, Map<String, Market.toSym>> multiFull = Market.getMultiFull(new String[] {"BTC", "ETH"}, new String[] {"USD", "EUR"});
        System.out.println("Bitcoin to USD 24 Hour Volume:");
        System.out.println(multiFull.get("BTC").get("USD").volume24Hour);
        System.out.println("Ethereum to EUR 24 Hour High:");
        System.out.println(multiFull.get("ETH").get("EUR").high24Hour);

        List<Market.Coin> usdTopVol = Market.getTopVolumes("USD");
        System.out.println("Top coins by volume trading to USD:");
        System.out.println(usdTopVol);

        List<Market.Pair> topPairs = Market.getTopPairs("BTC");
        System.out.println("Top pairs by volume for Bitcoin:");
        System.out.println(topPairs);
    }

    private static void miningTest() throws IOException, OutOfCallsException {
        System.out.println("\nMining APITest:");
        Mining.Contracts contracts = Mining.getContracts();
        System.out.println("Current mining contracts:");
        System.out.println(contracts.contracts);

        System.out.println("Current coins mined:");
        System.out.println(contracts.coins);

        Mining.Equipment equipment = Mining.getEquipment();
        System.out.println("Current mining equipment:");
        System.out.println(equipment.equipment);
    }

    public static void main(String[] args) {
        try {
            rateLimitingTest();
            coinsTest();
            exchangesTest();
            newsTest();
            socialTest();
            historicTest();
            marketTest();
            miningTest();
        } catch (Exception e) {
            System.out.println("Something went wrong!");
            System.out.println(e);
        }
    }
}
