package com.bybit.api.examples.http.sync;

import com.bybit.api.client.config.BybitApiConfig;
import com.bybit.api.client.domain.affiliate.AffiliateDataRequest;
import com.bybit.api.client.domain.user.*;
import com.bybit.api.client.restApi.BybitApiAffiliateRestClient;
import com.bybit.api.client.service.BybitApiClientFactory;

import java.util.List;
import java.util.Map;

public class AffiliateExample {
    public static void main(String[] args) {

        BybitApiAffiliateRestClient client = BybitApiClientFactory.newInstance("111", "222", BybitApiConfig.MAINNET_DOMAIN).newAffiliateRestClient();
        System.out.println(client);
        AffiliateDataRequest affUserListRequest = AffiliateDataRequest.builder().size(1000).build();
        Object affUserList = client.affUserList(affUserListRequest);
        System.out.println(affUserList);



    }
}
