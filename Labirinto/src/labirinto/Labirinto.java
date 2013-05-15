package labirinto;

import helper.Posicao;

import java.util.ArrayList;
import java.util.List;

public class Labirinto {
	
	static boolean nSaiu = true;
	static boolean nEncontrouCaminho = true;
	
	static char[][] LABIRINTO =	 {  {'1' ,'1' ,'1' ,'1' ,'1', '1', '1', '1', '1', '1', '1'},
									{'1','0', '0', '0', '0', '0', '1', '0', '0', '0', '1'},
									{'1', '0', '1', '0', '0', '0', '1', '0', '1', '0', '1'},
									{'S' ,'0', '1', '0', '0', '0', '0', '0', '1', '0', '1'},
									{'1', '0', '1', '1', '1', '1', '1', '0', '1', '0', '1'},
									{'1', '0', '1', '0', '1', '0', '0', '0', '1', '0', '1'},
									{'1', '0', '0', '0', '1', '0', '1', '0', '0', '0', '1'},
									{'1', '1', '1', '1', '1', '0', '1', '0', '0', '0', '1'},
									{'1', '0', '1', 'E' ,'1', '0', '1', '0', '0', '0', '1'},
									{'1', '0', '0', '0', '0', '0', '1', '0', '0', '0', '1'},
									{'1', '1', '1', '1', '1', '1', '1', '1','1', '1', '1' } }; 
	
	
	static Integer[][] pilha = new Integer[4][2]; 
	/* vizinhança da direita [0][0] e [0][1]
	 * vizinhança da esquerda [1][0] e [1][1]
	 * vizinnança inferior [2][0] e [2][1]
	 * vizinnança superior [3][0] e [3][1]
	 */
	
	static Posicao posicaoRato = new Posicao();
	static List<Posicao> posicaoAnterior = new ArrayList<Posicao>();
	
	/**
	 *  verifica para onde o rato pode andar
	 */
	static void localizarCaminho(){

		//verificar posição superior
		if(LABIRINTO[posicaoRato.getLinha() - 1][posicaoRato.getColuna()] == '0' || 
		   LABIRINTO[posicaoRato.getLinha() - 1][posicaoRato.getColuna()] == 'S'		){
			
			pilha[3][0] = posicaoRato.getLinha() - 1 ;
			pilha [3][1] = posicaoRato.getColuna();
		}else{
			pilha[3][0] = null ;
			pilha [3][1] = null;			
		}
		
		//verificar posição inferior
		if(LABIRINTO[posicaoRato.getLinha() + 1][posicaoRato.getColuna()] == '0' || 
		   LABIRINTO[posicaoRato.getLinha() + 1][posicaoRato.getColuna()] == 'S'){
			
			pilha[2][0] = posicaoRato.getLinha() + 1 ;
			pilha[2][1] = posicaoRato.getColuna();
		}else{
			pilha[2][0] = null ;
			pilha[2][1] = null;
		}
		
		//verificar posição esquerda
		if(LABIRINTO[posicaoRato.getLinha()][posicaoRato.getColuna()- 1] == '0' ||
		   LABIRINTO[posicaoRato.getLinha()][posicaoRato.getColuna()- 1] == 'S'	){
			
			pilha[1][0] = posicaoRato.getLinha();
			pilha [1][1] = posicaoRato.getColuna() - 1 ;
		}else{
			pilha[1][0] = null;
			pilha[1][1] = null ;
		}
		
		//verificar posição direita
		if(LABIRINTO[posicaoRato.getLinha()][posicaoRato.getColuna()+ 1] == '0' ||
		   LABIRINTO[posicaoRato.getLinha()][posicaoRato.getColuna()+ 1] == 'S'	){
			
			pilha[0][0] = posicaoRato.getLinha();
			pilha [0][1] = posicaoRato.getColuna() + 1 ;
		}else{
			pilha[0][0] = null;
			pilha [0][1] = null;
		}
		
		
	}
	
	/**
	 * encontra a posição inicial do rato 
	 */
	static void acharPosicaoInicial(){
		for (int i = 0; i < LABIRINTO.length; i++) {
			   
			    for (int j = 0; j < LABIRINTO[0].length; j++) {
			    	
					if (LABIRINTO[i][j] == 'E'){
						posicaoRato.setLinha(i);
						posicaoRato.setColuna(j);
					}
					
				}
			  
			
		}
	}
	
	static void mover(){
		for (int i = pilha.length -1; i >= 0 ; i--) {
			 
			
				 if(pilha[i][0] !=null ){
					 
					 if( LABIRINTO[ pilha[i][0] ][ pilha[i][1]] == 'S'){
						 nSaiu = false ;
						 break;
					 }
					 
					 Posicao posicao = new Posicao();
					 posicao.setLinha(posicaoRato.getLinha());
					 posicao.setColuna(posicaoRato.getColuna());
					 
					 posicaoAnterior.add(posicao);				
					 
					 posicaoRato.setLinha( pilha[i][0] );
					 posicaoRato.setColuna( pilha[i][1] );					 
					 LABIRINTO[ pilha[i][0] ][ pilha[i][1] ] = '.';
					 nEncontrouCaminho = false;
					 break;
					 
				 }
			
			  }
			
			if (nEncontrouCaminho) {
			  
				posicaoRato.setColuna( posicaoAnterior.get(posicaoAnterior.size()-1).getColuna() );
				posicaoRato.setLinha( posicaoAnterior.get(posicaoAnterior.size()-1).getLinha() );
				
				posicaoAnterior.remove(posicaoAnterior.size()-1);
				
			}else{
				nEncontrouCaminho = true;
			}
			
		
	}
	
	static void imprimirLabirintoFinal(){
		
		for (int i = 0; i < LABIRINTO.length; i++) {
			   
		    for (int j = 0; j < LABIRINTO[0].length; j++) {
		    	if(j == LABIRINTO[0].length - 1){
		    		System.out.println(LABIRINTO[i][j]);
		    	}else{
		    		System.out.print(LABIRINTO[i][j]);
		    	}
		    	
		       }
		    }
		
	}
	
	public static void main(String[] args) {
		
		acharPosicaoInicial();
		
		while (nSaiu) {
			localizarCaminho();
			mover();
		}
		
		System.out.println("E assim fica o labirinto depois de todos os movimentos ");
		System.out.println("=======================================================");
		imprimirLabirintoFinal();
		
	}

}
