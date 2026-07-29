class Solution {
    fun uniquePaths(m: Int, n: Int): Int {
        val memo = Array(m){
            IntArray(n){
                -1
            }
        }
        fun dfs(row:Int, col:Int):Int{
            if(row == m - 1 && col == n - 1){
                return 1
            }

            if(row >= m || col >= n) return 0

            if(memo[row][col] != -1){
                return memo[row][col]
            }

            val value = dfs(row + 1, col) + dfs(row, col + 1)
            memo[row][col] = value
            return value
        }
        return dfs(0, 0)
    }
}
