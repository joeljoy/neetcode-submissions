class Solution {
    fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
        val map = mutableMapOf<Int, Int>()
        for(idx in nums.indices){
            if(map.contains(nums[idx])){
                if(abs(map[nums[idx]]!! - idx) <= k){
                    return true
                }

            }
            map[nums[idx]] = idx
        }
        return false
    }
}
