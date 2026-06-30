class Solution {
    fun exist(board: Array<CharArray>, word: String): Boolean {
        val rows = board.size
        val cols = board.first().size
        val visited = Array(rows){
            BooleanArray(cols)
        }
        var result = false
        fun dfs(row:Int, col:Int, idx:Int){
            if(row < 0 || row >= rows || col < 0 || col >= cols) return
            if(board[row][col] != word[idx]) return
            if(visited[row][col]) return
            
            if(idx == word.length - 1){
                result = true
                return
            }

            visited[row][col] = true
            dfs(row + 1, col, idx + 1)
            dfs(row - 1, col, idx + 1)
            dfs(row, col + 1, idx + 1)
            dfs(row, col - 1, idx + 1)
            visited[row][col] = false
        }

        for(row in 0 until rows){
            for(col in 0 until cols){
                dfs(row, col, 0)
            }
        }
        return result
    }
}
