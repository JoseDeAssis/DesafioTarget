import java.util.Scanner;

public class Desafio2 {
    /**
     * 2) Dado a sequência de Fibonacci, onde se inicia por 0 e 1 e o próximo valor sempre será a soma dos 2 valores anteriores
     * (exemplo: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34...), escreva um programa na linguagem que desejar onde, informado um número,
     * ele calcule a sequência de Fibonacci e retorne uma mensagem avisando se o número informado pertence ou não a sequência.
     *
    **/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe o número que deseja saber se está na sequência de Fibonacci: ");
        int numPotencial = scanner.nextInt();

        if(numPotencial > 0) {
            int numSequencia = 1;
            int numFib = 0;
            while(numFib < numPotencial) {
                numFib = fibonacci(numSequencia);
                if(numFib == numPotencial) {
                    System.out.println("O número " + numPotencial + " está na sequência de fibonacci e é o " + numSequencia + "º número da sequência.");
                    break;
                }
                numSequencia++;
            }
        } else {
            System.out.println("O número " + numPotencial + " não está na sequência de fibonacci.");
        }
    }

    public static int fibonacci(int i) {
        if(i == 1) return 0;
        if(i == 2) return 1;
        return fibonacci(i - 1) + fibonacci(i - 2);
    }
}
