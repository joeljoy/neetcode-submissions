class Solution {
    fun combine(n: Int, k: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        fun backtrack(slate:List<Int>, num:Int){
            if(num > n){
                if(slate.size == k){
                    result.add(slate)
                }
                return
            }
          

            backtrack(slate.plus(num), num + 1)
            backtrack(slate, num + 1)
        }
        backtrack(listOf(), 1)
        return result
    }
}
