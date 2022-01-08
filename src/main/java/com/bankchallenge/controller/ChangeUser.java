package com.bankchallenge.controller;

import com.bankchallenge.model.Banco;
import com.bankchallenge.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ChangeUser implements Action{

    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userName = request.getParameter("name");
        String userEmail = request.getParameter("senha");
        String userPassword = request.getParameter("password");
        String paramId = request.getParameter("id");
        Integer id = Integer.valueOf(paramId);



//        Date dataAbertura = null;
//
//        try {
//            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
//            dataAbertura = sdf.parse(dataEmpresa);
//        } catch (ParseException e) {
//            throw new ServletException(e);
//        }

        Banco banco = new Banco();
        User user = banco.buscaUsuarioPeloId(id);
        user.setName(userName);
        user.setEmail(userEmail);
        user.setPassword(userPassword);

        return "redirect:entrada?acao=ListaEmpresas";

    }
}
