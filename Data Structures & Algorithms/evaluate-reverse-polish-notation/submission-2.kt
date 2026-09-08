class Solution {
    fun evalRPN(tokens: Array<String>): Int {
        val stack = ArrayDeque<Int>()
        for(token in tokens){
            if(token.isOperator()){
                val op1 = stack.removeLast()
                val op2 = stack.removeLast()
                val result = evaluate(op2, op1, token)
                stack.addLast(result)
            }else{
                stack.addLast(token.toInt())
            }
        }
        return stack.removeLast()
    }

    private fun evaluate(a:Int, b:Int, op:String):Int{
        return when(op){
            "+" -> a + b
            "-" -> a - b
            "*" -> a * b
            "/" -> a / b
            else -> throw RuntimeException("Invalid op $op")
        }
    }

    fun String.isOperator():Boolean{
        return when(this){
            "+","-","*","/" -> true
            else -> false
        }
    }
}
