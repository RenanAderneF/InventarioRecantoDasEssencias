import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TelaLista {

    JPanel painelLista;
    JTable tabelaProduto;
    DefaultTableModel modelo;
    JScrollPane scrollTabela;

    TelaLista() {

        painelLista = new JPanel(); //Flow Layout por padrão
        painelLista.setPreferredSize(new Dimension(500,500));
        painelLista.setOpaque(true);
        painelLista.setVisible(false);

        JLabel outputLabel = new JLabel("Listagem de produtos: ");
        painelLista.add(outputLabel);


        //Criação da tabela:

        Object [][] dados = {};

        String[] colunas = {"Nome",  "Código de Barras", "Tamanho", "Preço", "Quantidade"}; //Colunas na tabela

        modelo = new DefaultTableModel(colunas, 0);
        tabelaProduto = new JTable(modelo);

        scrollTabela = new JScrollPane(tabelaProduto);
        painelLista.add(scrollTabela);


    }

    public JPanel getPainelLista(){

        return painelLista;

    }

    public void listaProduto(){

        String sql = "SELECT * FROM produto";

        try (Connection conn = ConectaDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {

                //Modelo que realiza as operações na tabela:

                modelo.addRow(new Object[]{rs.getString("nome"),rs.getLong("codigoBarras"),
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

