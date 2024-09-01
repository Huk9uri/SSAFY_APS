package 분할정복;

public class 이진검색02_재귀 {
	static int[] arr = {8, 9,17,21,23,36,88,379};
	static int key= 19;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	static boolean binarySearch(int left, int right) {
		
		//기저
		if(left > right) return false;  // 교차가 되는 순간 
		//재귀
		int mid = (left+right)/2;
		// 같다면
		if(arr [mid] == key) return true;
		//크다면
		else if (arr[mid] > key) 
			return binarySearch(left, mid-1);
		//작다면
		else return binarySearch(mid+1, right);
	}
}
