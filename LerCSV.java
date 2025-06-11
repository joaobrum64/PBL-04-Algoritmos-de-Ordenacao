import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LerCSV {

    public static int[] lerArquivo(String caminho) {
        int[] dados = new int[10000]; // tamanho máximo
        int quantidade = 0;

        try {
            BufferedReader leitor = new BufferedReader(new FileReader(caminho));
            String linha;

            // cabeçalho
            linha = leitor.readLine();
            while ((linha = leitor.readLine()) != null) {
                try {
                    dados[quantidade] = Integer.parseInt(linha.trim());
                    quantidade++;
                } catch (NumberFormatException e) {
                    System.out.println("Linha inválida (ignorada): " + linha);
                }
            }

            leitor.close();
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + caminho);
        }

        // resultado em vetor
        int[] resultado = new int[quantidade];
        for (int i = 0; i < quantidade; i++) {
            resultado[i] = dados[i];
        }

        return resultado;
    }

    // copia o vetor pra não alterar o original e os outros algorítmos usarem um vetor já organizado
    public static int[] copiarVetor(int[] original) {
        int[] copia = new int[original.length];
        for (int i = 0; i < original.length; i++) {
            copia[i] = original[i];
        }
        return copia;
    }
}
