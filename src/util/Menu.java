package util;

import dao.AlunoDAO;
import dao.EmprestimoDAO;
import dao.LivroDAO;
import model.Aluno;
import model.Livro;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private final Scanner sc = new Scanner(System.in);

    public void iniciar() {
        while (true) {
            System.out.println("\n=== Biblioteca - Menu Principal ===");
            System.out.println("1) Cadastrar Aluno");
            System.out.println("2) Listar Alunos");
            System.out.println("3) Cadastrar Livro");
            System.out.println("4) Listar Livros");
            System.out.println("5) Registrar Empréstimo");
            System.out.println("6) Registrar Devolução");
            System.out.println("7) Listar Empréstimos");
            System.out.println("0) Sair");
            System.out.print("Escolha: ");
            String op = sc.nextLine();
            try {
                switch (op) {
                    case "1": cadastrarAluno(); break;
                    case "2": listarAlunos(); break;
                    case "3": cadastrarLivro(); break;
                    case "4": listarLivros(); break;
                    case "5": registrarEmprestimo(); break;
                    case "6": registrarDevolucao(); break;
                    case "7": listarEmprestimos(); break;
                    case "0": System.out.println("Saindo..."); return;
                    default: System.out.println("Opção inválida.");
                }
            } catch (SQLException ex) {
                System.out.println("Erro de banco: " + ex.getMessage());
            } catch (Exception ex) {
                System.out.println("Erro: " + ex.getMessage());
            }
        }
    }

    private void cadastrarAluno() throws SQLException {
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Matrícula: ");
        String mat = sc.nextLine();
        System.out.print("Data nascimento (YYYY-MM-DD): ");
        LocalDate dt = LocalDate.parse(sc.nextLine());
        Aluno a = new Aluno(nome, mat, dt);
        AlunoDAO.inserir(a);
        System.out.println("Aluno cadastrado com sucesso.");
    }

    private void listarAlunos() throws SQLException {
        List<Aluno> lista = AlunoDAO.listar();
        System.out.println("-- Alunos --");
        lista.forEach(System.out::println);
    }

    private void cadastrarLivro() throws SQLException {
        System.out.print("Título: ");
        String titulo = sc.nextLine();
        System.out.print("Autor: ");
        String autor = sc.nextLine();
        System.out.print("Ano publicação: ");
        int ano = Integer.parseInt(sc.nextLine());
        System.out.print("Quantidade estoque: ");
        int q = Integer.parseInt(sc.nextLine());
        Livro l = new Livro(titulo, autor, ano, q);
        LivroDAO.inserir(l);
        System.out.println("Livro cadastrado.");
    }

    private void listarLivros() throws SQLException {
        List<Livro> lista = LivroDAO.listar();
        System.out.println("-- Livros --");
        lista.forEach(System.out::println);
    }

    private void registrarEmprestimo() throws SQLException {
        System.out.print("ID Aluno: ");
        int idAluno = Integer.parseInt(sc.nextLine());
        System.out.print("ID Livro: ");
        int idLivro = Integer.parseInt(sc.nextLine());
        EmprestimoDAO.registrarEmprestimo(idAluno, idLivro);
        System.out.println("Empréstimo registrado.");
    }

    private void registrarDevolucao() throws SQLException {
        System.out.print("ID Empréstimo: ");
        int idEmp = Integer.parseInt(sc.nextLine());
        EmprestimoDAO.registrarDevolucao(idEmp);
        System.out.println("Devolução processada.");
    }

    private void listarEmprestimos() throws SQLException {
        var lista = EmprestimoDAO.listar();
        System.out.println("-- Empréstimos --");
        lista.forEach(System.out::println);
    }
}
