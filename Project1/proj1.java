import java.util.*;
import java.io.*;

/**
 * This program compresses and decompresses text files that contain no digits.
 *
 * @author Matthew F. Leader
 */
public class proj1 {

    public static void main(String[] args) {

        if (args.length < 1) {
            Scanner keyboard = new Scanner(System.in);
            // Validate No Digits in keyboard entry
            if (validateNoDigits(keyboard)) {
                // Compress text
                compress(keyboard);
            } else {
                digitsUsageMessage();
            }
        } else {
            // Compress or decompress text from a filename arguments given
            for (int k = 0; k < args.length; k++) {
                Scanner input = getInputScanner(args[k]);
                if (input.next().equals("0")) {
                    // Decompress
                    decompress(text);
                } else {
                    // Compress
                    if (validateNoDigits(input)) {
                        input = getInputScanner(args[k]);
                        compress(input);
                    } else {
                        digitsUsageMessage();
                    }
                }
            }
        }
    }

    public static boolean validateNoDigits(Scanner text) {

    }

    public static void compress(Scanner text) {

    }

    public static void decompress(Scanner text) {

    }

    public static void digitsUsageMessage() {
        System.out.println("Your text contains at least one digit from"
                            + " the series 0, 1, 2, 3, 4, 5, 6, 7, 8, "
                            + "9.");
        System.out.println("Please remove all digits from your text"
                            + " and try again.");
    }

    /**
     * Returns a Scanner for input from a file.
     *
     * @param console
     *              Scanner for console
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
     * This class models the state and behavior of a Linked List Stack
     *
     */
    private class LinkedList {

        /** the first element in the collection */
        private Node front;
        /** size of the list */
        private int size;

        /**
         * Construct a Doubly Linked List
         */
        public LinkedList() {
            front = new Node(null);
            size = 0;
        }

        public isEmpty() {
            return first == null;
        }

        /**
         * Add an item to the front, or if it is already on the list, then move
         * element the containing data equal to the parameter to the front.
         * @param data
         *              the data to add to the list
         */
        public void add(String data) {
            remove(data);
            front = new Node(data, front);
        }

        /**
         * Remove a Node with the given data, if it exists
         * @param data
         *              the data to remove from the list
         * @return the Node removed from the list
         */
        private String remove(String data) {
            Node current = front;
            Node previous = null;
            while (current != null && !current.data.equals(data)) {
                previous = current;
                current = current.next;
            }
            if (current != null) {
                if (current == front) {
                    front = front.next;
                } else {
                    previous.next = current.next;
                }
                return current.data;
            }
            return null;
        }

        /**
         * Find a String on the list.
         * @param data
         *              the String to look for on the list
         * @return if the String is on the list, then return the index,
         *          otherwise return 0
         */
        public int find(String data) {
            int index = 0;
            for (Node k = front; k != null; k = k.next) {
                if (k.data.equals(data)) {
                    return index;
                }
                index++;
            }
            return index;
        }

        /**
         * Remove a Node at a given index
         * @param index
         *              the index of the element to remove from the list
         * @return the Node removed from the list
         */
        private Node remove(int index) {

        }



        /**
         * This class models the state and behavior of a Node in the
         * LinkedList.
         */
        private class Node {

            /** the data within the element */
    		private String data;
    		/** a reference to the next element in the list */
    		private Node next;

            /**
             * Constructs a Node given data and a pointer to the next element.
             * @param data
             *              the data in this element
             * @param next
             *              the pointer to the next element
             */
            public Node(String data, Node next) {
                this.data = data;
                this.next = next;
            }

            /**
             * Constructs a Node with null pointers
             * @param data
             *              the data in this element
             */
            public Node(String data) {
                this(data, null);
            }
        }
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
