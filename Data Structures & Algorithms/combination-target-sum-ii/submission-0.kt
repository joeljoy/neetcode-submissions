class Solution {
    fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
        candidates.sort()
        val result = mutableListOf<List<Int>>()
        fun helper(start:Int, sumSoFar:Int, slate:List<Int>){
            if(sumSoFar > target){
                return
            }

            if(sumSoFar == target){
                result.add(slate)
                return
            }

            for(idx in start..<candidates.size){
                if(idx != start && candidates[idx] == candidates[idx - 1]) continue
                helper(idx + 1, sumSoFar + candidates[idx], slate.plus(candidates[idx]))
            }           
        }
        helper(0, 0, listOf())
        return result
    }
}