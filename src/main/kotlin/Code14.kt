import kotlin.math.min

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 *
 *
 * 示例 1：
 *
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 *
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 *
 *
 * 提示：
 *
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 如果非空，则仅由小写英文字母组成
 */
class Solution14 {
    //    fun longestCommonPrefix(strs: Array<String>): String {
//        strs.sort()
//
//        val minStr = strs[0]
//        val maxStr = strs[strs.size - 1]
//
//        var count = 0
//        for (index in 0 until (min(minStr.length, maxStr.length))) {
//            if (minStr[index] == maxStr[index]) {
//                count++
//            } else {
//                break
//            }
//        }
//        return minStr.substring(0, count)
//    }
    fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.isEmpty()) return ""
        val pre = strs[0]
        var i = 0

        while (i < pre.length) {
            var j = 1
            while (j < strs.size) {
                if (i == strs[j].length || pre[i] != strs[j][i])
                    return pre.subSequence(0, i).toString()
                ++j
            }

            ++i
        }

        return pre.toString()
    }
}

fun main() {
    val strs = arrayOf("racecar", "dog", "car")
    val commonPrefix = Solution14().longestCommonPrefix(strs)
    println("commonPrefix: $commonPrefix")
}