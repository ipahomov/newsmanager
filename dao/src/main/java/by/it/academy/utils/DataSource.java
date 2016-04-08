package by.it.academy.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.log4j.Logger;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;


public class DataSource {
    final static Logger logger = Logger.getLogger(DataSource.class);
    private static DataSource dataSource;
    private ComboPooledDataSource cpds;

    private DataSource() {
        InputStream inputStream = DataSource.class.getClassLoader().getResourceAsStream("db.properties");
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            logger.error("Error load properties", e);
        }
        try {
            cpds = new ComboPooledDataSource();
            cpds.setDriverClass(properties.getProperty("driver"));
            cpds.setJdbcUrl(properties.getProperty("dbURL"));
            cpds.setUser(properties.getProperty("username"));
            cpds.setPassword(properties.getProperty("password"));

            // settings c3p0
            cpds.setMinPoolSize(5);
            cpds.setAcquireIncrement(5);
            cpds.setMaxPoolSize(20);
            cpds.setMaxStatements(150);
            cpds.setMaxStatementsPerConnection(100);

        } catch (PropertyVetoException e) {
            logger.info(e);
        }

    }

    public static DataSource getInstance() {
        if (dataSource == null) {
            dataSource = new DataSource();
        }
        return dataSource;
    }

    public Connection getConnection() throws SQLException {
        return this.cpds.getConnection();
    }

}
