package LN;

public class clsMailNoValido extends Exception {
	
private final String MENSAJE= "La dirección de correo electrónico introducida no es correcta.";
	
	@Override
	public String getMessage() 
	{
		// TODO Auto-generated method stub
		return MENSAJE;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return MENSAJE;
	}
}
