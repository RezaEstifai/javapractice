package it.polito.main;

import java.util.Arrays;

public class stringMaster {

    public static void main(String[] args) {

        // =========================================================================
        // PART 1: DECLARATIONS & WHY char[] != String (Slide 84)
        // =========================================================================
        System.out.println("=== PART 1: STRING DECLARATIONS & char[] != String ===");

        // 1. Literal declaration (Pooled)
        String sLiteral1 = "Exam2026";
        String sLiteral2 = "Exam2026";

        // 2. Explicit heap object
        String sObject = new String("Exam2026");

        // Reference equality (==) vs Value equality (.equals)
        System.out.println("Literal == Literal: " + (sLiteral1 == sLiteral2)); // true (Same pool reference)
        System.out.println("Literal == Object:  " + (sLiteral1 == sObject));   // false (Different heap address)
        System.out.println("Literal.equals(Obj):" + sLiteral1.equals(sObject)); // true (ALWAYS USE .equals() IN EXAMS!)

        // 3. Proving char[] != String
        char[] rawChars = {'E', 'x', 'a', 'm', '2', '0', '2', '6'};
        // String error = rawChars; // COMPILE ERROR: Cannot assign char[] to String

        
        //* ---------------------------------------------------------------- */
        //* CONVERTING CHAR [] TO STRING AND STRING TO CHAR [] */
        //* ---------------------------------------------------------------- */


        // Converting char[] -> String
        String convertedToString = new String(rawChars);

        // Converting String -> char[]
        char[] backToChars = convertedToString.toCharArray();
        System.out.println("Converted back to char[]: " + Arrays.toString(backToChars));



        // Mutability difference:
        rawChars[0] = 'O'; // Mutates the array directly
        System.out.println("Modified char[]:          " + Arrays.toString(rawChars));
        // convertedToString remains "Exam2026" because Strings are IMMUTABLE!
        System.out.println("String remains unchanged: " + convertedToString);


        // =========================================================================
        // PART 2: LOOPING TECHNIQUES OVER STRINGS (EXAM CORE)
        // =========================================================================
        System.out.println("\n=== PART 2: 3 WAYS TO LOOP OVER A STRING ===");
        String sample = "PoliTo 2026!";

        // Loop Way A: Standard index-based loop (Useful when you need index 'i')
        System.out.print("Way A (charAt):    ");
        for (int i = 0; i < sample.length(); i++) { // Note: .length() is a method, not a field!
            char c = sample.charAt(i);
            System.out.print(c + " ");
        }
        System.out.println();

        // Loop Way B: For-each loop via .toCharArray() (Cleanest syntax)
        System.out.print("Way B (for-each):  ");
        for (char c : sample.toCharArray()) {
            System.out.print(c + " ");
        }
        System.out.println();

        // Loop Way C: Backward loop (Standard exam trick: reverse a string)
        System.out.print("Way C (Reversed):  ");
        for (int i = sample.length() - 1; i >= 0; i--) {
            System.out.print(sample.charAt(i));
        }
        System.out.println();


        // =========================================================================
        // PART 3: Character UTILITY METHODS (Slide 85)
        // =========================================================================
        System.out.println("\n=== PART 3: Character UTILITY METHODS IN ACTION ===");

        int lettersCount = 0;
        int digitsCount  = 0;
        int spacesCount  = 0;
        int othersCount  = 0;

        StringBuilder transformed = new StringBuilder();

        for (char ch : sample.toCharArray()) {
            // Character.isLetter(ch) -> checks if alphabetic (a-z, A-Z)
            if (Character.isLetter(ch)) {
                lettersCount++;

                // Character.isUpperCase(ch) / toLowerCase / toUpperCase
                if (Character.isUpperCase(ch)) {
                    transformed.append(Character.toLowerCase(ch)); // Swap uppercase to lowercase
                } else {
                    transformed.append(Character.toUpperCase(ch)); // Swap lowercase to uppercase
                }
            }
            // Character.isDigit(ch) -> checks if '0'..'9'
            else if (Character.isDigit(ch)) {
                digitsCount++;
                transformed.append(ch); // Keep number as is
            }
            // Character.isWhitespace(ch) or Character.isSpaceChar(ch)
            else if (Character.isWhitespace(ch)) {
                spacesCount++;
                transformed.append('_'); // Replace space with underscore
            }
            else {
                othersCount++;
                transformed.append('#'); // Mask punctuation (!, ?, $, etc.)
            }
        }

        System.out.println("Original:     " + sample);
        System.out.println("Letters:      " + lettersCount);
        System.out.println("Digits:       " + digitsCount);
        System.out.println("Spaces:       " + spacesCount);
        System.out.println("Symbols:      " + othersCount);
        System.out.println("Transformed:  " + transformed.toString());


        // =========================================================================
        // PART 4: MUST-KNOW String METHODS FOR CODING EXAMS
        // =========================================================================
        System.out.println("\n=== PART 4: TOP EXAM METHODS ON String ===");

        String sentence = "Object Oriented Programming at PoliTo";

        // 1. .substring(start, end) -> [start inclusive, end exclusive]
        String sub = sentence.substring(0, 6); // "Object"
        System.out.println(".substring(0, 6):     " + sub);

        // 2. .indexOf(str) -> returns index or -1 if not found
        int idx = sentence.indexOf("Oriented");
        System.out.println(".indexOf('Oriented'): " + idx);

        // 3. .contains(str) -> boolean check
        System.out.println(".contains('PoliTo'):  " + sentence.contains("PoliTo"));

        // 4. .startsWith() / .endsWith()
        System.out.println(".startsWith('Obj'):   " + sentence.startsWith("Obj"));

        // 5. .split(regex) -> tokenizing by delimiter into String[]
        String[] words = sentence.split(" ");
        System.out.println(".split(' '):          " + Arrays.toString(words));
        System.out.println("Total word count:     " + words.length);

        // 6. .trim() -> strips leading and trailing whitespaces
        String dirty = "   hello polito   \n";
        System.out.println(".trim():              [" + dirty.trim() + "]");
    }
}