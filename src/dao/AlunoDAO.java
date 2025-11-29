package dao;

import model.Aluno;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {

    public static void inserir(Aluno aluno) throws SQLException {
        String sql = "INSERT INTO Alunos (nome_aluno, matricula, data_nascimento) VALUES (?, ?, ?)";
        try (Connection conn = Conexao.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, aluno.getNome());
            ps.setString(2, aluno.getMatricula());
            ps.setDate(3, Date.valueOf(aluno.getDataNascimento()));
            ps.executeUpdate();
        }
    }

    public static List<Aluno> listar() throws SQLException {
        List<Aluno> lista = new ArrayList<>();
        String sql = "SELECT id_aluno, nome_aluno, matricula, data_nascimento FROM Alunos";
        try (Connection conn = Conexao.getConnection(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Aluno a = new Aluno(
                        rs.getInt("id_aluno"),
                        rs.getString("nome_aluno"),
                        rs.getString("matricula"),
                        rs.getDate("data_nascimento").toLocalDate()
                );
                lista.add(a);
            }
        }
        return lista;
    }

    public static Aluno buscarPorId(int id) throws SQLException {
        String sql = "SELECT id_aluno, nome_aluno, matricula, data_nascimento FROM Alunos WHERE id_aluno = ?";
        try (Connection conn = Conexao.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Aluno(
                            rs.getInt("id_aluno"),
                            rs.getString("nome_aluno"),
                            rs.getString("matricula"),
                            rs.getDate("data_nascimento").toLocalDate()
                    );
                }
            }
        }
        return null;
    }
}
