class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val map = mutableMapOf<List<Int>, List<String>>()

        for(str in strs){
            val count = MutableList(26){ 0 }
            for(c in str){
                count[c - 'a'] += 1
            }
            map[count] = map.getOrDefault(count, listOf()).plus(str)
        }
        return map.values.toList()
    }
}
