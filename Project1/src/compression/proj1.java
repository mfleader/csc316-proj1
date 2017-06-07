package compression;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Pattern;



/**
 * This program compresses contain no digits, and can decompress those files by means
 * of Standard input and output.
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

    /**
     * 
     * @param fileScanner
     */
    public static void compress(Scanner fileScanner) {
        LinkedList list = new LinkedList();
        int listIndex;
        int uncompCharCt = 0;
        int compCharCt = 0;
        System.out.print("0 ");                      
        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            uncompCharCt += line.length();                 
            String[] textArray = line.split("\\b");
            
            /*
            System.out.println();
            System.out.println();
            System.out.println("---LIST---");
            System.out.println("textArray size = " + textArray.length);
            for (int k = 0; k < textArray.length; k++) {
                System.out.println("textArray[" + k + "] = \"" + textArray[k] + "\"");
            }
            System.out.println("---END----");
            */
            
            for (int k = 0; k < textArray.length; k++) {
            	if (textArray[k].length() > 0 && Character.isLetter(textArray[k].charAt(0))) {
            		String data = textArray[k];
            		listIndex = list.find(data);
            		if (listIndex == -1) {
            			compCharCt += data.length();
            			System.out.print(data);
            		} else {
            			compCharCt += (Integer.toString(listIndex + 1).length());
            			System.out.print(listIndex + 1);
            		}
            		list.add(data);
            	} else {
            		compCharCt += textArray[k].length();
            		System.out.print(textArray[k]);
            	}
            }                
            if (fileScanner.hasNextLine()) {
                System.out.println();
            }            
        }      
        System.out.println();
        System.out.println("0 Uncompressed: " + uncompCharCt + " bytes;"
                            + " Compressed: " + compCharCt + " bytes");
        
        /*
        System.out.println();
        System.out.println();
        System.out.println("---LIST---");
        System.out.println("list size = " + list.size());
        for (int k = 0; k < list.size(); k++) {
            System.out.println("list.get(" + k + ") = " + list.get(k));
        }
        System.out.println("---END----");
		*/
    }

    /**
     * 
     * @param fileScanner
     */
    public static void decompress(Scanner fileScanner) {
        LinkedList list = new LinkedList();
        fileScanner.findInLine("0 ");
        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            if (line.length() > 0 && line.charAt(0) != '0') {            	
                String[] textArray = line.split("\\b"); 
                
                /*
                System.out.println();
                System.out.println();
                System.out.println("---LIST---");
                System.out.println("textArray size = " + textArray.length);
                for (int k = 0; k < textArray.length; k++) {
                    System.out.println("textArray[" + k + "] = \"" + textArray[k] + "\"");
                }
                System.out.println("---END----");
                */
                
                for (int k = 0; k < textArray.length; k++) {
                	if (textArray[k].length() > 0) {
                		if (Character.isLetter(textArray[k].charAt(0))) {
                			list.add(textArray[k]);
                			System.out.print(textArray[k]);
                		} else if (Character.isDigit(textArray[k].charAt(0))) {
                			int index = Integer.parseInt(textArray[k]) - 1;
                			System.out.print(list.get(index));
                			list.add(list.get(index));
                		} else {
                			System.out.print(textArray[k]);
                		}
                	}
                }                
                if (fileScanner.hasNextLine()) {
                	System.out.println();
                }   
            } else if (line.length() == 0) {
            	System.out.println();
            }
        }               
    }    
}

