class Solution {
    fun combinationSum(nums: IntArray, target: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        fun helper(sum:Int, idx:Int, slate:List<Int>){
            if(idx >= nums.size) return
            if(sum > target) return
            if(sum == target){
                result.add(slate)
                return
            }

            helper(sum + nums[idx], idx, slate.plus(nums[idx]))
            helper(sum, idx + 1, slate)
        }
        helper(0, 0, listOf())
        return result
    }
}
