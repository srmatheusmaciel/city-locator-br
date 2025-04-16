package com.matheusmaciel.city_locator_br.infrastucture.cities.entities;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.springframework.data.geo.Point;

@Converter
public class PointConverter implements AttributeConverter<Point, String> {

    @Override
    public String convertToDatabaseColumn(Point point) {
        if (point == null) return null;
        return "(" + point.getX() + "," + point.getY() + ")";
    }

    @Override
    public Point convertToEntityAttribute(String dbData) {
        if (dbData == null || dbData.isBlank()) return null;

        try {

            dbData = dbData.replace("(", "").replace(")", "");
            String[] parts = dbData.split(",");
            double x = Double.parseDouble(parts[0]); // longitude
            double y = Double.parseDouble(parts[1]); // latitude
            return new Point(x, y);
        } catch (Exception e) {
            throw new IllegalArgumentException("Erro ao converter lat_lon: " + dbData, e);
        }
    }
}
