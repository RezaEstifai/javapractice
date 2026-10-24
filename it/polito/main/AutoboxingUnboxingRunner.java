package it.polito.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ======================================================================
 * TOPIC: AUTOBOXING, UNBOXING, WRAPPER CLASSES, ARRAYS, AND ARRAYLIST
 * ======================================================================
 *
 * PURPOSE
 * -------
 * This file is designed as a self-contained revision guide. You should be
 * able to return to it months later and understand:
 *
 * 1. The difference between primitive types and wrapper classes.
 * 2. Automatic autoboxing and unboxing.
 * 3. Explicit conversions using valueOf() and xxxValue().
 * 4. How conversions work with ordinary variables, arrays, and ArrayList.
 * 5. What happens with null, ==, and wrapper-object caching.
 * 6. Common Java exam mistakes.
 *
 * HOW TO RUN
 * ----------
 * Run this class from VS Code. The examples are deliberately kept in one
 * main method so you can follow the output from top to bottom.
 *
 * IMPORTANT
 * ---------
 * Java's primitive int is a value; Integer is an object reference.
 * Similar wrapper pairs include:
 * byte/Byte, short/Short, int/Integer, long/Long,
 * float/Float, double/Double, char/Character, boolean/Boolean.
 */
public class AutoboxingUnboxingRunner {

