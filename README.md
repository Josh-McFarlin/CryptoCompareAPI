# CryptoCompareAPI
Java implementation of CryptoCompare API service

## Installation
Maven:
```
<dependency>
    <groupId>me.joshmcfarlin.CryptoCompareAPI</groupId>
    <artifactId>CryptoCompareAPI</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```

## Usage
```java
double dayAverage = Market.getDayAverage("BTC", "USD");
System.out.println("Bitcoin day average:");
System.out.println(dayAverage);

Market.ExchangeAverage exchangeAverage = Market.getExchangeAverage("BTC", "USD", "Coinbase", "Kraken", "Bitstamp");
System.out.println("Bitcoin average from Coinbase, Kraken, and Bitstamp:");
System.out.println(exchangeAverage.high24Hour);

Map<String, Double> btcPrice = Market.getPrice("BTC", "USD", "EUR");
System.out.println("Bitcoin price in USD and EUR:");
System.out.println(btcPrice);
```

An example is provided in the Maven test sources.

## License
This project is developed under the MIT license. This license can be found at [LICENSE](LICENSE).
