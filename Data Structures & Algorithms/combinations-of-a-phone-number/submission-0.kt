class Solution {
    val digitToLetterMap = mutableMapOf(
        '1' to "",
        '2' to "ABC",
        '3' to "DEF",
        '4' to "GHI",
        '5' to "JKL",
        '6' to "MNO",
        '7' to "PQRS",
        '8' to "TUV",
        '9' to "WXYZ",
        '0' to ""
    )
    fun letterCombinations(digits: String): List<String> {
        if (digits.isEmpty()) return emptyList()
        val result = mutableListOf<String>()

        fun dfs(idx:Int, slate:String){
            if(idx == digits.length){
                result.add(slate.lowercase())
                return
            }

            for(letter in digitToLetterMap[digits[idx]]!!){
                dfs(idx + 1, slate + letter)
            }
        }
        dfs(0, "")
        return result
    }
}
