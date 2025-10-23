package src.App;

import src.App.ContaBancaria;
import src.Modulo.ModuloConexao;
import java.sql.*;

public class ContaBancariaDAO {
    public void inserir(ContaBancaria contaBancaria) {
        String sql = "INSERT INTO contaBancaria (numeroConta, saldo, titular) VALUES (?,?,?)";
        try {
            Connection connection = ModuloConexao.Conexao();
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, contaBancaria.getNumeroConta());
            pst.setFloat(2, contaBancaria.getSaldo());
            pst.setString(3, contaBancaria.getTitular());
            pst.executeUpdate();
            System.out.println("Dados preenchido");
        } catch (Exception e) {
            System.out.println("Erro em: " + e);
        }
    }

    public void deletar(int id) {
        String sql = "DELETE FROM contaBancaria WHERE id = ?";
        try {
            Connection connection = ModuloConexao.Conexao();
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, id);
            pst.executeUpdate();
            System.out.println("Linha "+id+" deletada");
        } catch (Exception e) {
            System.out.println("Erro função inserir"+e);
        }
        
    }
}
