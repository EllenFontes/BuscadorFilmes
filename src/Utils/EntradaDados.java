package Utils;

import java.util.Scanner;

public class EntradaDados {

    public static String entrada() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o filme que deseja buscar ou digite 'sair' para encerrar a busca ");
        String busca = scanner.nextLine().replaceAll(" ", "-");

        return busca;
    }


}
