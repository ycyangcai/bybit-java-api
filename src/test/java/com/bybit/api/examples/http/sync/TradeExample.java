package com.bybit.api.examples.http.sync;

import com.bybit.api.client.config.BybitApiConfig;
import com.bybit.api.client.domain.position.ExecType;
import com.bybit.api.client.domain.trade.request.TradeOrderRequest;
import com.bybit.api.client.domain.*;
import com.bybit.api.client.domain.trade.*;
import com.bybit.api.client.restApi.BybitApiTradeRestClient;
import com.bybit.api.client.service.BybitApiClientFactory;


/**
 * Examples on how to place orders, cancel them, amend them and query them
 */
public class TradeExample {
    public static void main(String[] args) {
        BybitApiTradeRestClient client = BybitApiClientFactory.newInstance("YOUR_API_KEY", "YOUR_API_SECRET", BybitApiConfig.TESTNET_DOMAIN).newTradeRestClient();

        // Getting a list of history order between 2 years
        TradeOrderRequest orderHistory = TradeOrderRequest.builder().category(CategoryType.LINEAR).limit(10).build();
        System.out.println(client.getOrderHistory(orderHistory));

        // Get all real time orders
        TradeOrderRequest openOrderRequest = TradeOrderRequest.builder().category(CategoryType.SPOT).build();
        Object allOpenOrders = client.getOpenOrders(openOrderRequest);
        System.out.println(allOpenOrders);

        // Create a new order
        TradeOrderRequest newOrderRequest = TradeOrderRequest.builder().category(CategoryType.LINEAR).symbol("XRPUSDT").side(Side.BUY).orderType(TradeOrderType.MARKET).qty("10").build();
        Object newOrder = client.createOrder(newOrderRequest);
        System.out.println(newOrder);

        // Create an AmendOrderRequest
        TradeOrderRequest amendOrderRequest = TradeOrderRequest.builder().orderId("1523347543495541248").category(CategoryType.LINEAR).symbol("XRPUSDT")
                .price("0.5")  // setting a new price, for example
                .qty("15")  // and a new quantity
                .build();
        Object amendedOrder = client.amendOrder(amendOrderRequest);
        System.out.println(amendedOrder);

        // Create a CancelOrderRequest
        TradeOrderRequest cancelOrderRequest = TradeOrderRequest.builder().category(CategoryType.SPOT).symbol("XRPUSDT").orderId("1523347543495541248").build();
        Object canceledOrder = client.cancelOrder(cancelOrderRequest);
        System.out.println(canceledOrder);

        // Get Trade History
        TradeOrderRequest tradeHistoryRequest = TradeOrderRequest.builder().category(CategoryType.LINEAR).symbol("BTCUSDT").execType(ExecType.Trade).limit(100).build();
        System.out.println(client.getTradeHistory(tradeHistoryRequest));

        // Set DCP Options
        TradeOrderRequest setDcpOptionsRequest = TradeOrderRequest.builder().timeWindow(40).build();
        System.out.println(client.setDisconnectCancelAllTime(setDcpOptionsRequest));

        // Get Borrow Quota
        TradeOrderRequest getBorrowQuotaRequest = TradeOrderRequest.builder().category(CategoryType.SPOT).symbol("BTCUSDT").side(Side.BUY).build();
        System.out.println(client.getBorrowQuota(getBorrowQuotaRequest));
    }
}
