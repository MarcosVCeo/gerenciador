package br.com.marcos.gerenciador.servlet.acao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;

public class TelaLogin implements Executavel {

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
        return "foward:formLogin.jsp";
    }
}
