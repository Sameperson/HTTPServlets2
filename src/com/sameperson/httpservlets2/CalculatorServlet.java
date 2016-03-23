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

    private volatile PrintWriter writer;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        writer = resp.getWriter();

        if (req.getParameterMap().containsKey("operation") &&
                req.getParameterMap().containsKey("operand1")&&
                req.getParameterMap().containsKey("operand2"))
        {
            Double result = new HttpCalculator(
                    req.getParameter("operation"),
                    req.getParameter("operand1"),
                    req.getParameter("operand2")
            ).calculate();

            if(result!=null) {
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
}
