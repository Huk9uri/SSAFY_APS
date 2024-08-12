package BFS;

public class TreeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] names = { "헤일리쌤", "배장한", "김혜원", "손진호", "김소현", "최혁규" };
		// 						헤일리쌤                         너비 0
		//		 배장한     					김혜원			   너비 1
		//	손진호		김소현			최혁규				   너비 2
		// 위의 names를 이용하여 완전이진트리 생성
		CompleteBinaryTree<String> tree = new CompleteBinaryTree<>(names.length);
		for (int i = 0; i < names.length; i++) {
			tree.add(names[i]);
		}
		// bfs 탐색
		tree.bfs2();
	}

}
