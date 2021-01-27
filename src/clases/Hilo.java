package clases;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;


public class Hilo extends Thread {
	
	private Socket cliente;
	private DatosEnviar datosEnviar;
	private int id;
	private Compartido c;
	private ObjectInputStream flujoEntrada;
	private ObjectOutputStream flujoSalida;
	private int intentosPendientes = 5;

	
	public Hilo(Socket cliente, int id, Compartido c) {
		this.cliente = cliente;
		this.id = id;
		this.c = c;
	}
	
	@Override
	public void run() {
		Scanner sc = new Scanner(System.in);
		DatosEnviar d = new DatosEnviar(intentosPendientes, id, "Debes introducir un número entre 1 y 25" );
		
		try {
			while(intentosPendientes>0 && c.isAcertado()==false) {
				
				flujoSalida = new ObjectOutputStream(cliente.getOutputStream());
				flujoSalida.writeObject(d);
				intentosPendientes--;
				flujoEntrada = new ObjectInputStream(cliente.getInputStream());
				d = (DatosEnviar)flujoEntrada.readObject();
				String cadena = (c.nuevaJugada(d.getNumero(), id));
				d.setCadena(cadena);
				d.setIntentos(intentosPendientes);
				d.setAcertado(c.isAcertado());
			}
			if(intentosPendientes == 0) {
				d.setCadena("Se han acabado los intentos");
			}
			else if (c.isAcertado()) {
				d.setCadena("El número ha sido acertado por el jugador con ID->"+c.getGanador());
			}
			flujoSalida = new ObjectOutputStream(cliente.getOutputStream());
			flujoSalida.writeObject(d);
			
		} catch (IOException e) {

			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
		
		try {
			flujoSalida.close();
			flujoEntrada.close();
			cliente.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

			
			
		
		

		
	}
	
	
	

}
