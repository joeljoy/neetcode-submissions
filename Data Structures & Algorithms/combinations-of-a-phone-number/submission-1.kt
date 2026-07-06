class Solution {
    private val digitToLetter = mapOf(
            '2' to "abc",
            '3' to "def",
            '4' to "ghi",
            '5' to "jkl",
            '6' to "mno",
            '7' to "pqrs",
            '8' to "tuv",
            '9' to "wxyz"
        )

    fun letterCombinations(digits: String): List<String> {
        if(digits.isEmpty()) return listOf()
        val result = mutableListOf<String>()
        fun backtrack(idx:Int, slate:String){
            if(idx == digits.length){
                result.add(slate)
                return
            }
            val digit = digits[idx]
            if(digitToLetter.contains(digit).not()){
                backtrack(idx + 1, slate + digit)
                return
            }

            for(lt in digitToLetter[digit]!!){
                backtrack(idx + 1, slate + lt)
            }
        }
        backtrack(0, "")
        return result
    }
}
