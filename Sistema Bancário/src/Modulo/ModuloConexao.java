package src.Modulo;

import java.sql.*;

public class ModuloConexao {

    public static Connection Conexao() {
        String url = "jdbc:mysql://localhost:3306/dados";
        String user = "root";
        String password = "mysql";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conectado");
            return connection;
        } catch (Exception e) { 
            System.out.println("Erro em: " + e);
            return null;
        }

    }
}