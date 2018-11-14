package COMUN;


public class clsElementoRepetido extends Exception
{
	/**
	 * Este es el mensaje que va a avisar al usuario que ya existe el elemento que quiere dar de alta.
	 */
	private final String MENSAJE= "El elemento que quiere dar de alta ya ha sido dado de alta previamente.";
	
	/**
	 * Este es el m�todo que manda el mensaje.
	 */
	@Override
	public String getMessage() 
	{
		// TODO Auto-generated method stub
		return MENSAJE;
	}
	/**
	 * Este es el m�todo que hace que el mensaje sea apropiado para su presentaci�n.
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return MENSAJE;
	}
}



