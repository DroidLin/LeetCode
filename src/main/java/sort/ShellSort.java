package sort;

import java.util.Arrays;

public class ShellSort {

    public static void main(String[] args) {
        int[] numbers = new int[]{1, 2, 3, 5, 4};
        shellSort(numbers);
        System.out.println(Arrays.toString(numbers));
    }

    public static void shellSort(int[] arr) {
        int length = arr.length;
        int temp;
        for (int step = length / 2; step >= 1; step /= 2) {
            for (int i = step; i < length; i++) {
                temp = arr[i];
                int j = i - step;
                while (j >= 0 && arr[j] > temp) {
                    arr[j + step] = arr[j];
                    j -= step;
                }
                arr[j + step] = temp;
            }
        }
    }
}
