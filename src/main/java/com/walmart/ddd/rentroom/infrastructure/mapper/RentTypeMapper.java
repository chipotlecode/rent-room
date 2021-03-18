package com.walmart.ddd.rentroom.infrastructure.mapper;

import com.walmart.ddd.rentroom.domain.model.RentType;
import com.walmart.ddd.rentroom.infrastructure.model.RentTypeDTO;

public class RentTypeMapper {

    private RentTypeMapper() {
        
    }
    
    public static RentTypeDTO parse(RentType rentType) {
        return new RentTypeDTO(
            rentType.getRentTypeId(),
            rentType.getName()
        );
    }

}
