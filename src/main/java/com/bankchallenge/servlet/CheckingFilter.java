package com.bankchallenge.servlet;

import javax.servlet.*;
import java.io.IOException;

public class CheckingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        System.out.println("MonitoramentoFilter");

        long antes = System.currentTimeMillis();

        String acao = request.getParameter("acao");

        //executa a ação
        chain.doFilter(request, response);

        long depois = System.currentTimeMillis();

        System.out.println("Tempo de Execução da ação " + acao + " -> " +(depois - antes));

    }
}
