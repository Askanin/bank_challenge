package com.bankchallenge.controller;

import com.bankchallenge.model.Banco;
import com.bankchallenge.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UserList implements Action{

    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("Listando Empresas");

        Banco banco = new Banco();
        List<User> list = banco.getUsers();

        request.setAttribute("users", list);

        return "forward:userList.jsp";
    }
}
