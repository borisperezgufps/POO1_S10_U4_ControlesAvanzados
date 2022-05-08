package poo1.menues.views;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class MainMenues extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			GridPane root = (GridPane) FXMLLoader.
					load(getClass().getResource("GestionPersonal.fxml"));
			
//			GridPane root = (GridPane) FXMLLoader.
//					load(getClass().getResource("EmpleadoView_Ejemplo.fxml"));

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
