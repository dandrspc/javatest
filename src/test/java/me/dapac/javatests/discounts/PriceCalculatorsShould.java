package me.dapac.javatests.discounts;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PriceCalculatorsShould {

    @Test
    public void total_zero_when_there_are_no_prices() {
        PriceCalculator calculator = new PriceCalculator();
        assertThat(calculator.getTotal(), is(0.0));
    }

    @Test
    public void total_is_the_sum_of_prices() {
        PriceCalculator calculator = new PriceCalculator();
        calculator.addPrice(10.2);
        calculator.addPrice(15.7);

        assertThat(calculator.getTotal(), is(25.9));
    }

    @Test
    public void apply_discount_to_prices() {
        PriceCalculator calculator = new PriceCalculator();
        calculator.addPrice(12.5);
        calculator.addPrice(17.5);

        calculator.setDiscount(25);

        assertThat(calculator.getTotal(), is(22.5));
    }
}