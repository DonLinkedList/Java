package lab7B;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class SplitSentence {
	public static ArrayList<String> splitSentence(String string) {
		ArrayList<String> words = new ArrayList<String>();
		int start = 0;
		int end;
		for (int i = 0; i < string.length(); i++) {
			if(string.charAt(i) == ' ') {
				end = i;
				words.add(string.substring(start, end));
				start = i + 1;
			} else if (i == string.length() - 1) {
				words.add(string.substring(start, string.length()));
			}
		}
		return words;
	}
	public static int wordCount(ArrayList<String> list) {
		int count = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).toLowerCase().equals("the")) {
				count++;
			}
		}
		return count;
	}
	public static void printList(ArrayList<String> list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list);
		}
	}
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("alice.txt");
		int count = 0;
		Scanner scan = new Scanner(file);
		
		while(scan.hasNextLine()) {
			count += wordCount(splitSentence(scan.nextLine()));
		}
		scan.close();
		
		String sentence = "The Brown Fox Jumped Over the Sleeping Dog The The tHe Thhe The thE";
		System.out.println(splitSentence(sentence));
		System.out.println(wordCount(splitSentence(sentence)));
		System.out.println(count);
	}
}
