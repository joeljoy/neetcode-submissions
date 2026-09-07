class Solution {
    fun combine(n: Int, k: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        fun backtrack(start:Int, slate:List<Int>){
            if(slate.size == k){
                result.add(slate)
                return
            }

            for(num in start..n){
                backtrack(num + 1, slate.plus(num))
            }
        }
        backtrack(1, listOf())
        return result
    }
}
