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
            
            String linea = miBuffer.readLine(); // Leer la primera línea
            while (linea != null) {
            	
            	
            	 if (!linea.isEmpty()) { // Ignorar líneas vacías
                     try {
                         personas.add(Persona.fromString(linea));
                     } catch (IllegalArgumentException e) {
                         System.err.println("Línea mal formateada: " + linea);
                     }
                 }
                linea = miBuffer.readLine(); // Leer la siguiente línea
            }
            miBuffer.close();
            entrada.close();

        } catch (IOException e) {
            System.out.println("No se encontró el archivo: " + ruta);
            e.printStackTrace();
        }
        return personas;
    }
}
