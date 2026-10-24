package it.polito.model;

/**
 * CONCEPT 1: "Top-Level Class"
 * This class sits directly in the file, not inside another class.
 * 
 * CONCEPT 2: "Exported Public API"
 * Marked 'public', so other packages (like it.polito.main) can import and use it.
 */
public class BankAccount {

    // CONCEPT 3: "Encapsulation Boundary"
    // Marked 'private'. Outside code cannot touch or corrupt this directly!
    private int balance;

    public BankAccount(int initialDeposit) {
        if (initialDeposit > 0) {
            this.balance = initialDeposit;
        } else {
            this.balance = 0;
        }
    }

    // PART OF THE PUBLIC API: A safe doorway to change balance
    public void deposit(int amount) {
        if (amount > 0) {
            this.balance += amount;
            // Uses our hidden helper (inside the trust boundary) to log the event
            InternalAuditLogger.log("Deposited: " + amount);
        }
    }

    // PART OF THE PUBLIC API: A safe doorway to read balance
    public int getBalance() {
        return this.balance;
    }
}

/**
 * CONCEPT 4: "Trust Boundary" & "Package-Private"
 * Notice there is NO 'public' keyword here! Just 'class InternalAuditLogger'.
 * 
 * This is an internal helper. 
 * - BankAccount can use it because they live in the SAME folder (it.polito.model).
 * - Outside packages CANNOT see it or touch it.
 */
class InternalAuditLogger {
    static void log(String message) {
        System.out.println("[INTERNAL LOG]: " + message);
    }
}