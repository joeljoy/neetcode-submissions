class Solution {
    fun makesquare(matchsticks: IntArray): Boolean {
        val sum = matchsticks.sum()
        if (sum % 4 != 0) return false
        val maxLength = sum / 4
        var isSquare = false
        fun helper(top: Int, right: Int, bottom: Int, left: Int, idx: Int) {
            if (idx == matchsticks.size) {
                if (top == right && right == bottom && bottom == left) {
                    isSquare = true
                }
                return
            }
            val side = matchsticks[idx]
            if (top + side <= maxLength) {
                helper(top + side, right, bottom, left, idx + 1)
            }
            if (right + side <= maxLength) {
                helper(top, right + side, bottom, left, idx + 1)
            }
            if (bottom + side <= maxLength) {
                helper(top, right, bottom + side, left, idx + 1)
            }
            if (left + side <= maxLength) {
                helper(top, right, bottom, left + side, idx + 1)
            }
        }
        matchsticks.sortDescending()
        helper(0, 0, 0, 0, 0)
        return isSquare
    }
}
