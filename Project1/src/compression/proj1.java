package compression;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Pattern;

import compress.util.LinkedList;


/**
 * This program compresses and decompresses text files that contain no digits.
 *
 * @author Matthew F. Leader
 */
public class proj1 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
        	if (input.hasNextInt()) {
        		decompress(input);
        	} else {
        		compress(input);
        	}
        }
    }

    public static void compress(Scanner fileScanner) {
        LinkedList list = new LinkedList();
        int listIndex;
        int uncompCharCt = 0;
        int compCharCt = 0;
        Pattern nonLetterCharacter = Pattern.compile("[^a-zA-Z]");
        Pattern letterChar = Pattern.compile("[a-zA-Z]");
        System.out.print("0 ");
        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            uncompCharCt += line.toCharArray().length;
            Scanner lineScanner = new Scanner(line);
            lineScanner.useDelimiter(nonLetterCharacter);
            while (lineScanner.hasNext()) {
                String text = lineScanner.next();
                listIndex = list.find(text);

                if (listIndex == -1) {
                    compCharCt += text.toCharArray().length;
                    System.out.print(text);
                } else {
                    compCharCt += (Integer.toString(listIndex + 1).length());
                    System.out.print(listIndex + 1);
                }
                list.add(text);
                lineScanner.useDelimiter(letterChar);
                if (lineScanner.hasNext()) {
                    String specialCharacters = lineScanner.next();
                    compCharCt += specialCharacters.toCharArray().length;
                    System.out.print(specialCharacters);
                }
                lineScanner.useDelimiter(nonLetterCharacter);
            }
            if (fileScanner.hasNextLine()) {
                System.out.println();
            }
        }

        System.out.println("\n0 Uncompressed: " + uncompCharCt + " bytes;"
                            + " Compressed: " + compCharCt + " bytes");

    }

    public static void decompress(Scanner fileScanner) {
        LinkedList list = new LinkedList();
        int listIndex;

        Pattern nonLetterCharacter = Pattern.compile("[^a-zA-Z]");
        Pattern letterChar = Pattern.compile("[a-zA-Z]");
        fileScanner.findInLine("0 ");
        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            Scanner lineScanner = new Scanner(line);
            lineScanner.useDelimiter(nonLetterCharacter);
            while (lineScanner.hasNext()) {
                String text = lineScanner.next();
                listIndex = list.find(text);
                if (listIndex == -1) {
                    System.out.print(text);
                } else {
                    System.out.print(listIndex + 1);
                }
                list.add(text);
                lineScanner.useDelimiter(letterChar);
                if (lineScanner.hasNext()) {
                    String specialCharacters = lineScanner.next();
                    System.out.print(specialCharacters);
                }
                lineScanner.useDelimiter(nonLetterCharacter);
            }
            if (fileScanner.hasNextLine()) {
                System.out.println();
            }
        }
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
}

