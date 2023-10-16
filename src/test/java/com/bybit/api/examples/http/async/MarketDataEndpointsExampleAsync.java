package com.bybit.api.examples.http.async;

import com.bybit.api.client.domain.ProductType;
import com.bybit.api.client.domain.market.DataRecordingPeriod;
import com.bybit.api.client.domain.market.InstrumentStatus;
import com.bybit.api.client.domain.market.MarketDataRequest;
import com.bybit.api.client.service.BybitApiClientFactory;
import com.bybit.api.client.domain.market.MarketInterval;
import com.bybit.api.client.BybitApiAsyncRestClient;

public class MarketDataEndpointsExampleAsync {
    public static void main(String[] args) {
        BybitApiClientFactory factory = BybitApiClientFactory.newInstance();
        BybitApiAsyncRestClient client = factory.newAsyncRestClient();

        var marketKLineRequest = MarketDataRequest.builder().category(ProductType.LINEAR).symbol("BTCUSDT").marketInterval(MarketInterval.WEEKLY).build();
        // Weekly Marketklin for a symbol
        client.getMarketLinesData(marketKLineRequest, System.out::println);

        // Weekly market price Kline for a symbol
        client.getMarketPriceLinesData(marketKLineRequest, System.out::println);

        // Weekly index price Kline for a symbol
        client.getIndexPriceLinesData(marketKLineRequest, System.out::println);

        // Weekly premium index price Kline for a symbol
        client.getPremiumIndexPriceLinesData(marketKLineRequest, System.out::println);

        // Get server time
        client.getServerTime(System.out::println);

        // Get Instrument info
        var instrumentInfoRequest = MarketDataRequest.builder().category(ProductType.SPOT)
                .symbol("BTCUSDT")
                .instrumentStatus(InstrumentStatus.TRADING)
                .limit(500)
                .build();
        client.getInstrumentsInfo(instrumentInfoRequest,System.out::println);

        // Get orderbook
        var orderbookRequest = MarketDataRequest.builder().category(ProductType.SPOT).symbol("BTCUSDT").build();
        client.getMarketOrderBook(orderbookRequest,System.out::println);

        // Get market tickers
        var tickerReueqt = MarketDataRequest.builder().category(ProductType.SPOT).symbol("BTCUSDT").build();
        client.getMarketTickers(tickerReueqt, System.out::println);

        // Get funding history
        var fundingHistoryRequest = MarketDataRequest.builder().category(ProductType.LINEAR).symbol("BTCUSD")
                .startTime(1632046800000L) // Example start time
                .endTime(1632133200000L)   // Example end time
                .limit(150)
                .build();
        client.getFundingHistory(fundingHistoryRequest, System.out::println);

        // Get Open Interest data
        var openInterest = MarketDataRequest.builder().category(ProductType.LINEAR).symbol("BTCUSDT").marketInterval(MarketInterval.FIVE_MINUTES).build();
        client.getOpenInterest(openInterest, System.out::println);

        // Get Recent Trade Data
        var recentTrade = MarketDataRequest.builder().category(ProductType.OPTION).symbol("ETH-30JUN23-2050-C").build();
        client.getRecentTradeData(recentTrade, System.out::println);

        // Get Historical Volatility
        var historicalVolatilityRequest = MarketDataRequest.builder().category(ProductType.OPTION).optionPeriod(7).build();
        client.getHistoricalVolatility(historicalVolatilityRequest, System.out::println);

        // Get Insurance data
        client.getInsurance("BTC", System.out::println); // BTC Insurance

        // Get Risk Limit
        var riskMimitRequest = MarketDataRequest.builder().category(ProductType.INVERSE).symbol("ADAUSD").build();
        client.getRiskLimit(riskMimitRequest, System.out::println);

        // Get delivery price
        var deliveryPriceRequest = MarketDataRequest.builder().category(ProductType.OPTION)
                .baseCoin("BTC")
                .limit(10)
                .build();
        client.getDeliveryPrice(deliveryPriceRequest, System.out::println);

        // Get Long Short Ratio
        var marketAccountRatioRequest = MarketDataRequest.builder().category(ProductType.LINEAR)
                .symbol("BTCUSDT")
                .dataRecordingPeriod(DataRecordingPeriod.FIFTEEN_MINUTES)
                .limit(10)
                .build();
        client.getMarketAccountRatio(marketAccountRatioRequest, System.out::println);
    }
}
