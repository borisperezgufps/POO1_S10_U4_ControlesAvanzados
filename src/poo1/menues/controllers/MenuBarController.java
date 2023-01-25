package poo1.menues.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MenuBarController {

	private LogicaMenues logica;
	
	@FXML 
	private MenuBar myMenuBar;
	
	public MenuBarController() {
		logica = new LogicaMenues();
	}
	
	@FXML
	public void handleIncluirAmigoMenu(ActionEvent event) {
		logica.handleIncluirAmigoMenu(event, myMenuBar);
	}
	
	@FXML
	public void handleIncluirMascotaMenu(ActionEvent event) {
		logica.handleIncluirMascotaMenu(event, myMenuBar);		
	}
	
	@FXML
	public void handleInicioMenu(ActionEvent event) {
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
