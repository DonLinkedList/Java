package lab7B;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class Main {
	static int count;
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
	public static void Count(ArrayList<String> list, String SW) {
		RecursiveAction cwa = new CountWordsAgain(list, SW);
		ForkJoinPool pool = new ForkJoinPool();
		pool.invoke(cwa);
	}
	
	public static void main(String[] args) {
		File file = new File("alice.txt");
		Scanner scan;
		ArrayList<String> bigList = new ArrayList<String>();
		ArrayList<String> temp;
		try {
			scan = new Scanner(file);
			while(scan.hasNextLine()) {
				temp = splitSentence(scan.nextLine());
				for (int i = 0; i < temp.size(); i++) {
					bigList.add(temp.get(i));
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
//		System.out.println(bigList);
		Count(bigList, "the");
		System.out.println("The final count of the word \"the\"(with an error range of 4): " + count);
	}
}
