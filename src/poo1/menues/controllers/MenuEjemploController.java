package poo1.menues.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuBar;

public class MenuEjemploController {

	private LogicaMenuEmpleado lol;
	
	@FXML
	private MenuBar myMenuBar;
	
	public MenuEjemploController() {
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
