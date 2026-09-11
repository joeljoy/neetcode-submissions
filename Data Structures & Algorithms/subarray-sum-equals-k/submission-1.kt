class Solution {
    fun subarraySum(nums: IntArray, k: Int): Int {
        val sumMap = mutableMapOf<Int,Int>()
        sumMap[0] = 1

        var prefixSum = 0
        var count = 0
        for(num in nums){
            prefixSum += num

            val neededSum = prefixSum - k
            count += sumMap.getOrDefault(neededSum, 0)

            sumMap[prefixSum] = sumMap.getOrDefault(prefixSum, 0) + 1
        }
        return count
    }
}
