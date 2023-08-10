package interfaces;

import domain.ComplexNumber;

@FunctionalInterface
public interface BinaryOperation {
    ComplexNumber apply(ComplexNumber num1, ComplexNumber num2);
}
