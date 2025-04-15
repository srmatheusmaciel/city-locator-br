package com.matheusmaciel.city_locator_br.infrastucture.cities.entities;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.usertype.UserType;
import org.postgresql.geometric.PGpoint;
import org.springframework.data.geo.Point;

public class PointType implements UserType<Point> {

    @Override
    public int getSqlType() {
        return Types.OTHER;
    }

    @Override
    public Class<Point> returnedClass() {
        return Point.class;
    }

    @Override
    public boolean equals(Point x, Point y) {
        if (x == null || y == null) {
            return (x == null) && (y == null);
        }
        return x.equals(y);
    }

    @Override
    public int hashCode(Point x) {
        return (x == null) ? 0 : x.hashCode();
    }

    @Override
    public Point nullSafeGet(ResultSet rs, int names, SharedSessionContractImplementor session, @Deprecated Object owner)
            throws SQLException {
        PGpoint value = (PGpoint) rs.getObject(names);
        if (value == null) {
            return null;
        }
        return new Point(value.x, value.y);
    }

    @Override
    public void nullSafeSet(PreparedStatement st, Point value, int index,
                            SharedSessionContractImplementor session)
            throws SQLException {
        if (value == null) {
            st.setNull(index, Types.OTHER);
        } else {
            PGpoint pGpoint = new PGpoint(value.getX(), value.getY());
            st.setObject(index, pGpoint, Types.OTHER);
        }
    }

    @Override
    public Point deepCopy(Point value) {
        if (value == null) {
            return null;
        }
        return new Point(value.getX(), value.getY());
    }

    @Override
    public boolean isMutable() {
        return false;
    }

    @Override
    public Serializable disassemble(Point value) {
        return (Serializable) value;
    }

    @Override
    public Point assemble(Serializable cached, Object owner) {
        return (Point) cached;
    }

    @Override
    public Point replace(Point detached, Point managed, Object owner) {
        return deepCopy(detached);
    }
}