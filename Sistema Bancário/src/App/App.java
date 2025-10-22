package src.App;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o número da conta: ");
        String numeroConta = scanner.nextLine();
        System.out.print("Digite o saldo: ");
        float saldo = scanner.nextFloat();
        scanner.nextLine();
        System.out.print("Digite o nome do titular: ");
        String titular = scanner.nextLine();
        ContaBancaria contaBancaria = new ContaBancaria(numeroConta, saldo, titular);
        ContaBancariaDAO contaBancariaDAO = new ContaBancariaDAO();
        contaBancariaDAO.inserir(contaBancaria);
    }
}
