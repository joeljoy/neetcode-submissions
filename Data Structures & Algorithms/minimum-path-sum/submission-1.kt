class Solution {
    fun minPathSum(grid: Array<IntArray>): Int {
        val memo = mutableMapOf<Pair<Int, Int>,Int>()
        fun recursion(row:Int, col:Int):Int{
            if(row == 0 && col == 0) return grid[row][col]
            if(row < 0 || col < 0) return Int.MAX_VALUE
            val key = row to col
            memo[key]?.let{
                return it
            }

            val sum = min(recursion(row - 1, col), recursion(row, col - 1)) + grid[row][col]
            memo[key] = sum
            return sum
        }
        return recursion(grid.size - 1, grid.first().size - 1)
    }
}
