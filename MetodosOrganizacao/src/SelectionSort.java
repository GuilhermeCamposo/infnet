
public class SelectionSort {
	
	public static void SelectionSort(int[] v) {
		   int index_min,
		       aux;
		 
		   for (int i = 0; i < v.length; i++) {
		       index_min = i;
		       for (int j = i + 1; j < v.length; j++) {
		          if (v[j] < v[index_min]) { //descobre o índice do menor elemento
		             index_min = j;
		          }
		       }
		       if (index_min != i) { // coloca o menor elemento na primeira posição 
		         aux = v[index_min];
		         v[index_min] = v[i];
		         v[i] = aux;
		       }
		   }
		}
	

}
