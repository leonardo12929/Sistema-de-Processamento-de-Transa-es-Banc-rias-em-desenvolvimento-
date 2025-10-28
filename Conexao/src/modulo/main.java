package src.modulo;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthPasswordFieldUI;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            Usuario usuario = new Usuario();
            System.out.println("Tela de cadastro" +
                    "\n1 - para cadastrar" +
                    "\n2 - para sair");
            int opc = scanner.nextInt();
            scanner.nextLine();
            if (opc == 1) {
                System.out.print("Seu nome: ");
                String nome = scanner.nextLine();
                usuario.nome = nome;
                System.out.print("\nSua idade: ");
                String idade = scanner.nextLine();
                usuario.idade = idade;
                System.out.print("\nSeu sexo: ");
                String sexo = scanner.nextLine();
                usuario.sexo = sexo;
            }
            if (opc == 2) {
                break;
            }
            Inserir inserir = new Inserir(usuario.getNome(), usuario.getIdade(), usuario.getSexo());
        }


    }
}
