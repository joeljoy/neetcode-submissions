class Solution {
    fun isValid(s: String): Boolean {
        val stack = ArrayDeque<Char>()
        for(c in s){
            if(c in listOf('(','{','[')){
                stack.addLast(c)
            }else{
                if(stack.isEmpty()) return false
                val opening = stack.removeLast()
                if(c == ')'){
                    if(opening != '(') return false
                }

                if(c == '}'){
                    if(opening != '{') return false
                }

                if(c == ']'){
                    if(opening != '[') return false
                }
            }
        }
        return stack.isEmpty()
    }
}
