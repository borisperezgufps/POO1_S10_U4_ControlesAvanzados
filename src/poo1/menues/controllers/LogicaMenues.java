package poo1.menues.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LogicaMenues {

	public void handleIncluirMascotaMenu(ActionEvent event, MenuBar myMenuBar) {
		try {
			GridPane root = (GridPane) FXMLLoader
					.load(getClass().getResource("/poo1/menues/views/RegistrarMascotas.fxml"));

			Stage stage = (Stage) myMenuBar.getScene().getWindow();
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void handleIncluirAmigoMenu(ActionEvent event, MenuBar myMenuBar) {
		try {
			GridPane root = (GridPane) FXMLLoader
					.load(getClass().getResource("/poo1/menues/views/RegistrarAmigos.fxml"));

			Stage stage = (Stage) myMenuBar.getScene().getWindow();
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void handleInicioMenu(ActionEvent event, MenuBar myMenuBar) {
		try {
			GridPane root = (GridPane) FXMLLoader
					.load(getClass().getResource("/poo1/menues/views/GestionPersonal.fxml"));

			Stage stage = (Stage) myMenuBar.getScene().getWindow();
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