    public static void main(String[] args) {

        System.out.println("==================================================");
        System.out.println("JAVA OOP: AUTOBOXING AND UNBOXING REVISION GUIDE");
        System.out.println("==================================================\n");

        // --------------------------------------------------------------
        // SECTION 1: PRIMITIVE VS WRAPPER CLASS
        // --------------------------------------------------------------
        System.out.println("SECTION 1: Primitive vs wrapper class");

        int primitiveValue = 10;           // Primitive: stores an int value.
        Integer wrapperValue = Integer.valueOf(20); // Integer object reference.

        System.out.println("primitiveValue = " + primitiveValue);
        System.out.println("wrapperValue   = " + wrapperValue);
        System.out.println();

        /*
         * WHY ARE THERE TWO TYPES?
         *
         * int is a primitive type. It is not an object and cannot be null.
         *
         * Integer is a wrapper class. It represents an int value as an
         * object, so it can be used in APIs and collections that work with
         * objects. An Integer reference can also be null.
         *
         * Example:
         * int x = null;       // DOES NOT COMPILE
         * Integer y = null;   // Compiles, but y contains no Integer object.
         */

        // --------------------------------------------------------------
        // SECTION 2: AUTOBOXING (AUTOMATIC int -> Integer)
        // --------------------------------------------------------------
        System.out.println("SECTION 2: Autoboxing");

        int primitiveVal = 42;

        // AUTOBOXING: Java automatically converts int to Integer.
        Integer boxedVal = primitiveVal;

        // The assignment above is conceptually equivalent to:
        Integer boxedExplicitly = Integer.valueOf(primitiveVal);

        System.out.println("primitiveVal       = " + primitiveVal);
        System.out.println("boxedVal            = " + boxedVal);
        System.out.println("boxedExplicitly     = " + boxedExplicitly);
        System.out.println("Both Integer values contain the same number.");
        System.out.println();

        /*
         * AUTOBOXING means:
         *
         *     int x = 42;
         *     Integer object = x;
         *
         * Java inserts a conversion for you. For an int-to-Integer conversion,
         * the operation is effectively based on Integer.valueOf(x).
         *
         * You do not need to write valueOf() for ordinary assignments.
         */

        // --------------------------------------------------------------
        // SECTION 3: UNBOXING (AUTOMATIC Integer -> int)
        // --------------------------------------------------------------
        System.out.println("SECTION 3: Unboxing");

        Integer storedObject = Integer.valueOf(75);

        // UNBOXING: Java automatically extracts the int value.
        int extractedPrimitive = storedObject;

        // The assignment above is conceptually equivalent to:
        int extractedExplicitly = storedObject.intValue();

        System.out.println("storedObject        = " + storedObject);
        System.out.println("extractedPrimitive  = " + extractedPrimitive);
        System.out.println("extractedExplicitly = " + extractedExplicitly);
        System.out.println();

        /*
         * UNBOXING means:
         *
         *     Integer object = Integer.valueOf(75);
         *     int number = object;
         *
         * Java automatically calls the wrapper's value-extraction operation,
         * for Integer this is intValue().
         *
         * Matching methods:
         * Integer.intValue()       -> int
         * Double.doubleValue()     -> double
         * Boolean.booleanValue()   -> boolean
         * Character.charValue()    -> char
         * Long.longValue()         -> long
         */

        // --------------------------------------------------------------
        // SECTION 4: EXPLICIT CONVERSION METHODS
        // --------------------------------------------------------------
        System.out.println("SECTION 4: Explicit conversion methods");

        // valueOf() creates/returns an Integer object representing 100.
        Integer fromValueOf = Integer.valueOf(100);

        // intValue() extracts the primitive int from an Integer object.
        int fromIntValue = fromValueOf.intValue();

        // Parsing text is different: parseInt() converts String -> int.
        int fromTextPrimitive = Integer.parseInt("123");

        // valueOf(String) converts String -> Integer.
        Integer fromTextWrapper = Integer.valueOf("456");

        System.out.println("Integer.valueOf(100)        = " + fromValueOf);
        System.out.println("fromValueOf.intValue()     = " + fromIntValue);
        System.out.println("Integer.parseInt(\"123\")    = " + fromTextPrimitive);
        System.out.println("Integer.valueOf(\"456\")     = " + fromTextWrapper);
        System.out.println();

        /*
         * REMEMBER THE DIFFERENCE:
         *
         * Integer.valueOf(100)
         *     int -> Integer (boxing / wrapper creation or retrieval)
         *
         * fromValueOf.intValue()
         *     Integer -> int (extract the primitive)
         *
         * Integer.parseInt("123")
         *     String -> int
         *
         * Integer.valueOf("456")
         *     String -> Integer
         *
         * The input to parseInt()/valueOf(String) must be valid integer text.
         * Integer.parseInt("hello") throws NumberFormatException.
         *
         * AVOID:
         *     new Integer(100)
         * The Integer constructors are deprecated in modern Java. Prefer
         * Integer.valueOf(100) or autoboxing instead.
         */

        // --------------------------------------------------------------
        // SECTION 5: OTHER WRAPPER TYPES
        // --------------------------------------------------------------
        System.out.println("SECTION 5: Other wrapper types");

        double primitiveDouble = 3.14;
        Double boxedDouble = primitiveDouble;       // Autoboxing
        double unboxedDouble = boxedDouble;         // Unboxing

        boolean primitiveBoolean = true;
        Boolean boxedBoolean = primitiveBoolean;    // Autoboxing
        boolean unboxedBoolean = boxedBoolean;      // Unboxing

        char primitiveChar = 'A';
        Character boxedChar = primitiveChar;        // Autoboxing
        char unboxedChar = boxedChar;               // Unboxing

        System.out.println("double -> Double -> double: "
                + primitiveDouble + " -> " + boxedDouble + " -> " + unboxedDouble);
        System.out.println("boolean -> Boolean -> boolean: "
                + primitiveBoolean + " -> " + boxedBoolean + " -> " + unboxedBoolean);
        System.out.println("char -> Character -> char: "
                + primitiveChar + " -> " + boxedChar + " -> " + unboxedChar);
        System.out.println();

        // --------------------------------------------------------------
        // SECTION 6: AUTOBOXING AND UNBOXING IN ARRAYS
        // --------------------------------------------------------------
        System.out.println("SECTION 6: Arrays");

        // A primitive array stores primitive int values.
        int[] primitiveArray = {1, 2, 3};

        // A wrapper array stores references to Integer objects.
        Integer[] wrapperArray = {4, 5, 6}; // Each int literal is autoboxed.

        // Assignment from int to Integer array element: autoboxing.
        primitiveArray[0] = 10;
        wrapperArray[0] = primitiveArray[0];

        // Assignment from Integer array element to int: unboxing.
        int valueFromWrapperArray = wrapperArray[1];

        System.out.println("primitiveArray = " + Arrays.toString(primitiveArray));
        System.out.println("wrapperArray   = " + Arrays.toString(wrapperArray));
        System.out.println("wrapperArray[1] unboxed to int = " + valueFromWrapperArray);
        System.out.println();

        /*
         * KEY DIFFERENCE:
         *
         * int[] can contain primitive int values, but never null elements.
         * Integer[] contains references and can contain null.
         *
         * Example:
         * int[] a = {1, 2, 3};
         * Integer[] b = {1, null, 3};
         *
         * Be careful: reading a null Integer and converting it to int causes
         * NullPointerException. See Section 9.
         */

        // --------------------------------------------------------------
        // SECTION 7: AUTOBOXING AND UNBOXING IN ARRAYLIST
        // --------------------------------------------------------------
        System.out.println("SECTION 7: ArrayList<Integer>");

        /*
         * Generic collections such as ArrayList<Integer> require object
         * element types. You cannot write ArrayList<int>.
         *
         * This is valid:
         *     ArrayList<Integer> numbers = new ArrayList<>();
         *
         * This is invalid:
         *     ArrayList<int> numbers = new ArrayList<>(); // DOES NOT COMPILE
         */

        ArrayList<Integer> numbers = new ArrayList<>();

        // Autoboxing: each int is converted to Integer for the list.
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);

