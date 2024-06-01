import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OperacoesDB {

    private static TelaLista TelaLista;

    public static void registraProduto(Produto produto){




        try {

            Connection conn = ConectaDB.getConnection();
            String sql = "INSERT INTO produto (nome, tamanho, quantidade, preco, codigoBarras) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement pstmt = conn.prepareStatement(sql);{

                pstmt.setString(1, produto.getNome());
                pstmt.setString(2, produto.getTamanho());
                pstmt.setInt(3, produto.getQuantidade());
                pstmt.setFloat(4, produto.getPreco());
                pstmt.setString(5, produto.getcodigoBarras());
                pstmt.executeUpdate();

            }

            System.out.println("Registro de produto realizado com sucesso.");

        }

        catch (SQLException e) {
            System.err.println(STR."Erro ao registar o produto. \{e.getMessage()}");
        }
    }
}

