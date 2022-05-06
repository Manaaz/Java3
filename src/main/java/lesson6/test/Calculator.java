package lesson6.test;

public class Calculator {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        System.out.println(calculator.add(-3, 5) == -2);
    }

    public Calculator() {
        System.out.println("Калькулятор создан");
    }

    public int add(int a, int b) {
        System.out.println("Выполняется сложение");
        return a + b;
    }

    public int div(int a, int b) {
        System.out.println("Выполняется деление");

        return a / b;
    }



}
