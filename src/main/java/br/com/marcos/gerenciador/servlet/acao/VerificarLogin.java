package br.com.marcos.gerenciador.servlet.acao;

import br.com.marcos.gerenciador.servlet.modelo.Banco;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;

public class VerificarLogin implements Executavel {

    private Banco banco = new Banco();

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
        var login = request.getParameter("login");
        var senha = request.getParameter("senha");

        var usuario = banco.existeUsuario(login, senha);

        if (usuario.isPresent()) {
            var session = request.getSession();
            session.setAttribute("usuarioLogado", usuario.get());
            return "redirect:entrada?acao=ListaEmpresas";
        } else {
            return "redirect:entrada?acao=TelaLogin";
        }
    }
}
