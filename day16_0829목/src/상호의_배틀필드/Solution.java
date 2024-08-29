package 상호의_배틀필드;

import java.util.Scanner;

public class Solution {
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int direction;
	static int tankR;
	static int tankC;
	static int bulletR;
	static int bulletC;
	static char[][] map;
	static int H;
	static int W;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			H = sc.nextInt();
			W = sc.nextInt();
			map = new char[H][W];
			direction = 0;
			tankR = 0;
			tankC = 0;
			bulletR = 0;
			bulletC = 0;
			for (int i = 0; i < H; i++) {
				String str = sc.next();
				for (int j = 0; j < W; j++) {
					map[i][j] = str.charAt(j);
					if (map[i][j] == '^') {
						tankR = i;
						tankC = j;
						direction = 0;
					} else if (map[i][j] == 'v') {
						tankR = i;
						tankC = j;
						direction = 1;
					} else if (map[i][j] == '<') {
						tankR = i;
						tankC = j;
						direction = 2;
					} else if (map[i][j] == '>') {
						tankR = i;
						tankC = j;
						direction = 3;

					}
				}
			}
			int N = sc.nextInt();
			String orderList = sc.next();
			for (int i = 0; i < N; i++) {
				char order = orderList.charAt(i);
				if (order != 'S') {
					move(order);
				} else { // Shoot 일때
					shoot();
				}
			}
			System.out.print("#" + tc + " ");
			printMap();
		}
	}

	static void printMap() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + "");
			}
			System.out.println();
		}
	}

	static void move(char order) {
		if (order == 'U') {
			direction = 0;
			map[tankR][tankC] = '^';
		} else if (order == 'D') {
			direction = 1;
			map[tankR][tankC] = 'v';
		} else if (order == 'L') {
			direction = 2;
			map[tankR][tankC] = '<';
		} else if (order == 'R') {
			direction = 3;
			map[tankR][tankC] = '>';
		}

		int newTankR = tankR + dr[direction];
		int newTankC = tankC + dc[direction];
		// 이동할 칸이 필드 안이고, 평지일 때.
		if (newTankR >= 0 && newTankR < H && newTankC >= 0 && newTankC < W && map[newTankR][newTankC] == '.') {
			map[newTankR][newTankC] = map[tankR][tankC]; // 탱크 옮기기
			map[tankR][tankC] = '.'; // 탱크가 있던 곳은 평지로 만들고
			tankR = newTankR; // 탱크 좌표 업데이트 .
			tankC = newTankC;
		} else {
			return;
		}
	}

	static void shoot() {
		// 현재 바라보고 있는 direction 으로 포탄이 전진
		bulletR = tankR + dr[direction];
		bulletC = tankC + dc[direction];
		if (bulletR >= 0 && bulletR < H && bulletC >= 0 && bulletC < W) {
			while (map[bulletR][bulletC] == '.' || map[bulletR][bulletC] == '-') {
				bulletR = bulletR + dr[direction];
				bulletC = bulletC + dc[direction];
				// 벽을 만나지 않아서 맵 밖으로 가는 경우
				if (bulletR < 0 || bulletR >= H || bulletC < 0 || bulletC >= W) {
					return;
				}
			}
			// 강철벽과 만나면 포탄 소멸
			if (map[bulletR][bulletC] == '#' || bulletR < 0 || bulletR >= H || bulletC < 0 || bulletC >= W) {
				return;
			} else if (map[bulletR][bulletC] == '*') { // 벽돌 벽과 만나면
				map[bulletR][bulletC] = '.';
				return;
			}
		}
	}
}