package poo1.controlesavanzados.model;

import java.util.ArrayList;

public class Fachada {

	private ArrayList<String> listaAmigos;
	private ArrayList<String> listaAmigosGrupo;
	
	public Fachada() {
		listaAmigos = new ArrayList<String>();
		listaAmigosGrupo = new ArrayList<String>();
		
		listaAmigos.add("Rafael Sepúlveda");
		listaAmigos.add("Allison Rodríguez");
		listaAmigos.add("Rainiero Principado");
		listaAmigos.add("Marcela Carvajal");
		listaAmigos.add("Manuel Ramírez");
		listaAmigos.add("José Peñaranda");
		listaAmigos.add("Victor Angarita");
		listaAmigos.add("Paola Romero");
		
	}
	
	public String agregarAmigo(String amigo) {
		listaAmigos.add(amigo);
		String mensaje = "Amigo agregado satisfactoriamente";
		return mensaje;
	}
	
	public ArrayList<String> generarListaAmigosInicial(){
		return listaAmigos;
	}
	
	public ArrayList<String> obtenerAmigosGrupo(){
		return listaAmigosGrupo;
	}
	
	public String agregarAmigoAGrupo(String amigoSeleccionado) {
		
		String mensaje = "";
		
		// Se debe validar que el amigo no haya sido previamente agregado
		
		for(String amigoEnLista : listaAmigosGrupo) {
			if(amigoEnLista.equals(amigoSeleccionado)) {
				mensaje = "Error: El amigo ya se encuentra seleccionado, por favor seleccione otro.";
				break;
			}
		}
		
		// Si la variable mensaje está vacía, significa que no se 
		// encontró al amigo dentro de la lista de amigos del grupo,
		// y por lo tanto, se puede agregar a la lista de amigos del grupo.
		if(mensaje.isEmpty()) {
			listaAmigosGrupo.add(amigoSeleccionado);
			mensaje = "OK";
		}
		
		return mensaje;
		
	}

	public String eliminarAmigoAGrupo(String amigoAEliminar) {
		String mensaje = "";
		
		// Se debe buscar el elemento dentro de la lista de amigos del grupo,
		// y cuando se encuentre, entonces se procede a retirar el elemento de
		// la lista.
		for(String amigoEnLista : listaAmigosGrupo) {
			if(amigoEnLista.equals(amigoAEliminar)) {
				// Se puede eliminar pasando el objeto, en este caso un String, o
				// se puede eliminar pasando un índice.
				listaAmigosGrupo.remove(amigoEnLista);
				mensaje = "OK";
				break;
			}
		}
		
		// Si el mensaje está en blanco (sin texto o con espacios en blanco),
		// es porque no se encontró a la persona que se quiere eliminar. Si bien
		// en este ejemplo esto sería bastante
		if(mensaje.isBlank()) {
			mensaje = "Error. El amigo a eliminar no se encontró en el grupo.";
		}
		
		return mensaje;
	}
	
}
