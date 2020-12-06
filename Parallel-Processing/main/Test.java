package lab7B;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) throws FileNotFoundException {
		String line = "";
//		int count = 0;
		ArrayList<String> words = new ArrayList<String>();
		File file = new File("test.txt");
		Scanner scan = new Scanner(file);
		while(scan.hasNextLine()) {
			line = scan.nextLine();
			for (int i = 0; i < words.size(); i++) {
				line.split(" ");
			}
		}
		scan.close();
	}
}
