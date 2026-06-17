class Solution {
    fun minWindow(s: String, t: String): String {
        val windowCount = mutableMapOf<Char, Int>()
        val tCount = mutableMapOf<Char,Int>()
        var left = 0
        var minWindow = Int.MAX_VALUE
        var window = ""
        
        for(c in t){
            tCount[c] = tCount.getOrDefault(c, 0) + 1
        }

        fun addToWindow(c:Char){
           windowCount[c] = windowCount.getOrDefault(c, 0) + 1 
        }

        fun removeFromWindow(c:Char){
            windowCount[c] = windowCount.getOrDefault(c, 0) - 1
        }

        fun isWindowValid():Boolean{
            for((c, need) in tCount.entries){
                val have = windowCount.getOrDefault(c, 0)
                if(have < need) return false
            }
            return true
        }

        for(right in 0 until s.length){
            addToWindow(s[right])
            if(isWindowValid()){
                 val currentWindow = right - left + 1
                if(currentWindow < minWindow){
                    minWindow = currentWindow
                    window = s.substring(left, right + 1)
                }
            }
            
            while(isWindowValid()){
                val currentWindow = right - left + 1
                if(currentWindow < minWindow){
                    minWindow = currentWindow
                    window = s.substring(left, right + 1)
                }
                removeFromWindow(s[left++])
            }
        }

        return window
    }
}
