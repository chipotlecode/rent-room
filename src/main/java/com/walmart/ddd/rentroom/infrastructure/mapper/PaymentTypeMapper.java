package com.walmart.ddd.rentroom.infrastructure.mapper;

import com.walmart.ddd.rentroom.domain.model.PaymentType;
import com.walmart.ddd.rentroom.infrastructure.model.PaymentTypeDTO;

public class PaymentTypeMapper {
 
    private PaymentTypeMapper() {

    }

    public static PaymentTypeDTO parse(PaymentType paymentType) {
        return new PaymentTypeDTO(
            paymentType.getPaymentTypeId(),
            paymentType.getName()
        );
    }

}
