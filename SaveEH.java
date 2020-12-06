package fileIO;

import javafx.event.EventHandler;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

@SuppressWarnings("unused")
public class SaveEH implements EventHandler<ActionEvent>{
	TextField TF;
	TextArea TF2;
	String line = "";
	String filename = "";
	
	public SaveEH(TextField TF, TextArea TF2) {
		this.TF = TF;
		this.TF2 = TF2;
	}
	
	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		filename = TF.getText();
		try {
			FileReader fr = new FileReader(filename);
			FileWriter fw = new FileWriter(filename);
			BufferedReader br = new BufferedReader(fr);
			BufferedWriter bw = new BufferedWriter(fw);
			
			System.out.println(TF2.getText());
			bw.write(TF2.getText());
			
//			while ((line = br.readLine()) != null) {
//				bw.write(line);
//			}
			
			br.close();
			bw.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
