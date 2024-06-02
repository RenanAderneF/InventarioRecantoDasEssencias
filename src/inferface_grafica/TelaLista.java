package inferface_grafica;

import javax.swing.*;
//import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * Classe responsável por inicializar o painel de listagem de produtos no banco de dados. Possui métodos para retornar
 * a tabela com os dados inseridos, assim como um método para remover suas linhas.
 */

public class TelaLista extends JPanel  {

    JTable tabelaProduto;
    DefaultTableModel modelo;
    JScrollPane scrollTabela;
    //TableModelListener l;

    TelaLista() {

        new JPanel(); //Flow Layout por padrão
        setPreferredSize(new Dimension(500, 500));
        setOpaque(true);
        setVisible(false);

        JLabel outputLabel = new JLabel("Listagem de produtos: ");
        add(outputLabel);

        //Criação da tabela:

        String[] colunas = {"ID", "Nome", "Código de Barras", "Tamanho", "Preço", "Quantidade"}; //Colunas na tabela

        modelo = new DefaultTableModel(colunas, 0){ //Classe anônima para modificar método.

            // O método "isCellEditable" é sobrescrito para retornar que apenas a coluna ID não possa ser editada.

            @Override
            public boolean isCellEditable(int row, int column){

                int indexID = findColumn("ID");
                return column != indexID;
            }
        };



        tabelaProduto = new JTable(modelo);
        scrollTabela = new JScrollPane(tabelaProduto);


        add(scrollTabela);

        //Adiciona Ouvinte de Modelo de Tabela:

    }


    //MÉTODOS DE INSTÂNCIA:

    public DefaultTableModel getModeloTbl() {

        return modelo;

    }

    public void limpaLista() {

        modelo.setRowCount(0);
        System.out.println("Linhas da tabela resetadas para atualizar busca quando for aberta novamente.");

    }

    //Faz com que coluna "ID" não seja editável.

}