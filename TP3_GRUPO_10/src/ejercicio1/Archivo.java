package ejercicio1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.TreeSet;

public class Archivo {

    private String ruta;

    public Archivo(String ruta) {
        this.ruta = ruta;
    }

    public Archivo() {
    	this.ruta = null;
    }
    
    public void setRuta(String ruta) {
    	this.ruta = ruta;
    }
    
    public boolean crearArchivo() {
    	FileWriter escritura;
    	
    	if(this.ruta == null) {
    		System.out.println("Error, no se ha asignado una ruta");
    		return false;
    	}
    	
    	try {
    		escritura = new FileWriter(this.ruta, true);
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
        
    	if(this.ruta == null) {
    		System.out.println("Error, no se ha asignado una ruta");
    		return personas;
    	}
        
        
        try {
            FileReader entrada = new FileReader(this.ruta);
            BufferedReader miBuffer = new BufferedReader(entrada);
            String linea = miBuffer.readLine(); // Leer la primera línea
            while (linea != null) {
            	 if (!linea.isEmpty()) { // Ignorar líneas vacías
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
                         System.err.println("DNI inválido en línea: " + linea);
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
    
    
    public void escribe_linea(TreeSet<Persona> listaPersonas) {
    	
       	if(this.ruta == null) {
    		System.out.println("Error, no se ha asignado una ruta");
    		return;
    	}
    	
    	Archivo archivo = new Archivo(this.ruta);
    	archivo.crearArchivo();
    	
		try {
			FileWriter entrada = new FileWriter(this.ruta, true);
			BufferedWriter buffer = new BufferedWriter(entrada);
			
			Iterator it = listaPersonas.iterator();
			
			while(it.hasNext()) {
				Persona p = (Persona) it.next();
				
				buffer.write(p.toString());
				buffer.newLine();
				
			}
			
			buffer.close();
			entrada.close();
			
		} catch (IOException e) {
			
			System.out.println("Error al escribir el archivo");
			e.printStackTrace();
		}
    }
}
