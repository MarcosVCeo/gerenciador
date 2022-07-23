package br.com.marcos.gerenciador.servlet.servlets;

import br.com.marcos.gerenciador.servlet.modelo.Banco;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/empresas")
public class EmpresasService extends HttpServlet {

    private Banco banco = new Banco();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var gson = new Gson();
        var empresasJson = gson.toJson(banco.getEmpresas());
        response.setContentType("application/json");

        var writer = response.getWriter();
        writer.write(empresasJson);
    }
}
