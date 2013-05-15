package com.tarefajavap2.service;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.sql.ResultSet;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
/**
 * Thread que vai tratar a criacao e envio do PDF.
 *
 */
public class TrataPedidoRelatorioService implements Runnable{
	
	
	private static final String LAYOUT_JRXML = "relatorio.jrxml";
	
	private String FILE_NAME = "saida.pdf";
	private String ipCliente;
	private ResultSet rs;


	public TrataPedidoRelatorioService() {
		
	}
	
	
	
	public TrataPedidoRelatorioService(String ipCliente, ResultSet rs) {
		this.ipCliente = ipCliente;
		this.rs = rs;
	}



	@Override
	public void run() {
		
		long thisThreadId = Thread.currentThread().getId();
		System.out.println("Iniciando a Thread "+thisThreadId);
		//Gerar o pdf e enviar para o cliente
		try {
			gerarPDF();
			enviaPDF();
		} catch (JRException e) {
			e.printStackTrace();
		}
		
		System.out.println("Finalizando a Thread "+thisThreadId);
		
	}
	/**
	 * Metodo que gera o PDF
	 * @throws JRException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes"})
	private synchronized void gerarPDF() throws JRException {

		// gerando o jasper design
		JasperDesign desenho = JRXmlLoader.load(LAYOUT_JRXML);

		// compila o relatório
		JasperReport relatorio = JasperCompileManager.compileReport(desenho);

		// implementação da interface JRDataSource para DataSource ResultSet
		JRResultSetDataSource jrRS = new JRResultSetDataSource(rs);

		// executa o relatório
		Map parametros = new HashMap();
		
		parametros.put("subtitulo", "Subtitulo");
		
		JasperPrint impressao = JasperFillManager.fillReport(relatorio,	parametros, jrRS);
	
		//EVITANDO QUE O ARQUIVO POSSA SER USADO POR OUTRA THREAD. Gerando o arquivo com nome de chave de transacao.
		FILE_NAME = UUID.randomUUID()+FILE_NAME;
		//gerando para arquivo em disco
		JasperExportManager.exportReportToPdfFile(impressao,FILE_NAME );
		
	}


/**
 * Metodo que envia o PDF
 */
	private synchronized void enviaPDF(){
		try {
			
			Socket socket = new Socket(ipCliente,80);
			System.out.println("Conectado ao servidor...");
			OutputStream out = socket.getOutputStream();
			BufferedOutputStream bout = new BufferedOutputStream(out);

			FileInputStream fin = new FileInputStream(FILE_NAME);

			long ti = new Date().getTime(); 

			System.out.println("Iniciando transferencia...");
			while(fin.available()>0){
				bout.write(fin.read());
			}
			
			long tf = new Date().getTime();
			
			System.out.println("Transferencia terminada !!!");
			System.out.println("tempo = " + (tf-ti) + "ms");
			
			fin.close();
			bout.close();
			out.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getIpCliente() {
		return ipCliente;
	}



	public void setIpCliente(String ipCliente) {
		this.ipCliente = ipCliente;
	}



	public ResultSet getRs() {
		return rs;
	}



	public void setRs(ResultSet rs) {
		this.rs = rs;
	}

}
