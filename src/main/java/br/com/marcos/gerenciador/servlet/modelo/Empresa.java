package br.com.marcos.gerenciador.servlet.modelo;

import java.util.Date;

public class Empresa {

    private Integer id;
    private String nome;
    private Date dataAbertura = new Date();
    private static int contadorId = 0;

    public Empresa(String nome, Date dataAbertura) {
        contadorId++;
        this.id = contadorId;
        this.nome = nome;
        this.dataAbertura = dataAbertura;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Empresa [id=" + id + ", nome=" + nome + "]";
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }
}
