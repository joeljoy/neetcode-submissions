class Solution {
    fun characterReplacement(s: String, k: Int): Int {
        val freqMap = mutableMapOf<Char, Int>()
        var longest = 0
        var maxFrequency = 0
        var left = 0
        for(right in 0 until s.length){
            val freq = freqMap.getOrDefault(s[right], 0) + 1
            freqMap[s[right]] = freq
            maxFrequency = max(freq, maxFrequency)
            while((right - left + 1) - maxFrequency > k){
                freqMap[s[left]] = freqMap.getOrDefault(s[left], 0) - 1
                if(freqMap[s[left]]!! < 0){
                    freqMap.remove(s[left])
                }
                left++
            }
            longest = max(longest, right - left + 1)
        }
        return longest
    }
}
