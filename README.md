# CryptoCompareAPI
A Java implementation of the [CryptoCompare API service.](https://min-api.cryptocompare.com/)

## Downloading

#### Gradle
```
repositories {
    maven { url 'https://jitpack.io' }
}

dependencies {
    implementation 'com.github.Josh-McFarlin:CryptoCompareAPI:master-SNAPSHOT'
}
```

#### Maven
```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```
```xml
<dependency>
    <groupId>com.github.Josh-McFarlin</groupId>
    <artifactId>CryptoCompareAPI</artifactId>
    <version>master-SNAPSHOT</version>
</dependency>
```

## Usage
```java
public class Test {
    private CryptoCompareAPI api = new CryptoCompareAPI();
    
    public static void main(String[] args) {
        double dayAverage = api.historic.getDayAverage("BTC", "USD");
            System.out.println("Bitcoin day average:");
            System.out.println(dayAverage);
    
            Market.ExchangeAverage exchangeAverage = api.market.getExchangeAverage("BTC", "USD", "Coinbase,Kraken,Bitstamp");
            System.out.println("Bitcoin average from Coinbase, Kraken, and Bitstamp:");
            System.out.println(exchangeAverage.getHigh24Hour());
    
            Map<String, Double> btcPrice = api.market.getPrice("BTC", "USD,EUR");
            System.out.println("Bitcoin price in USD and EUR:");
            System.out.println(btcPrice);
    }
}
```

An example is provided in the test sources.

## Documentation

Documentation is provided at [https://joshmcfarlin.me/CryptoCompareAPI/](https://joshmcfarlin.me/CryptoCompareAPI/)

## License
This project is developed under the MIT license. This can be found at [LICENSE](LICENSE).
