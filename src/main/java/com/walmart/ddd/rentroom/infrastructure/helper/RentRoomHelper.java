package com.walmart.ddd.rentroom.infrastructure.helper;

import java.util.Date;

import org.joda.time.Duration;


public class RentRoomHelper {

    private RentRoomHelper() {
    }
    
    public static double getTotalPrice(double unitPrice, Date checkInDate, Date checkOutDate) {
        double days = (double) countDaysBetweenDates(checkInDate, checkOutDate);

        return unitPrice * days;
    }

    private static int countDaysBetweenDates(Date checkInDate, Date checkOutDate) {
        Duration duration = new Duration(checkInDate.getTime(), checkOutDate.getTime());
        
        return duration.toStandardDays().getDays() + 1;
    }

}
