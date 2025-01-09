import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Desafio3 {
    /**
     * 3) Dado um vetor que guarda o valor de faturamento diário de uma distribuidora, faça um programa, na linguagem que desejar, que calcule e retorne:
     * • O menor valor de faturamento ocorrido em um dia do mês;
     * • O maior valor de faturamento ocorrido em um dia do mês;
     * • Número de dias no mês em que o valor de faturamento diário foi superior à média mensal.
     *
     * IMPORTANTE:
     * a) Usar o json ou xml disponível como fonte dos dados do faturamento mensal;
     * b) Podem existir dias sem faturamento, como nos finais de semana e feriados. Estes dias devem ser ignorados no cálculo da média;
     * @param args
     */
    public static void main(String[] args) {
        String jsonPath = "faturamento.json";
        List<FaturamentoDia> faturamentoMensal = new ArrayList<>();

        // Leitura e parsing do JSON
        try (BufferedReader br = new BufferedReader(new FileReader(jsonPath))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.startsWith("{")) {
                    int dia = Integer.parseInt(line.split(":")[1].trim().split(",")[0]);
                    double faturamento = Double.parseDouble(line.split(":")[2].trim().replace(",", "").replace("}", ""));
                    faturamentoMensal.add(new FaturamentoDia(dia, faturamento));
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo JSON: " + e.getMessage());
            return;
        }

        double menorFaturamento = Double.MAX_VALUE;
        double maiorFaturamento = Double.MIN_VALUE;
        double somaFaturamento = 0.0;
        int diasComFaturamento = 0;

        for (FaturamentoDia dia : faturamentoMensal) {
            double faturamento = dia.getFaturamento();
            if (faturamento > 0) {
                menorFaturamento = Math.min(menorFaturamento, faturamento);
                maiorFaturamento = Math.max(maiorFaturamento, faturamento);
                somaFaturamento += faturamento;
                diasComFaturamento++;
            }
        }

        double mediaMensal = somaFaturamento / diasComFaturamento;

        int diasAcimaDaMedia = 0;
        for (FaturamentoDia dia : faturamentoMensal) {
            if (dia.getFaturamento() > mediaMensal) {
                diasAcimaDaMedia++;
            }
        }

        System.out.println("Menor faturamento: R$ " + menorFaturamento);
        System.out.println("Maior faturamento: R$ " + maiorFaturamento);
        System.out.println("Dias com faturamento acima da média: " + diasAcimaDaMedia);
    }
}
