package it.polito.model;

/**
 * Recreates Slide 133: A Counter containing a non-static Inner Class (Incrementer)
 * that mutates the outer counter's state directly through its hidden instance tether.
 */
public class InnerClasses {

    // Instance variable of the outer class stored on the Heap
    private int i = 0;

    // =========================================================================
    // NON-STATIC INNER CLASS (Slide 131 & 133)
    // =========================================================================
    // Notice: NO 'static' keyword!
    // Every Incrementer object carries a hidden pointer (Counter.this) back to 
    // the specific Counter instance that instantiated it.
    public class Incrementer {
        
        private int step = 1;

        public Incrementer(int step) {
            // 'this.step' refers to the Incrementer's own field.
            this.step = step;
        }

        /**
         * Mutates the parent Counter's private variable 'i'!
         */
        public void doIncrement() {
            // Under the hood, javac rewrites 'i += step' to:
            // Counter.this.i += this.step;
            i += step;
        }
    }

    // =========================================================================
    // OUTER CLASS METHODS
    // =========================================================================
    /**
     * Factory method on the outer class that instantiates an Incrementer
     * tethered to THIS current Counter object.
     */
    public Incrementer buildIncrementer(int step) {
        // 'this' is implicitly passed to the inner class constructor
        return new Incrementer(step);
    }

    public int getValue() {
        return this.i;
    }
}