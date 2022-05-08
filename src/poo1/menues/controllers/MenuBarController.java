package poo1.menues.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuBar;

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
		logica.handleInicioMenu(event, myMenuBar);		
	}
	
}
