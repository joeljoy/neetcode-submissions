class Solution {
    fun numIslands(grid: Array<CharArray>): Int {
        val rows = grid.size
        val cols = grid.first().size

        val visited = Array(rows){
            BooleanArray(cols)
        }
        fun dfs(row:Int, col:Int){
            if(row < 0 || row >= rows || col < 0 || col >= cols) return
            if(grid[row][col] == '0') return            
            if(visited[row][col]) return

            visited[row][col] = true
            dfs(row + 1, col)
            dfs(row - 1, col)
            dfs(row, col + 1)
            dfs(row, col - 1)
        }

        var islands = 0
        for(row in 0..<rows){
            for(col in 0..<cols){
                if(grid[row][col] == '0') continue
                if(visited[row][col]) continue
                dfs(row,col)
                islands += 1
            }
        }
        return islands
    }
}
