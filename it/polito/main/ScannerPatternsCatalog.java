package it.polito.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * ScannerPatternsCatalog
 *
 * Demonstrates the four essential patterns for reading, tokenizing,
 * and parsing data using java.util.Scanner in university exams and lab exercises.
 */
public class ScannerPatternsCatalog {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("PATTERN 1: FIXED/DECLARED SIZE ARRAY INPUT Getting the size from the first value of the input stream");
        System.out.println("==================================================");
        demoPattern1KnownSize();

        System.out.println("\n==================================================");
        System.out.println("PATTERN 2: DYNAMIC / UNKNOWN SIZE INPUT");
        System.out.println("==================================================");
        demoPattern2UnknownSize();

        System.out.println("\n==================================================");
        System.out.println("PATTERN 3: HETEROGENEOUS INPUT & TYPE SNIFFING");
        System.out.println("==================================================");
        demoPattern3HeterogeneousStream();

        System.out.println("\n==================================================");
        System.out.println("PATTERN 4: ROBUST LINE-BY-LINE TOKENIZATION");
        System.out.println("==================================================");
        demoPattern4LineByLine();
    }

    /**
     * Pattern 1: Known Size (Classic Exam Format)
     * Format: [N] [element_1] [element_2] ... [element_N]
     * Directly allocates a primitive array without dynamic collection overhead.
     */
    private static void demoPattern1KnownSize() {
        String mockInput = "5 10 20 30 40 50";  //* generally the first value is the length of the array (how many numbers are coming the loop) */

        try (Scanner sc = new Scanner(mockInput)) {
            if (!sc.hasNextInt()) { //* If the input is "5 10 20 30", then hasNextInt() is true and the condition is false. If the input is "abc 10 20" or there is no number at all, then hasNextInt() is false and the code enters the block. */
                System.err.println("Error: Missing dimension prefix.");
                return;
            }

            // Step 4: Reading the array size:
            // - sc.nextInt() reads the next token ("5"), parses it into a primitive int,
            //   advances the scanner cursor past "5", and assigns the value 5 to 'n'.
            int n = sc.nextInt();    //* now the first value which is 5 is consumed */

            // Step 5: Allocating heap memory for the array:
            // - Creates an array of primitive integers with capacity 'n' (5 elements).
            // - By default, Java initializes all slots in an int[] array to 0 -> [0, 0, 0, 0, 0].
            int[] data = new int[n]; //* we get the size of that from the first value of the sc not the size of it */


        //* ------------------------------------------------------------------------------------------ */
        //* ------------------------------------------------------------------------------------------ */

        //* how to create an array with size and using Scanner (since Scanner itself doesn't have the .size() method  */
        //* String inputWithoutSize = "10 20 30 40 50";


        // * String[] tokens = inputWithoutSize.trim().split("\\s+");

        // * int[] data = new int[tokens.length]; 

        // * for (int i = 0; i < tokens.length; i++) {
        //  *   data[i] = Integer.parseInt(tokens[i]);
        // * } */
            // Step 6: Loop through the array indices from 0 up to n - 1 (indices: 0, 1, 2, 3, 4):
            for (int i = 0; i < n; i++) {

                // Step 7: Verify before reading each item:
                // - Checks if another valid integer token exists in the stream.
                if (sc.hasNextInt()) {
                    // Step 8: Read and assign:
                    // - sc.nextInt() parses the next integer token and stores it at index 'i'.
                    // - Iteration 0: consumes "10" -> data[0] = 10
                    // - Iteration 1: consumes "20" -> data[1] = 20
                    // - Iteration 2: consumes "30" -> data[2] = 30
                    // - Iteration 3: consumes "40" -> data[3] = 40
                    // - Iteration 4: consumes "50" -> data[4] = 50
                    data[i] = sc.nextInt();
                } else {
                    // Safety fallback:
                    // - Triggers if the input string ended prematurely (e.g., provided fewer numbers than 'n').
                    System.err.println("Malformed input: Fewer elements than declared.");
                    break; // Stops reading to prevent NoSuchElementException
                }
            }
            // Step 9: Final result presentation:
            // - Arrays.toString(data) converts the primitive array contents into readable text format: [10, 20, 30, 40, 50].
            System.out.println("Array allocated: " + Arrays.toString(data));
        }
    }

    /**
     * Pattern 2: Unknown Size (Dynamic Buffering)
     * The input length is indeterminate. Uses an ArrayList<Integer> to buffer,
     * then flattens into an efficient primitive int[] array.
     */
    private static void demoPattern2UnknownSize() {
        String streamData = "14 82 9 -3 45 100 2";
        List<Integer> buffer = new ArrayList<>();

        try (Scanner sc = new Scanner(streamData)) {
            while (sc.hasNextInt()) {
                buffer.add(sc.nextInt()); // Autoboxing: int -> Integer
            }
        }

        // Unbox wrapper list into a primitive array for optimal performance
        int[] numbers = new int[buffer.size()];
        for (int i = 0; i < buffer.size(); i++) {
            numbers[i] = buffer.get(i); // Unboxing: Integer -> int
        }

        System.out.println("Total elements read: " + numbers.length);
        System.out.println("Primitive array: " + Arrays.toString(numbers));
    }

    /**
     * Pattern 3: Heterogeneous Stream (Unknown Content / Type Sniffing)
     * Demonstrates lookahead detection (hasNextInt before hasNextDouble)
     * and fallback to String inspection using Character static methods.
     */
    private static void demoPattern3HeterogeneousStream() {
        String payload = "POLI_101 28 94.5 pass 30 null 18.2 fail";

        List<Integer> integers = new ArrayList<>();
        List<Double> doubles = new ArrayList<>();
        List<String> words = new ArrayList<>();

        try (Scanner sc = new Scanner(payload)) {
            while (sc.hasNext()) {
                // Priority 1: Check integer representation first
                if (sc.hasNextInt()) {
                    integers.add(sc.nextInt());
                } 
                // Priority 2: Check floating point representation
                else if (sc.hasNextDouble()) {
                    doubles.add(sc.nextDouble());
                } 
                // Priority 3: Fallback token reading
                else {
                    words.add(sc.next());
                }
            }
        }

        System.out.println("Extracted Integers: " + integers);
        System.out.println("Extracted Doubles:  " + doubles);
        System.out.println("Extracted Words:    " + words);

        System.out.println("\nToken character decomposition:");
        for (String word : words) {
            int letters = 0;
            int digits = 0;
            for (char ch : word.toCharArray()) {
                if (Character.isLetter(ch)) letters++;
                if (Character.isDigit(ch))  digits++;
            }
            System.out.printf("  %-10s -> Letters: %d, Digits: %d%n", word, letters, digits);
        }
    }

    /**
     * Pattern 4: Robust Line-by-Line Tokenization
     * Prevents newline buffering bugs by consuming full lines with nextLine()
     * and delegating per-row tokenization to an isolated inner Scanner.
     */
    private static void demoPattern4LineByLine() {
        String rawDataset = 
            "StudentA 18 20 24\n" +
            "StudentB 30 28 30 29 27\n" +
            "StudentC 22\n";

        try (Scanner lineReader = new Scanner(rawDataset)) {
            while (lineReader.hasNextLine()) {
                String line = lineReader.nextLine().trim();
                if (line.isEmpty()) {
                    continue; // Skip trailing or blank lines
                }

                // Dedicated row-scoped Scanner
                try (Scanner rowScanner = new Scanner(line)) {
                    String studentName = rowScanner.next();
                    
                    List<Integer> marks = new ArrayList<>();
                    while (rowScanner.hasNextInt()) {
                        marks.add(rowScanner.nextInt());
                    }

                    int total = 0;
                    for (int mark : marks) {
                        total += mark;
                    }
                    double average = marks.isEmpty() ? 0.0 : (double) total / marks.size();

                    System.out.printf("Student: %-10s | Exams: %d | Avg: %.2f%n", 
                                      studentName, marks.size(), average);
                }
            }
        }
    }
}