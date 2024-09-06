package ejercicio1;

public class Dni{

	public static boolean verificarDniInvalido(String dni) throws DniInvalidoException
	
	{
		Boolean auxLetras = false;
		for(int i=0;i<dni.length();i++)
		{
			if(!Character.isDigit(dni.charAt(i)))
			{
				auxLetras = true;
			}
			if(auxLetras)
			{
				throw new DniInvalidoException();
			}
		}
		return auxLetras;
	}
	
	
}
