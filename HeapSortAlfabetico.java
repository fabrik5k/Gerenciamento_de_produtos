import java.util.List;

public class HeapSortAlfabetico {
    public static void heapSort(List<Produto> list) {
        int n = list.size();

        // Constrói o heap máximo
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(list, n, i);
        }

        // Extrai elementos do heap um por um
        for (int i = n - 1; i >= 0; i--) {
            // Move a raiz atual para o final
            Produto temp = list.get(0);
            list.set(0, list.get(i));
            list.set(i, temp);

            // Chama heapify na heap reduzida
            heapify(list, i, 0);
        }
    }

    public static void heapify(List<Produto> list, int n, int i) {
        int largest = i; // Inicializa o maior como raiz
        int left = 2 * i + 1; // Filho esquerdo do nó atual
        int right = 2 * i + 2; // Filho direito do nó atual

        // Se o filho esquerdo é maior que a raiz
        if (left < n && list.get(left).getNome().compareTo(list.get(largest).getNome()) > 0) {
            largest = left;
        }

        // Se o filho direito é maior que o maior até agora
        if (right < n && list.get(right).getNome().compareTo(list.get(largest).getNome()) > 0) {
            largest = right;
        }

        // Se o maior não é a raiz
        if (largest != i) {
            Produto swap = list.get(i);
            list.set(i, list.get(largest));
            list.set(largest, swap);

            // Recursivamente heapify a subárvore afetada
            heapify(list, n, largest);
        }
    }
}

