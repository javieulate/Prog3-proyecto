package COMUN;


/**
 * Esta es una clase en la que vamos a tratar una excepci�n que puede ser causada en nuestra aplicaci�n.
 * En concreto, se trata de una excepci�n que salta cuando queremos registrar un elemento (usuario, pelicula,serie)
 * que ya est� en fichero.
 * @author Juan Solozabal, Lander Pis�n y Javier Alvarez de Eulate
 *
 */
public class clsEmailNoValido extends Exception
{
	/**
	 * Este es el mensaje que va a avisar al usuario que ya existe el elemento que quiere dar de alta.
	 */
	private final String MENSAJE= "La direcci�n de correo electr�nico introducida no es correcta.";
	
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



