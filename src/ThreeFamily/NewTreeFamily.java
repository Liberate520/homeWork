package ThreeFamily;

import java.sql.*;

import Human.Human;

public class NewTreeFamily {
    private static String dataBase = "src/BazaD.db";
    private static Connection connection = null;

    public static void main(String[] args) throws SQLException {
        Statement statement = null;
        ResultSet result = null;
        String values = "";
        String SQL = "";

        try {
            System.out.println("Соединение установлено");
            connection = DriverManager.getConnection(dataBase);


        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            connection.close();
        }
        System.out.println("Соединение закрыто");
    }
}
