class Solution {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        if (checkRows(board).not()) return false
        if (checkCols(board).not()) return false
        if (checkSubBox(board).not()) return false
        return true
    }

    private fun checkRows(board: Array<CharArray>): Boolean {
        val rows = 9
        val cols = 9
        for (row in 0..<rows) {
            val uniqueRows = IntArray(9)
            for (col in 0..<cols) {
                if(board[row][col] == '.') continue
                val value = board[row][col].digitToInt()
                if (uniqueRows[value - 1] != 0) return false
                uniqueRows[value - 1] = 1
            }
        }
        return true
    }

    private fun checkCols(board: Array<CharArray>): Boolean {
        val rows = 9
        val cols = 9
        for (col in 0..<cols) {
            val uniqueRows = IntArray(9)
            for (row in 0..<rows) {
                if(board[row][col] == '.') continue
                val value = board[row][col].digitToInt()
                if (uniqueRows[value - 1] != 0) return false
                uniqueRows[value - 1] = 1
            }
        }
        return true
    }

    private fun checkSubBox(board: Array<CharArray>): Boolean {
        val rows = 9
        val cols = 9
        var row = 0
        var col = 0
        while (row < rows) {
            while (col < cols) {
                val rStart = row
                val rEnd = row + 3
                val cStart = col
                val cEnd = col + 3
                val uniqueBox = IntArray(9)
                for (r in rStart..<rEnd) {
                    for (c in cStart..<cEnd) {
                        if(board[r][c] == '.') continue
                        val value = board[r][c].digitToInt()
                        if (uniqueBox[value - 1] != 0) return false
                        uniqueBox[value - 1] = 1
                    }
                }
                col += 3
            }
            col = 0
            row += 3
        }
        return true
    }
}
