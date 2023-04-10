package fizzBuzz;

public class FizzBuzz {

    public FizzBuzz(){

    }

    public String fizzBuzz(int x){
        if (x % 15 == 0 || (contains(x, "3") && contains(x, "5"))) {
            return "FizzBuzz";
        }
        if (x % 3 == 0 || (contains(x, "3"))) {
            return "Fizz";
        }
        if (x % 5 == 0 || (contains(x, "5"))) {
            return "Buzz";
        }
        return String.valueOf(x);
    }

    private boolean contains(Integer x, String a){
        return x.toString().contains(a);
    }

}