        System.out.println("numbers = " + numbers);

        // get(0) returns Integer. Assigning it to int causes unboxing.
        int firstNumber = numbers.get(0);

        // You can also use the explicit method:
        int secondNumber = numbers.get(1).intValue();

        // Updating a list item with a primitive int causes autoboxing.
        numbers.set(2, 99);

        System.out.println("firstNumber (unboxed)  = " + firstNumber);
        System.out.println("secondNumber (explicit)= " + secondNumber);
        System.out.println("After set(2, 99)       = " + numbers);
        System.out.println();

        /*
         * FOLLOW THE TYPES:
         *
         * numbers.add(10)
         * int 10 -> Integer (autoboxing)
         *
         * numbers.get(0)
         * returns Integer
         *
         * int x = numbers.get(0)
         * Integer -> int (unboxing)
         *
         * numbers.set(2, 99)
         * int 99 -> Integer (autoboxing)
         */

        // --------------------------------------------------------------
        // SECTION 8: LOOPS AND EXPRESSIONS
        // --------------------------------------------------------------
        System.out.println("SECTION 8: Loops and arithmetic");

        int total = 0;

        // Each Integer read from the list is unboxed to int for addition.
        for (Integer number : numbers) {
            total += number;
        }

        System.out.println("numbers = " + numbers);
        System.out.println("total   = " + total);

        // Arithmetic on wrapper objects usually triggers unboxing first.
        Integer a = Integer.valueOf(7);
        Integer b = Integer.valueOf(8);
        int sum = a + b; // a and b unboxed, then added; result is int.

        System.out.println("a + b = " + sum);
        System.out.println();

        // --------------------------------------------------------------
        // SECTION 9: NULL AND UNBOXING (VERY IMPORTANT)
        // --------------------------------------------------------------
        System.out.println("SECTION 9: Null safety");

        Integer missingMark = null;

        System.out.println("missingMark == null: " + (missingMark == null));

        /*
         * DO NOT run this without a null check:
         *
         * int mark = missingMark;
         *
         * Java tries to unbox missingMark, but there is no Integer object.
         * This throws NullPointerException at runtime.
         *
         * SAFE APPROACH:
         * Check for null before unboxing.
         */
        if (missingMark != null) {
            int mark = missingMark; // Safe because it is not null here.
            System.out.println("Mark = " + mark);
        } else {
            System.out.println("No mark is available; unboxing was skipped.");
        }

        // Another safe approach: choose a default value when null.
        int markOrZero = (missingMark != null) ? missingMark : 0;
        System.out.println("markOrZero = " + markOrZero);
        System.out.println();

        // --------------------------------------------------------------
        // SECTION 10: == VS equals() AND INTEGER CACHING
        // --------------------------------------------------------------
        System.out.println("SECTION 10: Comparing Integer objects");

        Integer smallOne = 100;
        Integer smallTwo = 100;

        Integer largeOne = 1000;
        Integer largeTwo = 1000;

        System.out.println("smallOne == smallTwo: " + (smallOne == smallTwo));
        System.out.println("smallOne.equals(smallTwo): " + smallOne.equals(smallTwo));
        System.out.println("largeOne == largeTwo: " + (largeOne == largeTwo));
        System.out.println("largeOne.equals(largeTwo): " + largeOne.equals(largeTwo));
        System.out.println();

        /*
         * == on Integer references checks whether they refer to the same
         * object, not whether their numeric contents are equal.
         *
         * Java caches Integer objects for at least the values -128 to 127.
         * Therefore, smallOne == smallTwo is normally true for 100.
         *
         * Do NOT rely on == for numeric equality between wrapper objects.
         * For equal numeric contents, use:
         *
         *     smallOne.equals(smallTwo)
         *
         * Or unbox them and compare primitive values.
         *
         * equals() is safe only when the reference is not null.
         */

        // --------------------------------------------------------------
        // SECTION 11: COMMON EXAM TRAPS
        // --------------------------------------------------------------
        System.out.println("SECTION 11: Common exam traps");

        // Trap 1: Integer can be null; int cannot.
        Integer possibleNull = null;
        System.out.println("possibleNull is null: " + (possibleNull == null));

        // Trap 2: A null wrapper cannot be unboxed.
        // int x = possibleNull; // Compiles, but throws NullPointerException.

        // Trap 3: Generic collections use wrapper types, not primitives.
        List<Integer> list = new ArrayList<>();
        list.add(5); // Autoboxing
        int value = list.get(0); // Unboxing
        System.out.println("List value = " + value);

