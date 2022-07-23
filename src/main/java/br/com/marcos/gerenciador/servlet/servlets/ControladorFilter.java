package br.com.marcos.gerenciador.servlet.servlets;

import br.com.marcos.gerenciador.servlet.acao.Executavel;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(filterName = "EntradaFilter")
public class ControladorFilter implements Filter {

    private static String PACKAGE_SERVLETS = "br.com.marcos.gerenciador.servlet.acao.";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) {
        try {
            var httpRequest = (HttpServletRequest) request;

            var httpResponse = (HttpServletResponse) response;

            var paramAcao = request.getParameter("acao");

            var classe = (Executavel) Class.forName(PACKAGE_SERVLETS + paramAcao).newInstance();

            var endereco = classe.executar(httpRequest, httpResponse);

            var tipoEndereco = endereco.split(":");

            if (tipoEndereco[0].equals("foward")) {

                var requestDispactcher = request.getRequestDispatcher("WEB-INF/view/" + tipoEndereco[1]);
                requestDispactcher.forward(request, response);
            } else {

                httpResponse.sendRedirect(tipoEndereco[1]);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
