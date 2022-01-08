package com.bankchallenge.controller;

import com.bankchallenge.model.Banco;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RemoveUser implements Action{

    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("Removendo Empresa");

        String paramId = request.getParameter("id");
        Integer id = Integer.valueOf(paramId);

        System.out.println(id);

        Banco banco = new Banco();
        banco.removeUser(id);

        return "redirect:entry?acao=UserList";

    }
}
