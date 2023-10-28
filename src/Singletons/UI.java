package Singletons;

import java.util.Scanner;

/**
 * Singleton class for managing the UI
 * Ensures printing and reading from the console is thread-safe
 */
public class UI {
    /**
     * The instance of the UI class
     */
    private static UI instance;

    /**
     * The scanner used for reading from the console
     */
    private final Scanner scanner;

    /**
     * Private constructor of the UI class
     */
    private UI() {
        scanner = new Scanner(System.in);
    }

    /**
     * Returns the instance of the UI class
     */
    public static UI getInstance() {
        if (instance == null)
            instance = new UI();
        return instance;
    }

    /**
     * Prints a message to the console seperated by spaces
     */
    public synchronized void print(Object... args) {
        StringBuilder output = new StringBuilder();
        for (Object arg : args) {
            output.append(arg.toString()).append(" ");
        }
        print(output.toString(), true);
    }

    private void print(String message, boolean newLine) {
        if (newLine){
            System.out.println(message);
        } else {
            System.out.print(message);
        }
    }

    /**
     * Reads a line from the console
     */
    public synchronized String read() {
        print(">>", false);
        return scanner.nextLine();
    }
}
