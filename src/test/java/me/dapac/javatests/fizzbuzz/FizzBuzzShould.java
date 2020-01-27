package me.dapac.javatests.fizzbuzz;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class FizzBuzzShould {

    @Test
    public void fizz_when_number_is_divisible_by_3() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        assertThat(fizzBuzz.fizzBuzz(3), is("Fizz"));
        assertThat(fizzBuzz.fizzBuzz(6), is("Fizz"));
    }

    @Test
    public void buzz_when_number_is_divisible_by_5() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        assertThat(fizzBuzz.fizzBuzz(5), is("Buzz"));
        assertThat(fizzBuzz.fizzBuzz(10), is("Buzz"));
    }

    @Test
    public void fizzBuzz_when_number_is_divisible_by_both() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        assertThat(fizzBuzz.fizzBuzz(15), is("FizzBuzz"));
        assertThat(fizzBuzz.fizzBuzz(30), is("FizzBuzz"));
    }

    @Test
    public void when_number_not_divisible_by_any() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        assertThat(fizzBuzz.fizzBuzz(2), is("2"));
        assertThat(fizzBuzz.fizzBuzz(16), is("16"));
    }
}