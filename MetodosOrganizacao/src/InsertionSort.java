
public class InsertionSort {
	
	 public static Integer[] insertionSort(Integer[] array) 
     {
            for (int i = 1; i < array.length; i++) {
                    int a = array[i];
                    int j;
                    for (j = i - 1; j >= 0 && array[j] > a; j--){
                            array[j + 1] = array[j];
                            array[j] = a;
                    }
            }
            return array;
    }

}
