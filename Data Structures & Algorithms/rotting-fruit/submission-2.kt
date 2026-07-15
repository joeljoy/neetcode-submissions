class Solution {
    fun orangesRotting(grid: Array<IntArray>): Int {
        val queue = ArrayDeque<Pair<Int,Int>>()
        val rows = grid.size
        val cols = grid.first().size
        val visited = Array(rows){
            BooleanArray(cols)
        }

        for(row in 0..<rows){
            for(col in 0..<cols){
                if(grid[row][col] == 2){
                    queue.addLast(row to col)
                    visited[row][col] = true
                }
            }
        }

        val directions = listOf(
            intArrayOf(0, 1),
            intArrayOf(0, -1),
            intArrayOf(1, 0),
            intArrayOf(-1, 0)
        )
        var minutes = -1

        while(queue.isNotEmpty()){
            val size = queue.size
            println(size)
            (1..size).forEach{
                val (r, c) = queue.removeFirst()
                for(dir in directions){
                    val row = r + dir[0]
                    val col = c + dir[1]

                    if(row < 0 || row >= rows || col < 0 || col >= cols) continue
                    if(grid[row][col] == 0) continue
                    if(visited[row][col]) continue

                    queue.addLast(row to col)
                    visited[row][col] = true
                }
            }
            minutes += 1
        }

        for(row in 0..<rows){
            for(col in 0..<cols){
                if(grid[row][col] == 0)continue
                if(visited[row][col].not()) return -1
            }
        }

        return if(minutes == -1) 0 else minutes
    }
}
