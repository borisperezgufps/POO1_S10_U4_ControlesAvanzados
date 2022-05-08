package poo1.menues.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuBar;

public class AgregarEmpleadoController {

	private LogicaMenuEmpleado lol;
	
	@FXML
	private MenuBar myMenuBar;
	
	public AgregarEmpleadoController() {
		lol = new LogicaMenuEmpleado();
	}
	
	@FXML
	public void handleAgregarEmpleadoViewMenu(ActionEvent ev) {
		lol.abrirPantallaAgregarEmpleado(myMenuBar);
	}
	
	@FXML
	public void handleInicioViewMenu(ActionEvent ev) {
		lol.abrirPantallaInicio(myMenuBar);
	}
	
}
