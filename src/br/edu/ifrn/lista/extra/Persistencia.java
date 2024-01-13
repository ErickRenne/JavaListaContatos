package br.edu.ifrn.lista.extra;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Persistencia {
	public static void serializaGrava(String caminhoNome, Object ctt) {
		FileOutputStream arqSaida;
		ObjectOutputStream streamSaida;
		try {
			arqSaida = new FileOutputStream(caminhoNome);
			streamSaida = new ObjectOutputStream(arqSaida);
			streamSaida.writeObject(ctt);
			streamSaida.close();	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Object leDeserializa(String caminhoNome)throws IOException ,ClassNotFoundException{
		FileInputStream arqEntrada = new FileInputStream(caminhoNome);
		ObjectInputStream streamEntrada = new ObjectInputStream(arqEntrada);
		Object objetoLido = streamEntrada.readObject();
		System.out.println(objetoLido);
		streamEntrada.close();
		return objetoLido;
	}
}
