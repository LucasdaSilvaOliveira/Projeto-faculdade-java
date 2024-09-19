package entity;



import jakarta.json.bind.annotation.JsonbProperty;

import org.glassfish.jersey.server.JSONP;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import jakarta.persistence.Column;

public class Aluno {

    // @Column(name = "Id")
    public int id;

    // @Column(name = "Nome")
    public String nome;

    // @Column(name = "Idade")
    public int idade;

    // @Column(name = "diaPagamento")
    public int diaPagamento;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getDiaPagamento() {
        return diaPagamento;
    }

    public void setDiaPagamento(int diaPagamento) {
        this.diaPagamento = diaPagamento;
    }
}
