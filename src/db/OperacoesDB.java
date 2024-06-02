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

    // O atributo a seguir recebe a instância de painelLista na instância de inferface_grafica.MyFrame em main.Main.

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

                modeloTbl.addRow(new Object[]{rs.getInt("id"), rs.getString("nome"),rs.getLong("codigoBarras"),
                        rs.getString("tamanho"),rs.getFloat("preco"),
                        rs.getInt("quantidade")});

            }

            System.out.println("Listagem de produtos realizada com sucesso.");

        }

        catch (SQLException e) {
            System.err.println(STR."Erro ao listar os produtos: \{e.getMessage()}");
        }

    }

    public static void editaProduto() {

         /* Haverá uma variável que receberá um alvo (ou source) do ouvinte de evento de JTable, sendo este alvo, uma
        linha da tabela (ou registro). Com essa variável, será necessário utilizar um método para verificar o campo de
        ID dessa linha. Esse valor será armazenado em outra variável. Com esse valor, ele será
        passado em uma consulta SQL (ainda não sei como escrevê-la) para encontrar um registro no banco em que a coluna
        de codigo de barras seja equivalente ao valor da variável que representa o código de barras no JTable. Após
        encontrada, ela será removida do banco, assim como a linha que é o alvo do ouvinte de evento.
        */


    }

    public static void removeProduto(){

        /* Haverá uma variável que receberá um alvo (ou source) do ouvinte de evento de JTable, sendo este alvo, uma
        linha da tabela (ou registro). Com essa variável, será necessário utilizar um método para verificar o campo de
        ID dessa linha. Esse valor será armazenado em outra variável. Com esse valor, ele será
        passado em uma consulta SQL (ainda não sei como escrevê-la) para encontrar um registro no banco em que a coluna
        de ID seja equivalente ao valor da variável que representa o ID no JTable. Após
        encontrada, ela será removida do banco, assim como a linha que é o alvo do ouvinte de evento.
        */
    }
}





