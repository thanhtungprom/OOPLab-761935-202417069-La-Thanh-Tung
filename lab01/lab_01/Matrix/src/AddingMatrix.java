
public class AddingMatrix {
	public static void main(String[] args) {
		int[][] A = {
				{1, 2, 3},
				{4, 5, 6}
		};
		int[][] B = {
				{7, 8, 9},
				{1, 2, 1}
		};
		int sum[][] = new int[2][3];
		
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 3; j++) {
				sum[i][j] = A[i][j] + B[i][j];
			}
		}
		System.out.println("Ket qua");
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 3; j++) {
				System.out.print(sum[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
