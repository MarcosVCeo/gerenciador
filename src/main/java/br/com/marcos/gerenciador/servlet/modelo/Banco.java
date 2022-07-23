package br.com.marcos.gerenciador.servlet.modelo;

import java.io.FileNotFoundException;
import java.util.*;

public class Banco {

    private static List<Empresa> listaEmpresas = new LinkedList<>();
    private static List<Usuario> listaUsuarios = new LinkedList<>();

    public void adcionar(Empresa empresa) {
        listaEmpresas.add(empresa);
    }

    public List<Empresa> getEmpresas() {
        return Collections.unmodifiableList(listaEmpresas);
    }

    static {
        listaEmpresas.addAll(Arrays.asList(
                new Empresa("Google", new Date()),
                new Empresa("Alura", new Date())));

        listaUsuarios.addAll(Arrays.asList(
                new Usuario("Marcos", "123")));
    }

    public void remover(Empresa empresa) throws FileNotFoundException {
        if (listaEmpresas.removeIf(emp -> emp.getId().equals(empresa.getId()))) {
            throw new FileNotFoundException("A empresa com  " + empresa + " não foi encontrada");
        }
    }

    public void remover(Integer id) throws FileNotFoundException {
        if (!listaEmpresas.removeIf(empresa -> empresa.getId().equals(id))) {
            throw new FileNotFoundException("A empresa com ID: " + id + " não foi encontrada");
        }
    }

    public Empresa getEmpresa(int id) throws FileNotFoundException {
        var empresa = listaEmpresas.stream().filter(emp
                -> emp.getId().equals(id)).findFirst();

        return empresa.orElseThrow(()
                -> new FileNotFoundException("A empresa com ID: " + id + " não foi encontrada"));
    }

    public void atualizar(int id, String nome) throws FileNotFoundException {
        var empresa = this.getEmpresa(id);
        empresa.setNome(nome);
    }

    public Optional<Usuario> existeUsuario(String login, String senha) {
        return listaUsuarios.stream()
                .filter(usuario -> usuario.ehIgual(login, senha))
                .findFirst();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
