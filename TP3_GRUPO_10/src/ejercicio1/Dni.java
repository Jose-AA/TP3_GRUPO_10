package ejercicio1;

public class Dni{

	public static boolean verificarDniInvalido(String dni) throws DniInvalidoException
	
	{
		Boolean auxLetras = false;
		for(int i=0;i<dni.length();i++)
		{
			//pregunto si el caracter es un d�gito
			if(!Character.isDigit(dni.charAt(i)))
			{
				auxLetras = true;
			}
			if(auxLetras)//si se encontr� una letra en el dni se arroja la exception
			{
				throw new DniInvalidoException();
			}
		}
		return auxLetras;
	}
	
	
}
