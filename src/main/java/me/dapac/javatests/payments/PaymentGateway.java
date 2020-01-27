package me.dapac.javatests.payments;

public interface PaymentGateway {

    PaymentResponse requestPayment(PaymentRequest request);
}
