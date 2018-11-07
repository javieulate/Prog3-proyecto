import java.util.ArrayList;

import LN.clsGestor;
import LN.clsMailNoValido;
import LN.clsUsuario;
import LN.clsUsuarioRepetido;


public class clsMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<clsUsuario> listaUsu = new ArrayList<clsUsuario>();
		clsUsuario a = new clsUsuario("aa", "aa@aa.es", "aa", 0, 0);
		clsUsuario b = new clsUsuario("aa", "bb@aa.es", "aa", 0, 0);
		
		try {
			if(clsGestor.validarEmail(a.getMail())){
				try {
					
					clsGestor.altaUsuario( a, listaUsu);
					listaUsu.add(a);
				} catch (clsUsuarioRepetido e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}					
		} catch (clsMailNoValido e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			if(clsGestor.validarEmail(b.getMail())){
				try {
					clsGestor.altaUsuario(b, listaUsu);
					listaUsu.add(b);
				} catch (clsUsuarioRepetido e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}					
		} catch (clsMailNoValido e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}

}
