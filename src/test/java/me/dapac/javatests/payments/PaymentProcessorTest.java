package me.dapac.javatests.payments;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class PaymentProcessorTest {

    private PaymentGateway paymentGateway;
    private PaymentProcessor paymentProcessor;

    @Before
    public void setup() {
        paymentGateway = Mockito.mock(PaymentGateway.class);
        paymentProcessor = new PaymentProcessor(paymentGateway);
    }

    @Test
    public void payment_is_correct() {
        PaymentResponse response = new PaymentResponse(PaymentResponse.PaymentStatus.OK);
        Mockito.when(paymentGateway.requestPayment((PaymentRequest) Mockito.any())).thenReturn(response);

        assertTrue(paymentProcessor.makePayment(1000));
    }

    @Test
    public void payment_is_wrong() {
        PaymentResponse response = new PaymentResponse(PaymentResponse.PaymentStatus.ERROR);
        Mockito.when(paymentGateway.requestPayment((PaymentRequest) Mockito.any())).thenReturn(response);

        assertFalse(paymentProcessor.makePayment(1000));
    }

}