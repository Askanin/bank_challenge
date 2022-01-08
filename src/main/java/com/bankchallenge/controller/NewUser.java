package com.bankchallenge.controller;

import com.bankchallenge.model.Banco;
import com.bankchallenge.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class NewUser implements Action{

    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("Cadastrando nova empresa.");

        String userName = request.getParameter("name");
        String userEmail = request.getParameter("senha");
        String userPassword = request.getParameter("password");

        User user = new User();
        user.setName(userName);
        user.setEmail(userEmail);
        user.setPassword(userPassword);


        Banco banco = new Banco();
        banco.adiciona(user);

        request.setAttribute("user", user.getName());

        return "redirect:entry?acao=UserList";

    }
}
