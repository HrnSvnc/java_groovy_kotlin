package codingchallanges

class FizzbuzzKotlin {
        fun execute(){
            for (i in 1..100){
                if (i.mod(15) == 0)println("FizzBuzz")else if (i.mod(3) == 0) println("Fizz")else if(i.mod(5) == 0) println("Buzz")else println(i)
            }
        }
}

fun main(){
    FizzbuzzKotlin().execute();
}