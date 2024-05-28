import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OperacoesDB {


    public static void registraProduto(Produto produto){

        String sql = "INSERT INTO produto (nome, tamanho, quantidade, preco, descricao) VALUES (?, ?, ?, ?, ?)";

        try(Connection con = ConectaDB.getConnection()) {

            PreparedStatement stmt = con.prepareStatement(sql);{

                stmt.setString(1, produto.getNome());
                stmt.setString(2, produto.getTamanho());
                stmt.setInt(3, produto.getQuantidade());
                stmt.setFloat(4, produto.getPreco());
                stmt.setString(5, produto.getDescricao());
                stmt.executeUpdate();
            }

        }

        catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
