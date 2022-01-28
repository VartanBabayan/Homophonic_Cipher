package pl.polsl.lab.vartan.babayan.modelcipher;

import java.sql.*;
import java.util.ArrayList;

/**
 * class that handles working with dbms
 *
 * @author vartan babayan
 * @version 1.0
 */
public class DBManager {
    /**
     * main instance of a singleton
     */
    private static DBManager dbInstance;

    /**
     * schema's name inside db
     */
    private final String schema = "WEBH";

    /**
     * table's name inside db
     */
    private final String table = "HISTORY";

    /**
     * url to properly connect to db
     */
    private final String dbUrl = "jdbc:derby:/home/vartan/Downloads/db-derby-10.14.2.0-bin/WebHistory";

    /**
     * jdbc connector to db
     */
    private Connection connection;

    /**
     * private constructor to follow singleton pattern
     */
    private DBManager() {
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            this.connection = DriverManager.getConnection(dbUrl);
            this.processSchema();
        } catch (ClassNotFoundException | SQLException cnfe) {
            System.err.println(cnfe.getMessage());
        }
    }

    /**
     * return reference of the main singleton object
     *
     * @return - main instance
     */
    public static DBManager getInstance() {
        if (dbInstance == null) {
            dbInstance = new DBManager();
        }
        return dbInstance;
    }

    /**
     * check is current schema exist inside dbmc
     *
     * @return - true if exists, false otherwise
     * @throws SQLException - exception in case of incvalid connection
     */
    private boolean isSchemaExist() throws SQLException {
        DatabaseMetaData metaData = connection.getMetaData();
        ResultSet res = metaData.getSchemas();
        while (res.next()) {
            String schema = res.getString(1);
            if (schema.equals("WEBH")) {
                res.close();
                return true;
            }
        }
        return false;
    }

    /**
     * create schema inside dbmc
     *
     * @throws SQLException - exception in case of incvalid connection
     */
    private void createSchema() throws SQLException {
        String query = "CREATE SCHEMA " + schema;
        Statement statement = connection.createStatement();
        statement.execute(query);
    }

    private void createTable() throws SQLException {
        String query = "CREATE TABLE " + table + " (ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY " + "(START WITH 1, INCREMENT BY 1) PRIMARY KEY," + " MSG LONG VARCHAR," + " ENCODED_MSG LONG VARCHAR, " + "FLAG CHAR(1))";
        Statement statement = connection.createStatement();
        statement.executeQuery(query);
    }

    /**
     * process schema configuration
     */
    private void processSchema() {
        try {
            if (!isSchemaExist()) {
                createSchema();
                createTable();
            }

            connection.setSchema(schema);
        } catch (SQLException sqle) {
            System.err.println(sqle.getMessage());
        }
    }

    /**
     * check is connection valid
     *
     * @return - true if connection is valid, false otherwise
     */
    public boolean checkConnection() {
        return connection != null;
    }

    /**
     * create a record and insert into db
     *
     * @param record - new record contains a tuple of data for db
     * @return - true if created a record successfully, false otherwise
     * @throws - in case of problems with dbms
     */
    public boolean create(History record) throws SQLException {
        PreparedStatement preparedStatement = null;
        try {
            String query = "INSERT INTO " + schema + "." + table + "(msg, encoded_msg, flag) VALUES (?, ?, ?)";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, record.getMsg());
            preparedStatement.setString(2, record.getEncodedMsg());
            preparedStatement.setString(3, String.valueOf(record.getFlag()));
            preparedStatement.execute();
        } catch (SQLException sqle) {
            System.err.println(sqle.getMessage());
            return false;
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
        return true;
    }

    /**
     * read all records from db
     *
     * @return list of records read from db
     * @throws - in case of problems with dbms
     */
    public ArrayList<History> read() throws SQLException {
        ArrayList<History> records = new ArrayList<>();

        ResultSet result = null;
        try {
            String query = "SELECT * FROM " + table;
            Statement statement = connection.createStatement();
            result = statement.executeQuery(query);

            while (result.next()) {
                String msg = result.getString(2);
                String encoded_msg = result.getString(3);
                Character flag = result.getString(4).charAt(0);

                History record = new History(msg, encoded_msg, flag);
                records.add(record);
            }
        } catch (SQLException sqle) {
            System.err.println(sqle.getMessage());
        } finally {
            if (result != null) {
                result.close();
            }
        }

        return records;
    }

    /**
     * destroy connection with the schema
     */
    public void destroyConnection() {
        try {
            connection.close();
        } catch (SQLException sqle) {
            System.err.println(sqle.getMessage());
        }
    }
}
