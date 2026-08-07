class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
    val rows = matrix.size
    val cols = matrix[0].size

    var left = 0
    var right = rows * cols - 1

    while (left <= right) {
        val mid = left + (right - left) / 2

        // Convert 1D index -> 2D coordinates
        val row = mid / cols
        val col = mid % cols

        val value = matrix[row][col]

        when {
            value == target -> return true
            value < target -> left = mid + 1
            else -> right = mid - 1
        }
    }

    return false
}
}
