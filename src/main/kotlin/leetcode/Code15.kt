package leetcode

/**
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 *
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 解释：
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
 * 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
 * 注意，输出的顺序和三元组的顺序并不重要。
 * 示例 2：
 *
 * 输入：nums = [0,1,1]
 * 输出：[]
 * 解释：唯一可能的三元组和不为 0 。
 * 示例 3：
 *
 * 输入：nums = [0,0,0]
 * 输出：[[0,0,0]]
 * 解释：唯一可能的三元组和为 0 。
 *
 *
 * 提示：
 *
 * 3 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 */
class Solution15 {
//    fun threeSum(nums: IntArray): List<List<Int>> {
//        nums.sort()
//        val threeSum = mutableListOf<List<Int>>()
//        for (a in nums.indices) {
//            for (b in a + 1 until nums.size) {
//                for (c in b + 1 until nums.size) {
//                    val sum = nums[a] + nums[b] + nums[c]
//                    if (sum > 0) {
//                        break
//                    } else if (sum == 0) {
//                        val newList = listOf(nums[a], nums[b], nums[c])
//                        if (!threeSum.contains(newList)) {
//                            threeSum += newList
//                        }
//                    }
//                }
//            }
//        }
//        return threeSum
//    }

    fun threeSum(nums: IntArray): List<List<Int>> {
        nums.sort()
        val ansList = mutableListOf<List<Int>>()
        for (index in nums.indices) {
            if (index > 0 && nums[index] == nums[index - 1]) continue
            val target = -nums[index]

            var left = index + 1
            var right = nums.size - 1
            while (left < right) {
                val sum = nums[left] + nums[right]
                if (sum == target) {
                    ansList += listOf(nums[index], nums[left], nums[right])
                    left++
                    right--
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--
                    }
                } else if (sum < target) {
                    left++
                } else {
                    right--
                }
            }
        }
        return ansList
    }
}

fun main() {
    val nums = intArrayOf(-1,0,1,2,-1,-4)
    val indexes = Solution15().threeSum(nums)
    println(
        "indexes: ${
            indexes.joinToString(prefix = "[", postfix = "]") {
                it.joinToString(prefix = "[", postfix = "]")
            }
        }"
    )
}