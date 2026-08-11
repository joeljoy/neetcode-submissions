class Solution {
    fun canPartition(nums: IntArray): Boolean {
        val sum = nums.sum()
        if(sum % 2 != 0) return false
        val target = sum / 2
        val memo = mutableMapOf<Pair<Int, Int>, Boolean>()
        fun backtrack(subset1:Int, idx:Int):Boolean{
            if(subset1 > target) return false
            if(subset1 == target) return true

            if(idx >= nums.size){
               return false
            }

            val key = subset1 to idx
            memo[key]?.let{
                return it
            }

            if(backtrack(subset1 + nums[idx], idx + 1) || backtrack(subset1, idx + 1)){
                memo[key] = true
                return true
            }
            memo[key] = false
            return false
        }
        return backtrack(0, 0)
    }
}
