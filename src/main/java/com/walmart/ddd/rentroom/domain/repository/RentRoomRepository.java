package com.walmart.ddd.rentroom.domain.repository;

import java.util.Date;
import java.util.Optional;

import com.walmart.ddd.rentroom.domain.model.RentRoom;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RentRoomRepository extends CrudRepository<RentRoom, Long> {
    
    @Query(
        value = "select rentroom0_.rent_id as rent_id1_2_, rentroom0_.check_in_date as check_in2_2_," +
        " rentroom0_.check_out_date as check_ou3_2_, rentroom0_.payment_type_payment_type_id as payment_5_2_," +
        " rentroom0_.person_person_id as person_p6_2_, rentroom0_.rent_type_rent_type_id as rent_typ7_2_," +
        " rentroom0_.room_room_id as room_roo8_2_, rentroom0_.total_price as total_pr4_2_" +
        " from rent_room rentroom0_ left outer join room room1_ " +
        " on rentroom0_.room_room_id=room1_.room_id " +
        " where room1_.room_id=?1 " +
        " and ((rentroom0_.check_in_date between ?2 and ?3)" +
        " or (rentroom0_.check_out_date between ?2 and ?3))",
        nativeQuery = true
    )
    public Optional<RentRoom> findByRoomAndCheckInDateOrCheckOutDate(Short roomId, Date checkInDate, Date checkOutDate);


    public Optional<RentRoom> findByRoomRoomIdAndCheckInDateIsBetweenOrCheckOutDateIsBetween(Short roomId, Date checkInDate, Date checkOutDate, Date checkInDate2, Date checkOutDate2);

}
