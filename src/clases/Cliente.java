package clases;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
	
	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		String host = "localhost";
		int portServer = 6000;
		Socket cliente = new Socket(host, portServer);
		ObjectInputStream flujoEntrada = null;
		ObjectOutputStream flujoSalida = null;
		int numero = -1;
		
		flujoEntrada = new ObjectInputStream(cliente.getInputStream());
		try {
			DatosEnviar d = (DatosEnviar)flujoEntrada.readObject();

			
			while(d.getIntentos() > 0 && d.isAcertado() == false) {
				
				System.out.println("ID: "+d.getId()+" - Intentos: "+d.getIntentos()+" Mensaje: "+d.getCadena());
				do {
				System.out.print("Número (entre 0 y 25): ");
				numero = sc.nextInt();
				}while(numero > 25 || numero <0);
				
				
				d.setNumero(numero);
				flujoSalida = new ObjectOutputStream(cliente.getOutputStream());
				flujoSalida.writeObject(d);
				flujoEntrada = new ObjectInputStream(cliente.getInputStream());
				d = (DatosEnviar)flujoEntrada.readObject();
			}
			System.out.println("ID: "+d.getId()+" - Intentos: "+d.getIntentos()+" Mensaje: "+d.getCadena());
			

			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		

		
		


	
	}

}
