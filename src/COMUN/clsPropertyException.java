package COMUN;


public class clsPropertyException extends RuntimeException
{
	/**
	 * Esto es parte del mensaje que avisa al usuario de que no puede acceder a esa propiedad.
	 */
	private String MENSAJE= "Propiedad inexistente";
	
	/**
	 * Este es el mensaje completo que va a recibir el usuario, el mensaje anterior + la propiedad que no existe
	 * y �l intenta buscar.
	 * @param p propiedad inexistente.
	 */
	public clsPropertyException(String p)
	{
		MENSAJE = MENSAJE + ": "+p;
	}
	
	/**
	 * Este es el m�todo que manda el mensaje.
	 */
	@Override
	public String getMessage() 
	{
		return MENSAJE;
	}
	
	
	/**
	 * Este es el m�todo que hace que el mensaje sea apropiado para su presentaci�n.
	 */
	@Override
	public String toString() 
	{
		return MENSAJE;
	}
}
