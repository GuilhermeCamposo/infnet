package ocjp;

public class PQ800_20 {
	static void compute(int... is) { // (1)
		System.out.print("|");
		for (int i : is) {
			System.out.print(i + "|");
		}
		System.out.println();
	}

	static void compute(int[] ia, int... is) { // (2)
		compute(ia);
		compute(is);
	}

	static void compute(int[] inta, int[]... is) { // (3)
		for (int[] ia : is) {
			compute(ia);
		}
	}

	public static void main(String[] args) {
		compute(new int[] { 10, 11 }, new int[] { 12, 13, 14 }); // (4)
		compute(15, 16); // (5)
		compute(new int[] { 17, 18 }, new int[][] { { 19 }, { 20 } }); // (6)
		compute(null, new int[][] { { 21 }, { 22 } }); // (7)
	}
}