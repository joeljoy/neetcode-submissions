class Solution {
    fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {
        val rows = obstacleGrid.size
        val cols = obstacleGrid.first().size

        val dp = Array(rows){
            IntArray(cols)
        }

        var obstacle = false
        for(col in 0..<cols){
            obstacle = obstacle || obstacleGrid[0][col] == 1
            dp[0][col] = if(obstacle) 0 else 1
        }

        obstacle = false
        for(row in 0..<rows){
            obstacle = obstacle || obstacleGrid[row][0] == 1
            dp[row][0] = if(obstacle) 0 else 1
        }

        for(row in 1..<rows){
            for(col in 1..<cols){
                dp[row][col] = if(obstacleGrid[row][col] == 1){
                    0
                }else{
                    dp[row][col - 1] + dp[row - 1][col]
                }
            }
        }
        return dp[rows-1][cols-1]
    }
}
