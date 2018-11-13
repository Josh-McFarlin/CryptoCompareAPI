package me.joshmcfarlin.cryptocompareapi;

import me.joshmcfarlin.cryptocompareapi.Exceptions.InvalidParameterException;
import me.joshmcfarlin.cryptocompareapi.Exceptions.OutOfCallsException;
import me.joshmcfarlin.cryptocompareapi.api.*;
import me.joshmcfarlin.cryptocompareapi.models.coin.CoinList;
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
        CoinList coinList = api.coins.getCoinList();
        assertNotNull(coinList);
        assertFalse(coinList.getCoins().isEmpty());
        assertEquals("BTC", coinList.getCoins().get("BTC").getName());
    }

    @Test
    void shouldReturnExchangeListWithExchanges() throws IOException, OutOfCallsException {
        ExchangeList exchangeList = api.exchanges.getAllExchanges();
        assertNotNull(exchangeList);
        assertFalse(exchangeList.getExchanges().isEmpty());
        assertNotNull(exchangeList.getExchanges().get("Cryptsy").getCoins().get("BTC"));
    }

    @Test
    void shouldNotReturnNullEmptyNewsList() throws IOException, OutOfCallsException {
        List<NewsProvider> newsProviders = api.news.newsProviderList();
        assertNotNull(newsProviders);
        assertFalse(newsProviders.isEmpty());

        List<NewsStory> newsList = api.news.newsList();
        assertNotNull(newsList);
        assertFalse(newsList.isEmpty());
    }

    @Test
    void shouldReturnNewsListWithNews() throws IOException, OutOfCallsException {
        List<NewsProvider> newsProviders = api.news.newsProviderList();
        assertFalse(newsProviders.isEmpty());
        assertNotNull(newsProviders.get(0).getKey());

        List<NewsStory> newsList = api.news.newsList();
        assertFalse(newsList.isEmpty());
        assertNotNull(newsList.get(0).getTitle());
    }

    @Test
    void shouldNotReturnNullSocialStats() throws IOException, OutOfCallsException {
        SocialStats socialStats = api.social.getStats(1182);
        assertNotNull(socialStats);
        assertNotNull(socialStats.getData());
    }

    @Test
    void shouldNotReturnNullEmptyHistoricData() throws IOException, OutOfCallsException, InvalidParameterException {
        History history = api.historic.getDay("BTC", "USD", 30);
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
        ExchangeAverage exchangeAverage = api.market.getExchangeAverage("BTC", "USD", "Coinbase,Kraken,Bitstamp");
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
        Map<String, Map<String, ToSym>> multiFull = api.market.getMultiFull("BTC,ETH", "USD,EUR");
        assertNotNull(multiFull);
        assertFalse(multiFull.isEmpty());
    }

    @Test
    void shouldNotReturnNullEmptyTopVolumes() throws IOException, OutOfCallsException, InvalidParameterException {
        List<Coin> usdTopVol = api.market.getTopVolumes("USD");
        assertNotNull(usdTopVol);
        assertFalse(usdTopVol.isEmpty());
    }

    @Test
    void shouldNotReturnNullEmptyTopPairs() throws IOException, OutOfCallsException, InvalidParameterException {
        List<Pair> topPairs = api.market.getTopPairs("BTC");
        assertNotNull(topPairs);
        assertFalse(topPairs.isEmpty());
    }

    @Test
    void shouldNotReturnNullEmptyMiningContracts() throws IOException, OutOfCallsException {
        Contracts contracts = api.mining.getContracts();
        assertNotNull(contracts);
        assertFalse(contracts.getContracts().isEmpty());
    }

    @Test
    void shouldNotReturnNullEmptyMiningHardware() throws IOException, OutOfCallsException {
        Equipment equipment = api.mining.getEquipment();
        assertNotNull(equipment);
        assertFalse(equipment.getEquipment().isEmpty());
    }
}
