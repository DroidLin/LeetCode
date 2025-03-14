package leetcode
/**
 * 给你两个按 **非递减顺序** 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 *
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 **非递减顺序** 排列。
 *
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 *
 * - 示例 1：
 *
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 解释：需要合并 [1,2,3] 和 [2,5,6] 。
 * 合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
 * - 示例 2：
 *
 * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
 * 输出：[1]
 * 解释：需要合并 [1] 和 [] 。
 * 合并结果是 [1] 。
 * - 示例 3：
 *
 * 输入：nums1 = [0], m = 0, nums2 = [1], n = 1
 * 输出：[1]
 * 解释：需要合并的数组是 [] 和 [1] 。
 * 合并结果是 [1] 。
 * 注意，因为 m = 0 ，所以 nums1 中没有元素。nums1 中仅存的 0 仅仅是为了确保合并结果可以顺利存放到 nums1 中。
 */
class Solution88 {
    // [4, 5, 6, 0, 0, 0], [1, 2, 3]
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        require(nums1.size == (m + n))
        require(nums2.size == n)

        val newCopy = IntArray(m + n)
        var index1 = 0
        var index2 = 0
        var position = 0
        while (index1 < m && index2 < n) {
            if (nums1[index1] <= nums2[index2]) {
                newCopy[position++] = nums1[index1++]
            } else {
                newCopy[position++] = nums2[index2++]
            }
        }
        if (index1 < m) {
            for (index in index1 until m) {
                newCopy[position++] = nums1[index]
            }
        }
        if (index2 < n) {
            for (index in index2 until n) {
                newCopy[position++] = nums2[index]
            }
        }
        for (index in 0 until (m + n)) {
            nums1[index] = newCopy[index]
        }
    }
}

fun main() {
    val nums1 = intArrayOf(3, 4, 5, 0, 0, 0)
    val nums2 = intArrayOf(1, 2, 3)
    Solution88().merge(nums1, 3, nums2, 3)
    println(nums1.contentToString())
}