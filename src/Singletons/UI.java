package Singletons;

import java.util.Scanner;
import java.util.concurrent.Semaphore;

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
     * The semaphore used to lock print commands between overloads of print command
     */
    private final Semaphore printingSemaphore = new Semaphore(1);

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
        try {
            StringBuilder output = new StringBuilder();
            for (Object arg : args) {
                output.append(arg.toString()).append(" ");
            }

            printingSemaphore.acquire();
            printInternal(output.toString(), true, false);
            printingSemaphore.release();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized void printError(Object... args) {
        try {
            StringBuilder output = new StringBuilder();
            for (Object arg : args) {
                output.append(arg.toString()).append(" ");
            }
            printingSemaphore.acquire();
            printInternal(output.toString(), true, true);
            printingSemaphore.release();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void printInternal(String message, boolean newLine, boolean error) {
        if (error) {
            System.err.println(message);
        } else {
            if (newLine) {
                System.out.println(message);
            } else {
                System.out.print(message);
            }
        }
    }

    /**
     * Reads a line from the console
     */
    public synchronized String read() {
        try {

            printingSemaphore.acquire();
            printInternal(">>", false, false);
            String input = scanner.nextLine();
            printingSemaphore.release();

            return input;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
