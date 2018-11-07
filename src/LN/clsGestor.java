package LN;



import java.util.ArrayList;
import java.util.HashSet;
import java.util.regex.Pattern;


public class clsGestor {
	
	public static void altaUsuario(clsUsuario usuario,  ArrayList <clsUsuario> listaUsu)throws clsUsuarioRepetido{
		clsUsuario a = new clsUsuario();
		a=usuario;
		HashSet<clsUsuario>miSet = new HashSet<clsUsuario>();
		for (clsUsuario aux : listaUsu) {
			miSet.add(aux);
		}
		if(miSet.add(a)==true){
			System.out.println("El usuario se ha añadido");
			listaUsu.add(a);
		}
		else{
			throw new clsUsuarioRepetido();
		}
	}
	 public static boolean validarEmail(String email) throws clsMailNoValido
	  {
		  Pattern pattern = Pattern.compile(clsUsuario.EMAIL_ADDRESS); 
		  
		  if(pattern.matcher(email).matches()==true)
		  {
			  return pattern.matcher(email).matches();
		  }
		  else
		  {
			  throw new clsMailNoValido();
		  }
	  }
}
