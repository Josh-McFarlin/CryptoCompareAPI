package me.joshmcfarlin.cryptocompareapi;

import me.joshmcfarlin.cryptocompareapi.Utils.OutOfCallsException;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class APITest {
    @Test
    void shouldReturnCoinListWithCoins() throws IOException, OutOfCallsException {
        Coins.CoinList coinList = Coins.getCoinList();
        assertNotNull(coinList);
        assertFalse(coinList.coins.isEmpty());
        assertEquals("BTC", coinList.coins.get("BTC").name);
    }

    @Test
    void shouldReturnExchangeListWithExchanges() throws IOException, OutOfCallsException {
        Exchanges.ExchangeList exchangeList = Exchanges.getAllExchanges();
        assertNotNull(exchangeList);
        assertFalse(exchangeList.exchanges.isEmpty());
        assertNotNull(exchangeList.exchanges.get("Cryptsy").coins.get("BTC"));
    }

    @Test
    void shouldNotReturnNullEmptyNewsList() throws IOException, OutOfCallsException {
        List<News.NewsProvider> newsProviders = News.NewsProviderList();
        assertNotNull(newsProviders);
        assertFalse(newsProviders.isEmpty());

        List<News.NewsStory> newsList = News.NewsList();
        assertNotNull(newsList);
        assertFalse(newsList.isEmpty());
    }

    @Test
    void shouldReturnNewsListWithNews() throws IOException, OutOfCallsException {
        List<News.NewsProvider> newsProviders = News.NewsProviderList();
        assertFalse(newsProviders.isEmpty());
        assertNotNull(newsProviders.get(0).key);

        List<News.NewsStory> newsList = News.NewsList();
        assertFalse(newsList.isEmpty());
        assertNotNull(newsList.get(0).title);
    }

    @Test
    void shouldNotReturnNullSocialStats() throws IOException, OutOfCallsException {
        Social.SocialStats socialStats = Social.getStats(1182);
        assertNotNull(socialStats);
        assertNotNull(socialStats.data);
    }

    @Test
    void shouldNotReturnNullEmptyHistoricData() throws IOException, OutOfCallsException {
        Historic.History history = Historic.getDay("BTC", "USD", 30);
        assertNotNull(history);
        assertFalse(history.data.isEmpty());
    }

    @Test
    void shouldNotReturnNullEmptyHistoricPriceMap() throws IOException, OutOfCallsException {
        Map bitcoinPriceAt = Historic.getPriceAtTime(1515190000, "BTC", "USD", "EUR", "ETH");
        assertNotNull(bitcoinPriceAt);
        assertFalse(bitcoinPriceAt.isEmpty());
    }

    @Test
    void shouldNotReturnNullAverage() throws IOException, OutOfCallsException {
        double dayAverage = Market.getDayAverage("BTC", "USD");
        assertTrue(dayAverage > 0);
    }

    @Test
    void shouldNotReturnNullEmptyExchangeAverage() throws IOException, OutOfCallsException {
        Market.ExchangeAverage exchangeAverage = Market.getExchangeAverage("BTC", "USD", "Coinbase", "Kraken", "Bitstamp");
        assertNotNull(exchangeAverage);
    }

    @Test
    void shouldNotReturnNullEmptyMarketAverage() throws IOException, OutOfCallsException {
        Map<String, Double> btcPrice = Market.getPrice("BTC", "USD", "EUR");
        assertNotNull(btcPrice);
        assertFalse(btcPrice.isEmpty());
    }

    @Test
    void shouldNotReturnNullEmptyMultiPrice() throws IOException, OutOfCallsException {
        Map<String, Map<String, Double>> btcETHPrice = Market.getMultiPrice(new String[]{"BTC", "ETH"}, new String[]{"USD", "EUR"});
        assertNotNull(btcETHPrice);
        assertFalse(btcETHPrice.isEmpty());
    }

    @Test
    void shouldNotReturnNullEmptyMultiFull() throws IOException, OutOfCallsException {
        Map<String, Map<String, Market.toSym>> multiFull = Market.getMultiFull(new String[] {"BTC", "ETH"}, new String[] {"USD", "EUR"});
        assertNotNull(multiFull);
        assertFalse(multiFull.isEmpty());
    }

    @Test
    void shouldNotReturnNullEmptyTopVolumes() throws IOException, OutOfCallsException {
        List<Market.Coin> usdTopVol = Market.getTopVolumes("USD");
        assertNotNull(usdTopVol);
        assertFalse(usdTopVol.isEmpty());
    }

    @Test
    void shouldNotReturnNullEmptyTopPairs() throws IOException, OutOfCallsException {
        List<Market.Pair> topPairs = Market.getTopPairs("BTC");
        assertNotNull(topPairs);
        assertFalse(topPairs.isEmpty());
    }

    @Test
    void shouldNotReturnNullEmptyMiningContracts() throws IOException, OutOfCallsException {
        Mining.Contracts contracts = Mining.getContracts();
        assertNotNull(contracts);
        assertFalse(contracts.contracts.isEmpty());
    }

    @Test
    void shouldNotReturnNullEmptyMiningHardware() throws IOException, OutOfCallsException {
        Mining.Equipment equipment = Mining.getEquipment();
        assertNotNull(equipment);
        assertFalse(equipment.equipment.isEmpty());
    }
}
