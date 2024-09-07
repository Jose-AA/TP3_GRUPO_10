package ejercicio1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.TreeSet;

public class Archivo {

    private String ruta;

    public Archivo(String ruta) {
        this.ruta = ruta;
    }

    public boolean crearArchivo(String ruta) {
    	FileWriter escritura;
    	try {
    		escritura = new FileWriter(ruta, true);
    		escritura.write("");
    		escritura.close();
    		return true;
    	}
    	catch(IOException e) {
    		System.out.println("Error - no se pudo crear el archivo");
    		e.printStackTrace();
    	}
    	return false;
    }
    
    public TreeSet<Persona> leerPersonas() {
        TreeSet<Persona> personas = new TreeSet<>();
        try {
            FileReader entrada = new FileReader(ruta);
            BufferedReader miBuffer = new BufferedReader(entrada);
            String linea = miBuffer.readLine(); // Leer la primera l�nea
            while (linea != null) {
            	 if (!linea.isEmpty()) { // Ignorar l�neas vac�as
                     try {
                    	 
                    	 String[] parts = linea.split("-");
                         
                         // Validar el formato
                         if (parts.length != 3) {
                             throw new IllegalArgumentException();
                         }

                         // Validar el DNI
                         String dni = parts[2];
                         if (Dni.verificarDniInvalido(dni)) {
                             throw new DniInvalidoException();
                         }

                         Persona persona = new Persona(parts[1], parts[0], Integer.parseInt(dni));
                         personas.add(persona);
                     } catch (DniInvalidoException e) {
                         System.err.println("DNI inv�lido en l�nea: " + linea);
                     } catch (IllegalArgumentException e) {
                         System.err.println("L�nea mal formateada: " + linea);
                     }
                 }
                linea = miBuffer.readLine(); // Leer la siguiente l�nea
            }
            miBuffer.close();
            entrada.close();
        } catch (IOException e) {
            System.out.println("No se encontr� el archivo: " + ruta);
            e.printStackTrace();
        }
        return personas;
    }
}
