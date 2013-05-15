package webtermometro;

import webtermometro.entidades.Parametrizacao;
import webtermometro.entidades.Linha;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Locale;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.Days;
import org.joda.time.Seconds;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.DateTimeFormatterBuilder;
import webtermometro.entidades.Resultado;

public class Core {


	public static Resultado processar(String path, Parametrizacao parametros) {

	   // URL url = Core.class.getClassLoader().getResource("hotelbucsky.log");

		//URL url = Core.class.getClassLoader().getResource("teste_acesso.log");
		ArrayList<Linha> linhasLog = lerArquivo(path);
                Resultado  resultado = new Resultado();
                
		resultado.setMediaAcesso(verificarNumAcessoDia(linhasLog));
		resultado.setTmpGastoMedio(verificarMediaTempoAcesso(linhasLog));
	  
                        
                double nota = (100 *  resultado.getTmpGastoMedio() )/ parametros.getTmpGastoMedioSecIdeal();
                        
                resultado.setNotaQuesitoTempo( (nota > 100)? 10 : nota/10.0 );		
		
                
                nota = (100 *  resultado.getMediaAcesso() )/ parametros.getNumAcessoMedioDiaIdeal();
                resultado.setNotaQuesitoAcesso( (nota > 100)? 10 : nota/10.0 );
		
		 resultado.setNotaGeral(
                ( Math.ceil(
                         (resultado.getNotaQuesitoAcesso() * parametros.getPesoAcesso()) + 
                
                         (resultado.getNotaQuesitoTempo() * parametros.getPesoTempo())) 
                 
                         / (parametros.getPesoAcesso() + parametros.getPesoTempo() )
                         
                         ));
		
                return resultado;
	}

	static ArrayList<Linha> lerArquivo(String path) {

		ArrayList<Linha> lista = new ArrayList<Linha>();

		try {
			FileReader fileRead = new FileReader(new File(path));
			BufferedReader buReader = new BufferedReader(fileRead);

			String linha = buReader.readLine();

			DateTimeFormatter fmt = new DateTimeFormatterBuilder()
					.appendDayOfMonth(2).appendLiteral('/')
					.appendMonthOfYearShortText()
					.appendLiteral('/')
					.appendYear(4, 4)
					// pivot = 1956
					.appendLiteral(':').appendHourOfDay(2).appendLiteral(':')
					.appendMinuteOfHour(2).appendLiteral(':')
					.appendSecondOfMinute(2).toFormatter();

			fmt = fmt.withLocale(Locale.US).withZone(DateTimeZone.UTC);

			while (linha != null) {

				// identifca quem fez a requisicao
				String ipCliente = StringUtils.substringBetween(linha,
						"www.hotelbucsky.com.br", "- -").trim();

				String dataAcessoCliente = StringUtils.substringBetween(linha,
						"- - [", "-0").trim();

				DateTime dt = fmt.parseDateTime(dataAcessoCliente);
				lista.add(new Linha(ipCliente, dt));

				linha = buReader.readLine();
			}

			fileRead.close();
			buReader.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lista;

	}

	static double verificarNumAcessoDia(ArrayList<Linha> lista) {

		ArrayList<Linha> linhasCopy = new ArrayList<Linha>(lista);

		Integer numeroDias = 0;
		Long numTotalPessoas = 0l;

		// O log do onoda est� com datas decrescente
		while (linhasCopy.size() > 0) {

			Linha linhaCurrent = linhasCopy.get(0);
			HashSet<Linha> listRemocaoDia = new HashSet<Linha>();
			listRemocaoDia.add(linhaCurrent);
			int pessoasDifDia = 1;

			for (Linha linha : linhasCopy) {
				if (Days.daysBetween(linha.dataAcesso, linhaCurrent.dataAcesso)
						.getDays() > 0) { // se mudou de dia, paro de iterar
					break;
				} else {
					if (!linha.cliente.equals(linhaCurrent.cliente)) {
						listRemocaoDia.add(linha);// se for outro usuario, somo
						++pessoasDifDia;						
												
					}else{
						listRemocaoDia.add(linha);
					}
				}
			}

			++numeroDias;// adiciono mais um dia
			numTotalPessoas += pessoasDifDia;
			linhasCopy.removeAll(listRemocaoDia);
		}

		return (double)numTotalPessoas / numeroDias;
	}

	static double verificarMediaTempoAcesso(ArrayList<Linha> lista) {

		ArrayList<Linha> lstCopy = new ArrayList<Linha>(lista);
		int numNavegaSite = 0;
		int tmpGasto = 0;
		// pegar o dia
		// pegar os usuarios do dia
		// verificar se o usuario faz no minimo 2 acessos
		// somar o tempo
		// fazer media de usuario por dia
		// fazer media da media diaria com o numero de dias

		// O log do onoda est� com datas decrescente
		while (lstCopy.size() > 0) {

			Linha linhaCurrent = lstCopy.get(0);
			ArrayList<Linha> lstAcessoUsuario = new ArrayList<Linha>();
			lstAcessoUsuario.add(linhaCurrent);

			for (Linha linha : lstCopy) {
				if (Days.daysBetween(linha.dataAcesso, linhaCurrent.dataAcesso)
						.getDays() > 0) { // se mudou de dia, paro de iterar
					break;
				} else {
					if (linha.cliente.equals(linhaCurrent.cliente)
							&& !linha.equals(linhaCurrent)) {// nao podem ser o
																// mesmo acesso
						lstAcessoUsuario.add(linha);
					}
				}
			}

			if (lstAcessoUsuario.size() > 1) {

				++numNavegaSite;

				for (int i = 0; i < lstAcessoUsuario.size() - 1; i++) {
					tmpGasto += Seconds.secondsBetween(
							lstAcessoUsuario.get(i).dataAcesso,
							lstAcessoUsuario.get(i + 1).dataAcesso)
							.getSeconds();
				}

			}
			lstCopy.removeAll(lstAcessoUsuario);

		}
		return (double) tmpGasto / numNavegaSite;
	}

}
