class Solution {
    fun maxAreaOfIsland(grid: Array<IntArray>): Int {
        val rows = grid.size
        val cols = grid.first().size
        val visited = Array(rows){
            BooleanArray(cols)
        }

        fun dfs(row:Int, col:Int):Int{
            if(row < 0 || row >= rows || col < 0 || col >= cols) return 0
            if(grid[row][col] == 0 || visited[row][col]) return 0
            visited[row][col] = true

            val count = dfs(row + 1, col) + dfs(row - 1, col) + dfs(row, col + 1) + dfs(row, col - 1)
            return 1 + count
        }

        var maxSoFar = 0
        for(row in 0..<rows){
            for(col in 0..<cols){
                val area = dfs(row, col)
                maxSoFar = max(area, maxSoFar)
            }
        }
        return maxSoFar
    }
}
