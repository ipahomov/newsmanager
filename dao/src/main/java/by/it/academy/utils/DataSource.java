package by.it.academy.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.log4j.Logger;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Class realizes connections to database through the pool connections c3p0.
 * Database - MySQL, table - newsmanager.
 * db.properties file contain connections init params.
 */
public class DataSource {
    final static Logger logger = Logger.getLogger(DataSource.class);
    private static DataSource dataSource;
    private ComboPooledDataSource cpds;

    /**
     * Connection to database
     */
    private DataSource() {
        InputStream inputStream = DataSource.class.getClassLoader().getResourceAsStream("db.properties");
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            logger.error("Error load properties", e);
        }
        cpds = new ComboPooledDataSource();
        try {
            cpds.setDriverClass(properties.getProperty("driver"));
            cpds.setJdbcUrl(properties.getProperty("dbURL"));
            cpds.setUser(properties.getProperty("username"));
            cpds.setPassword(properties.getProperty("password"));

            // settings c3p0
            cpds.setMinPoolSize(5);
            cpds.setAcquireIncrement(5);
            cpds.setMaxPoolSize(20);
            cpds.setMaxStatements(150);
            cpds.setMaxStatementsPerConnection(40);

        } catch (PropertyVetoException e) {
            logger.info(e);
        }

    }

    /**
     * Singleton pattern
     * @return DataSource
     */
    public static synchronized DataSource getInstance() {
        if (dataSource == null) {
            dataSource = new DataSource();
        }
        return dataSource;
    }

    /**
     * This method getting connection
     * @return Connection connection
     */
    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = this.cpds.getConnection();
        } catch (SQLException e) {
            logger.error(e);
        }
        return connection;
    }


}
