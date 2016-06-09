package by.it.academy.utils;

import org.hibernate.cfg.DefaultNamingStrategy;

/**
 * Class for tables and fields names.
 * Adding 'T_' to tables name.
 * Adding 'F_'to fields names.
 * Created by IPahomov on 22.04.2016.
 */
public class CostumNamingStrategy extends DefaultNamingStrategy {

    @Override
    public String classToTableName(String className) {
        return "T_" + super.classToTableName(className).toUpperCase();
    }

    @Override
    public String propertyToColumnName(String propertyName) {
        return "F_" + super.propertyToColumnName(propertyName).toUpperCase();
    }

    @Override
    public String tableName(String tableName) {
        return super.tableName(tableName);
    }

    @Override
    public String columnName(String columnName) {
        return super.columnName(columnName);
    }
}
