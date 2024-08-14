package 순열_조합;

public class 중복조합 {
	static int[] arr = { 1, 2, 3 };
	static int r = 2;
	static int[] output = new int[r];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		combination(arr, output, 0, 0, r);
	}
	
	static void combination(int[] arr, int[] output, int start, int depth, int r) {
		
		if(depth == r) {
			for (int i = 0; i < output.length; i++) {
				System.out.print(output[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i = start; i < arr.length; i++) {
			output[depth] = arr[i];
			combination(arr, output, i, depth + 1, r);
		}
	}

}
