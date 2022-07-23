package br.com.marcos.gerenciador.servlet.servlets;

import javax.servlet.*;
import java.io.IOException;

public class MonitoramentoFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Filtro monitoramento");

        var acao = servletRequest.getParameter("acao");
        var antes = System.currentTimeMillis();
        filterChain.doFilter(servletRequest, servletResponse);

        var depois = System.currentTimeMillis();
        System.out.println(acao + ": " + (depois - antes));

    }
}
