class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val freqMap = mutableMapOf<Int, Int>()
        val pq = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })

        for (num in nums) {
            freqMap[num] = freqMap.getOrDefault(num, 0) + 1
        }

        for ((num, freq) in freqMap) {
            pq.add(num to freq)
            while (pq.size > k) {
                pq.poll()
            }
        }

        val result = mutableListOf<Int>()
        while (pq.isNotEmpty()) {
            result.add(pq.poll().first)
        }
        return result.toIntArray()
    }
}
