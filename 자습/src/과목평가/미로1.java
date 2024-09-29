package 과목평가;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class 미로1 {
    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };
    static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int tc = 1; tc <= 10; tc++) {
            sc.nextInt();  // 테스트 케이스 번호 읽기
            map = new int[16][16];
            int[] start = new int[2];
            for (int i = 0; i < map.length; i++) {
                String[] s = sc.next().split("");
                for (int j = 0; j < map.length; j++) {
                    map[i][j] = Integer.parseInt(s[j]);
                    if (map[i][j] == 2) {
                        start[0] = i;
                        start[1] = j;
                    }
                }
            }
            int result = bfs(start[0], start[1]);
            System.out.println("#" + tc + " " + result);
        }
        sc.close();
    }

    private static int bfs(int startRow, int startCol) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] { startRow, startCol });
        map[startRow][startCol] = 1;  // 방문 처리

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currRow = curr[0];
            int currCol = curr[1];

            for (int k = 0; k < dr.length; k++) {
                int nr = currRow + dr[k];
                int nc = currCol + dc[k];

                if (nr >= 0 && nr < 16 && nc >= 0 && nc < 16 && map[nr][nc] != 1) {
                    if (map[nr][nc] == 3) {
                        return 1;  // 도착점 도달
                    }
                    map[nr][nc] = 1;  // 방문 처리
                    queue.add(new int[] { nr, nc });
                }
            }
        }
        return 0;  // 도착점에 도달하지 못함
    }
}
