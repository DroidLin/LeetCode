package leetcode

/**
 * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
 *
 * 如果可以，返回 true ；否则返回 false 。
 *
 * magazine 中的每个字符只能在 ransomNote 中使用一次。
 *
 *
 *
 * 示例 1：
 *
 * 输入：ransomNote = "a", magazine = "b"
 * 输出：false
 * 示例 2：
 *
 * 输入：ransomNote = "aa", magazine = "ab"
 * 输出：false
 * 示例 3：
 *
 * 输入：ransomNote = "aa", magazine = "aab"
 * 输出：true
 *
 *
 * 提示：
 *
 * 1 <= ransomNote.length, magazine.length <= 105
 * ransomNote 和 magazine 由小写英文字母组成
 */
class Solution383 {
    fun canConstruct(ransomNote: String, magazine: String): Boolean {
        val intArray = IntArray(26) { 0 }
        for (index in magazine.indices) {
            intArray[magazine[index] - 'a']++
        }
        for (index in ransomNote.indices) {
            val char = ransomNote[index]
            intArray[char - 'a']--
            if (intArray[char - 'a'] < 0) {
                return false
            }
        }
        return true
    }
}

fun main() {
    val canConstruct = Solution383().canConstruct("aa", "ab")
    println("canConstruct: $canConstruct")
}