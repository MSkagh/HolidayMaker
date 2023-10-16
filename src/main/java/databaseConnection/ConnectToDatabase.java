package databaseConnection;

import java.sql.*;

public class ConnectToDatabase {
    public static final ConnectToDatabase instance = new ConnectToDatabase();

    public static ConnectToDatabase getInstance(){
        return instance;
    }
    public void startDatabase() throws SQLException {
        String url = "jdbc:mysql://161.97.144.27:8009";
        String username = "root";
        String password = "bowlingspeedyfins";
        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();
        System.out.println(statement);
        System.out.println(connection);
       /* String sqlQuery = "SELECT * FROM Holiday_maker.test"; //Get from test table
        ResultSet resultSet = statement.executeQuery(sqlQuery);
        resultSet.close();
        */
        statement.close();
        connection.close();
    }
}
