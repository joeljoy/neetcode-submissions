class Solution {
    fun permute(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()

        fun helper(slate:List<Int>, remain:List<Int>){
            if(slate.size == nums.size){
                result.add(slate)
                return
            }

            for(idx in 0 until remain.size){
                helper(slate.plus(remain[idx]), remain.slice(0..<idx) + remain.slice(idx + 1 ..<remain.size))
            }
        }
        helper(listOf(), nums.toList())
        return result
    }
}
