package src.App;

import java.util.ArrayList;
import java.util.List;
import src.App.ContaBancaria;
import src.Modulo.ModuloConexao;
import java.sql.*;

public class ContaBancariaDAO {
    public void inserir(ContaBancaria contaBancaria) {
        String sql = "INSERT INTO contaBancaria (numeroConta, saldo, titular) VALUES (?,?,?)";
        try {
            Connection connection = ModuloConexao.Conexao();
            if (connection != null) {
                PreparedStatement pst = connection.prepareStatement(sql);
                pst.setString(1, contaBancaria.getNumeroConta());
                pst.setFloat(2, contaBancaria.getSaldo());
                pst.setString(3, contaBancaria.getTitular());
                pst.executeUpdate();
                System.out.println("Dados preenchido");
                pst.close();
                connection.close();
            } else {
                System.out.println("Erro na conexão com o banco de dados.");
            }
        } catch (Exception e) {
            System.out.println("Erro função inserir" + e);
        }
    }

    public void deletar(int id) {
        String sql = "DELETE FROM contaBancaria WHERE id = ?";
        try {
            Connection connection = ModuloConexao.Conexao();
            if (connection != null) {
                PreparedStatement pst = connection.prepareStatement(sql);
                pst.setInt(1, id);
                pst.executeUpdate();
                System.out.println("Linha " + id + " deletada");
                pst.close();
                connection.close();
            } else {
                System.out.println("Erro na conexão com o banco de dados.");
            }
        } catch (Exception e) {
            System.out.println("Erro função deletar" + e);
        }

    }

    public List<ContaBancaria> listaContas() {

        List<ContaBancaria> contasBancarias = new ArrayList<ContaBancaria>();
        try {
            Connection connection = ModuloConexao.Conexao();
            if (connection != null) {
                Statement stmt = connection.createStatement();
                ResultSet set = stmt.executeQuery("SELECT * FROM  contabancaria");
                while (set.next()) {
                    ContaBancaria contaBancaria = new ContaBancaria();

                    contaBancaria.setNumeroConta(set.getString("numeroConta"));
                    contaBancaria.setSaldo(set.getFloat("saldo"));
                    contaBancaria.setTitular(set.getString("titular"));

                    contasBancarias.add(contaBancaria); 
                }
                return contasBancarias;
            } else {
                System.out.println("Erro na conexão com o banco");
                return null;
            }
        } catch (Exception e) {
            System.out.println("Erro função mostrar: " + e);
            return null;
        }
    }

}
