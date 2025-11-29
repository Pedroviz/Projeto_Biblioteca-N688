package dao;

import model.Livro;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LivroDAO {

    public static void inserir(Livro livro) throws SQLException {
        String sql = "INSERT INTO Livros (titulo, autor, ano_publicacao, quantidade_estoque) VALUES (?, ?, ?, ?)";
        try (Connection conn = Conexao.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, livro.getTitulo());
            ps.setString(2, livro.getAutor());
            ps.setInt(3, livro.getAnoPublicacao());
            ps.setInt(4, livro.getQuantidadeEstoque());
            ps.executeUpdate();
        }
    }

    public static List<Livro> listar() throws SQLException {
        List<Livro> lista = new ArrayList<>();
        String sql = "SELECT id_livro, titulo, autor, ano_publicacao, quantidade_estoque FROM Livros";
        try (Connection conn = Conexao.getConnection(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Livro l = new Livro(
                        rs.getInt("id_livro"),
                        rs.getString("titulo"),
                        rs.getString("autor"),
                        rs.getInt("ano_publicacao"),
                        rs.getInt("quantidade_estoque")
                );
                lista.add(l);
            }
        }
        return lista;
    }

    public static Livro buscarPorId(int id) throws SQLException {
        String sql = "SELECT id_livro, titulo, autor, ano_publicacao, quantidade_estoque FROM Livros WHERE id_livro = ?";
        try (Connection conn = Conexao.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Livro(
                            rs.getInt("id_livro"),
                            rs.getString("titulo"),
                            rs.getString("autor"),
                            rs.getInt("ano_publicacao"),
                            rs.getInt("quantidade_estoque")
                    );
                }
            }
        }
        return null;
    }

    public static void atualizarEstoque(int idLivro, int delta) throws SQLException {
        String sql = "UPDATE Livros SET quantidade_estoque = quantidade_estoque + ? WHERE id_livro = ?";
        try (Connection conn = Conexao.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, delta);
            ps.setInt(2, idLivro);
            ps.executeUpdate();
        }
    }
}
