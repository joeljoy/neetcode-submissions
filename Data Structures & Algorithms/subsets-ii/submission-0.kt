class Solution {
    fun subsetsWithDup(nums: IntArray): List<List<Int>> {
        nums.sort()
        val result = mutableListOf<List<Int>>()
        fun helper(start:Int, slate:List<Int>){
            result.add(slate)

            for(idx in start..<nums.size){
                if(idx > start && nums[idx] == nums[idx - 1]) continue

                helper(idx + 1, slate.plus(nums[idx]))
            }

        }
        helper(0, listOf())
        return result
    }
}
