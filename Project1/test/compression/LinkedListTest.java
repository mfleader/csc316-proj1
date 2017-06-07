/**
 * 
 */
package compression;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.Test;

/**
 * @author Matthew
 *
 */
public class LinkedListTest {
	
	private static final String LOVE = "LOVE";
	private static final String ME = "ME";
	private static final String YOU = "YOU";
	private static final String DO = "DO";
	private static final String I = "I";

	/**
	 * Test method for {@link compression.LinkedList#LinkedList()}.
	 */
	@Test
	public void testLinkedList() {
		LinkedList list = new LinkedList();
		assertTrue(list.isEmpty());
		assertEquals(0, list.size());
	}



	/**
	 * Test method for {@link compression.LinkedList#add(java.lang.String)}.
	 */
	@Test
	public void testAdd() {
		LinkedList list = new LinkedList();
		
		list.add(LOVE);
		assertEquals(1, list.size());
		assertEquals(LOVE, list.get(0));
		
		list.add(YOU);
		assertEquals(2, list.size());
		assertEquals(YOU, list.get(0));
		assertEquals(LOVE, list.get(1));
		
		list.add(LOVE);
		assertEquals(2, list.size());
		assertEquals(LOVE, list.get(0));
		assertEquals(YOU, list.get(1));
		
	}

	/**
	 * Test method for {@link compression.LinkedList#find(java.lang.String)}.
	 */
	@Test
	public void testFind() {
		
		//String line = "     \"You are in the Last Homely House — or the first — or maybe neither, as";
		
		LinkedList list = new LinkedList();
		int listIndex;
		int compCharCt = 0;
		String filename = "input3C.txt";
		Scanner file;
		try {
			PrintStream fileWriter = new PrintStream(new File(filename));
			file = new Scanner(new File("input3.txt"));
			while (file.hasNextLine()) {
				String line = file.nextLine();
				if (line.length() > 0) {
			        String[] textArray = line.split("\\b");			     			        
			        for (int k = 0; k < textArray.length; k++) {
			        	if (textArray[k].length() > 0 && Character.isLetter(textArray[k].charAt(0))) {
			        		String data = textArray[k];
			        		listIndex = list.find(data);
			        		if (listIndex == -1) {
			        			compCharCt += data.length();
			        			fileWriter.print(data);
			        		} else {
			        			compCharCt += (Integer.toString(listIndex + 1).length());
			        			fileWriter.print(listIndex + 1);
			        		}
			        		list.add(data);
			        	} else {
			        		compCharCt += textArray[k].length();
			        		fileWriter.print(textArray[k]);
			        	}
			        }    			        
			        if (file.hasNextLine()) {
			        	fileWriter.println();
			        }
				} else {
					fileWriter.println();
				}
			}
			fileWriter.close();
		} catch (FileNotFoundException e) {
			fail();
			e.printStackTrace();
		}
		
		

	}





}
