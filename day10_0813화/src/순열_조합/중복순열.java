package 순열_조합;

public class 중복순열 {
	static int[] arr = {1,2,3};
	static int r = 2;
	// 중복순열이므로 visited 필요없음
	//static boolean[] visited = new boolean[arr.length];
	
	static int[] output = new int[r];
	
	public static void main(String[] args) {
		perm(arr, output, 0, r);
		
	}
	
	static void perm(int[] arr, int[] output, int depth, int r) {
		
		if(depth == r) {
			for (int i = 0; i < output.length; i++) {
				System.out.print(output[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i = 0; i < arr.length; i++) {
			output[depth] = arr[i];
			perm(arr, output, depth + 1, r);
		}
		
	}

}
