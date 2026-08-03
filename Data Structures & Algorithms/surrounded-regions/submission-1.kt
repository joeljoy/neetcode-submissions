class Solution {
    fun solve(board: Array<CharArray>) {
        val rows = board.size
        val cols = board.first().size

        fun dfs(row:Int, col:Int){
            if(row < 0 || row >= rows || col < 0 || col >= cols) return
            if(board[row][col] != 'O') return

            board[row][col] = 'E'
            dfs(row + 1, col)
            dfs(row - 1, col)
            dfs(row, col + 1)
            dfs(row, col - 1)
        }

        for(row in 0..<rows){
            dfs(row, 0)
            dfs(row, cols - 1)
        }

        for(col in 0..<cols){
            dfs(0, col)
            dfs(rows -1, col)
        }

        for(row in 0..<rows){
            for(col in 0..<cols){
                board[row][col] = if(board[row][col] == 'E'){
                    'O'
                }else{
                    'X'
                }
            }
        }
    }
}
