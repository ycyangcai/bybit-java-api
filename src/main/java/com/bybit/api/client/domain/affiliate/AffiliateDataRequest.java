package com.bybit.api.client.domain.affiliate;

import com.bybit.api.client.domain.user.*;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@ToString
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AffiliateDataRequest {

    private Integer size;

    private String cursor;

    private Boolean needDeposit;

    private Boolean need30;

    private Boolean need365;

    private String uid;
}
