public class Main {

    static String[][] arquivos = {
            {"csv/aleatorio_100.csv", "csv/aleatorio_1000.csv", "csv/aleatorio_10000.csv"},
            {"csv/crescente_100.csv", "csv/crescente_1000.csv", "csv/crescente_10000.csv"},
            {"csv/decrescente_100.csv", "csv/decrescente_1000.csv", "csv/decrescente_10000.csv"}
    };


    static String[] ordens = {
            "Aleatório", "Crescente", "Decrescente"
    };

    public static void main(String[] args) {
        executarAlgoritmo("Insertion Sort");
        executarAlgoritmo("Quick Sort");
        executarAlgoritmo("Bubble Sort");
    }


    public static void executarAlgoritmo(String nomeAlgoritmo) {
        System.out.println("===== " + nomeAlgoritmo + " ====\n");

        long tempoTotal = 0;
        // pra cada arquivo:
        // i = cont de fora j = cont de dentro
        for (int i = 0; i < arquivos.length; i++) {
            String ordem = ordens[i];
            String[] arquivo = arquivos[i];
            // lista com os tempos de cada arquivo e de cada ordem (3 tempos por arquivo por ser 100, 1000 e 10000)
            long[] tempos = new long[3];

            for (int j = 0; j < arquivo.length; j++) {
                int[] original = LerCSV.lerArquivo(arquivo[j]);
                int[] copia = LerCSV.copiarVetor(original);
                // inicia o cronômetro
                long inicio = System.nanoTime();

                // checa qual é o algoritmo da vez e executa de acordo
                if (nomeAlgoritmo.equals("Insertion Sort")) {
                    Algoritmos.insertionSort(copia);
                } else if (nomeAlgoritmo.equals("Quick Sort")) {
                    Algoritmos.quickSort(copia, 0, copia.length - 1);
                } else if (nomeAlgoritmo.equals("Bubble Sort")) {
                    Algoritmos.bubbleSort(copia);
                }
                // para o cronômetro
                long fim = System.nanoTime();
                // calcula o tempo
                long tempo = fim - inicio;
                // bota o tempo na lista
                tempos[j] = tempo;
                // soma os tempos da lista pra gerar o total
                tempoTotal += tempo;
            }

        //prints do console
            String tempo1 = String.format("%.3f", tempos[0] / 1_000_000.0);
            String tempo2 = String.format("%.3f", tempos[1] / 1_000_000.0);
            String tempo3 = String.format("%.3f", tempos[2] / 1_000_000.0);

            System.out.println(ordem + " (100, 1000, 10000 elementos): " +
                    tempo1 + " ms | " + tempo2 + " ms |  " + tempo3 + " ms\n");
        }

        String tempoTotalFormatado = String.format("%.3f", tempoTotal / 1_000_000.0);
        System.out.println("TEMPO TOTAL: " + tempoTotalFormatado + " ms\n\n");
    }
}
