class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val intToFreqMap = mutableMapOf<Int, Pair<Int, Int>>()
        val result = IntArray(k)
        for (num in nums) {
            val freq = intToFreqMap.getOrDefault(num, Pair(num, 0)).second + 1
            intToFreqMap[num] = num to freq
        }
        val sorted = intToFreqMap.values.sortedByDescending {
            it.second
        }
        for (idx in 0..<k) {
            val num = sorted[idx].first
            result[idx] = num
        }
        return result
    }
}
