package it.polito.main.Inheritance;
/*
 TOPICS: java.lang.Object, toString(), equals(), hashCode(), printing objects.
 Every Java class ultimately inherits from Object.
*/
class Product {
    private String code;
    private String description;

    Product(String code, String description) {
        this.code = code;
        this.description = description;
    }

    @Override public String toString() {
        return "Product{code=" + code + ", description=" + description + "}";
    }

    @Override public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof Product)) return false;
        Product p = (Product) other;
        return this.code.equals(p.code);
    }

    // Contract: equal objects must have equal hash codes.
    @Override public int hashCode() { return code.hashCode(); }
}

class ObjectExamples {
    static void run() {
        Product p1 = new Product("P-100", "Laptop");
        Product p2 = new Product("P-100", "Different description");
        Product p3 = new Product("P-200", "Mouse");

        System.out.println(p1); // printing object calls toString()
        System.out.println(p1 == p2);       // false: different object references
        System.out.println(p1.equals(p2));  // true: same product code
        System.out.println(p1.equals(p3));  // false
        System.out.println(p1.hashCode() == p2.hashCode()); // true

        Object anything = p1; // Object is a very general reference type
        printAnything(anything);
        printAnything("A String is also an Object");
        printAnything(Integer.valueOf(42));
    }

    static void printAnything(Object value) {
        System.out.println("Received: " + value);
    }
}
