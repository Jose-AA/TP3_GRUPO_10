package ejercicio1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Archivo {

    private String ruta;

    public Archivo(String ruta) {
        this.ruta = ruta;
    }

    public List<Persona> leerPersonas() {
        List<Persona> personas = new ArrayList<>();
        try {
            FileReader entrada = new FileReader(ruta);
            BufferedReader miBuffer = new BufferedReader(entrada);
            
            String linea = miBuffer.readLine(); // Leer la primera l�nea
            while (linea != null) {
            	
            	
            	 if (!linea.isEmpty()) { // Ignorar l�neas vac�as
                     try {
                         personas.add(Persona.fromString(linea));
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
