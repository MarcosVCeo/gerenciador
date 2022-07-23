package br.com.marcos.gerenciador.servlet.servlets;

import br.com.marcos.gerenciador.servlet.modelo.Banco;
import com.thoughtworks.xstream.XStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EmpresasServiceXML", value = "/EmpresasServiceXML")
public class EmpresasServiceXML extends HttpServlet {

    private Banco banco = new Banco();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var xStream = new XStream();
        response.setContentType("application/xml");
        var empresasXML = xStream.toXML(banco.getEmpresas());

        var writer = response.getWriter();
        writer.write(empresasXML);
    }
}
