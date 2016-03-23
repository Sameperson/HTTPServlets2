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

        try {
            Double operandOne = Double.parseDouble(this.operandOne);
            Double operandTwo = Double.parseDouble(this.operandTwo);

            if (operation.equals("add")) {
                return add(operandOne, operandTwo);
            } else if (operation.equals("multiply")) {
                return multiply(operandOne, operandTwo);
            } else if (operation.equals("subtract")) {
                return subtract(operandOne, operandTwo);
            } else if (operation.equals("divide")) {
                return divide(operandOne, operandTwo);
            }
        }
        catch (NumberFormatException e) {
            return Double.NaN;
        }

        return null;
    }

    private Double add(Double operandOne, Double operandTwo) {
        return operandOne + operandTwo;
    }

    private Double multiply(Double operandOne, Double operandTwo) {
        return operandOne * operandTwo;
    }

    private Double subtract(Double operandOne, Double operandTwo) {
        return operandOne - operandTwo;
    }

    private Double divide(Double operandOne, Double operandTwo) {
        return operandOne / operandTwo;
    }

}
