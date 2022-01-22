package codingchallanges;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Fizzbuzz {

  public void execute(){
    System.out.println(
        IntStream
            .range(1,101)
            .mapToObj(String::valueOf)
            .map(i->Integer.parseInt(i)%15==0?"FizzBuzz":Integer.parseInt(i)%3==0?"Fizz":Integer.parseInt(i)%5==0?"Buzz": i)
            .collect(Collectors.toList()));
  }

  public static void main(String[] args){
    new Fizzbuzz().execute();
  }

  public Fizzbuzz(){
  }





}
