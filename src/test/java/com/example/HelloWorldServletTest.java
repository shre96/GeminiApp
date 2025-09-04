package com.example;

import org.junit.Test;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.StringWriter;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class HelloWorldServletTest {

    @Test
    public void testDoGet() throws Exception {
        // Mock the HttpServletRequest and HttpServletResponse objects
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        // Use a StringWriter to capture the output of the response
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);

        // When the response's getWriter() method is called, return our mock writer
        when(response.getWriter()).thenReturn(writer);

        // Create an instance of the servlet and call the doGet method
        new HelloWorldServlet().doGet(request, response);

        // Verify that the response's content type was set correctly
        verify(response).setContentType("text/html");

        // Flush the writer to ensure all content is written to the StringWriter
        writer.flush();

        // Assert that the output contains the expected "Hello, World!" text
        assertTrue(stringWriter.toString().contains("<h1>Hello, World!</h1>"));
    }
}
