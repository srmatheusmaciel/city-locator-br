package com.matheusmaciel.city_locator_br.infrastucture.utils;

public class StringLocationUtils {
    public static Double[] transform(String geolocation) {
        String result = geolocation.replace("(", "").replace(")", "");
        String[] strings = result.trim().split(",");
        return new Double[] {Double.valueOf(strings[0]), Double.valueOf(strings[1])};
    }
}