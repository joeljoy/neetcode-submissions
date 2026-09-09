class Solution {
    fun checkInclusion(s1: String, s2: String): Boolean {
        if(s1.length > s2.length) return false
        val s1Array = IntArray(26){
            0
        }
        for(c in s1){
            s1Array[c- 'a'] += 1
        }

        val s2Array = IntArray(26){
            0
        }

        var left = 0
        var right = 0
        while(right < s1.length){
            val c = s2[right]
            s2Array[c- 'a'] += 1
            right += 1
        }

        if(check(s1Array, s2Array)){
            return true
        }

        while(right < s2.length){
            val outC = s2[left++] - 'a'
            val inC = s2[right++] - 'a'

            s2Array[outC] -= 1
            s2Array[inC] += 1
            if(check(s2Array, s1Array)){
                return true
            }
        }
        return false
    }   

    private fun check(s1:IntArray, s2:IntArray):Boolean{
        return s1.contentEquals(s2)
    }
}
