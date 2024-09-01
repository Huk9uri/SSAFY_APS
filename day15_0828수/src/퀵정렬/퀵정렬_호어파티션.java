package 퀵정렬;

import java.util.Arrays;

public class 퀵정렬_호어파티션 {
    // 정렬할 배열을 초기화합니다.
    static int[] arr = { 7, 5, 13, 2, 79, 12, 35, 42 };
    static int N = arr.length; // 배열의 길이

    public static void main(String[] args) {
        quickSort(0, N - 1);
        System.out.println(Arrays.toString(arr));
    }

    // 퀵 정렬 메서드입니다. 재귀적으로 호출되어 배열을 정렬합니다.
    static void quickSort(int left, int right) {
        // left가 right보다 작을 때만 정렬을 수행
        // 배열이 더 이상 나눌 수 없을 때 재귀를 종료
        if (left < right) {
            int pivot = partition(left, right);
            quickSort(left, pivot - 1); // 피벗의 왼쪽 부분 정렬
            quickSort(pivot + 1, right); // 피벗의 오른쪽 부분 정렬
        }
    }

    // 배열을 분할하고 피벗의 최종 위치 반환 메서드
    static int partition(int left, int right) {
        int pivot = arr[left]; // 피벗을 배열의 가장 왼쪽 요소로 설정
        int L = left + 1; // 왼쪽 포인터를 피벗 바로 오른쪽에서 시작
        int R = right; // 오른쪽 포인터를 배열의 끝에서 시작

        // 왼쪽 포인터와 오른쪽 포인터가 교차하기 전까지 반복
        while (L <= R) {
            // L 포인터를 오른쪽으로 이동하여 피벗보다 큰 값 찾기
            while (L <= R && arr[L] <= pivot)
                L++;
            // R 포인터를 왼쪽으로 이동하여 피벗보다 작거나 같은 값 찾기
            while (arr[R] > pivot)
                R--;

            // 만약 L과 R이 교차하지 않았다면 두 요소를 교환합니다.
            if (L < R) {
                int tmp = arr[L];
                arr[L] = arr[R];
                arr[R] = tmp;
            }
        }

        // 마지막으로 피벗을 R이 가리키는 위치로 이동합니다.
        // 이 위치가 피벗의 최종 위치가 됩니다.
        int tmp = arr[left];
        arr[left] = arr[R];
        arr[R] = tmp;

        // 피벗의 최종 위치를 반환합니다.
        return R;
    }
}
