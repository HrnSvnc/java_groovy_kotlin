package codingchallanges

class FizzbuzzKotlin {

}

    fun main(a:Array<String>){(1..100).map{i->println(mapOf(0 to i,i%3 to "Fizz",i%5 to "Buzz",i%15 to "FizzBuzz")[0])}}
