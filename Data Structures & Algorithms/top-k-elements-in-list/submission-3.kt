class Solution {
   fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val pq = PriorityQueue<Pair<Int, Int>> { a, b ->
            a.second - b.second
        }
        val freqMap = mutableMapOf<Int, Int>()
        for(num in nums){
            freqMap[num] = freqMap.getOrDefault(num, 0) + 1
        }
        for((num, freq) in freqMap.entries){
            pq.add(num to freq)
            if(pq.size > k){
                pq.poll()
            }
        }
        return pq.map { it.first }.toIntArray()
    }
}
