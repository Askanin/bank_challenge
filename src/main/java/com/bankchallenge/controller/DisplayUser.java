package com.bankchallenge.controller;

import com.bankchallenge.model.Banco;
import com.bankchallenge.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DisplayUser implements Action{

    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String paramId = request.getParameter("id");
        Integer id = Integer.valueOf(paramId);

        Banco banco = new Banco();

        User user = banco.buscaUsuarioPeloId(id);

        System.out.println(user.getName());

        request.setAttribute("user", user);

        return "forward:formChangeUser.jsp";


    }

}
