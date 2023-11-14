package poo1.controlesavanzados.simple.controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import poo1.controlesavanzados.model.Fachada;

public class ListViewSimpleController implements Initializable{

	@FXML
	private TextField txtPersonaje;
	
	@FXML
	private ListView<String> lvListaPersonajes;
	
	private ObservableList<String> listaPersonajes;
	
	private Fachada f = new Fachada();
	
	public ListViewSimpleController() {
		listaPersonajes = FXCollections.observableArrayList();
		listaPersonajes.add("Mariela");
		listaPersonajes.add("Marisol");
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		ArrayList<String> lista = f.getListaContactosListView();
		lvListaPersonajes.getItems().addAll(lista);
		
//		lvListaPersonajes.setItems(listaPersonajes);
		
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
		f.eliminarAmigo(personajeSeleccionado);
		
		ArrayList<String> lista = f.getListaContactosListView();
		lvListaPersonajes.getItems().clear();
		lvListaPersonajes.getItems().addAll(lista);
		
		
//		for(String nombrePers : listaPersonajes) {
//			if(nombrePers.equals(personajeSeleccionado)) {
//				listaPersonajes.remove(nombrePers);
//			}
//		}
		
	}

	
	
}
