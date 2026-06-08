class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        if(s.length != t.length) return false

        val sMap = IntArray(26)
        val tMap = IntArray(26)

        for(c in s){
            sMap[c - 'a'] += 1
        }
        for(c in t){
            tMap[c - 'a'] += 1
        }

        return sMap.contentEquals(tMap)
    }
}
