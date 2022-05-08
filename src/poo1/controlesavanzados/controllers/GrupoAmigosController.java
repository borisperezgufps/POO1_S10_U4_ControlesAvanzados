package poo1.controlesavanzados.controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import poo1.controlesavanzados.model.Fachada;

public class GrupoAmigosController implements Initializable {

	private Fachada modelo;
	
	private ObservableList<String> listAmigos, listAmigosGrupo;
	
	@FXML
	private ComboBox<String> cmbAmigos;
	@FXML
	private ListView<String> lvGrupoAmigos;
	@FXML
	private TextField txtNuevoAmigo;
	
	public GrupoAmigosController() {
		modelo = new Fachada();
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		// Se obtiene de la fachada la lista de amigos inicial
		// Como el método retorna un ArrayList, entonces se debe
		// declarar un objeto de tipo ArrayList para guardar el resultado.
		ArrayList<String> listaAmigosInicial = modelo.generarListaAmigosInicial();
		
		// Se invoca el método getItems del ComboBox, y se agregan todos los
		// elementos que vienen de la lista de amigos inicial.
		cmbAmigos.getItems().addAll(listaAmigosInicial);
//		lvGrupoAmigos.getItems().addAll(listAmigosGrupo);
		
	}
	
	@FXML
	public void handleAgregarAmigoGrupo(ActionEvent event) {
		
		// Se obtiene el nombre del amigo que está seleccionado
		// en el ComboBox, y se guarda en una variable de tipo String.
		String amigoSeleccionado = cmbAmigos.getValue();
		
		// Toda la lógica de validaciones se realiza en el modelo (Fachada), 
		// por lo tanto, se invoca el método correspondiente y se le pasa
		// como parámetro el amigo seleccionado.
		// El método podría retorna falso o verdadero, dependiendo del éxito 
		// del método. Pero, si el método falla (falso), cómo podríamos saber
		// la razón del fallo?
		// Es por esto que el método, por ahora, retorna un String, con un "OK"
		// si esto sale bien, y "cualquier mensaje de error" si algo sale mal.
		
		String exitoOperacion = modelo.agregarAmigoAGrupo(amigoSeleccionado); 
		
		if(exitoOperacion.equals("OK")) {
			// Si la operacion de agregado de amigo a grupo fue exitosa, entonces
			// se procede a agregarlo a la Vista de Lista.
			ArrayList<String> listaAmigosGrupo = modelo.obtenerAmigosGrupo();
			
			// Pero primero se debe limpiar la Vista de Lista de cualquier
			// elemento previamente agregado, de modo que se puedan agregar
			// todos nuevamente.
			lvGrupoAmigos.getItems().clear();
			
			// Se agregan todos los elementos a la Vista.
			lvGrupoAmigos.getItems().addAll(listaAmigosGrupo);
		}else {
			// Si la operación no fue exitosa, se muestra el mensaje.
			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText(exitoOperacion);
			alert.show();
		}
		
	}
	
	@FXML
	public void handleRetirarAmigoGrupo(ActionEvent event) {
		String amigoAEliminar = lvGrupoAmigos.getSelectionModel().getSelectedItem();
				
		String exitoOperacion = modelo.eliminarAmigoAGrupo(amigoAEliminar); 
		
		if(exitoOperacion.equals("OK")) {
			ArrayList<String> listaAmigosGrupo = modelo.obtenerAmigosGrupo();
			
			lvGrupoAmigos.getItems().clear();
			
			lvGrupoAmigos.getItems().addAll(listaAmigosGrupo);
		}else {
			// Si la operación no fue exitosa, se muestra el mensaje.
			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText(exitoOperacion);
			alert.show();
		}
	}
	
	@FXML
	public void handleAceptar(ActionEvent event) {
		
		ArrayList<String> listaAmigosGrupo = modelo.obtenerAmigosGrupo();
		
		String mensajeAceptar = "Los amigos del grupo son:\n";
		
		if(listaAmigosGrupo!=null) {
			for(String amigo : listaAmigosGrupo) {
				mensajeAceptar += amigo + "\n";
			}
		}
		
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setContentText(mensajeAceptar);
		alert.show();
	}
	
	@FXML
	public void handleAgregarAmigoButton(ActionEvent event){
		String amigo = txtNuevoAmigo.getText();
		String mensaje = modelo.agregarAmigo(amigo);
		
		/**
		 * ------------------------------------------------
		 * Este bloque se incluye para limpiar el combobox y que se 
		 * incluya el nuevo amigo agregado.
		 * Haga la prueba retirando este bloque y revise qué sucede
		 * en la GUI.
		 */
		// Se obtiene la lista de amigos
		ArrayList<String> listaAmigosInicial = modelo.generarListaAmigosInicial();
		// Se limpia el combo
		cmbAmigos.getItems().clear();
		// Se agregan la lista que ahora incluye al amigo agregado
		cmbAmigos.getItems().addAll(listaAmigosInicial);
		
		/**
		 * ------------------------------------------------
		 */
		
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setContentText(mensaje);
		alert.show();
	}
	
}
