package src.modulo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConsultarContaBancaria {
    public static void main(String[] args) {
        try {
            Connection conn = ModuloConexao.moduloConexao();
            if (conn != null) {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM contaBancaria");
                while (rs.next()) {
                    int id = rs.getInt("id"); // ajuste o nome da coluna conforme seu banco
                    String nome = rs.getString("nome"); // ajuste o nome da coluna conforme seu banco
                    double saldo = rs.getDouble("saldo"); // ajuste o nome da coluna conforme seu banco
                    System.out.println("ID: " + id + ", Nome: " + nome + ", Saldo: " + saldo);
                }
                rs.close();
                stmt.close();
                conn.close();
            } else {
                System.out.println("Não foi possível conectar ao banco de dados.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao consultar: " + e.getMessage());
        }
    }
}
