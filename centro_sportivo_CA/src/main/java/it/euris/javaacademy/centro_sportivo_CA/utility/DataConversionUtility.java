package it.euris.javaacademy.centro_sportivo_CA.utility;

import java.time.LocalDateTime;

public class DataConversionUtility {
    private DataConversionUtility(){}
    public static String numberToString(Number value){
        return value == null ? null : value.toString();
    }
    public static Long stringToLong(String value){
        return value == null ? null : Long.parseLong( value);
    }
    public static LocalDateTime stringToLocalDateTime(String value){
        return value == null ? null : LocalDateTime.parse(value);

    }
    public static String localDateTimeToString(LocalDateTime value){
        return value == null ? null : value.toString();
    }
}
