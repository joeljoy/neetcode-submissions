class Solution {
    fun subsets(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        fun helper(idx:Int, slate:List<Int>){
            if(idx == nums.size){
                result.add(slate)
                return
            }

            helper(idx + 1, slate.plus(nums[idx]))
            helper(idx + 1, slate)
        }
        helper(0, listOf())
        return result
    }
}
