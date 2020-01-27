package me.dapac.javatests.fizzbuzz;

public class FizzBuzz {

    private static final String FIZZ = "Fizz";
    private static final String BUZZ = "Buzz";
    private static final String FIZZBUZZ = "FizzBuzz";

    public String fizzBuzz(int number) {
        if (number % 3 == 0 && number % 5 == 0) {
            return FIZZBUZZ;
        } else if (number % 3 == 0) {
            return FIZZ;
        }else if (number % 5 == 0){
            return BUZZ;
        }

        return String.valueOf(number);
    }
}
