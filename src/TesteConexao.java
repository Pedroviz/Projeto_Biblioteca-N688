import dao.Conexao;
import java.sql.Connection;

public class TesteConexao {
    public static void main(String[] args) {
        try {
            Connection conn = Conexao.getConnection();
            System.out.println("Conexão estabelecida com sucesso!");
            conn.close();
        } catch (Exception e) {
            System.out.println("Erro na conexão: " + e.getMessage());
        }
    }
}
