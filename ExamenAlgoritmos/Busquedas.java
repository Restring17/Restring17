//Secuencial
public class SequentialSearchInt {
    /**
     * Busca un valor en un array de enteros de forma secuencial.
     *
     * @param numbers El array en el que se va a buscar.
     * @param value   El valor que se busca.
     * @return El índice del elemento si se encuentra; de lo contrario, -1.
     */
    static int sequentialSearch(int[] numbers, int value) {
        for (int i = 0; i < numbers.length; i++) {
            // Compara el elemento actual con el valor buscado
            if (numbers[i] == value) {
                return i; // Valor encontrado, devuelve el índice
            }
        }
        return -1; // Valor no encontrado después de recorrer todo el array
    }
}


public class SequentialSearchString {
    /**
     * Busca un valor en un array de Strings de forma secuencial.
     *
     * @param texts El array en el que se va a buscar.
     * @param value La cadena de texto que se busca.
     * @return El índice del elemento si se encuentra; de lo contrario, -1.
     */
    static int sequentialSearch(String[] texts, String value) {
        for (int i = 0; i < texts.length; i++) {
            // Usa .equals() para comparar el contenido de las cadenas
            if (texts[i].equals(value)) {
                return i; // Valor encontrado, devuelve el índice
            }
        }
        return -1; // Valor no encontrado
    }
}


import java.util.Comparator;

// Suponemos que la clase Contacto está definida en alguna parte.
// public class Contacto { ... }

public class SequentialSearchComparator {
    /**
     * Busca un objeto Contacto en un array utilizando un Comparator para definir la igualdad.
     *
     * @param contacts   El array de Contactos en el que se va a buscar.
     * @param value      El objeto Contacto que se busca (puede ser un objeto "plantilla" con los datos a buscar).
     * @param comparator El Comparator que define cuándo dos Contactos son "iguales".
     * @return El índice del elemento si se encuentra; de lo contrario, -1.
     */
    static int sequentialSearch(Contacto[] contacts, Contacto value, Comparator<Contacto> comparator) {
        for (int i = 0; i < contacts.length; i++) {
            // Usa el Comparator. Si compare() devuelve 0, los objetos son "iguales".
            if (comparator.compare(contacts[i], value) == 0) {
                return i; // Valor encontrado, devuelve el índice
            }
        }
        return -1; // Valor no encontrado
    }
}


//Binaria
public class BinarySearchInt {
    /**
     * Busca un valor en un array de enteros ORDENADO utilizando la búsqueda binaria.
     *
     * @param numbers El array ordenado en el que se va a buscar.
     * @param value   El valor que se busca.
     * @return El índice del elemento si se encuentra; de lo contrario, -1.
     */
    static int binarySearch(int[] numbers, int value) {
        int low = 0;
        int high = numbers.length - 1;

        while (low <= high) {
            // Se usa (low + (high - low) / 2) para evitar un posible desbordamiento (overflow)
            // si low y high son muy grandes.
            int middle = low + (high - low) / 2;
            int middleValue = numbers[middle];

            // Comprueba si el valor está en el medio
            if (middleValue == value) {
                return middle; // Elemento encontrado
            }

            // Si el valor es mayor, ignora la mitad izquierda
            if (middleValue < value) {
                low = middle + 1;
            }
            // Si el valor es menor, ignora la mitad derecha
            else {
                high = middle - 1;
            }
        }
        return -1; // Elemento no encontrado
    }
}

public class BinarySearchString {
    /**
     * Busca un valor en un array de Strings ORDENADO utilizando la búsqueda binaria.
     *
     * @param texts El array ordenado en el que se va a buscar.
     * @param value La cadena de texto que se busca.
     * @return El índice del elemento si se encuentra; de lo contrario, -1.
     */
    static int binarySearch(String[] texts, String value) {
        int low = 0;
        int high = texts.length - 1;

        while (low <= high) {
            int middle = low + (high - low) / 2;
            String middleValue = texts[middle];
            
            // Usa compareTo para la comparación lexicográfica
            int comparison = middleValue.compareTo(value);

            // Comprueba si el valor está en el medio (compareTo devuelve 0)
            if (comparison == 0) {
                return middle; // Elemento encontrado
            }

            // Si el valor del medio es menor, ignora la mitad izquierda
            if (comparison < 0) {
                low = middle + 1;
            }
            // Si el valor del medio es mayor, ignora la mitad derecha
            else {
                high = middle - 1;
            }
        }
        return -1; // Elemento no encontrado
    }
}

