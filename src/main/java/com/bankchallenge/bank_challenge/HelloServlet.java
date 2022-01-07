package com.bankchallenge.bank_challenge;

import com.bankchallenge.model.User;
import com.bankchallenge.repository.BankChallengeRepository;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        User user = new User();
        user.setName("Javão");
        user.setEmail("euodeioeclipse@gmail.com");
        user.setPassword("int3ll1j");
//        user.setPhones("21666-7070");

        BankChallengeRepository.saveUser(user);

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}