package com.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// Defines a servlet named "HelloWorldServlet" mapped to the URL pattern "/hello"
@WebServlet("/hello")
public class HelloWorldServlet extends HttpServlet {

    // Overrides the doGet method to handle GET requests
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set the content type of the response
        response.setContentType("text/html");

        // Get the writer to write the response body
        response.getWriter().println("<h1>Hello, World!</h1>");
        response.getWriter().println("<p>This is a simple Java web application deployed on Tomcat.</p>");
    }
}
