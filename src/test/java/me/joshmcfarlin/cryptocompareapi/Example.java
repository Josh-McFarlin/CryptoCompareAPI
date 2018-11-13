package me.joshmcfarlin.cryptocompareapi;

import me.joshmcfarlin.cryptocompareapi.Exceptions.InvalidParameterException;
import me.joshmcfarlin.cryptocompareapi.api.*;
import me.joshmcfarlin.cryptocompareapi.models.coin.CoinSnapshot;
import me.joshmcfarlin.cryptocompareapi.models.coin.PairSnapshot;
import me.joshmcfarlin.cryptocompareapi.models.exchanges.Exchange;
import me.joshmcfarlin.cryptocompareapi.models.exchanges.ExchangeList;
import me.joshmcfarlin.cryptocompareapi.models.historic.History;
import me.joshmcfarlin.cryptocompareapi.models.market.Coin;
import me.joshmcfarlin.cryptocompareapi.models.market.ExchangeAverage;
import me.joshmcfarlin.cryptocompareapi.models.market.Pair;
import me.joshmcfarlin.cryptocompareapi.models.market.ToSym;
import me.joshmcfarlin.cryptocompareapi.models.mining.Contracts;
import me.joshmcfarlin.cryptocompareapi.models.mining.Equipment;
import me.joshmcfarlin.cryptocompareapi.models.news.NewsProvider;
import me.joshmcfarlin.cryptocompareapi.models.news.NewsStory;
import me.joshmcfarlin.cryptocompareapi.models.social.SocialStats;
import me.joshmcfarlin.cryptocompareapi.utils.CallTypes;
import me.joshmcfarlin.cryptocompareapi.Exceptions.OutOfCallsException;
import me.joshmcfarlin.cryptocompareapi.utils.RateLimiting;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Example {
    private static CryptoCompareAPI api = new CryptoCompareAPI();

    private static void rateLimitingTest() throws IOException {
        System.out.println("\nRate Limiting APITest:");
        RateLimiting.Rates r = RateLimiting.getRates();
        System.out.println(r.getHour().getCallsMade());

        System.out.println("Are any price calls left?");
        System.out.println(RateLimiting.callable(CallTypes.PRICE));
    }

    private static void coinsTest() throws IOException, OutOfCallsException {
        System.out.println("\nCoins APITest:");
        //Coins.CoinList coinList = Coins.getCoinList();

        System.out.println("Bitcoin ID:");
        //System.out.println(coinList.getCoins().get("BTC").getId());

        PairSnapshot ethBTCSnapshot = api.coins.getPairSnapshot("ETH", "BTC");
        System.out.println("Ethereum Block Number:");
        System.out.println(ethBTCSnapshot.getData().getBlockNumber());

        CoinSnapshot btcSnapshot = api.coins.getCoinSnapshot(1182);
        System.out.println("Bitcoin Start Date:");
        System.out.println(btcSnapshot.getData().getGeneral().getStartDate());
    }

    private static void exchangesTest() throws IOException, OutOfCallsException, InvalidParameterException {
        System.out.println("\nExchanges APITest:");
        ExchangeList exchangeList = api.exchanges.getAllExchanges();

        System.out.println("Cryptsy Bitcoin info:");
        System.out.println(exchangeList.getExchanges().get("Cryptsy").getCoins().get("BTC").getTradingPairs());

        System.out.println("Top BTC-USD Exchange:");
        List<Exchange> topExchanges = api.exchanges.getTopExchanges("BTC", "USD");
        System.out.println(topExchanges.get(0));
    }

    private static void newsTest() throws IOException, OutOfCallsException {
        System.out.println("\nNews APITest:");
        List<NewsProvider> newsProviders = api.news.newsProviderList();
        System.out.println("First news provider:");
        System.out.println(newsProviders.get(0));

        System.out.println("News List:");
        List<NewsStory> newsList = api.news.newsList();

        System.out.println("First news story:");
        System.out.println(newsList.get(0));
    }

    private static void socialTest() throws IOException, OutOfCallsException {
        System.out.println("\nSocial APITest:");
        SocialStats socialStats = api.social.getStats(1182);
        System.out.println("Facebook likes:");
        System.out.println(socialStats.getData().getFacebook().getLikes());
    }

    private static void historicTest() throws IOException, OutOfCallsException, InvalidParameterException {
        System.out.println("\nHistoric APITest:");
        History history = api.historic.getDay("BTC", "USD", 30);
        System.out.println("First high price for BTC-USD:");
        System.out.println(history.getData().get(0).getHigh());

        System.out.println("Bitcoin price at 1515190000 in USD, EUR, and ETH:");
        Map bitcoinPriceAt = api.historic.getPriceAtTime("BTC", "USD,EUR,ETH", 1515190000);
        System.out.println(bitcoinPriceAt);
    }

    private static void marketTest() throws IOException, OutOfCallsException, InvalidParameterException {
        System.out.println("\nMarket APITest:");
        double dayAverage = api.historic.getDayAverage("BTC", "USD");
        System.out.println("Bitcoin day average:");
        System.out.println(dayAverage);

        ExchangeAverage exchangeAverage = api.market.getExchangeAverage("BTC", "USD", "Coinbase,Kraken,Bitstamp");
        System.out.println("Bitcoin average from Coinbase, Kraken, and Bitstamp:");
        System.out.println(exchangeAverage.getHigh24Hour());

        Map<String, Double> btcPrice = api.market.getPrice("BTC", "USD,EUR");
        System.out.println("Bitcoin price in USD and EUR:");
        System.out.println(btcPrice);

        Map<String, Map<String, Double>> btcETHPrice = api.market.getMultiPrice("BTC,ETH", "USD,EUR");
        System.out.println("Bitcoin and Ethereum price in USD and EUR:");
        System.out.println(btcETHPrice);

        Map<String, Map<String, ToSym>> multiFull = api.market.getMultiFull("BTC,ETH", "USD,EUR");
        System.out.println("Bitcoin to USD 24 Hour Volume:");
        System.out.println(multiFull.get("BTC").get("USD").getVolume24Hour());
        System.out.println("Ethereum to EUR 24 Hour High:");
        System.out.println(multiFull.get("ETH").get("EUR").getHigh24Hour());

        List<Coin> usdTopVol = api.market.getTopVolumes("USD");
        System.out.println("Top coins by volume trading to USD:");
        System.out.println(usdTopVol);

        List<Pair> topPairs = api.market.getTopPairs("BTC");
        System.out.println("Top pairs by volume for Bitcoin:");
        System.out.println(topPairs);
    }

    private static void miningTest() throws IOException, OutOfCallsException {
        System.out.println("\nMining APITest:");
        Contracts contracts = api.mining.getContracts();
        System.out.println("Current mining contracts:");
        System.out.println(contracts.getContracts());

        System.out.println("Current coins mined:");
        System.out.println(contracts.getCoins());

        Equipment equipment = api.mining.getEquipment();
        System.out.println("Current mining equipment:");
        System.out.println(equipment.getEquipment());
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
            e.printStackTrace();
        }
    }
}
