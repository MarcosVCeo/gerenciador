package br.com.marcos.gerenciador.servlet.acao;

import br.com.marcos.gerenciador.servlet.modelo.Banco;
import br.com.marcos.gerenciador.servlet.modelo.Empresa;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class NovaEmpresa implements Executavel {

    private Banco banco = new Banco();

    private static SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
        var nomeEmpresa = request.getParameter("nomeNovaEmpresa");
        var dataAbertura = SDF.parse(request.getParameter("dataAbertura"));

        banco.adcionar(new Empresa(nomeEmpresa, dataAbertura));
        return "redirect:entrada?acao=ListaEmpresas";
    }
}
