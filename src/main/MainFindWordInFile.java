package main;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class MainFindWordInFile {

	
	private static String fileName = "Z://book.txt";
	
	
	
	public static void main(String[] args) throws FileNotFoundException {
		
		
		HashMap<String, Integer> map = new HashMap<>();
		
		//Try to open txt file and read all text.
		//If file don't exist, than file create automatical
		String all = new String();
		try {
			all = FileWorker.read(fileName);
		}catch (FileNotFoundException e) {
			FileWorker.create(fileName);
			FileWorker.write(fileName, "This is test string, string for fun!");
			all = FileWorker.read(fileName);
		}
		
		
		//Go through the line and replace all punctuation marks with spaces
		//After replacing should split the string into spaces
		int value = 0;
		for (String s : all.toLowerCase().replaceAll("[^A-Za-zР-пр-џ0-9]", " ").split("[\n \\s]+")) {
			//if key already exist -> value++
			//else value = 1
			if (map.get(s) != null) {
				value = map.get(s);
			} else {
				value = 0;
			}
			map.put(s, ++value);
		}
		
		
		for (Map.Entry<String, Integer> entry : map.entrySet()){
			System.out.println(entry.getKey() + " " + entry.getValue() + " ");
		}
	}
	
	


}
