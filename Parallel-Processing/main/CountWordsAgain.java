package lab7B;

import java.util.ArrayList;
import java.util.concurrent.RecursiveAction;

@SuppressWarnings("serial")
public class CountWordsAgain extends RecursiveAction{
	private final int THRESHOLD = 20;
	static String scanningWord;
	ArrayList<String> list = new ArrayList<String>();
	
	public CountWordsAgain(ArrayList<String> list, String SW) {
		this.list = list;
		scanningWord = SW;
	}
	@Override
	protected void compute() {
		if (list.size() < THRESHOLD) {
			changeCount(wordCount(list));
//			System.out.println(Main.count);
		}
		else {
			ArrayList<String> partOne = new ArrayList<String>();
			ArrayList<String> partTwo = new ArrayList<String>();
			int half = (int)(list.size() / 2);
			
			for (int i = 0; i < half; i++) {
				partOne.add(list.get(i));
			}
			for (int i = half; i < list.size(); i++) {
				partTwo.add(list.get(i));
			}
			
			invokeAll(new CountWordsAgain(partOne, scanningWord), new CountWordsAgain(partTwo, scanningWord));
		}
		return;
	}
	
	//useless
	public static ArrayList<CountWords> shortenWorkload(ArrayList<String> lines) {
		ArrayList<CountWords> subtasks = new ArrayList<CountWords>();
		ArrayList<String> partOne = new ArrayList<String>();
		ArrayList<String> partTwo = new ArrayList<String>();
		int half = (int)(lines.size() / 2);
		
		for (int i = 0; i < half; i++) {
			partOne.add(lines.get(i));
		}
		for (int i = half; i < lines.size(); i++) {
			partTwo.add(lines.get(i));
		}
		
		subtasks.add(new CountWords(partOne, "the"));
		subtasks.add(new CountWords(partTwo, "the"));
		
		return subtasks;
	}
	
	public static int wordCount(ArrayList<String> list) {
		int count = 0;
		String keyWord = scanningWord;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).equalsIgnoreCase((keyWord))) {
				count++;
			}
		}
		return count;
	}
	
	public synchronized void changeCount(int amount) {
		Main.count += amount;
	}

}
