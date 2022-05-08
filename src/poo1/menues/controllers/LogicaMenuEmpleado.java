package poo1.menues.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LogicaMenuEmpleado {

	public void abrirPantallaInicio(MenuBar myMenuBar) {
		try {
			GridPane root = (GridPane) FXMLLoader
					.load(getClass().getResource("/poo1/menues/views/EmpleadoView_Ejemplo.fxml"));

			Stage stage = (Stage) myMenuBar.getScene().getWindow();
			
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
			
			System.out.println("Se abrió la pantalla de Inicio. Bienvenido");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void abrirPantallaAgregarEmpleado(MenuBar myMenuBar) {
		try {
			AnchorPane root = (AnchorPane) FXMLLoader
					.load(getClass().getResource("/poo1/menues/views/AgregarEmpleadoView_Ejemplo.fxml"));

			Stage stage = (Stage) myMenuBar.getScene().getWindow();
			
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
