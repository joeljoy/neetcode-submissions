class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val freqMap = mutableMapOf<String,List<String>>()
        for(str in strs){
            val freq = getFreq(str)
            freqMap[freq] = freqMap.getOrDefault(freq, listOf()).plus(str)
        }
        val result = mutableListOf<List<String>>()
        for((key, value) in freqMap.entries){
            result.add(value)
        }
        return result
    }

    private fun getFreq(str:String):String{
        val freq = IntArray(26)
        for(c in str){
            freq[c - 'a'] += 1
        }
        return freq.joinToString()
    }
}


