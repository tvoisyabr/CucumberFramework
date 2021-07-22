package utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatabaseUtils {

    public static Connection getConnection() {
        ConfigReader.readProperties(Constants.CONFIGURATION_FILEPATH);
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(ConfigReader.getPropertyValue("dbUrl"),
                                                     ConfigReader.getPropertyValue("dbUsername"),
                                                     ConfigReader.getPropertyValue("dbPassword"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }

    public static ResultSet getResultSet(String query) {
        Connection connection = getConnection();
        ResultSet resultSet = null;
        Statement statement = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return resultSet;
    }

    public static List<Map<String, String>> getTableDataAsList(String query) {
        ResultSet resultSet = getResultSet(query);
        ResultSetMetaData resultSetMetaData= null;
        List<Map<String, String>> table = new ArrayList<>();
        Map<String, String> rowMap = null;
        try {
            resultSetMetaData = resultSet.getMetaData();
            while (resultSet.next()) {
                rowMap = new HashMap<>();
                for (int i = 1; i <= resultSetMetaData.getColumnCount() ; i++) {
                    rowMap.put(resultSetMetaData.getColumnName(i), resultSet.getString(i));
                }
                table.add(rowMap);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return table;
    }
}
