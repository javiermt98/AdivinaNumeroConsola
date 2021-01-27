package clases;

import java.io.Serializable;

public class DatosEnviar implements Serializable{
	
	private int intentos;
	private int id;
	private String cadena;
	private int numero;
	private boolean acertado = false;
	
	public DatosEnviar(int intentos, int id, String cadena) {
		this.intentos = intentos;
		this.id = id;
		this.cadena = cadena;
	}

	public int getIntentos() {
		return intentos;
	}

	public void setIntentos(int intentos) {
		this.intentos = intentos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCadena() {
		return cadena;
	}

	public void setCadena(String cadena) {
		this.cadena = cadena;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public boolean isAcertado() {
		return acertado;
	}

	public void setAcertado(boolean acertado) {
		this.acertado = acertado;
	}
	
	
	
	

}
