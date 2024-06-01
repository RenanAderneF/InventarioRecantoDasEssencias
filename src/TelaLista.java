import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class TelaLista extends JPanel{

    JTable tabelaProduto;
    DefaultTableModel modelo;
    JScrollPane scrollTabela;

    TelaLista() {

        new JPanel(); //Flow Layout por padrão
        setPreferredSize(new Dimension(500, 500));
        setOpaque(true);
        setVisible(false);

        JLabel outputLabel = new JLabel("Listagem de produtos: ");
        add(outputLabel);


        //Criação da tabela:

        Object[][] dados = {};

        String[] colunas = {"Nome", "Código de Barras", "Tamanho", "Preço", "Quantidade"}; //Colunas na tabela

        modelo = new DefaultTableModel(colunas, 0);
        tabelaProduto = new JTable(modelo);

        scrollTabela = new JScrollPane(tabelaProduto);
        add(scrollTabela);


    }


    //MÉTODOS DE INSTÂNCIA:

    public DefaultTableModel getModeloTbl(){

        return modelo;

    }
}
