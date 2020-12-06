package fileIO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.Event;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

@SuppressWarnings("unused")
public class OpenEH implements EventHandler<ActionEvent>{
	TextField TF;
	TextArea TF2;
	String line = "";
	String filename = "";
	File file;
	int runs = 0;
	
	public OpenEH (TextField TF, TextArea TF2) {
		this.TF = TF;
		this.TF2 = TF2;
	}
	
	@Override
	public void handle(ActionEvent event) {
		filename = TF.getText();
		System.out.println(filename);
		TF2.setText("");
		try {
			file = new File(filename);
			if (file.createNewFile()) {
				System.out.println(filename + "File Created in Project root directory");
			}
			else {
				System.out.println("File " + filename + " already exists in the project root directory");
			}
			FileReader fr = new FileReader(filename);
			BufferedReader br = new BufferedReader(fr);
			
			while ((line = br.readLine()) != null) {
				if (runs == 0) {
					TF2.setText(line);
					runs++;
				}
				else if (line == null) {
					System.out.println(runs + 1);
				}
				else {
					TF2.setText(TF2.getText() + "\n" + line);
					runs++;
				}
			}
			
			fr.close();
			br.close();
			runs = 0;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			TF2.setText("Invalid File Format");
		}
	}
	
//	void createNewFile() throws IOException {
//		Files.create(Paths.get(filename));
//	}
}
