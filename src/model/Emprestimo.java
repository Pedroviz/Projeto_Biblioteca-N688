package model;

import java.time.LocalDate;

public class Emprestimo {
    private int id;
    private int idAluno;
    private int idLivro;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;

    public Emprestimo() {}

    public Emprestimo(int id, int idAluno, int idLivro, LocalDate dataEmprestimo, LocalDate dataDevolucao) {
        this.id = id;
        this.idAluno = idAluno;
        this.idLivro = idLivro;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getIdAluno() { return idAluno; }
    public void setIdAluno(int idAluno) { this.idAluno = idAluno; }
    public int getIdLivro() { return idLivro; }
    public void setIdLivro(int idLivro) { this.idLivro = idLivro; }
    public LocalDate getDataEmprestimo() { return dataEmprestimo; }
    public void setDataEmprestimo(LocalDate dataEmprestimo) { this.dataEmprestimo = dataEmprestimo; }
    public LocalDate getDataDevolucao() { return dataDevolucao; }
    public void setDataDevolucao(LocalDate dataDevolucao) { this.dataDevolucao = dataDevolucao; }

    @Override
    public String toString() {
        return String.format("Emprestimo[id=%d, aluno=%d, livro=%d, emprestimo=%s, devolucao=%s]",
                id, idAluno, idLivro, dataEmprestimo, dataDevolucao);
    }
}
