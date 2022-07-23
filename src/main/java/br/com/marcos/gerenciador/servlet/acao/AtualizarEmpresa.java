package br.com.marcos.gerenciador.servlet.acao;

import br.com.marcos.gerenciador.servlet.modelo.Banco;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AtualizarEmpresa implements Executavel {

    private Banco banco = new Banco();

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var novoNome = request.getParameter("nomeAtualizadoEmpresa");
        var id = Integer.parseInt(request.getParameter("id"));

        banco.atualizar(id, novoNome);
        return "redirect:entrada?acao=ListaEmpresas";
    }
}
