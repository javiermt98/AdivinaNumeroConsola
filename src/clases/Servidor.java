package clases;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class Servidor {
	public static void main(String[] args) throws IOException {
		Random r = new Random();
		int port = 6000;
		ServerSocket servidor = new ServerSocket(port);
		
		int numero = r.nextInt(25);
		System.out.println("Número generado: "+ numero);
		
		Compartido c = new Compartido(numero);
		int id=1;
		while(true) {
			Socket cliente = servidor.accept();
			Hilo h = new Hilo(cliente, id, c);
			h.start();
			id++;
					
		}

	
	
	}

}
