package com.bankchallenge.servlet;

import com.bankchallenge.controller.Action;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ControllerFilter implements Filter {

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {

        System.out.println("ControladorFilter ");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String paramAcao = request.getParameter("acao");
        String nomeDaClasse = "com.bankchallenge.bank_challenge.controller" + paramAcao;

        String nome;
        try {
            Class classe = Class.forName(nomeDaClasse); //Carrega a classe com o nome
            Action acao= (Action) classe.newInstance();
            nome = acao.execute(request, response);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ServletException
                | IOException e) {
            throw new ServletException(e);
        }

        String[] tipoEndereco = nome.split(":");
        if(tipoEndereco[0].equals("forward")) {
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + tipoEndereco[1]);
            rd.forward(request, response);
        } else {
            response.sendRedirect(tipoEndereco[1]);
        }
    }
}
