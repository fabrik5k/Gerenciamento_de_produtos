import java.util.List;

public class BinarySearch {
    public static int binarySearch(List<Produto> listaProdutos, String searchKey) {
        int left = 0;
        int right = listaProdutos.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = searchKey.compareTo(listaProdutos.get(mid).getNome());

            if (comparison == 0) {
                return mid; // Encontrou o elemento
            } else if (comparison < 0) {
                right = mid - 1; // O elemento está à esquerda
            } else {
                left = mid + 1; // O elemento está à direita
            }
        }

        return -1; // Elemento não encontrado
    }
}

