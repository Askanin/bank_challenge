package com.bankchallenge.servlet;

import com.bankchallenge.controller.Action;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/entry")
public class EntryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String paramAcao = request.getParameter("acao");

//		HttpSession sessao = request.getSession();
//		boolean usuarioNaoEstaLogado = (sessao.getAttribute("usuarioLogado") == null);
//		boolean ehUmaAcaoProtegida = !(paramAcao.equals("Login") || paramAcao.equals("LoginForm"));
//
//		if(ehUmaAcaoProtegida && usuarioNaoEstaLogado) {
//			response.sendRedirect("entrada?acao=LoginForm");
//			return;
//		}



        String nomeDaClasse = "com.bankchallenge.bank_challenge.controller" + paramAcao;

        String nome;
        try {
            Class classe = Class.forName(nomeDaClasse); //Carrega a classe com o nome
            Action action = (Action) classe.newInstance();
            nome = action.execute(request, response);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ServletException
                | IOException e) {
            throw new ServletException(e);
        }

        String[] tipoEndereco = nome.split(":");
        if(tipoEndereco[0].equals("forward")) {
            RequestDispatcher rd = request.getRequestDispatcher("webapp/view/" + tipoEndereco[1]);
            rd.forward(request, response);
        } else {
            response.sendRedirect(tipoEndereco[1]);
        }

    }
}
