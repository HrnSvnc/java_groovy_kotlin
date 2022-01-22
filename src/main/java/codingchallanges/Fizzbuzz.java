package codingchallanges;

public class Fizzbuzz {

  public void execute(){
    for(int i = 0; i<100;i++){
      System.out.println(i%15==0?"FizzBuzz":i%3==0?"Fizz":i%5==0?"Buzz":i);
    }
  }

  public static void main(String[] args){
    new Fizzbuzz().execute();
  }

  public Fizzbuzz(){
  }





}
