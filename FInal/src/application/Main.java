package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) throws IOException {
		Parent root = FXMLLoader.load(Controller.class.getResource("Splash.fxml"));
		
		 Scene scene = new Scene(root);

		
		 primaryStage.setScene(scene);
		 primaryStage.setTitle("FXML"); 
		 primaryStage.sizeToScene();
		 primaryStage.show();
		 
		 
		 
		 
	}

	public static void main(String[] args) {
		launch(args);
	}
}
