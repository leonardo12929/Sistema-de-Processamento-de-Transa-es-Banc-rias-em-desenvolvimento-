package src.App;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContaBancariaDAO contaBancariaDAO = new ContaBancariaDAO();
        while (true) {
            contaBancariaDAO.mostrar();
            System.out.println("\n1 - inserir valores\n2 - deletar");
            int opc = scanner.nextInt();
            if (opc == 1 ) {
                scanner.nextLine(); // limpa o buffer
                System.out.print("Digite o número da conta: ");
                String numeroConta = scanner.nextLine();
                System.out.print("Digite o saldo: ");
                float saldo = scanner.nextFloat();
                scanner.nextLine(); // limpa o buffer
                System.out.print("Digite o nome do titular: ");
                String titular = scanner.nextLine();
                ContaBancaria contaBancaria = new ContaBancaria(numeroConta, saldo, titular);
                contaBancariaDAO.inserir(contaBancaria);
            }
            if (opc == 2) {
                System.out.println("Digte o id para deletar");
                int opcInserir = scanner.nextInt();
                contaBancariaDAO.deletar(opcInserir);            
            }
        }
    }
}
