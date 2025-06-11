public class Algoritmos {

    // Bubble Sort - varre o vetor vendo se o elemento de uma posição é maior que o da próxima (2 posições por varrida)
    public static void bubbleSort(int[] vetor) {
        int tamanho = vetor.length;
        // Percorre o vetor várias vezes
        for (int i = 0; i < tamanho - 1; i++) {
            // compara 2 posições
            for (int j = 0; j < tamanho - 1 - i; j++) {
                if (vetor[j] > vetor[j + 1]) {
                    // troca se for maior
                    int temporario = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = temporario;
                }
            }
        }
    }

    // Insertion Sort - checa se o elemento atual é maior que o anterior (atual - 1) e troca até não ser (checa todos os anteriores e ajusta 1 elemento por vez)
    public static void insertionSort(int[] vetor) {
        // começa no segundo elemento porque o primeiro não tem anterior
        for (int i = 1; i < vetor.length; i++) {
            int valorAtual = vetor[i]; // valor que vai ser comparado ao anterior
            int posicao = i - 1;

            // move os elementos maiores que o valorAtual uma posição à frente
            while (posicao >= 0 && vetor[posicao] > valorAtual) {
                vetor[posicao + 1] = vetor[posicao];
                posicao--;
            }

            // bot o valorAtual na posição correta
            vetor[posicao + 1] = valorAtual;
        }
    }

    // Quick Sort - elemento na última posição vira pivô (referência), os menores ficam na esquerda e maiores na direita
    public static void quickSort(int[] vetor, int inicio, int fim) {
        if (inicio < fim) {
            // posição (index) do pivô
            int indicePivo = particionar(vetor, inicio, fim);

            // faz o quick sort na esquerda (menores) e direita (maiores) do pivô, repetindo para cada número que vira pivô
            quickSort(vetor, inicio, indicePivo - 1);
            quickSort(vetor, indicePivo + 1, fim);
        }
    }

    // faz partição do Quick Sort
    private static int particionar(int[] vetor, int inicio, int fim) {
        int pivo = vetor[fim];  // último elemento vira pivô
        int indiceMenor = inicio - 1;  // index do menor elemento até agora

        // varre os elementos do vetor
        for (int i = inicio; i < fim; i++) {
            if (vetor[i] < pivo) {
                indiceMenor++; // incrementa o índice de elementos menores que o pivô

                // troca o elemento atual com o elemento da posição do índiceMenor
                int temporario = vetor[indiceMenor];
                vetor[indiceMenor] = vetor[i];
                vetor[i] = temporario;
            }
        }

        // coloca o pivô no meio (entre os menores e maiores)
        int temporario = vetor[indiceMenor + 1];
        vetor[indiceMenor + 1] = vetor[fim];
        vetor[fim] = temporario;

        return indiceMenor + 1; // retorna o índice onde o pivô foi colocado
    }
}
