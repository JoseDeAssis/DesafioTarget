import java.util.Scanner;

public class Desafio5 {
    /**
     * 5) Escreva um programa que inverta os caracteres de um string.
     *
     * IMPORTANTE:
     * a) Essa string pode ser informada através de qualquer entrada de sua preferência ou pode ser previamente definida no código;
     * b) Evite usar funções prontas, como, por exemplo, reverse;
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a string para ser invertida: ");
        String input = scanner.nextLine();

        char[] caracteres = input.toCharArray();
        int length = caracteres.length;

        for(int i = 0; i < length/2; i++) {
            char temp = caracteres[i];
            caracteres[i] = caracteres[length - 1 - i];
            caracteres[length - 1 - i] = temp;
        }

        String inverso = new String(caracteres);

        System.out.println("String invertida: " + inverso);
    }
}
