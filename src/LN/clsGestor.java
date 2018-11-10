package LN;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.regex.Pattern;

import COMUN.clsElementoRepetido;
import COMUN.clsUsuarioNoRegistrado;
import COMUN.clsConstantes.enFicDatos;
import LD.clsDatos;
import LD.itfDatos;

public class clsGestor {
	
	public static void altaUsuario(clsUsuario usuario,  ArrayList <clsUsuario> listaUsu) throws clsUsuarioRepetido {
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
	
	public static ArrayList<clsUsuario> ListaUsuariosclsUsuarios()
	{
		ArrayList<Serializable>leido;
		ArrayList<clsUsuario>retorno;
		clsDatos objDatos;
		
		retorno=null;
		objDatos=new clsDatos();
		
		try
		{
			objDatos.ComenzarRead(enFicDatos.FICHEROUSU);
			leido=objDatos.Read();
			retorno=new ArrayList<clsUsuario>();
			
			for(Serializable s: leido)
			{
				retorno.add((clsUsuario)s);
			}
			
		}
		catch(IOException e)
		{
			//Si hay error devuelvo una lista vacía.
			retorno=new ArrayList<clsUsuario>();
		}
		finally
		{
			objDatos.TerminarRead();
		}
		
		objDatos=null;
		return retorno;
	}	
	/**
	 * Método para comprobar si un usuario existe en fichero.	
	 * @param nomusuario nombre de usuario a buscar
	 * @param correoelec correo del usuario a buscar
	 * @throws clsUsuarioNoRegistrado excepción que salta si no existe
	 */
	public static void ComprobarUsuario(String nomusuario, String correoelec) throws clsUsuarioNoRegistrado
		{
			boolean marca = true;
			ArrayList<clsUsuario>listausuarios = ListaUsuariosclsUsuarios();
			
			for (clsUsuario aux : listausuarios) 
			{
				if(aux.getMail().toUpperCase().equals(correoelec.toUpperCase()) && aux.getNomUsuario().toUpperCase().equals(nomusuario.toUpperCase()))
				{
					marca = false;
				}
			}
			if (marca == true)
			{
				throw new clsUsuarioNoRegistrado();
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

/**
		 * Método usado para guardar los datos en fichero sesion del usuario que ha inciado su sesión en la 
		 * aplicación.
		 * @param nomusuario nombre del usuario
		 * @param correoelec correo del usuario
		 */
		public static void IniciarSesion(String nomusuario, String correoelec)
			{
				
				ArrayList<clsUsuario>listaususarios = ListaUsuariosclsUsuarios();
				clsUsuario a = null;
				
				for (clsUsuario aux : listaususarios) 
				{
					if(aux.getMail().toUpperCase().equals(correoelec.toUpperCase()) && aux.getNomUsuario().toUpperCase().equals(nomusuario.toUpperCase()))
					{
						a = aux;
					}
				}
			
		
				itfDatos ObjDatos = new clsDatos();
					
				ObjDatos.ComenzarSave(enFicDatos.FICHEROSESION);
				ObjDatos.Save((Serializable)a);
				ObjDatos.TerminarSave();
				
			}
		
		/**
		 * Este es el método del clsGestor que elabora una lista de usuarios de nuestra aplicación. Lo que hace es
		 * leer toda la información que existe de los usuarios registrados entrando en el fichero de estos. Mete los
		 * usuarios registrados en una lista y la manda a donde queramos, normalmente se usa en el menú principal.
		 * 
		 * @return lista llena de información de los usuarios.
		 */

		public static ArrayList<itfProperty> ListaUsuarios()
		{
			ArrayList<Serializable>leido;
			ArrayList<itfProperty>retorno;
			clsDatos objDatos;
			
			retorno=null;
			objDatos=new clsDatos();
			
			try
			{
				objDatos.ComenzarRead(enFicDatos.FICHEROUSU);
				leido=objDatos.Read();
				retorno=new ArrayList<itfProperty>();
				
				for(Serializable s: leido)
				{
					retorno.add((itfProperty)s);
				}
				
			}
			catch(IOException e)
			{
				//Si hay error devuelvo una lista vacía.
				retorno=new ArrayList<itfProperty>();
			}
			finally
			{
				objDatos.TerminarRead();
			}
			
			objDatos=null;
			return retorno;
		}
		
		/**
		 * Este es el método de alta de un usuario. Es un método que usa la lógica de presentación cuando quiere registrar
		 * un usuario nuevo en nuestra aplicación. Dispone de la funcionalidad del Hashset para eliminar aquellos usuarios 
		 * que estén repetidos (por mail). Los guarda en el fichero de usuarios que hemos definido en clsConstantes.
		 * @param nombre nombre del usuario
		 * @param apellido apellido del usuario
		 * @param correoelectronico mail del usuario
		 * @param nomusu nombre de usuario
		 */
		public static void AltaUsuario(String nombre, String apellido, String mail, String nomUsu, String contrasena) throws clsElementoRepetido
		{
				itfProperty a = new clsUsuario(nombre, apellido, mail, nomUsu, contrasena);
				itfDatos ObjDatos = new clsDatos();
				
				HashSet<itfProperty>miSet = new HashSet<itfProperty>();
				
				ArrayList<itfProperty>milista;
				milista = ListaUsuarios();
			
				
				for (itfProperty aux : milista) 
				{
					miSet.add((clsUsuario)aux);
				}
				if(miSet.add(a)==true)
				{
					ObjDatos.ComenzarSave(enFicDatos.FICHEROUSU);
					ObjDatos.Save((Serializable)a);
					ObjDatos.TerminarSave();
					
					ObjDatos.ComenzarSave(enFicDatos.FICHEROSESION);
					ObjDatos.Save((Serializable)a);
					ObjDatos.TerminarSave();
				}
				else
				{
					throw new clsElementoRepetido();
				}		
		}
		
		/**
		 * Método que borra el fichero sesion cuando el usuario abandona la aplicación.
		 */
		public static void CerrarSesion()
			{
				itfDatos ObjDatos = new clsDatos();
				
				ObjDatos.ResetFile(enFicDatos.FICHEROSESION);
			}
		
		public static String NomUsuario() throws IOException
		{
			String nomusu ="";
			itfProperty b = null;
			itfDatos ObjDatos = new clsDatos();
			
			ObjDatos.ComenzarRead(enFicDatos.FICHEROSESION);
			b =  (itfProperty)ObjDatos.ReadSerializable();
			ObjDatos.TerminarRead();
			
			nomusu = b.getStringProperty(COMUN.clsConstantes.PROP_USUARIO_NOMUSUARIO);
			
			return nomusu;
		}
		
}
