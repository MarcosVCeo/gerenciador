package br.com.marcos.gerenciador.servlet.servlets;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AutorizacaoFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        var httpRequest = (HttpServletRequest) request;

        var session = httpRequest.getSession();

        var paramAcao = request.getParameter("acao");

        var isLogado = session.getAttribute("usuarioLogado") != null;

        var isAcaoDesprotegida = !(paramAcao.equals("TelaLogin") || paramAcao.equals("VerificarLogin"));

        if (!isLogado && isAcaoDesprotegida) {
            var httpResponse = (HttpServletResponse) response;
            httpResponse.sendRedirect("entrada?acao=TelaLogin");
            return;
        }
        chain.doFilter(request, response);
    }
}
