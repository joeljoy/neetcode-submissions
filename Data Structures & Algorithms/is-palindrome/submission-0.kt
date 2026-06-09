class Solution {
    fun isPalindrome(s: String): Boolean {
        val processed = preProcess(s)
        return processed == processed.reversed()
    }

    private fun preProcess(s:String):String{
        val builder = StringBuilder()
        for(c in s.lowercase()){
            if(c.isLetterOrDigit()){
                builder.append(c)
            }
        }
        return builder.toString()
    }
}
