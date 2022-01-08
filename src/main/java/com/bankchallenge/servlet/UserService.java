package com.bankchallenge.servlet;

import com.bankchallenge.model.Banco;
import com.bankchallenge.model.User;
import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/users")
public class UserService extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<User> users = new Banco().getUsers();

        String valor = request.getHeader("Accept");

        System.out.println(valor);

        if (valor.contains("xml")) {
            XStream xstream = new XStream();
            xstream.alias("user", User.class);
            String xml = xstream.toXML(users);

            response.setContentType("application/xml");
            response.getWriter().print(xml);
        } else if (valor.endsWith("json")) {
            Gson gson = new Gson();
            String json = gson.toJson(users);

            response.setContentType("application/json");
            response.getWriter().print(json);
        } else {
            response.setContentType("application/json");
            response.getWriter().print("{'message':'no content'}");
        }
    }
}
