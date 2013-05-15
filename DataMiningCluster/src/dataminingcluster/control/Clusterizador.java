package dataminingcluster.control;

import java.util.ArrayList;
import java.util.List;

import dataminingcluster.model.Dao;

public class Clusterizador {

	private String[][] baseNormalizada;
	double[] vMax;
	double[] vMin;

	public Clusterizador(String[] colunas, String tabela , Dao dao) {

		try {
			normalizaBase(dao.leTabela(colunas, tabela));
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	/**
	 * normaliza os dados de uma matriz
	 * 
	 * @param base
	 * @return
	 */
	private void normalizaBase(String[][] base) {

		vMax = new double[base[0].length];
		vMin = new double[base[0].length];

		for (int i = 0; i < base.length; i++) {

			for (int y = 0; y < base[0].length; y++) {

				double valor = Double.parseDouble(base[i][y]);

				if (i == 0) {
					vMax[y] = valor;
					vMin[y] = valor;
				} else {

					if (valor > vMax[y]) {
						vMax[y] = valor;
					}

					if (valor < vMin[y]) {
						vMin[y] = valor;
					}

				}

			}

		}// termina de denominar os valores min e max

		baseNormalizada = new String[base.length][base[0].length];

		for (int i = 0; i < base.length; i++) {

			for (int y = 0; y < base[0].length; y++) {

				baseNormalizada[i][y] = String.valueOf((Double
						.parseDouble(base[i][y]) - vMin[y])
						/ (vMax[y] - vMin[y]));

			}

		}

	}

	/**
	 * normaliza os valores de centroide inseridos pelo usu�rio
	 * 
	 * @param centroides
	 * @return
	 */
	private String[][] normalizaCentroides(String[][] centroides) {

		String[][] centroideNormalizada = new String[centroides.length][centroides[0].length];

		for (int i = 0; i < centroides.length; i++) {

			for (int y = 0; y < centroides[0].length; y++) {

				centroideNormalizada[i][y] = String.valueOf((Double
						.parseDouble(centroides[i][y]) - vMin[y])
						/ (vMax[y] - vMin[y]));

			}

		}

		return centroideNormalizada;

	}
        
        /**
         * divide em grupos de acordo com os centroides dados , fazendo um numero
         * de passos de acordo com o valor de vezes
         * @param centroides
         * @param vezes
         * @return 
         */
	public List<List<Integer>> clusteriza(String[][] centroides, int vezes) {

		String[][] centroideNormalizada = normalizaCentroides(centroides);
		List<List<Integer> > clusters = null ;

		for (int i = 0; i < vezes; i++) {
			clusters =	criaGrupos(centroideNormalizada);
			
			if (i + 1 < vezes) {
				centroideNormalizada =	recalculaCetroides(clusters);
			}
			
		}
		
		return clusters ;

	}

	private List<List<Integer>> criaGrupos(String[][] centroides) {

		List<List<Integer>> clusters = new ArrayList<List<Integer>>();

		for (int i = 0; i < centroides.length; i++) {

			clusters.add(new ArrayList<Integer>());

		}

	

		for (int i = 0; i < baseNormalizada.length; i++) {
			
			double[] distancias = new double[centroides.length];

			for (int j = 0; j < centroides.length; j++) {

				for (int y = 0; y < centroides[0].length; y++) { 

					double distancia = Double.parseDouble(centroides[j][y])
							- Double.parseDouble(baseNormalizada[i][y]);

					if (distancia < 0) {
						distancia = distancia * (-1);
					}

					distancias[j] = distancias[j] + distancia;

				}

			}

			boolean menorDistancia = false;

			for (int j = 0; j < distancias.length; j++) {
				
				double distancia = distancias[j];

				for (int k = 0; k < distancias.length; k++) {
					
					if (distancia > distancias[k]) {
						menorDistancia = false;
						break;
					}
					
					menorDistancia = true;
				}

				if (menorDistancia) {
					clusters.get(j).add(i);
					menorDistancia = false;
					break;
				}

			}

		}

		return clusters;

	}

	private String[][] recalculaCetroides(List<List<Integer>> clusters) {

		String[][] novosCentroides = new String[clusters.size()][baseNormalizada[0].length];

		int i = 0;
		int col = 0;
		double valor = 0;

		for (List<Integer> cluster : clusters) {

			valor = 0;
			col =0 ;

			for (int j = 0; j < baseNormalizada[0].length; j++) {

				for (Integer row : cluster) {

					valor = valor + Double.parseDouble(baseNormalizada[row][j]);

				}

				novosCentroides[i][col] = String.valueOf(valor
						/ clusters.size());
              col++;
			}

			i++;
		}

		return novosCentroides;

	}

}
