class Solution {
    fun restoreIpAddresses(s: String): List<String> {
        val result = mutableListOf<String>()
        fun backtrack(start:Int, slate:String, count:Int){
            if(start > s.length) return
            
            if(count == 4 && start == s.length){
                result.add(slate.dropLast(1))
                return
            }

            if(count > 4) return

            for(len in 1..3){
                val segment = s.substring(start, min(start + len, s.length))
                if(isValid(segment).not()) continue
                
                backtrack(start + len, slate + segment + ".", count + 1)
            }
        }
        backtrack(0, "", 0)
        return result
    }

    private fun isValid(s:String):Boolean{
       if(s.isEmpty()) return false
        if(s.length > 1 && s[0] == '0') return false
        if(s.toInt() > 255) return false
        return true
    }
}
