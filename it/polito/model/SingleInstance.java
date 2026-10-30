package it.polito.model;
import java.util.HashMap;
import java.util.Map;

public class SingleInstance {

    // 1. Private static variable of the same type to store the single instance
    private static SingleInstance instance; //* */ [Lazy Initialization.png]
    // 4. Public static method providing global on-demand access
    public static SingleInstance getInstance() {
        if (instance == null) {
            instance = new SingleInstance();
        }
        return instance;
    }

    // 2. Instance data managed by this class
    private Map<String, String> settings;

    // 3. Private constructor: blocks "new SingleInstance()" from outside
    private SingleInstance() {
        System.out.println("[SingleInstance] Constructor executed: Loading instance state once.");
        settings = new HashMap<>();
        settings.put("theme", "light");
        settings.put("volume", "70");
    }


    // 5. Normal non-static methods operating on this shared object
    public void setSetting(String key, String value) {
        this.settings.put(key, value);
    }

    public String getSetting(String key) {
        return this.settings.get(key);
    }

    // static lets this nested class exist without a SingleInstance object,
    // so its static root field can create the singleton directly.
    public static class DirectoryEager { 

        // Initialized when the class is loaded.
        public static final DirectoryEager root = new DirectoryEager();  // * [Eager Initialization.png]

        private DirectoryEager() {
            // Prevent callers from creating additional instances.
        }

        public void displayRootPath() {
            System.out.println("[DirectoryEager] Accessing global root directory.");
        }
    }
}