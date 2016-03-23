package com.sameperson.httpservlets2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/calculate")
public class CalculatorServlet extends HttpServlet {

    private String operation;
    private String operand1;
    private String operand2;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter writer = resp.getWriter();

        if (req.getParameterMap().containsKey("operation") &&
                req.getParameterMap().containsKey("operand1")&&
                req.getParameterMap().containsKey("operand2"))
        {
            operation = req.getParameter("operation");
            operand1 = req.getParameter("operand1");
            operand2 = req.getParameter("operand2");

            if(isOperation(operation) && isNumber(operand1) && isNumber(operand2)) {
                Double result = new HttpCalculator(operation, operand1, operand2).calculate();
                writer.print("The result is: " + result);
            }
            else {
                writer.print("Illegal arguments!");
            }
        }

        else {
            writer.print("Please post your parameters using 'calculate?operation=add&operand1=5&operand2=10' pattern. " +
                    "You can use 'add', 'subtract', 'multiply' and 'divide' operators");
        }

        writer.flush();

    }

    private boolean isNumber(String str)
    {
        try
        {
            double d = Double.parseDouble(str);
        }
        catch(NumberFormatException nfe)
        {
            return false;
        }
        return true;
    }

    private boolean isOperation(String operator) {
        if(operator.equals("add") || operator.equals("subtract") || operator.equals("multiply") || operator.equals("divide")) {
            return true;
        }
        return false;
    }
}
