package com.matheusmaciel.city_locator_br.infrastucture.cities.entities;

import jakarta.persistence.AttributeConverter;
import org.springframework.data.geo.Point;
import org.postgresql.geometric.PGpoint;

public class PointConverter implements AttributeConverter<Point, PGpoint> {

    @Override
    public PGpoint convertToDatabaseColumn(Point attribute) {
        if (attribute == null) {
            return null;
        }
        return new PGpoint(attribute.getX(), attribute.getY());
    }

    @Override
    public Point convertToEntityAttribute(PGpoint dbData) {
        if (dbData == null) {
            return null;
        }
        return new Point(dbData.x, dbData.y);
    }
}
