package Media;

import java.util.Scanner;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        String continuar;

        do {
            System.out.println("## CÁLCULO DE MÉDIA FATEC ##");
            System.out.print("Digite a nota da P1: ");
            double p1 = scanner.nextDouble();

            System.out.print("Digite a nota da P2: ");
            double p2 = scanner.nextDouble();
            
            System.out.print("Digite a nota da P3: ");
            double p3 = scanner.nextDouble();

            System.out.print("Digite a nota do Trabalho 1: ");
            double t1 = scanner.nextDouble();

            System.out.print("Digite a nota do Trabalho 2: ");
            double t2 = scanner.nextDouble();
            
            System.out.print("Digite a nota da Prova de Laboratório: ");
            double lab = scanner.nextDouble();

            MediaFatec aluno = new MediaFatec(p1, p2, p3, t1, t2, lab);
            aluno.printDetails();

            System.out.print("\nDeseja calcular a média de outro aluno? (s/n): ");
            continuar = scanner.next();
            System.out.println("----------------------------------------");

        } while (continuar.equalsIgnoreCase("s"));

        System.out.println("Programa finalizado.");
        scanner.close();
    }
}