package com.propertymanagement.portal.dto.request;

import com.propertymanagement.portal.domain.enums.OfferType;
import lombok.Data;

@Data
public class MakeOfferRequest {
    private double offerAmount;
    private OfferType offerType;
}

