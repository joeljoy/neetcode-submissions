class Solution {
    fun pacificAtlantic(heights: Array<IntArray>): List<List<Int>> {
        val rows = heights.size
        val cols = heights.first().size

        val pacific = Array(rows) {
            BooleanArray(cols)
        }
        for (col in 0..<cols) {
            dfsHelper(0, col, pacific, heights)
        }

        for (row in 0..<rows) {
            dfsHelper(row, 0, pacific, heights)
        }

        val atlantic = Array(rows) {
            BooleanArray(cols)
        }
        for (col in 0..<cols) {
            dfsHelper(rows - 1, col, atlantic, heights)
        }

        for (row in 0..<rows) {
            dfsHelper(row, cols - 1, atlantic, heights)
        }

        val result = mutableListOf<List<Int>>()
        for (row in 0..<rows) {
            for (col in 0..<cols) {
                if (pacific[row][col] && atlantic[row][col]) {
                    result.add(listOf(row, col))
                }
            }
        }
        return result
    }

    private fun dfsHelper(row: Int, col: Int, visited: Array<BooleanArray>, heights: Array<IntArray>) {
        val rows = heights.size
        val cols = heights.first().size

        fun dfs(row: Int, col: Int, prev: Int) {
            if (row < 0 || row >= rows || col < 0 || col >= cols) return
            if (visited[row][col]) return
            if (heights[row][col] < prev) return

            visited[row][col] = true
            dfs(row + 1, col, heights[row][col])
            dfs(row - 1, col, heights[row][col])
            dfs(row, col - 1, heights[row][col])
            dfs(row, col + 1, heights[row][col])
        }
        dfs(row, col, Int.MIN_VALUE)
    }
}
