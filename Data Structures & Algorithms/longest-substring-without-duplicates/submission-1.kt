class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        val set = mutableSetOf<Char>()
        var longest = 0
        var left = 0
        for (right in 0 until s.length) {
            while (set.contains(s[right])) {
                set.remove(s[left++])
            }

            set.add(s[right])
            longest = max(right - left + 1, longest)
        }
        return longest
    }
}
