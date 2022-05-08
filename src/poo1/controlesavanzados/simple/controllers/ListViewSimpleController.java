package poo1.controlesavanzados.simple.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class ListViewSimpleController implements Initializable{

	@FXML
	private TextField txtPersonaje;
	
	@FXML
	private ListView<String> lvListaPersonajes;
	
	private ObservableList<String> listaPersonajes;
	
	public ListViewSimpleController() {
		listaPersonajes = FXCollections.observableArrayList();
		listaPersonajes.add("Mariela");
		listaPersonajes.add("Marisol");
	}
	
	@FXML
	public void handleAgregarPersonajeButton(ActionEvent event) {
		String nombrePersonaje = txtPersonaje.getText();
		
		// Adicionalmente se puede incluir una validación al contenido,
		// por ejemplo, que no incluya nombres con la ñ ni espacios en blanco.
		
		if(!nombrePersonaje.isBlank()) {
			String nombrePersonajeTempo = nombrePersonaje.toUpperCase();
			if(nombrePersonajeTempo.indexOf("Ñ")<0) {
				listaPersonajes.add(nombrePersonaje);
				// Después de agregar, limpie la caja de texto del nombre
				txtPersonaje.clear();
				
			}
			// De pronto agregar una alerta en el else?
		}
		
	}
	
	@FXML
	public void handleEliminarPersonajeButton(ActionEvent event) {
		String personajeSeleccionado = lvListaPersonajes.getSelectionModel().getSelectedItem();
		for(String nombrePers : listaPersonajes) {
			if(nombrePers.equals(personajeSeleccionado)) {
				listaPersonajes.remove(nombrePers);
			}
		}
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		lvListaPersonajes.setItems(listaPersonajes);
		
	}
	
}
