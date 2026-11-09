package it.polito.main.Inheritance;
/*
 TOPICS: varargs, sorting flexibility, reusable sorting algorithm.
*/
import java.util.Arrays;
import java.util.Comparator;

class UtilityExamples {
    static void run() {
        // Varargs (...) lets one method receive zero or more arguments.
        printNumbers();
        printNumbers(10);
        printNumbers(10, 20, 30);

        Integer[] values = {8, 2, 5, 1, 9};
        Sorter.sort(values, Comparator.naturalOrder());
        System.out.println("Ascending: " + Arrays.toString(values));

        // Same sorting code, different comparison rule.
        Sorter.sort(values, Comparator.reverseOrder());
        System.out.println("Descending: " + Arrays.toString(values));
    }

    static void printNumbers(int... numbers) {
        System.out.println("Received: " + Arrays.toString(numbers));
    }
}

class Sorter {
    // Generic method: works with different reference types.
    // Comparator is the rule that decides which item comes first.
    static <T> void sort(T[] values, Comparator<? super T> rule) {
        Arrays.sort(values, rule);
    }
}
