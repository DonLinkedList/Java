package fileIO;

import javafx.scene.text.Font ;
import javafx.application.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.*;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.SwingConstants;

@SuppressWarnings({ "unused", "static-access" })
public class Main extends Application {
	Button save, open;
	TextField TF;
	TextArea TF2;
	
	static File file;
	
	@Override
	public void start(Stage stage) {
		// TODO Auto-generated method stub
		testStage(stage);
	}
	
	public void testStage(Stage stage) {
		TF = new TextField("");
		TF.setMinSize(200, 30);
		TF.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

		TF2 = new TextArea("");
		TF2.setMinSize(200, 200);
		TF2.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		
		// TODO make the event handlers for the buttons
		OpenEH openEH = new OpenEH(TF, TF2);
		SaveEH saveEH = new SaveEH(TF, TF2);
		
		save = new Button(" save ");
		save.setMinSize(200, 30);
		save.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		save.setOnAction(saveEH);
		
		open = new Button(" open ");
		open.setMinSize(200, 30);
		open.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		open.setOnAction(openEH);
		
		GridPane io = new GridPane();
		io.setMinSize(250, 300);
		io.setPadding(new Insets(10, 10, 10, 10));
		io.setVgap(5);
		io.setHgap(5);
		io.setAlignment(Pos.CENTER);
		io.setGridLinesVisible(false);
		
		io.add(TF, 0, 0);
		io.add(open, 0, 1);
		io.add(TF2, 0, 2);
		io.add(save, 0, 3);
		
		Scene scene = new Scene(io, 250, 350);
		
		stage.setTitle("FileIO");
		stage.setMinWidth(250);
		stage.setMinHeight(300);
		stage.setScene(scene);
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}