class Solution {
    fun findTargetSumWays(nums: IntArray, target: Int): Int {
        fun backtrack(sum:Int, idx:Int):Int{
            if(idx == nums.size){
                if(sum == target){
                    return 1
                }
                return 0
            }

            return backtrack(sum + nums[idx], idx + 1) + backtrack(sum - nums[idx], idx + 1)
        }
        return backtrack(0, 0)
    }
}
