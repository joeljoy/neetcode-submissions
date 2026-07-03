class Solution {
    fun generateParenthesis(n: Int): List<String> {
        val result = mutableListOf<String>()
        fun helper(slate:String, opening:Int, closing:Int){
            if(slate.length == 2*n){
                result.add(slate)
                return
            }

            if(opening < n){
                helper(slate + "(", opening + 1, closing)
            }
            if(closing < opening){
                helper(slate + ")", opening, closing + 1)
            }
        }
        helper("", 0,0)
        return result
    }
}
