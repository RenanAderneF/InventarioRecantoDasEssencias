package db;
import main.Main;
import main.Produto;
import inferface_grafica.TelaLista;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Classe contendo métodos estáticos para realização das operações com banco de dados. Realiza operações CRUD utilizando
 * consultas SQL, como registro, listagem dos itens, edição e remoção dos produtos no banco.
 */

public class OperacoesDB {

    // O atributo a seguir recebe a instância de painelLista na instância de MyFrame em Main.

    private static final TelaLista painelLista = Main.getMyFrame().getPainelLista();
    private static final DefaultTableModel modelo = painelLista.getMdlPersonalizado();

    /* Tendo o acesso ao painelLista, o atributo a seguir acessa o modelo da tabela desse painel para a inserção dos
    dados via queries sql nesta classe. */

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

                if (modelo.getRowCount() == 0) { //Se tabela vazia, puxar os dados.

                    modelo.addRow(new Object[]{rs.getInt("id"), rs.getString("nome"),
                        rs.getLong("codigoBarras"),
                        rs.getString("tamanho"),rs.getFloat("preco"),
                        rs.getInt("quantidade")});

                }


            }

            System.out.println("Listagem de produtos realizada com sucesso.");

        }

        catch (SQLException e) {
            System.err.println(STR."Erro ao listar os produtos: \{e.getMessage()}");
        }

    }

    public static void editaProduto(int id, String nome, String codigoBarras, String tamanho, float preco, int quantidade) {

       String sql = "UPDATE produto SET nome = ?, codigoBarras = ?, tamanho = ?, preco = ?, quantidade = ? " +
               "WHERE id = ?";

       try (Connection conn = ConectaDB.getConnection();

            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nome);
            pstmt.setString(2, codigoBarras);
            pstmt.setString(3, tamanho);
            pstmt.setFloat(4, preco);
            pstmt.setInt(5, quantidade);
            pstmt.setInt(6, id);
            pstmt.executeUpdate();
            System.out.println(STR."Produto com ID \{id} atualizado no banco de dados.");
       }

       catch (SQLException e) {
           System.err.println(STR."Erro ao deletar o produto do banco de dados: \{e.getMessage()}");
       }

    }

    public static void removeProduto(int id) {

        String sql = "DELETE FROM produto WHERE id = ?";
        try (Connection conn = ConectaDB.getConnection();

            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println(STR."Produto com ID \{id} deletado do banco de dados.");
        }

        catch (SQLException e) {
            System.err.println(STR."Erro ao deletar o produto do banco de dados: \{e.getMessage()}");
        }

    }
}






