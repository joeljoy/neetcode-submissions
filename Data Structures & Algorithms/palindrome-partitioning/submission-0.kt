class Solution {
    fun partition(s: String): List<List<String>> {
        val result = mutableListOf<List<String>>()
        fun helper(slate:List<String>, last:String, idx:Int){
            if(idx >= s.length){
                if(isPalindrome(last)){
                    result.add(slate + last)
                }
                return
            }

            helper(slate, last + s[idx], idx + 1)
            if(last.isNotEmpty() && isPalindrome(last)){
                helper(slate.plus(last), ""+s[idx], idx + 1)
            }
        }

        helper(listOf(), "", 0)
        return result
    }


    private fun isPalindrome(s:String):Boolean{
        return s == s.reversed()
    }
}
