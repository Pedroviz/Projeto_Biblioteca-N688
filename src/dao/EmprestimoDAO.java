package dao;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.Emprestimo;

public class EmprestimoDAO {

    public static void registrarEmprestimo(int idAluno, int idLivro) throws SQLException {
        try (Connection conn = Conexao.getConnection()) {
            conn.setAutoCommit(false);
            try {
                // verifica estoque
                String verificar = "SELECT quantidade_estoque FROM Livros WHERE id_livro = ? FOR UPDATE";
                try (PreparedStatement ps = conn.prepareStatement(verificar)) {
                    ps.setInt(1, idLivro);
                    try (ResultSet rs = ps.executeQuery()) {
                        if (!rs.next() || rs.getInt("quantidade_estoque") <= 0) {
                            conn.rollback();
                            throw new SQLException("Livro sem estoque disponível.");
                        }
                    }
                }

                // atualiza estoque
                String atualizar = "UPDATE Livros SET quantidade_estoque = quantidade_estoque - 1 WHERE id_livro = ?";
                try (PreparedStatement ps = conn.prepareStatement(atualizar)) {
                    ps.setInt(1, idLivro);
                    ps.executeUpdate();
                }

                // insere emprestimo (7 dias padrão)
                String inserir = "INSERT INTO Emprestimos (id_aluno, id_livro, data_devolucao) VALUES (?, ?, ?)";
                try (PreparedStatement ps = conn.prepareStatement(inserir)) {
                    ps.setInt(1, idAluno);
                    ps.setInt(2, idLivro);
                    ps.setDate(3, Date.valueOf(LocalDate.now().plusDays(7)));
                    ps.executeUpdate();
                }

                conn.commit();
            } catch (SQLException ex) {
                conn.rollback();
                throw ex;
            } finally {
                conn.setAutoCommit(true);
            }
        }
    }

    public static void registrarDevolucao(int idEmprestimo) throws SQLException {
        try (Connection conn = Conexao.getConnection()) {
            conn.setAutoCommit(false);
            try {
                // obtém emprestimo
                String sel = "SELECT id_livro FROM Emprestimos WHERE id_emprestimo = ?";
                int idLivro = -1;
                try (PreparedStatement ps = conn.prepareStatement(sel)) {
                    ps.setInt(1, idEmprestimo);
                    try (ResultSet rs = ps.executeQuery()) {
                        if (rs.next()) {
                            idLivro = rs.getInt("id_livro");
                        } else {
                            conn.rollback();
                            throw new SQLException("Empréstimo não encontrado.");
                        }
                    }
                }

                // remove registro de empréstimo (opcional: manter histórico)
                String del = "DELETE FROM Emprestimos WHERE id_emprestimo = ?";
                try (PreparedStatement ps = conn.prepareStatement(del)) {
                    ps.setInt(1, idEmprestimo);
                    ps.executeUpdate();
                }

                // atualiza estoque +1
                String upd = "UPDATE Livros SET quantidade_estoque = quantidade_estoque + 1 WHERE id_livro = ?";
                try (PreparedStatement ps = conn.prepareStatement(upd)) {
                    ps.setInt(1, idLivro);
                    ps.executeUpdate();
                }

                conn.commit();
            } catch (SQLException ex) {
                conn.rollback();
                throw ex;
            } finally {
                conn.setAutoCommit(true);
            }
        }
    }

    public static List<Emprestimo> listar() throws SQLException {
        List<Emprestimo> lista = new ArrayList<>();
        String sql = "SELECT id_emprestimo, id_aluno, id_livro, data_emprestimo, data_devolucao FROM Emprestimos";
        try (Connection conn = Conexao.getConnection(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Emprestimo e = new Emprestimo();
                e.setId(rs.getInt("id_emprestimo"));
                e.setIdAluno(rs.getInt("id_aluno"));
                e.setIdLivro(rs.getInt("id_livro"));
                Date de = rs.getDate("data_emprestimo");
                if (de != null) e.setDataEmprestimo(de.toLocalDate());
                Date dd = rs.getDate("data_devolucao");
                if (dd != null) e.setDataDevolucao(dd.toLocalDate());
                lista.add(e);
            }
        }
        return lista;
    }
}
