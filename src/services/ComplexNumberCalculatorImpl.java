package services;

import domain.ComplexNumber;
import interfaces.BinaryOperation;
import interfaces.Calculator;
import utils.Logger;

public class ComplexNumberCalculatorImpl implements Calculator {
    private final Logger logger;

    public ComplexNumberCalculatorImpl(Logger logger) {
        this.logger = logger;
    }

    @Override
    public ComplexNumber add(ComplexNumber num1, ComplexNumber num2) {
        logger.log("Сложение комплексных чисел");
        return performOperation(num1, num2,
                (a, b) -> new ComplexNumber(a.getReal() + b.getReal(), a.getImaginary() + b.getImaginary()));
    }

    @Override
    public ComplexNumber multiply(ComplexNumber num1, ComplexNumber num2) {
        logger.log("Умножение комплексных числа");
        return performOperation(num1, num2,
                (a, b) -> new ComplexNumber(
                        a.getReal() * b.getReal() - a.getImaginary() * b.getImaginary(),
                        a.getReal() * b.getImaginary() + a.getImaginary() * b.getReal()
                ));
    }

    @Override
    public ComplexNumber divide(ComplexNumber num1, ComplexNumber num2) {
        logger.log("Деление комплексных чисел");
        double denominator = num2.getReal() * num2.getReal() + num2.getImaginary() * num2.getImaginary();
        return performOperation(num1, num2,
                (a, b) -> new ComplexNumber(
                        (a.getReal() * b.getReal() + a.getImaginary() * b.getImaginary()) / denominator,
                        (a.getImaginary() * b.getReal() - a.getReal() * b.getImaginary()) / denominator
                ));
    }

    private ComplexNumber performOperation(ComplexNumber num1, ComplexNumber num2, BinaryOperation operation) {
        return operation.apply(num1, num2);
    }
}
