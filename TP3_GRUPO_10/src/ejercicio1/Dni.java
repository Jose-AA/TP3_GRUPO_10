package ejercicio1;

public class Dni{

	public static boolean verificarDniInvalido(String dni) throws DniInvalidoException
	
	{
		
		for(int i=0;i<dni.length();i++)
		{
			//pregunto si el caracter es un dígito
			if(!Character.isDigit(dni.charAt(i)))
			{
				throw new DniInvalidoException();
			}
		}
		return false;
	}
	
	
}
