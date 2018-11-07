package LN;



import java.io.Serializable;

public class clsUsuario implements Serializable {

	
	private String nomUsuario;
	private String mail;
	private String contraseña;
	private int numeroVidas;
	private int puntuacion;
	
	public clsUsuario(){
		nomUsuario="";
		mail="";
		contraseña="";
		numeroVidas=5;
		puntuacion=0;				
	}
	
	public clsUsuario(String nomUsuario, String mail, String contraseña, int numeroVidas, int puntuacion){
		this.nomUsuario=nomUsuario;
		this.mail=mail;
		this.contraseña=contraseña;
		this.numeroVidas=numeroVidas;
		this.puntuacion=puntuacion;
	}

	public String getnomUsuarioarioario() {
		return nomUsuario;
	}

	public void setnomUsuarioarioario(String nomUsuario) {
		this.nomUsuario = nomUsuario;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public int getNumeroVidas() {
		return numeroVidas;
	}

	public void setNumeroVidas(int numeroVidas) {
		this.numeroVidas = numeroVidas;
	}

	public int getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}


	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mail == null) ? 0 : mail.hashCode());
		result = prime * result
				+ ((nomUsuario == null) ? 0 : nomUsuario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		clsUsuario other = (clsUsuario) obj;
		if (mail == null) {
			if (other.mail != null) {
				return false;
			}
		} else if (!mail.equals(other.mail)) {
			return false;
		}
		if (nomUsuario == null) {
			if (other.nomUsuario != null) {
				return false;
			}
		} else if (!nomUsuario.equals(other.nomUsuario)) {
			return false;
		}
		return true;
	}



	public static final String EMAIL_ADDRESS = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
	            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	

}
