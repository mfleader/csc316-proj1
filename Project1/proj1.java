import java.util.*;
import java.io.*;

/**
 * This program compresses and decompresses text files that contain no digits.
 *
 * @author Matthew F. Leader
 * Last Edited    2017.05.22
 * Created        2017.05.22
 */
public class proj1 {

    public static void main(String[] args) {

        if (args.length < 1) {
            // Compress text
        } else {
            // Compress or decompress text from a filename arguments given
            for (int k = 0; k < args.length; k++) {
                Scanner input = getInputScanner(args[k]);
                if (input.next().equals("0")) {
                    // Decompress
                } else {
                    // Compress
                }
            }
        }

    }

    /**
     * Returns a Scanner for input from a file.
     *
     * @param console Scanner for console
     * @return Scanner for input from a file
     */
    public static Scanner getInputScanner(Scanner console) {
        Scanner input = null;
        while (input == null) {
            System.out.print("input file name? ");
            String name = console.nextLine();
            try {
                input = new Scanner(new File(name));
            } catch (FileNotFoundException e) {
                System.out.println("File not found. Please try again.");
            }
        }
        return input;
    }




    /**
     * This class models the state and behavior of a LinkedList.
     *
     */
    private class LinkedList {

        /** the first element in the collection */
        private Node head;

        /**
         * This class models the state and behavior of a Node in the
         * LinkedList.
         */
        public class Node {

            /** the data within the element */
    		private String data;
    		/** a reference to the next element in the list */
    		private ListNode next;

            /**
             * Constructs a Node given data and a pointer to the next element.
             * @param data
             *              the data in this element
             * @param next
             *              the pointer to the next element
             */
            public Node(String data, Node next) {
                this.data = data;
                this.next = null;
            }

            /**
             * Constructs a Node when give data and no pointer to the
             * next element.
             * @param data
             *              the data in this element
             */
            public Node(String data) {
                this(data, null);
            }
        }
    }

    /**
     * This method gets the arguments supplied to the main method and
     * creates a Scanner object representation of the input file.
     * @param mainArgs the argument given to the main method
     * @return a Scanner object representation of the input file
     */
    public static Scanner getArgInput(String[] mainArgs) {
        /** A Scanner object representation of the input file */
        Scanner input = null;
        if (mainArgs.length == 1) {
            // ASSERT: mainArgs.length == 1
            /** the file name supplied as argument to the program startup */
            String fileName = mainArgs[0];
            try {
                input = new Scanner(new File(mainArgs[0]));
            } catch (FileNotFoundException e) {
                System.out.println("Unable to access input file: " + fileName);
                System.exit(1);
            }
        } else {
            // ASSERT: mainArg.length != 1
            System.out.println("Usage: java proj1 filename");
            System.exit(1);
        }
        return input;
    }



    /**
     * Returns a PrintStream for output to a file. NOTE: If file exists, this
     * code will overwrite the existing file. It is likely that you want to add
     * additional tests.
     *
     * @param console Scanner for console.
     * @return PrintStream for output to a file
     */
    public static PrintStream getOutputPrintStream(Scanner console) {
        PrintStream outputFile = null;
        while (outputFile == null) {
            System.out.print("output file name? ");
            String name = console.nextLine();
            try {
                outputFile = new PrintStream(new File(name));
            } catch (FileNotFoundException e) {
                System.out.println("File unable to be written. Please try again.");
            }
        }
        return outputFile;
    }
}
