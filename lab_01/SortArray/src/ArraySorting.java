import java.util.Arrays;

public class ArraySorting {
	public static void main(String[] args) {
		int[] a = {2,4,1313,1,3,6,7};
		int n = a.length;
		
		for(int i = 0; i < n - 1; i++) {
			for(int j = i + 1; j < n; j++) {
				if(a[i] > a[j]) {
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
		int sum = 0;
		for(int x : a) {
			sum += x;
		}
		double tb = (double) sum / n;
		
		System.out.println("Mang sap xep " + Arrays.toString(a));
		System.out.println("Tong " + sum);
		System.out.println("Trung binh " + tb);
	}
}
