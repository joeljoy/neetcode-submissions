class Solution {
    fun asteroidCollision(asteroids: IntArray): IntArray {
        val stack = ArrayDeque<Int>()
        for(asteroid in asteroids){
            if(asteroid > 0){
                stack.addLast(asteroid)
            }else{
                var isLeftAsteroidBroken = false
                while(stack.isNotEmpty()){
                    val ast = stack.removeLast()
                    if(ast < 0){
                        stack.addLast(ast)
                        break
                    }
                    //asteroid is bigger
                    //do nothing keeping on popping while that happens

                    //asteroid is smaller
                    if(abs(asteroid) < ast){
                        stack.addLast(ast)
                        isLeftAsteroidBroken = true
                        break
                    }
                    if(abs(asteroid) == ast){
                        isLeftAsteroidBroken = true
                        break
                    }
                }
                if(isLeftAsteroidBroken.not()){
                    stack.addLast(asteroid)
                }
            }
        }
        return stack.toIntArray()
    }
}
