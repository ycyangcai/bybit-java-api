package com.bybit.api.client.restApi;

import com.bybit.api.client.domain.affiliate.AffiliateDataRequest;
import com.bybit.api.client.domain.preupgrade.PreUpgradeDataRequest;
import com.bybit.api.client.domain.user.UserDataRequest;

public interface BybitApiAffiliateRestClient {
    // User Data
    Object affUserList(AffiliateDataRequest affiliateDataRequest);

    Object affCustomerInfo(AffiliateDataRequest affiliateDataRequest);

}
