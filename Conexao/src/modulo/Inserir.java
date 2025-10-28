package src.modulo;

import java.rmi.ConnectException;
import java.sql.*;

public class Inserir {
    Connection connection = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public Inserir(String nome, String idade, String sexo) {
        connection = ModuloConexao.moduloConexao();
        String sql = "INSERT INTO usuario (nome, idade, sexo) VALUES (?,?,?)";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, nome);
            ps.setString(2, idade);
            ps.setString(3, sexo);
            ps.executeUpdate();
            System.out.println("Preenchido");
        } catch (Exception e) {
            System.out.println("esse erro: " + e);
        }

    }
}