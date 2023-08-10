package app;

import domain.ComplexNumber;
import services.ComplexNumberCalculatorImpl;
import utils.Logger;

public class Main {

    public static void main(String[] args) {
        Logger logger = new Logger();
        ComplexNumberCalculatorImpl calculator = new ComplexNumberCalculatorImpl(logger);

        ComplexNumber num1 = new ComplexNumber(1, 2);
        ComplexNumber num2 = new ComplexNumber(5, 7);

        ComplexNumber resultAdd = calculator.add(num1, num2);
        System.out.println("Сложение: (" + num1.getReal() + " + " + num1.getImaginary() + "i) + (" +
                num2.getReal() + " + " + num2.getImaginary() + "i) = " +
                resultAdd.getReal() + " + " + resultAdd.getImaginary() + "i");

        ComplexNumber resultMul = calculator.multiply(num1, num2);
        System.out.println("Умножение: (" + num1.getReal() + " + " + num1.getImaginary() + "i) * (" +
                num2.getReal() + " + " + num2.getImaginary() + "i) = " +
                resultMul.getReal() + " + " + resultMul.getImaginary() + "i");

        ComplexNumber resultDiv = calculator.divide(num1, num2);
        System.out.println("Деление: (" + num1.getReal() + " + " + num1.getImaginary() + "i) / (" +
                num2.getReal() + " + " + num2.getImaginary() + "i) = " +
                resultDiv.getReal() + " + " + resultDiv.getImaginary() + "i");
    }
}
