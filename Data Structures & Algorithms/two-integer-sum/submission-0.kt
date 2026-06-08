class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = mutableMapOf<Int, Int>()
        map[nums.first()] = 0
        for(idx in 1..<nums.size){
            val diff = target - nums[idx]
            if(map.containsKey(diff)){
                return intArrayOf(map[diff]!!, idx)
            }
            map[nums[idx]] = idx
        }
        return intArrayOf(-1,-1)
    }
}