import java.util.Comparator;

// Suponemos que la clase Contacto está definida en alguna parte.
// public class Contacto { ... }

public class BinarySearchComparator {
    /**
     * Busca un objeto Contacto en un array ORDENADO utilizando la búsqueda binaria y un Comparator.
     *
     * @param contacts   El array de Contactos ordenado en el que se va a buscar.
     * @param value      El objeto Contacto que se busca.
     * @param comparator El mismo Comparator que se usó para ordenar el array.
     * @return El índice del elemento si se encuentra; de lo contrario, -1.
     */
    static int binarySearch(Contacto[] contacts, Contacto value, Comparator<Contacto> comparator) {
        int low = 0;
        int high = contacts.length - 1;

        while (low <= high) {
            int middle = low + (high - low) / 2;
            Contacto middleValue = contacts[middle];
            
            // Delega toda la lógica de comparación al Comparator
            int comparison = comparator.compare(middleValue, value);

            // Comprueba si el valor del medio es "igual" al buscado
            if (comparison == 0) {
                return middle; // Elemento encontrado
            }

            // Si el valor del medio es menor que el buscado, ignora la mitad izquierda
            if (comparison < 0) {
                low = middle + 1;
            }
            // Si el valor del medio es mayor, ignora la mitad derecha
            else {
                high = middle - 1;
            }
        }
        return -1; // Elemento no encontrado
    }
}



//BusquedaSecuencialParcial
public class PartialSearchStringArray {
    /**
     * Busca cadenas que contengan un término de búsqueda (insensible a mayúsculas).
     *
     * @param texts      El array de Strings en el que se va a buscar.
     * @param searchTerm El texto a buscar como subcadena.
     * @return Un nuevo array que contiene solo las cadenas que coinciden.
     */
    static String[] sequentialSearchPartial(String[] texts, String searchTerm) {
        String lowerCaseSearchTerm = searchTerm.toLowerCase();

        // --- PRIMERA PASADA: Contar las coincidencias ---
        int matchCount = 0;
        for (String text : texts) {
            if (text.toLowerCase().contains(lowerCaseSearchTerm)) {
                matchCount++;
            }
        }

        // Si no hay coincidencias, devuelve un array vacío.
        if (matchCount == 0) {
            return new String[0];
        }

        // --- SEGUNDA PASADA: Poblar el array de resultados ---
        String[] results = new String[matchCount];
        int resultIndex = 0;
        for (String text : texts) {
            if (text.toLowerCase().contains(lowerCaseSearchTerm)) {
                results[resultIndex] = text;
                resultIndex++;
            }
        }

        return results;
    }
}



// Suponemos una clase Contacto con un método getNombre()
// public class Contacto {
//     private String nombre;
//     // ... constructor, otros campos, etc.
//     public String getNombre() { return this.nombre; }
// }

public class PartialSearchObjectArray {
    /**
     * Busca contactos cuyo nombre contenga un término de búsqueda parcial.
     *
     * @param contacts   El array de Contactos en el que se va a buscar.
     * @param partialName El nombre parcial a buscar.
     * @return Un nuevo array que contiene solo los Contactos que coinciden.
     */
    static Contacto[] searchContactsByName(Contacto[] contacts, String partialName) {
        String lowerCaseSearchTerm = partialName.toLowerCase();

        // --- PRIMERA PASADA: Contar las coincidencias ---
        int matchCount = 0;
        for (Contacto contact : contacts) {
            if (contact.getNombre().toLowerCase().contains(lowerCaseSearchTerm)) {
                matchCount++;
            }
        }

        // Si no hay coincidencias, devuelve un array vacío.
        if (matchCount == 0) {
            return new Contacto[0];
        }

        // --- SEGUNDA PASADA: Poblar el array de resultados ---
        Contacto[] results = new Contacto[matchCount];
        int resultIndex = 0;
        for (Contacto contact : contacts) {
            if (contact.getNombre().toLowerCase().contains(lowerCaseSearchTerm)) {
                results[resultIndex] = contact;
                resultIndex++;
            }
        }

        return results;
    }
}