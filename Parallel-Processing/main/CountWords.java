package lab7B;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class CountWords implements Runnable{
	File file;
	int count;
	Scanner scan;
	ArrayList<String> list = new ArrayList<String>();
	static String scanningWord;
	
	public CountWords(ArrayList<String> list, String SW) {
		this.list = list;
		scanningWord = SW;
	}
	
	@Override
	public void run() {
		count += wordCount(list);
		System.out.println("The amount of times the word \"" + scanningWord + "\" appears in " + file.getName() + ": " + count);
	}
	
	public static int wordCount(ArrayList<String> list) {
		int count = 0;
		String keyWord = scanningWord;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).toLowerCase().equals(keyWord)) {
				count++;
			}
		}
		return count;
	}
}
