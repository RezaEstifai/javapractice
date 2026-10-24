package it.polito.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerLearning {

    private static final String DATA_DIRECTORY = "data/scanner/";

    public static void main(String[] args)
            throws FileNotFoundException {

        // Run ONE example at a time.
        exampleHasNextInt();

        // exampleHasNextLine();
        // exampleHasNext();
        // exampleNextIntVersusNextLine();
        // exampleHasNextVersusHasNextInt();
        // exampleNestedLoops();
    }

    // ============================================================
    // EXAMPLE 1: hasNextInt() + nextInt()
    //
    // example1-integers.txt:
    // 10 20 30
    // 40 50
    //
    // Output:
    // 10
    // 20
    // 30
    // 40
    // 50
    // ============================================================

    public static void exampleHasNextInt()
            throws FileNotFoundException {

        System.out.println("--- Example 1 ---");

        Scanner sc = openExampleData("example1-integers.txt");

        while (sc.hasNextInt()) {
            int number = sc.nextInt();
            System.out.println(number);
        }

        sc.close();
    }


    // ============================================================
    // EXAMPLE 2: hasNextLine() + nextLine()
    //
    // example2-lines.txt:
    // Alice is 20 years old
    // Bob is 21 years old
    // Charlie is 22 years old
    //
    // Output:
    // Alice is 20 years old
    // Bob is 21 years old
    // Charlie is 22 years old
    // ============================================================

    public static void exampleHasNextLine()
            throws FileNotFoundException {

        System.out.println("--- Example 2 ---");

        Scanner sc = openExampleData("example2-lines.txt");

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            System.out.println(line);
        }

        sc.close();
    }


    // ============================================================
    // EXAMPLE 3: hasNext() + next()
    //
    // example3-tokens.txt:
    // Alice 25 Turin
    // Bob 21 Milan
    //
    // Output:
    // Alice
    // 25
    // Turin
    // Bob
    // 21
    // Milan
    // ============================================================

    public static void exampleHasNext()
            throws FileNotFoundException {

        System.out.println("--- Example 3 ---");

        Scanner sc = openExampleData("example3-tokens.txt");

        while (sc.hasNext()) {
            String token = sc.next();
            System.out.println(token);
        }

        sc.close();
    }


    // ============================================================
    // EXAMPLE 4: nextInt() vs nextLine()
    //
    // example4-numbers.txt:
    // 25 30 40
    //
    // nextInt() output:
    // 25
    // 30
    //
    // nextLine() output:
    // 25 30 40
    // ============================================================

    public static void exampleNextIntVersusNextLine()
            throws FileNotFoundException {

        System.out.println("--- Example 4A: nextInt() ---");

        Scanner sc1 = openExampleData("example4-numbers.txt");

        int a = sc1.nextInt();
        int b = sc1.nextInt();

        System.out.println(a);
        System.out.println(b);

        sc1.close();


        System.out.println("--- Example 4B: nextLine() ---");

        Scanner sc2 = openExampleData("example4-numbers.txt");

        String line = sc2.nextLine();
        System.out.println(line);

        sc2.close();
    }


    // ============================================================
    // EXAMPLE 5: hasNext() vs hasNextInt()
    //
    // example5-mixed-tokens.txt:
    // 10 hello 20
    //
    // hasNext() + next() output:
    // 10
    // hello
    // 20
    //
    // hasNextInt() + nextInt() output:
    // 10
    //
    // The integer loop stops at "hello".
    // ============================================================

    public static void exampleHasNextVersusHasNextInt()
            throws FileNotFoundException {

        System.out.println("--- Example 5A: hasNext() ---");

        Scanner sc1 = openExampleData("example5-mixed-tokens.txt");

        while (sc1.hasNext()) {
            System.out.println(sc1.next());
        }

        sc1.close();


        System.out.println("--- Example 5B: hasNextInt() ---");

        Scanner sc2 = openExampleData("example5-mixed-tokens.txt");

        while (sc2.hasNextInt()) {
            System.out.println(sc2.nextInt());
        }

        sc2.close();
    }


    // ============================================================
    // EXAMPLE 6: Nested loops
    //
    // example6-grid.txt:
    // 10 20 30
    // 40 50 60
    //
    // Output:
    // 10
    // 20
    // 30
    // 40
    // 50
    // 60
    //
    // Outer loop: reads one line at a time.
    // Inner loop: reads integers from that line.
    // ============================================================

    public static void exampleNestedLoops()
            throws FileNotFoundException {

        System.out.println("--- Example 6 ---");

        Scanner sc = openExampleData("example6-grid.txt");

        while (sc.hasNextLine()) {

            String line = sc.nextLine();

            Scanner lineScanner = new Scanner(line);

            while (lineScanner.hasNextInt()) {
                int number = lineScanner.nextInt();
                System.out.println(number);
            }

            lineScanner.close();
        }

        sc.close();
    }

    private static Scanner openExampleData(String fileName)
            throws FileNotFoundException {
        return new Scanner(new File(DATA_DIRECTORY + fileName));
    }
}
