package me.joshmcfarlin.cryptocompareapi;

import me.joshmcfarlin.cryptocompareapi.Exceptions.InvalidParameterException;
import me.joshmcfarlin.cryptocompareapi.Exceptions.OutOfCallsException;
import me.joshmcfarlin.cryptocompareapi.utils.IntervalTypes;
import me.joshmcfarlin.cryptocompareapi.utils.RateLimiting;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class APITest {
    @Test
    void shouldReturnValidAPIUsage() throws IOException {
        RateLimiting.Rates rates = RateLimiting.getRates();
        assertNotNull(rates);
    }

    @Test
    void shouldReturnCoinListWithCoins() throws IOException, OutOfCallsException, InterruptedException {
        Coins.CoinList coinList = Coins.getCoinList();
        assertNotNull(coinList);
        assertFalse(coinList.getCoins().isEmpty());
        assertEquals("BTC", coinList.getCoins().get("BTC").getName());
    }

    @Test
    void shouldReturnExchangeListWithExchanges() throws IOException, OutOfCallsException, InterruptedException {
        Exchanges.ExchangeList exchangeList = Exchanges.getAllExchanges();
        assertNotNull(exchangeList);
        assertFalse(exchangeList.getExchanges().isEmpty());
        assertNotNull(exchangeList.getExchanges().get("Cryptsy").getCoins().get("BTC"));
    }

    @Test
    void shouldNotReturnNullEmptyNewsList() throws IOException, OutOfCallsException, InterruptedException {
        List<News.NewsProvider> newsProviders = News.NewsProviderList();
        assertNotNull(newsProviders);
        assertFalse(newsProviders.isEmpty());

        List<News.NewsStory> newsList = News.NewsList();
        assertNotNull(newsList);
        assertFalse(newsList.isEmpty());
    }

    @Test
    void shouldReturnNewsListWithNews() throws IOException, OutOfCallsException, InterruptedException {
        List<News.NewsProvider> newsProviders = News.NewsProviderList();
        assertFalse(newsProviders.isEmpty());
        assertNotNull(newsProviders.get(0).getKey());

        List<News.NewsStory> newsList = News.NewsList();
        assertFalse(newsList.isEmpty());
        assertNotNull(newsList.get(0).getTitle());
    }

    @Test
    void shouldNotReturnNullSocialStats() throws IOException, OutOfCallsException, InterruptedException {
        Social.SocialStats socialStats = Social.getStats(1182);
        assertNotNull(socialStats);
        assertNotNull(socialStats.getData());
    }

    @Test
    void shouldNotReturnNullEmptyHistoricData() throws IOException, OutOfCallsException, InterruptedException, InvalidParameterException {
        Historic.History history = Historic.getDay("BTC", "USD", 30);
        assertNotNull(history);
        assertFalse(history.getData().isEmpty());
    }

    @Test
    void shouldNotReturnNullEmptyHistoricPriceMap() throws IOException, OutOfCallsException, InterruptedException, InvalidParameterException {
        Map bitcoinPriceAt = Historic.getPriceAtTime("BTC", "USD,EUR,ETH", 1515190000);
        assertNotNull(bitcoinPriceAt);
        assertFalse(bitcoinPriceAt.isEmpty());
    }

    @Test
    void shouldNotReturnNullAverage() throws IOException, OutOfCallsException, InterruptedException {
        double dayAverage = Market.getDayAverage("BTC", "USD");
        assertTrue(dayAverage > 0);
    }

    @Test
    void shouldNotReturnNullEmptyExchangeAverage() throws IOException, OutOfCallsException, InterruptedException {
        Market.ExchangeAverage exchangeAverage = Market.getExchangeAverage("BTC", "USD", "Coinbase", "Kraken", "Bitstamp");
        assertNotNull(exchangeAverage);
    }

    @Test
    void shouldNotReturnNullEmptyMarketAverage() throws IOException, OutOfCallsException, InterruptedException {
        Map<String, Double> btcPrice = Market.getPrice("BTC", "USD", "EUR");
        assertNotNull(btcPrice);
        assertFalse(btcPrice.isEmpty());
    }

    @Test
    void shouldNotReturnNullEmptyMultiPrice() throws IOException, OutOfCallsException, InterruptedException {
        Map<String, Map<String, Double>> btcETHPrice = Market.getMultiPrice(new String[]{"BTC", "ETH"}, new String[]{"USD", "EUR"});
        assertNotNull(btcETHPrice);
        assertFalse(btcETHPrice.isEmpty());
    }

    @Test
    void shouldNotReturnNullEmptyMultiFull() throws IOException, OutOfCallsException, InterruptedException {
        Map<String, Map<String, Market.toSym>> multiFull = Market.getMultiFull(new String[] {"BTC", "ETH"}, new String[] {"USD", "EUR"});
        assertNotNull(multiFull);
        assertFalse(multiFull.isEmpty());
    }

    @Test
    void shouldNotReturnNullEmptyTopVolumes() throws IOException, OutOfCallsException, InterruptedException {
        List<Market.Coin> usdTopVol = Market.getTopVolumes("USD");
        assertNotNull(usdTopVol);
        assertFalse(usdTopVol.isEmpty());
    }

    @Test
    void shouldNotReturnNullEmptyTopPairs() throws IOException, OutOfCallsException, InterruptedException {
        List<Market.Pair> topPairs = Market.getTopPairs("BTC");
        assertNotNull(topPairs);
        assertFalse(topPairs.isEmpty());
    }

    @Test
    void shouldNotReturnNullEmptyMiningContracts() throws IOException, OutOfCallsException, InterruptedException {
        Mining.Contracts contracts = Mining.getContracts();
        assertNotNull(contracts);
        assertFalse(contracts.getContracts().isEmpty());
    }

    @Test
    void shouldNotReturnNullEmptyMiningHardware() throws IOException, OutOfCallsException, InterruptedException {
        Mining.Equipment equipment = Mining.getEquipment();
        assertNotNull(equipment);
        assertFalse(equipment.getEquipment().isEmpty());
    }
}
