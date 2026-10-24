package it.polito.main;

/* =============================================================================
 * TOPIC: Modifier / Query Separation (image_15f580.png)
 * FILE NAME: LearnQueryModifierSeparation.java
 * ============================================================================= */

// -----------------------------------------------------------------------------
// PART 1: THE PROPERLY DESIGNED CLASS (Separated)
// -----------------------------------------------------------------------------
class BankAccount {
    @SuppressWarnings("unused")
    private String owner;
    private double balance;

    public BankAccount(String owner, double initialBalance) {
        this.owner = owner;
        this.balance = initialBalance;
    }

    /*
     * 1. PURE QUERY
     * - Returns a value (double).
     * - Does NOT alter 'balance' or 'owner'.
     * - Safe to call repeatedly in any order.
     */
    public double getBalance() {
        return this.balance;
    }

    /*
     * Another Pure Query
     * - Returns a value (boolean).
     * - Does NOT modify anything.
     */
    public boolean hasSufficientFunds(double amount) {
        return this.balance >= amount;
    }

    /*
     * 2. PURE MODIFIER
     * - Returns 'void'.
     * - Modifies internal state ('balance').
     * - Calling this changes program behavior.
     */
    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.println("   [Modifier]: Deposited " + amount + "€");
        }
    }

    /*
     * Another Pure Modifier
     * - Returns 'void'.
     * - Modifies internal state ('balance').
     */
    public void withdraw(double amount) {
        if (amount <= this.balance) {
            this.balance -= amount;
            System.out.println("   [Modifier]: Withdrew " + amount + "€");
        } else {
            System.out.println("   [Modifier Error]: Insufficient funds!");
        }
    }

    // -------------------------------------------------------------------------
    // ANTI-PATTERN: BAD DESIGN (Mixing Query and Modifier)
    // -------------------------------------------------------------------------
    /*
     * THIS BREAKS THE PRINCIPLE:
     * This method looks like a query because it returns a double,
     * but it sneakily changes the balance by charging a fee!
     */
    public double badGetBalanceWithHiddenFee() {
        this.balance -= 2.0; // HIDDEN SIDE EFFECT!
        return this.balance;
    }
}

// -----------------------------------------------------------------------------
// PART 2: MAIN EXECUTION DEMONSTRATING THE SLIDE'S RULES
// -----------------------------------------------------------------------------
public class LearnQueryModifierSeparation {

    public static void main(String[] args) {

        BankAccount account = new BankAccount("Reza", 100.0);

        /* =====================================================================
         * DEMONSTRATION 1: QUERIES CAN BE ADDED, REMOVED, OR SWAPPED FREELY
         * "queries can be added, removed, and swapped without affecting the 
         * overall behavior"
         * ===================================================================== */
        System.out.println("--- 1. TESTING QUERIES (Safe & Idempotent) ---");
        
        // Calling queries multiple times in random order:
        System.out.println("Query 1 - Balance check: " + account.getBalance() + "€");
        System.out.println("Query 2 - Can afford 50€? " + account.hasSufficientFunds(50.0));
        System.out.println("Query 3 - Balance check again: " + account.getBalance() + "€");
        System.out.println("Query 4 - Can afford 150€? " + account.hasSufficientFunds(150.0));

        // The balance is STILL 100.0€. Queries left no footprint.


        /* =====================================================================
         * DEMONSTRATION 2: MODIFIERS CANNOT BE TOUCHED WITHOUT AFFECTING BEHAVIOR
         * "modifiers cannot be touched without affecting the behavior"
         * ===================================================================== */
        System.out.println("\n--- 2. TESTING MODIFIERS (State Alters With Every Call) ---");

        // Executing modifier operations:
        account.deposit(50.0);
        account.withdraw(30.0);
        System.out.println("Current balance after modifiers: " + account.getBalance() + "€");

        /*
         * Notice what happens if we change the order or duplicate a modifier:
         * - If we call deposit(50.0) a second time, balance becomes 170.0€ instead of 120.0€.
         * - If we swapped withdrawal and deposit on an empty account, withdrawal would fail.
         * Modifiers directly dictate system history.
         */


        /* =====================================================================
         * DEMONSTRATION 3: WHY MIXING THEM CAUSES DISASTER
         * ===================================================================== */
        System.out.println("\n--- 3. WHY MIXING QUERY & MODIFIER IS DANGEROUS ---");

        System.out.println("Starting balance: " + account.getBalance() + "€");

        // A programmer just wants to display the balance on the screen 3 times:
        System.out.println("Screen display 1: " + account.badGetBalanceWithHiddenFee() + "€");
        System.out.println("Screen display 2: " + account.badGetBalanceWithHiddenFee() + "€");
        System.out.println("Screen display 3: " + account.badGetBalanceWithHiddenFee() + "€");

        // The programmer only wanted to READ the balance, but lost 6.0€!
        System.out.println("Final balance ruined by side effects: " + account.getBalance() + "€");
    }
}
/* If a method answers a question, it is a Query → It must return a value and change nothing.   
PNG

If a method performs an action, it is a Modifier → It must return void and focus only on changing state.   
PNG */

/* =============================================================================
 *EXPECTED TERMINAL OUTPUT:
 * -----------------------------------------------------------------------------
 * --- 1. TESTING QUERIES (Safe & Idempotent) ---
 * Query 1 - Balance check: 100.0€
 * Query 2 - Can afford 50€? true
 * Query 3 - Balance check again: 100.0€
 * Query 4 - Can afford 150€? false
 * 
 * --- 2. TESTING MODIFIERS (State Alters With Every Call) ---
 *    [Modifier]: Deposited 50.0€
 *    [Modifier]: Withdrew 30.0€
 * Current balance after modifiers: 120.0€
 * 
 * --- 3. WHY MIXING QUERY & MODIFIER IS DANGEROUS ---
 * Starting balance: 120.0€
 * Screen display 1: 118.0€
 * Screen display 2: 116.0€
 * Screen display 3: 114.0€
 * Final balance ruined by side effects: 114.0€
 * ============================================================================= */