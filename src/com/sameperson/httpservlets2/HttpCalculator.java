package com.sameperson.httpservlets2;

public class HttpCalculator {

    private String operation;
    private String operandOne;
    private String operandTwo;

    public HttpCalculator(String operation, String operandOne, String operandTwo) {
        this.operation = operation;
        this.operandOne = operandOne;
        this.operandTwo = operandTwo;
    }

    public Double calculate() {
        double operandOne = Double.parseDouble(this.operandOne);
        double operandTwo = Double.parseDouble(this.operandTwo);

        if (operation.equals("add")) {
                return add(operandOne, operandTwo);
        } else if (operation.equals("multiply")) {
                return multiply(operandOne, operandTwo);
        } else if (operation.equals("subtract")) {
                return subtract(operandOne, operandTwo);
        } else if (operation.equals("divide")) {
                return divide(operandOne, operandTwo);
        }
        return 0.0;
    }

    private double add(double operandOne, double operandTwo) {
        return operandOne + operandTwo;
    }

    private double multiply(double operandOne, double operandTwo) {
        return operandOne * operandTwo;
    }

    private double subtract(double operandOne, double operandTwo) {
        return operandOne - operandTwo;
    }

    private double divide(double operandOne, double operandTwo) {
        return operandOne / operandTwo;
    }

}
