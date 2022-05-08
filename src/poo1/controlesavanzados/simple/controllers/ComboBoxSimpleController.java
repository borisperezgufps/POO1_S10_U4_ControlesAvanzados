package poo1.controlesavanzados.simple.controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class ComboBoxSimpleController implements Initializable {

	@FXML
	private ComboBox<String> cmbRangoEdad;
	@FXML
	private ComboBox<String> cmbRangoEdadOp1;
	@FXML
	private ComboBox<String> cmbRangoEdadOp2;
	@FXML
	private TextField txtRangoSeleccionado;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		/*
		 * ------------------------
		 * Opción 1: Uso de la clase ObservableList para crear
		 * los elementos del combo.
		 */
		ObservableList<String> items = obtenerRangoEdadOpcion_1();
		cmbRangoEdad.setItems(items);
		
		/*
		 * ------------------------
		 * Opción 2: Uso de la clase ArrayList para crear los
		 * elementos del combo.
		 * Primero se obtiene el ObservableList con el método .getItems(),
		 * y luego se agrega la lista con .addAll();
		 * El método obtenerRangoEdadOpcion_2 está simulando lo que podría
		 * ser la invocación a la clase Fachada.
		 */
		ArrayList<String> listaItems = obtenerRangoEdadOpcion_2();
		cmbRangoEdadOp1.getItems().addAll(listaItems);
		
		/*
		 * ------------------------
		 * Opción 3: Uso de la clase ArrayList para crear los
		 * elementos del combo.
		 * Primero se obtiene el ObservableList con el método .getItems(),
		 * y luego se agregan, uno a uno, los elementos al combo.
		 * Esta opción es útil cuando se quieren agregar solo algunos elementos.
		 * Supongo que no se incluirá el rango de mayores de 70 años.
		 * El método obtenerRangoEdadOpcion_2 está simulando lo que podría
		 * ser la invocación a la clase Fachada.
		 */
		ArrayList<String> listaItemsOp2 = obtenerRangoEdadOpcion_2();
		if(listaItemsOp2!=null) {
			for(String rango : listaItemsOp2) {
				if(!rango.equals("71+ años")) {
					cmbRangoEdadOp2.getItems().add(rango);
				}
			}
		}
		
	}
	
	private ObservableList<String> obtenerRangoEdadOpcion_1(){
		ObservableList<String> items = FXCollections.observableArrayList();
		items.addAll("18 - 23 años", "24 - 30 años", "31 - 50 años", "51 - 70 años", "71+ años");
		
		
		
		return items;
	}
	
	private ArrayList<String> obtenerRangoEdadOpcion_2(){
		ArrayList<String> listaRangos = new ArrayList<String>();
		
		listaRangos.add("18 - 23 años");
		listaRangos.add("24 - 30 años");
		listaRangos.add("31 - 50 años");
		listaRangos.add("51 - 70 años");
		listaRangos.add("71+ años");
		
		return listaRangos;
	}
	
	public void handleSeleccionarRangoButton(ActionEvent event) {
		String rango = cmbRangoEdadOp2.getValue();
		txtRangoSeleccionado.setText(rango);
	}
	
}
