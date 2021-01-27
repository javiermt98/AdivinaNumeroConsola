package clases;

public class Compartido implements Runnable{
	
	private int numero;
	private boolean acertado = false;
	private int id;
	private int ganador;
	
	public Compartido(int numero) {
		this.numero = numero;
	}
	
	public synchronized String nuevaJugada(int numeroCliente, int id) {
		String respuesta = "";
		if(this.acertado == false) {
			if(numeroCliente < this.numero) {
				
				respuesta = "El número es demasiado bajo";
									
			}
			
			else if (numeroCliente > this.numero) {
				
				respuesta = "El número es demasiado alto";
			}
			
			else {
				this.acertado = true;
				this.ganador = id;
				respuesta = "Has acertado !!";
			}
			
		}
		else {
			respuesta = "El juego ha acabado. Ha ganado el jugador "+this.ganador;
		}
		
		return respuesta;
		
		
		
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
	public int getGanador() {
		return ganador;
	}
	public void setGanador(int ganador) {
		this.ganador = ganador;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public void run() {
		
		
	}
	
	

}
