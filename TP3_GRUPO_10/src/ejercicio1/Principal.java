package ejercicio1;

import java.util.TreeSet;

public class Principal {

	public static void main(String[] args) {
		Archivo archivo = new Archivo("Personas.txt");
		
		TreeSet<Persona> listaPersonas = archivo.leerPersonas();
		
		for(Persona p : listaPersonas) {
			
			System.out.println(p);
		}
		

	}

}
