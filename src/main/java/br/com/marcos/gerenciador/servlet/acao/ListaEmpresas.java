package br.com.marcos.gerenciador.servlet.acao;

import br.com.marcos.gerenciador.servlet.modelo.Banco;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ListaEmpresas implements Executavel {

    private Banco banco = new Banco();

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("empresas", banco.getEmpresas());
        return "foward:listaEmpresas.jsp";
    }
}

