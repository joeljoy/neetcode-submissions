class Solution {
    private val INF = 2147483647

    fun islandsAndTreasure(grid: Array<IntArray>) {
        val directions = listOf(
            intArrayOf(1, 0),
            intArrayOf(-1, 0),
            intArrayOf(0, 1),
            intArrayOf(0, -1)
        )

        val rows = grid.size
        val cols = grid.first().size
        val visited = Array(rows){
            BooleanArray(cols)
        }
        fun isEligible(row:Int, col:Int):Boolean{
            if(row < 0 || row >= rows || col < 0 || col >= cols) return false
            if(grid[row][col] == -1) return false
            if(visited[row][col]) return false
            return true
        }

        val queue = ArrayDeque<Pair<Int, Int>>()
        for(row in 0..<rows){
            for(col in 0..<cols){
                if(grid[row][col] == 0){
                    queue.addFirst(row to col)
                    visited[row][col] = true
                }
            }
        }

        var distance = 0
        while(queue.isNotEmpty()){
            val size = queue.size
            (1..size).forEach{
                val (row, col) = queue.removeLast()
                if(grid[row][col] == INF){
                    grid[row][col] = distance
                }

                for(direction in directions){
                    val nRow = row + direction[0]
                    val nCol = col + direction[1]
                    if(isEligible(nRow, nCol)){
                        queue.addFirst(nRow to nCol)
                        visited[nRow][nCol] = true
                    }
                }
            }
            distance += 1
        }
    }
}
