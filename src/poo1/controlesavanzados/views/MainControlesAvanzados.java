package poo1.controlesavanzados.views;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class MainControlesAvanzados extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			GridPane root = (GridPane) FXMLLoader.load(getClass().getResource("GrupoAmigos.fxml"));

			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
