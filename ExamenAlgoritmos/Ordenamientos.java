//selectionSort
/**
 * Ordena un array de enteros utilizando el algoritmo de ordenación por selección.
 *
 * @param arr El array de enteros a ordenar.
 */
static void selectionSort(int[] arr) {
    for (int i = 0; i < arr.length - 1; i++) {
        int minIndex = i;
        for (int j = i + 1; j < arr.length; j++) {
            if (arr[j] < arr[minIndex]) {
                minIndex = j;
            }
        }
        int temp = arr[minIndex];
        arr[minIndex] = arr[i];
        arr[i] = temp;
    }
}


/**
 * Ordena un array de Strings utilizando el algoritmo de ordenación por selección.
 *
 * @param arr El array de Strings a ordenar.
 */
static void selectionSort(String[] arr) {
    for (int i = 0; i < arr.length - 1; i++) {
        int minIndex = i;
        for (int j = i + 1; j < arr.length; j++) {
            if (arr[j].compareTo(arr[minIndex]) < 0) {
                minIndex = j;
            }
        }
        String temp = arr[minIndex];
        arr[minIndex] = arr[i];
        arr[i] = temp;
    }
}

import java.util.Comparator;

// Suponemos que existe una clase Contacto
// public class Contacto { ... }

    /**
     * Ordena un array de objetos Contacto utilizando el algoritmo de ordenación por selección
     * y un Comparator proporcionado.
     *
     * @param arr        El array de Contactos a ordenar.
     * @param comparator El Comparator que define el orden de los elementos.
     */
    static void selectionSort(Contacto[] arr, Comparator<Contacto> comparator) {
        // El bucle principal recorre el array.
        for (int i = 0; i < arr.length - 1; i++) {
            // Suponemos que el elemento mínimo es el primero de la porción no ordenada.
            int minIndex = i;

            // Buscamos el verdadero elemento mínimo en el resto del array.
            for (int j = i + 1; j < arr.length; j++) {
                // La comparación se delega al Comparator.
                // Si arr[j] es "menor que" arr[minIndex], actualizamos el índice del mínimo.
                if (comparator.compare(arr[j], arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }

            // Intercambiamos el elemento mínimo encontrado con el primer elemento de la
            // porción no ordenada. El tipo de la variable temporal es ahora "Contacto".
            Contacto temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

//MergeSort

public class MergeSortInt {
    /**
     * Ordena una porción de un array de enteros utilizando el algoritmo MergeSort.
     *
     * @param arr El array a ordenar.
     * @param izquierda El índice inicial.
     * @param derecha El índice final.
     */
    public static void sort(int[] arr, int izquierda, int derecha) {
        if (izquierda < derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;
            sort(arr, izquierda, medio);
            sort(arr, medio + 1, derecha);
            merge(arr, izquierda, medio, derecha);
        }
    }

    /**
     * Fusiona dos sub-arrays de arr[].
     * El primer sub-array es arr[izquierda..medio]
     * El segundo sub-array es arr[medio+1..derecha]
     */
    private static void merge(int[] arr, int izquierda, int medio, int derecha) {
        int n1 = medio - izquierda + 1;
        int n2 = derecha - medio;

        // Crea arrays temporales
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copia los datos a los arrays temporales
        for (int i = 0; i < n1; i++) L[i] = arr[izquierda + i];
        for (int j = 0; j < n2; j++) R[j] = arr[medio + 1 + j];

        // Fusiona los arrays temporales
        int i = 0, j = 0;
        int k = izquierda;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }

        // Copia los elementos restantes si los hay
        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }
}


//=============================
public class MergeSortString {
    /**
     * Ordena una porción de un array de Strings utilizando el algoritmo MergeSort.
     *
     * @param arr El array a ordenar.
     * @param izquierda El índice inicial.
     * @param derecha El índice final.
     */
    public static void sort(String[] arr, int izquierda, int derecha) {
        if (izquierda < derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;
            sort(arr, izquierda, medio);
            sort(arr, medio + 1, derecha);
            merge(arr, izquierda, medio, derecha);
        }
    }

    /**
     * Fusiona dos sub-arrays de arr[].
     */
    private static void merge(String[] arr, int izquierda, int medio, int derecha) {
        int n1 = medio - izquierda + 1;
        int n2 = derecha - medio;

        // Crea arrays temporales
        String[] L = new String[n1];
        String[] R = new String[n2];

        // Copia los datos a los arrays temporales
        for (int i = 0; i < n1; i++) L[i] = arr[izquierda + i];
        for (int j = 0; j < n2; j++) R[j] = arr[medio + 1 + j];

        // Fusiona los arrays temporales
        int i = 0, j = 0;
        int k = izquierda;
        while (i < n1 && j < n2) {
            // La comparación se realiza con compareTo()
            if (L[i].compareTo(R[j]) <= 0) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }

        // Copia los elementos restantes si los hay
        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }
}
//===================================
    public static void mergeSort(Contacto[] arreglo, int inicio, int fin, Comparator<Contacto> comparador) {
        if (inicio < fin) {
            int medio = (inicio + fin) / 2;
            mergeSort(arreglo, inicio, medio,comparador);
            mergeSort(arreglo, medio + 1, fin,comparador);
            merge(arreglo, inicio, medio, fin,comparador);
        }
    }
	
	    public static void merge(Contacto[] arreglo, int inicio, int medio, int fin,Comparator<Contacto> comparador){
        int n1 = medio - inicio + 1;
        int n2 = fin - medio;

        Contacto[] L = new Contacto[n1];
        Contacto[] R = new Contacto[n2];

        for (int i = 0; i < n1; i++) L[i] = arreglo[inicio + i];
        for (int j = 0; j < n2; j++) R[j] = arreglo[medio + 1 + j];

        int i = 0, j = 0, k = inicio;
        while (i < n1 && j < n2) {
            if (comparador.compare(L[i], R[j])<= 0) arreglo[k++] = L[i++];
            else arreglo[k++] = R[j++];
        }

        while (i < n1) arreglo[k++] = L[i++];
        while (j < n2) arreglo[k++] = R[j++];
    }
	
	//BubbleSort
	
	public class BubbleSortInt {
    /**
     * Ordena un array de enteros utilizando el algoritmo Bubble Sort.
     *
     * @param arr El array de enteros a ordenar.
     */
    static void bubbleSort(int[] arr) {
        int n = arr.length;
        // El bucle exterior controla el número de pasadas.
        for (int i = 0; i < n - 1; i++) {
            // El bucle interior realiza las comparaciones y los intercambios.
            // Se resta 'i' porque después de cada pasada, el elemento más grande ya está en su lugar.
            for (int j = 0; j < n - 1 - i; j++) {
                // Si el elemento actual es mayor que el siguiente, se intercambian.
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}

public class BubbleSortString {
    /**
     * Ordena un array de Strings utilizando el algoritmo Bubble Sort.
     *
     * @param arr El array de Strings a ordenar.
     */
    static void bubbleSort(String[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                // La comparación se realiza lexicográficamente con compareTo().
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    // El intercambio se realiza con una variable temporal de tipo String.
                    String temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}


import java.util.Comparator;

// Suponemos que la clase Contacto está definida en alguna parte.
// public class Contacto { ... }

public class BubbleSortComparator {
    /**
     * Ordena un array de Contactos utilizando Bubble Sort y un Comparator.
     *
     * @param arr El array de Contactos a ordenar.
     * @param comparator El Comparator que define el criterio de ordenación.
     */
    static void bubbleSort(Contacto[] arr, Comparator<Contacto> comparator) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                // La lógica de la comparación se delega completamente al Comparator.
                if (comparator.compare(arr[j], arr[j + 1]) > 0) {
                    // El intercambio se realiza con una variable temporal de tipo Contacto.
                    Contacto temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}


//quicksort

public class QuickSortInt {
    /**
     * El método de partición que toma el último elemento como pivote y coloca
     * todos los elementos más pequeños a la izquierda y los mayores a la derecha.
     * @return El índice de la posición final del pivote.
     */
    public static int partition(int[] arr, int inicio, int fin) {
        int pivote = arr[fin];
        int i = (inicio - 1); // Índice del elemento más pequeño

        for (int j = inicio; j < fin; j++) {
            // Si el elemento actual es menor o igual que el pivote
            if (arr[j] <= pivote) {
                i++;
                // Intercambia arr[i] y arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Intercambia el pivote con el elemento en la posición siguiente al último menor
        int temp = arr[i + 1];
        arr[i + 1] = arr[fin];
        arr[fin] = temp;

        return i + 1;
    }

    /**
     * La función principal que implementa QuickSort.
     * @param arr El array a ordenar.
     * @param inicio El índice de inicio.
     * @param fin El índice de fin.
     */
    public static void quickSort(int[] arr, int inicio, int fin) {
        if (inicio < fin) {
            // pi es el índice de partición, arr[pi] ya está en el lugar correcto
            int pi = partition(arr, inicio, fin);

            // Ordena recursivamente los elementos antes y después de la partición
            quickSort(arr, inicio, pi - 1);
            quickSort(arr, pi + 1, fin);
        }
    }
}

public class QuickSortString {
    /**
     * El método de partición para un array de Strings.
     */
    public static int partition(String[] arr, int inicio, int fin) {
        String pivote = arr[fin];
        int i = (inicio - 1);

        for (int j = inicio; j < fin; j++) {
            // La comparación se realiza usando compareTo para el orden lexicográfico
            if (arr[j].compareTo(pivote) <= 0) {
                i++;
                String temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        String temp = arr[i + 1];
        arr[i + 1] = arr[fin];
        arr[fin] = temp;

        return i + 1;
    }

    /**
     * La función principal que implementa QuickSort para Strings.
     * @param arr El array a ordenar.
     * @param inicio El índice de inicio.
     * @param fin El índice de fin.
     */
    public static void quickSort(String[] arr, int inicio, int fin) {
        if (inicio < fin) {
            int pi = partition(arr, inicio, fin);
            quickSort(arr, inicio, pi - 1);
            quickSort(arr, pi + 1, fin);
        }
    }
}

import java.util.Comparator;

// Se asume que la clase Contacto está definida
// public class Contacto { ... }

public class QuickSortComparator {
    /**
     * El método de partición que utiliza un Comparator para la lógica de comparación.
     */
    public static int partition(Contacto[] arreglo, int inicio, int fin, Comparator<Contacto> comparador) {
        Contacto pivote = arreglo[fin];
        int i = (inicio - 1);
        for (int j = inicio; j < fin; j++) {
            // La comparación se delega completamente al objeto Comparator
            if (comparador.compare(arreglo[j], pivote) <= 0) {
                i++;
                Contacto temp = arreglo[i];
                arreglo[i] = arreglo[j];
                arreglo[j] = temp;
            }
        }
        Contacto temp = arreglo[i + 1];
        arreglo[i + 1] = arreglo[fin];
        arreglo[fin] = temp;
        return i + 1;
    }

    /**
     * La función principal que implementa QuickSort usando un Comparator.
     * @param arreglo El array a ordenar.
     * @param inicio El índice de inicio.
     * @param fin El índice de fin.
     * @param comparador El criterio de ordenación.
     */
    public static void quickSort(Contacto[] arreglo, int inicio, int fin, Comparator<Contacto> comparador) {
        if (inicio < fin) {
            int pivote = partition(arreglo, inicio, fin, comparador);
            quickSort(arreglo, inicio, pivote - 1, comparador);
            quickSort(arreglo, pivote + 1, fin, comparador);
        }
    }
}