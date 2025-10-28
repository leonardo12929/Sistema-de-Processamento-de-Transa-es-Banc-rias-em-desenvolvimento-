package src.modulo;
import java.sql.*;

public class ModuloConexao {
    public static Connection moduloConexao() {
        Connection connection = null;
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/dados";
        String user = "root";
        String password = "mysql";
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
            return connection;
        } catch (Exception e) {
            System.out.println("Erro em:"+e);
            return null;
        }
    }
}