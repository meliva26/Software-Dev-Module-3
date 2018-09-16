package module3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Checks the spelling of words in a text file
 * @author Sky Varga
 */
public class SpellcheckApp {
	private static ArrayList<String> statesList;
	private static ArrayList<String> dictionaryList;
	private static final String STATES_FILE = "testStates.txt";
	private static final String DICTIONARY_FILE = "dictionary.txt";

	/**
	 * Main method
	 * @param args
	 */
	public static void main(String[] args) {
		ScanFiles(); //This will add words to the ArrayLists
		
		String dictionaryCheck = null;
		String statesCheck = null;
		
		for (int i = 0; i < dictionaryList.size(); i++) {
			dictionaryCheck = dictionaryList.get(i);
			for (int j = 0; j < statesList.size(); j++) {
				statesCheck = statesList.get(j);
				if (i == j && !dictionaryCheck.equals(statesCheck)) { //Check only if indexes are the same
					System.out.println(statesCheck + " is an unknown word.");
				}
			}
		}
	}
	
	/**
	 * Reads the provided text files
	 */
	public static void ScanFiles() {
		statesList = new ArrayList<>();
		dictionaryList = new ArrayList<>();
		
		//Read the contents of testStates.txt
		try (Scanner statesScanner = new Scanner(new File(STATES_FILE))) {
			while (statesScanner.hasNextLine()) {
				statesList.add(statesScanner.nextLine());
			}
		} catch (FileNotFoundException e) {
			System.out.println("Can't find " + STATES_FILE);
		}
		
		//Read the contents of dictionary.txt
		try (Scanner dictionaryScanner = new Scanner(new File(DICTIONARY_FILE))) {
			while (dictionaryScanner.hasNextLine()) {
				dictionaryList.add(dictionaryScanner.nextLine());
			}
		} catch (FileNotFoundException e) {
			System.out.println("Can't find " + DICTIONARY_FILE);
		}
	}

}
