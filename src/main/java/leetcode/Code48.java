package leetcode;

import java.util.Arrays;

/**
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 * <p>
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[[7,4,1],[8,5,2],[9,6,3]]
 * 示例 2：
 * <p>
 * <p>
 * 输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
 * 输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == matrix.length == matrix[i].length
 * 1 <= n <= 20
 * -1000 <= matrix[i][j] <= 1000
 */
class Solution48 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                new int[]{5, 1, 9, 11},
                new int[]{2, 4, 8, 10},
                new int[]{13, 3, 6, 7},
                new int[]{15, 14, 12, 16},
        };
        new Solution48().rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    public void rotate(int[][] matrix) {
        // 副对角线翻转
        for (int i = 0; i < matrix.length - 1; i++) {
            int optI = matrix.length - 1 - i;
            for (int j = 0; j < matrix[i].length - 1 - i; j++) {
                int optJ = matrix[i].length - 1 - j;
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[optJ][optI];
                matrix[optJ][optI] = tmp;
            }
        }
        // 上下翻转
        for (int i = 0; i < matrix.length / 2; i++) {
            int optI = matrix.length - 1 - i;
            for (int j = 0; j < matrix[i].length; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[optI][j];
                matrix[optI][j] = tmp;
            }
        }
    }
}

