package me.joshmcfarlin.cryptocompareapi;

import me.joshmcfarlin.cryptocompareapi.Exceptions.InvalidParameterException;
import me.joshmcfarlin.cryptocompareapi.Exceptions.OutOfCallsException;
import me.joshmcfarlin.cryptocompareapi.utils.RateLimiting;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class APITest {
    private CryptoCompareAPI api = new CryptoCompareAPI();

    @Test
    void shouldReturnValidAPIUsage() throws IOException {
        RateLimiting.Rates rates = RateLimiting.getRates();
        assertNotNull(rates);
    }

    @Test
    void shouldReturnCoinListWithCoins() throws IOException, OutOfCallsException {
        Coins.CoinList coinList = api.coins.getCoinList();
        assertNotNull(coinList);
        assertFalse(coinList.getCoins().isEmpty());
        assertEquals("BTC", coinList.getCoins().get("BTC").getName());
    }

    @Test
    void shouldReturnExchangeListWithExchanges() throws IOException, OutOfCallsException {
        Exchanges.ExchangeList exchangeList = api.exchanges.getAllExchanges();
        assertNotNull(exchangeList);
        assertFalse(exchangeList.getExchanges().isEmpty());
        assertNotNull(exchangeList.getExchanges().get("Cryptsy").getCoins().get("BTC"));
    }

    @Test
    void shouldNotReturnNullEmptyNewsList() throws IOException, OutOfCallsException {
        List<News.NewsProvider> newsProviders = api.news.newsProviderList();
        assertNotNull(newsProviders);
        assertFalse(newsProviders.isEmpty());

        List<News.NewsStory> newsList = api.news.newsList();
        assertNotNull(newsList);
        assertFalse(newsList.isEmpty());
    }

    @Test
    void shouldReturnNewsListWithNews() throws IOException, OutOfCallsException {
        List<News.NewsProvider> newsProviders = api.news.newsProviderList();
        assertFalse(newsProviders.isEmpty());
        assertNotNull(newsProviders.get(0).getKey());

        List<News.NewsStory> newsList = api.news.newsList();
        assertFalse(newsList.isEmpty());
        assertNotNull(newsList.get(0).getTitle());
    }

    @Test
    void shouldNotReturnNullSocialStats() throws IOException, OutOfCallsException {
        Social.SocialStats socialStats = api.social.getStats(1182);
        assertNotNull(socialStats);
        assertNotNull(socialStats.getData());
    }

    @Test
    void shouldNotReturnNullEmptyHistoricData() throws IOException, OutOfCallsException, InvalidParameterException {
        Historic.History history = api.historic.getDay("BTC", "USD", 30);
        assertNotNull(history);
        assertFalse(history.getData().isEmpty());
    }

    @Test
    void shouldNotReturnNullEmptyHistoricPriceMap() throws IOException, OutOfCallsException, InvalidParameterException {
        Map bitcoinPriceAt = api.historic.getPriceAtTime("BTC", "USD,EUR,ETH", 1515190000);
        assertNotNull(bitcoinPriceAt);
        assertFalse(bitcoinPriceAt.isEmpty());
    }

    @Test
    void shouldNotReturnNullAverage() throws IOException, OutOfCallsException, InvalidParameterException {
        double dayAverage = api.historic.getDayAverage("BTC", "USD");
        assertTrue(dayAverage > 0);
    }

    @Test
    void shouldNotReturnNullEmptyExchangeAverage() throws IOException, OutOfCallsException, InvalidParameterException {
        Market.ExchangeAverage exchangeAverage = api.market.getExchangeAverage("BTC", "USD", "Coinbase,Kraken,Bitstamp");
        assertNotNull(exchangeAverage);
    }

    @Test
    void shouldNotReturnNullEmptyMarketAverage() throws IOException, OutOfCallsException, InvalidParameterException {
        Map<String, Double> btcPrice = api.market.getPrice("BTC", "USD,EUR");
        assertNotNull(btcPrice);
        assertFalse(btcPrice.isEmpty());
    }

    @Test
    void shouldNotReturnNullEmptyMultiPrice() throws IOException, OutOfCallsException, InvalidParameterException {
        Map<String, Map<String, Double>> btcETHPrice = api.market.getMultiPrice("BTC,ETH", "USD,EUR");
        assertNotNull(btcETHPrice);
        assertFalse(btcETHPrice.isEmpty());
    }

    @Test
    void shouldNotReturnNullEmptyMultiFull() throws IOException, OutOfCallsException, InvalidParameterException {
        Map<String, Map<String, Market.toSym>> multiFull = api.market.getMultiFull("BTC,ETH", "USD,EUR");
        assertNotNull(multiFull);
        assertFalse(multiFull.isEmpty());
    }

    @Test
    void shouldNotReturnNullEmptyTopVolumes() throws IOException, OutOfCallsException, InvalidParameterException {
        List<Market.Coin> usdTopVol = api.market.getTopVolumes("USD");
        assertNotNull(usdTopVol);
        assertFalse(usdTopVol.isEmpty());
    }

    @Test
    void shouldNotReturnNullEmptyTopPairs() throws IOException, OutOfCallsException, InvalidParameterException {
        List<Market.Pair> topPairs = api.market.getTopPairs("BTC");
        assertNotNull(topPairs);
        assertFalse(topPairs.isEmpty());
    }

    @Test
    void shouldNotReturnNullEmptyMiningContracts() throws IOException, OutOfCallsException {
        Mining.Contracts contracts = api.mining.getContracts();
        assertNotNull(contracts);
        assertFalse(contracts.getContracts().isEmpty());
    }

    @Test
    void shouldNotReturnNullEmptyMiningHardware() throws IOException, OutOfCallsException {
        Mining.Equipment equipment = api.mining.getEquipment();
        assertNotNull(equipment);
        assertFalse(equipment.getEquipment().isEmpty());
    }
}
