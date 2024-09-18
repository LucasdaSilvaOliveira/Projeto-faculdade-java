package entity;

public class Aluno {
    public int Id;

    public String Nome;

    public int Idade;

    public int DiaPagamento;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public int getIdade() {
        return Idade;
    }

    public void setIdade(int idade) {
        Idade = idade;
    }

    public int getDiaPagamento() {
        return DiaPagamento;
    }

    public void setDiaPagamento(int diaPagamento) {
        DiaPagamento = diaPagamento;
    }
}
