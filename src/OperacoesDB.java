import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OperacoesDB {

    // O atributo a seguir recebe a instância de painelLista na instância de MyFrame em Main.

    private static final TelaLista painelLista = Main.getMyFrame().getPainelLista();

    /* Tendo o acesso ao painelLista, o atributo a seguir acessa o modelo da tabela desse painel para a inserção dos
    dados via queries sql nesta classe. */

    private static final DefaultTableModel modeloTbl = painelLista.getModeloTbl();



    //MÉTODOS ESTÁTICOS:

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

    public static void listaProdutos() {

        String sql = "SELECT * FROM produto";

        try (Connection conn = ConectaDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {

                //Modelo que realiza as operações na tabela:

                modeloTbl.addRow(new Object[]{rs.getString("nome"),rs.getLong("codigoBarras"),
                        rs.getString("tamanho"),rs.getFloat("preco"),
                        rs.getInt("quantidade")});

            }

            System.out.println("Listagem de produtos realizada com sucesso.");
        }

        catch (SQLException e) {
            System.err.println(STR."Erro ao listar os produtos: \{e.getMessage()}");
        }

    }
}





