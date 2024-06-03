package inferface_grafica;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import Table_model.Model;

/**
 * Classe responsável por inicializar o painel de listagem de produtos no banco de dados. Possui métodos para retornar
 * a tabela com os dados inseridos, assim como um método para remover suas linhas.
 */

public class TelaLista extends JPanel  {

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

        //Criação do modelo personalizado e da tabela:

        modelo = new Model();

        tabelaProduto = new JTable(modelo);
        scrollTabela = new JScrollPane(tabelaProduto);

        add(scrollTabela);

        //Adiciona Ouvinte de Modelo de Tabela:

    }


    //MÉTODOS DE INSTÂNCIA:

    public DefaultTableModel getMdlPersonalizado() {

        return modelo;

    }

    public void limpaLista() {

        modelo.setRowCount(0);
        System.out.println("Linhas da tabela resetadas para atualizar busca quando for aberta novamente.");

    }

    //Faz com que coluna "ID" não seja editável.

}