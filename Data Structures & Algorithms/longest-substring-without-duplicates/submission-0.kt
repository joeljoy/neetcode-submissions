class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        val set = mutableSetOf<Char>()
        var left = 0
        var longestSoFar = 0
        for(right in 0..<s.length){
            while(set.contains(s[right])){
                set.remove(s[left++])
            }

            set.add(s[right])
            val currentLength = right - left + 1
            longestSoFar = max(longestSoFar, currentLength)
        }
        return longestSoFar
    }
}
