class Solution {
    fun countServers(grid: Array<IntArray>): Int {
        var count = 0
        val rows = grid.size
        val cols = grid.first().size
        fun isCommunicates(row:Int, col:Int):Boolean{
            if(grid[row][col] != 1) return false
            for(r in 0..<rows){
                if(r == row) continue
                if(grid[r][col] == 1) return true
            }

            for(c in 0..<cols){
                if(c == col) continue
                if(grid[row][c] == 1) return true
            }
            
            return false
        }
        for(row in 0..<rows){
            for(col in 0..<cols){
                if(grid[row][col] == 0) continue
                
                if(isCommunicates(row, col)){
                    count += 1
                }
            }
        }
        return count
    }
}
