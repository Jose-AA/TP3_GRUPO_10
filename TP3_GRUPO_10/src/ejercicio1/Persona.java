package ejercicio1;

public class Persona {

	private String apellido;
	private String nombre;
	private int dni;
	
	public Persona() {
	}
	
	public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }
	
	
	public Persona(String apellido, String nombre, int dni) {
		this.apellido = apellido;
		this.nombre = nombre;
		this.dni = dni;
	}
	
	public static Persona fromString(String str) {
		String[] parts = str.split("-");
        return new Persona(parts[1], parts[0], Integer.parseInt(parts[2]));
    }
}
