import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class test {
	static Queue<Integer> arr = new ArrayDeque<>();
	static Queue<int[]> arr2 = new ArrayDeque<>();

	public static void main(String[] args) {
		arr.add(5);
		arr.add(8);
		arr.add(1);
		arr.add(4);
		arr.add(7);
		System.out.println(arr);
		int tmp = arr.poll();
		
		arr.add(tmp);
		
		System.out.println(arr);
		
		arr2.add(new int[] {2,4,5});
		arr2.add(new int[] {30,11,2});
		arr2.add(new int[] {1,5,9});
		
		while(!arr2.isEmpty()) {
			System.out.println(Arrays.toString(arr2.poll()));
		}
		System.out.println(arr2);
	}
}
