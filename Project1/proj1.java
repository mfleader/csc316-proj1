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

        /*
        Not sure if we are doing input as program arguments or not
        if (args.length == 0) {
            new BattleshipGUI(new Battleship());
        }

        else if (args.length == 1) {
            try {
                int seed = Integer.parseInt(args[0]);
                new BattleshipGUI(new Battleship(seed));
            }
            catch (NumberFormatException e) {
                usageMessage();
                System.exit(1);
            }
        }
        else {
            usageMessage();
            System.exit(1);
        }
        */
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
     * Reads filename from user until the file exists, then return a file
     * scanner
     *
     * @param console Scanner that reads from the console
     *
     * @return a scanner to read input from the file
     * @throws FileNotFoundException if File does not exist
     */
     public static Scanner getInputScanner(Scanner console) throws FileNotFoundException
     {
         System.out.print("Enter a file name to process: ");

         /** a file object of the file named by the user */
         File file = new File(console.next());

         while (!file.exists())
         {
             // ASSERT: file.exists() returns false
             System.out.print("File doesn't exist. " + "Enter a file name to process: ");
             file = new File(console.next());
         }
         // ASSERT: file.exsits() returns true

         /** a Scanner object of the file, so that it can be read */
         Scanner fileScanner = new Scanner(file);

         return fileScanner;
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
}
