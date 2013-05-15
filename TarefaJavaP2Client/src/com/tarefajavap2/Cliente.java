package com.tarefajavap2;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import com.tarefajavap2.interfaces.IServidor;

/**
 * Client que testa o serviço de geracao de PDF.
 * 
 * 
 */
public class Cliente {

	static String diretorioAplicacao = "C:\\java\\workspace\\TarefaJavaP2Client\\";

	public Cliente() {

	}

	public static void main(String[] args) throws RemoteException,
			UnknownHostException {

		IServidor servidorRelatorio = lookUpPedidoRelatorio();
		// Pegar o ip do cliente dinamicamente

		String nome = JOptionPane
				.showInputDialog("Entra com um nome para gerar relatório ");

		if (servidorRelatorio.pedidoRelatorio(nome, InetAddress.getLocalHost()
				.getHostAddress())) {
			// Abrir o server socket para aguardar a resposta
			montaServerSocket();
		} else {
			System.out.println();
			JOptionPane.showMessageDialog(null,
					"Nao encontrou as movimentacoes para o nome passado");
		}
	}

	/**
	 * Busca o servico rmi do relatorio
	 * 
	 * @return
	 */
	private static IServidor lookUpPedidoRelatorio() {
		IServidor s = null;
		try {
			System.out.println("Estou no cliente...");
			s = (IServidor) Naming.lookup("rmi://localhost:1099/servidor");

		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,
					"não foi possivel se conectar ao servidor");
		}
		return s;
	}

	/**
	 * Metodo que monta o server socket para aguardar o envio do PDF
	 */
	private static void montaServerSocket() {

		String nomeArquivo = null;

		try {
			System.out.println("Servidor socket no cliente no ar");
			ServerSocket serverSocket = new ServerSocket(80);
			Socket socket = serverSocket.accept();

			InputStream in = socket.getInputStream();
			BufferedInputStream bin = new BufferedInputStream(in);

			nomeArquivo = "saidaCliente"
					+ new SimpleDateFormat("dd-mm-yyyy-HHMMSS")
							.format(new Date()) + ".pdf";

			FileOutputStream fileOutputStream = new FileOutputStream(
					nomeArquivo);
			BufferedOutputStream bout = new BufferedOutputStream(
					fileOutputStream);

			long qtdBytes = 0;
			int lido = bin.read();
			while (lido > -1) {
				bout.write(lido);
				lido = bin.read();
				qtdBytes++;
			}

			bout.close();

			fileOutputStream.close();
			System.out.println("Recebi " + qtdBytes);

		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,
					"não foi possivel se conectar ao servidor");
		}

		try {
			
			
			Runtime.getRuntime().exec("cmd.exe /C "+diretorioAplicacao+nomeArquivo);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null,
					"Não foi encontrado um pdf Reader em seu sistema");
		}

	}

}
