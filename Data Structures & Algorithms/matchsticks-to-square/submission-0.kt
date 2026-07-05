class Solution {
    fun makesquare(matchsticks: IntArray): Boolean {
        val sum = matchsticks.sum()
        if(sum % 4 != 0) return false

        fun backtrack(side1:Int, side2:Int, side3:Int, side4:Int, idx:Int):Boolean{
            if(idx == matchsticks.size){
                if(side1 == side2 && side2 == side3 && side3 == side4 && side4 == side1){
                    return true
                }
                return false
            }
            val matchstick = matchsticks[idx]
            return backtrack(side1 + matchstick, side2, side3, side4, idx + 1) ||
                backtrack(side1, side2 + matchstick, side3, side4, idx + 1) ||
                backtrack(side1, side2, side3 + matchstick, side4, idx + 1) ||
                backtrack(side1, side2, side3, side4 + matchstick, idx + 1)
        }
        return backtrack(0,0,0,0,0)
    }
}