        // Trap 4: String parsing can fail.
        try {
            int invalidNumber = Integer.parseInt("12x");
            System.out.println(invalidNumber);
        } catch (NumberFormatException exception) {
            System.out.println("parseInt(\"12x\") throws NumberFormatException.");
        }

        // Trap 5: The following line does not compile:
        // Integer bad = "123"; // String is not automatically converted to Integer.
        // Use Integer.valueOf("123") instead.

        System.out.println();

        // --------------------------------------------------------------
        // SECTION 12: QUICK REVISION TABLE
        // --------------------------------------------------------------
        System.out.println("SECTION 12: Quick revision");
        System.out.println("Autoboxing:   int -> Integer (automatic)");
        System.out.println("Unboxing:     Integer -> int (automatic)");
        System.out.println("valueOf(int): int -> Integer");
        System.out.println("intValue():   Integer -> int");
        System.out.println("parseInt():   String -> int");
        System.out.println("valueOf(String): String -> Integer");
        System.out.println("ArrayList<Integer>: stores Integer objects/references");
        System.out.println("int[]: primitive values; Integer[]: object references");
        System.out.println("Null Integer unboxed to int -> NullPointerException");
        System.out.println("Compare Integer contents with equals(), not ==, in general");

        System.out.println("\n=== END OF REVISION GUIDE ===");
        IO.println("--------------------------------------------------------------");



        // --------------------------------------------------------------
        // SECTION 13: COMPARING INTEGER OBJECTS WITH == AND equals()
        // --------------------------------------------------------------
        Integer a_value = new Integer(88);   // * best way is : Integer.valueOf(88) */
        Integer b_value = 88;

        System.out.println(a_value == b_value);      // * false because a == b	 Do both references point to the same object?	            false                              
        System.out.println(a_value.equals(b_value)); // * a.equals(b)	         Do both Integer objects represent the same value?	        true
    }
}

/*
======================================================================
EXPECTED TERMINAL OUTPUT
======================================================================

==================================================
JAVA OOP: AUTOBOXING AND UNBOXING REVISION GUIDE
==================================================

SECTION 1: Primitive vs wrapper class
primitiveValue = 10
wrapperValue   = 20

SECTION 2: Autoboxing
primitiveVal       = 42
boxedVal            = 42
boxedExplicitly     = 42
Both Integer values contain the same number.

SECTION 3: Unboxing
storedObject        = 75
extractedPrimitive  = 75
extractedExplicitly = 75

SECTION 4: Explicit conversion methods
Integer.valueOf(100)        = 100
fromValueOf.intValue()     = 100
Integer.parseInt("123")    = 123
Integer.valueOf("456")     = 456

SECTION 5: Other wrapper types
double -> Double -> double: 3.14 -> 3.14 -> 3.14
boolean -> Boolean -> boolean: true -> true -> true
char -> Character -> char: A -> A -> A

SECTION 6: Arrays
primitiveArray = [10, 2, 3]
wrapperArray   = [10, 5, 6]
wrapperArray[1] unboxed to int = 5

SECTION 7: ArrayList<Integer>
numbers = [10, 20, 30]
firstNumber (unboxed)  = 10
secondNumber (explicit)= 20
After set(2, 99)       = [10, 20, 99]

SECTION 8: Loops and arithmetic
numbers = [10, 20, 99]
total   = 129
a + b = 15

SECTION 9: Null safety
missingMark == null: true
No mark is available; unboxing was skipped.
markOrZero = 0

SECTION 10: Comparing Integer objects
smallOne == smallTwo: true
smallOne.equals(smallTwo): true
largeOne == largeTwo: false
largeOne.equals(largeTwo): true

SECTION 11: Common exam traps
possibleNull is null: true
List value = 5
parseInt("12x") throws NumberFormatException.

SECTION 12: Quick revision
Autoboxing:   int -> Integer (automatic)
Unboxing:     Integer -> int (automatic)
valueOf(int): int -> Integer
intValue():   Integer -> int
parseInt():   String -> int
valueOf(String): String -> Integer
ArrayList<Integer>: stores Integer objects/references
int[]: primitive values; Integer[]: object references
Null Integer unboxed to int -> NullPointerException
Compare Integer contents with equals(), not ==, in general

=== END OF REVISION GUIDE ===

NOTE ABOUT THE == OUTPUT:
Java specifies caching for Integer values in at least the -128 to 127 range.
The comparison for 100 is therefore true in this example. The comparison
for 1000 is false with the usual Integer.valueOf-based boxing used here;
never use == to compare the numeric contents of Integer objects.

======================================================================
*/
