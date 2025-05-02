package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "";
    private static final String USER = "";
    private static final String CLAVE = "";

    public static Connection conectarMySQL() {
        Connection connection = null;
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(URL, USER, CLAVE);

        } catch (SQLException e) {
            if (e instanceof java.sql.SQLNonTransientConnectionException) {
                return connection;
            } else {
                e.printStackTrace();
            }
        }
        return connection;
    }
}
