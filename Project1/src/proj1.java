import java.util.*;
import java.io.*;
import java.util.regex.Pattern;


/**
 * This program compresses and decompresses text files that contain no digits.
 *
 * @author Matthew F. Leader
 */
public class proj1 {

    public static void main(String[] args) {

        /*
        LinkedList list = new LinkedList();
        String str0 = "love";
        String str1 = "me";
        String str2 = "do";

        System.out.println("list.size() = " + list.size());
        System.out.println("list.isEmpty() = " + list.isEmpty());

        list.add(str0);
        System.out.println("list.size() = " + list.size());
        System.out.println("list.toArray()[0] = " + list.toArray()[0]);
        System.out.println("list.get(0) = " + list.get(0));
        System.out.println("list.isEmpty() = " + list.isEmpty());
        System.out.println("----------------------");

        list.add(str1);
        System.out.println("list.size() = " + list.size());
        System.out.println("list.toArray()[0] = " + list.toArray()[0]);
        System.out.println("list.toArray()[1] = " + list.toArray()[1]);
        System.out.println("list.get(0) = " + list.get(0));
        System.out.println("list.get(1) = " + list.get(1));
        System.out.println("----------------------");

        list.add(str2);
        System.out.println("list.size() = " + list.size());
        System.out.println("list.toArray()[0] = " + list.toArray()[0]);
        System.out.println("list.toArray()[1] = " + list.toArray()[1]);
        System.out.println("list.toArray()[2] = " + list.toArray()[2]);
        System.out.println("list.get(0) = " + list.get(0));
        System.out.println("list.get(1) = " + list.get(1));
        System.out.println("list.get(2) = " + list.get(2));
        System.out.println("----------------------");
        */

        Scanner console = new Scanner(System.in);
        String filename = null;
        Scanner input = null;

        while (input == null) {
            System.out.println("Text Compressor and Decompressor.");
            System.out.print("input file name: ");
            filename = console.nextLine();
            input = getInputScanner(filename);
        }

        if (validateNoDigits(input)) {
            input = getInputScanner(filename);
            if (input.hasNextInt()) {
                decompress(input);
            } else {
                compress(input);
            }
        } else {
            digitsUsageMessage();
        }
    }

    public static boolean validateNoDigits(Scanner fileScanner) {
        return true;
    }


    public static void compress(Scanner fileScanner) {
        LinkedList list = new LinkedList();
        int listIndex;
        Pattern nonLetterCharacter = Pattern.compile("[^a-zA-Z]");
        Pattern letterChar = Pattern.compile("[a-zA-Z]");
        while (fileScanner.hasNextLine()) {
            Scanner lineScanner = new Scanner(fileScanner.nextLine());
            lineScanner.useDelimiter(nonLetterCharacter);
            while (lineScanner.hasNext()) {
                String text = lineScanner.next();
                //System.out.println("text1 = " + text);
                listIndex = list.find(text);
                //System.out.println("listIndex = " + listIndex);
                //System.out.println("list.get(listIndex) = " + list.get(listIndex));
                //System.out.println("list.get(0) = " + list.get(0));
                if (listIndex == -1) {
                    System.out.print(text);
                    //System.out.println("text.length() = " + text.length());
                } else {
                    System.out.print(listIndex + 1);
                }
                //System.out.println("list.size() =" + list.size());
                list.add(text);
                //System.out.println("list.size() =" + list.size());
                //lineScanner.useDelimiter(letterChar);
                while (lineScanner.hasNext("[^a-zA-Z]&&[ \\t\\n\\f\\r]")) {
                    System.out.print(lineScanner.findInLine(nonLetterCharacter));
                }

                //lineScanner.useDelimiter(nonLetterCharacter);
                //System.out.println(lineScanner.next());

                /*
                System.out.println("---LIST---");
                for (int k = 0; k < list.size(); k++) {
                    System.out.println(list.get(k));
                }
                System.out.println("---END----");
                */
            }
        }
    }

    public static void decompress(Scanner fileScanner) {

    }

    public static void digitsUsageMessage() {
        System.out.println("Your text contains at least one digit from"
                            + " the sequence 0, 1, 2, 3, 4, 5, 6, 7, 8, "
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
    public static Scanner getInputScanner(String filename) {
        Scanner input = null;
        try {
            input = new Scanner(new File(filename));
        } catch (FileNotFoundException e) {
            System.out.println("File not found. Please try again.");
        }
        return input;
    }


    /**
     * This class models the state and behavior of a Linked List Stack
     * @author Matthew F. Leader
     */
    private static class LinkedList {

        /** the first element in the collection */
        private Node front;
        /** size of the list */
        private int size;

        /**
         * Construct a Linked List
         */
        public LinkedList() {
            front = null;
            size = 0;
        }

        public boolean isEmpty() {
            return front == null;
        }

        public int size() {
            return size;
        }

        /**
         * Add an item to the front, or if it is already on the list, then move
         * element the containing data equal to the parameter to the front.
         * @param data
         *              the data to add to the list
         */
        public void add(String data) {
            if (front == null) {
                front = new Node(data, null);
            } else {
                //System.out.println("list.remove(data) = " + remove(data));
                front = new Node(data, front);
            }

            //System.out.println("data = " + data);

            //System.out.println("front.data = " + front.data);
            size++;
        }

        /**
         * Find a String on the list.
         * @param data
         *              the String to look for on the list
         * @return if the String is on the list, then return the index,
         *          otherwise return -1
         */
        public int find(String data) {
            int index = -1;
            for (Node k = front; k != null; k = k.next) {
                index++;
                if (k.data.equals(data)) {
                    return index;
                }
            }
            return -1;
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
                size--;
                return current.data;
            }
            return null;
        }

        /**
         * Convert the Linked List to an array
         * @return an array of the objects on the List
         */
        public String[] toArray() {
            String[] array = null;
            if (!isEmpty()) {
                array = new String[size];
                int k = 0;
                Node current = front;
                while (k < size && current != null) {
                    array[k] = current.data;
                    k++;
                    current = current.next;
                }
            }
            return array;
        }

        public String get(int index) {
            Node current = front;
            for (int k = 0; k < index; k++) {
                current = current.next;
            }
            if (current != null) {
                return current.data;
            }
            return null;
        }


        /**
         * Remove a Node at a given index
         * @param index
         *              the index of the element to remove from the list
         * @return the Node removed from the list
         */
        private Node remove(int index) {
            return null;
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

    /**
     * This method gets the arguments supplied to the main method and
     * creates a Scanner object representation of the input file.
     * @param mainArgs the argument given to the main method
     * @return a Scanner object representation of the input file
     */
    public static Scanner getArgInput(String arg) {
        /** A Scanner object representation of the input file */
        Scanner input = null;
        try {
            input = new Scanner(new File(arg));
        } catch (FileNotFoundException e) {
            System.out.println("Unable to access input file: " + arg);
            System.exit(1);
        }
        return input;
    }


}
