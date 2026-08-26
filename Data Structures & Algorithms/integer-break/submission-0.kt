class Solution {
    fun integerBreak(n: Int): Int {
        val memo = IntArray(n + 1){
            -1
        }
        fun backtrack(x:Int):Int{
            if(x < 0) return 0
            if(x == 0) return 1
            if(memo[x] != -1) return memo[x]

            var product = Int.MIN_VALUE
            for(num in 1..n-1){
                product = max(product, num * backtrack(x - num))
            }
            memo[x] = product
            return product
        }
        return backtrack(n)
    }
}
