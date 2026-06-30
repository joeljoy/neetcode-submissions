class Solution {
    fun permuteUnique(nums: IntArray): List<List<Int>> {
        nums.sort()
        val result = mutableListOf<List<Int>>()

        fun helper(slate:List<Int>, remaining:List<Int>){
            if(slate.size == nums.size){
                result.add(slate)
                return
            }

            for(idx in 0 until remaining.size){
                if(idx != 0 && remaining[idx] == remaining[idx - 1]) continue
                helper(slate.plus(remaining[idx]), remaining.slice(0..<idx) + remaining.slice(idx + 1..<remaining.size))
            }
        }
        helper(listOf(), nums.toList())
        return result
    }
}
