class Solution {
    fun isInterleave(s1: String, s2: String, s3: String): Boolean {
        if(s1.length + s2.length != s3.length) return false
        val memo = mutableMapOf<Pair<Int, Int>, Boolean>()

        fun backtrack(idx1:Int, idx2:Int, idx3:Int):Boolean{
            if(idx3 >= s3.length){
                return true
            }
            val key = idx1 to idx2
            memo[key]?.let{
                return it
            }

            if(idx1 < s1.length && s1[idx1] == s3[idx3]){
                if(backtrack(idx1 + 1, idx2, idx3 + 1)){
                    memo[key] = true
                    return true
                }
            }

            if(idx2 < s2.length && s2[idx2] == s3[idx3]){
                if(backtrack(idx1, idx2 + 1, idx3 + 1)){
                    memo[key] = true
                    return true
                }
            }
            memo[key] = false
            return false
        }
        return backtrack(0,0,0)
    }
}
