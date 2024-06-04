package inferface_grafica;
import db.OperacoesDB;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import Table_model.Model;
import main.Main;

/**
 * Classe responsável por inicializar o painel de listagem de produtos no banco de dados. Possui métodos para retornar
 * a tabela com os dados inseridos, assim como um método para remover suas linhas.
 */

public class TelaLista extends JPanel  {

    private int id;

    JTable tabelaProduto;
    DefaultTableModel modelo;
    JScrollPane scrollTabela;
    JButton btnDLTRegistro;
    JButton btnUPDTRegistro;

    private int linhaSelecionada;

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

        btnDLTRegistro = new JButton("Apagar registro");
        add(btnDLTRegistro);

        btnDLTRegistro.addActionListener(e -> { //função anônima

            deletaCampo(); //Deleta registro na tabela.

        });

        btnUPDTRegistro = new JButton("Atualizar registro selecionado");
        add(btnUPDTRegistro);

        btnUPDTRegistro.addActionListener(e -> { //função anônima

            String nome = (String) modelo.getValueAt(linhaSelecionada, 1);
            System.out.println(nome);
            String codigoBarras = Long.toString((Long) modelo.getValueAt(linhaSelecionada, 2));
            System.out.println(codigoBarras);
            String tamanho = (String) modelo.getValueAt(linhaSelecionada, 3);
            System.out.println(tamanho);
            float preco = (Float) modelo.getValueAt(linhaSelecionada, 4);
            System.out.println(preco);
            int quantidade = (Integer) modelo.getValueAt(linhaSelecionada,5);
            System.out.println(quantidade);

            exibeTelaEditaRegistro(nome, codigoBarras, tamanho, preco, quantidade);
        });


        //Adiciona Ouvinte de Modelo de Tabela:

        ouvinteSelecLinha();
    }

    //MÉTODOS DE INSTÂNCIA:

    public void exibeTelaEditaRegistro(String nome, String codigoBarras, String tamanho, float preco, int quantidade){

        this.setVisible(false);
        MyFrame myFrame = Main.getMyFrame();
        TelaEditaRegistro painelEditaRegistro = myFrame.getPainelEditaRegistro();
        painelEditaRegistro.setVisible(true);

        painelEditaRegistro.getInputNome().setText(nome);
        painelEditaRegistro.getInputcodigoBarras().setText(codigoBarras);
        painelEditaRegistro.getInputTamanho().setText(tamanho);
        painelEditaRegistro.getInputPreco().setText(Float.toString(preco));
        painelEditaRegistro.getInputQuantidade().setText(Integer.toString(quantidade));

    }

    public DefaultTableModel getMdlPersonalizado() {

        return modelo;

    }

    public void limpaLista() {

        modelo.setRowCount(0);
        System.out.println("Linhas da tabela resetadas para atualizar busca quando for aberta novamente.");

    }

    private static void printaConteudoLinha(int linha, JTable tabela) {

        int numColunas = tabela.getColumnCount();
        StringBuilder conteudoLinhas = new StringBuilder();

        for (int col = 0; col < numColunas; col++) {
            Object value = tabela.getValueAt(linha, col);
            conteudoLinhas.append(value).append(" ");
        }
        System.out.println(STR."Conteúdos da linha \{linha}: \{conteudoLinhas.toString()}");
    }

    public void ouvinteSelecLinha() {

        tabelaProduto.addMouseListener(new MouseAdapter(){

            @Override
            public void mouseClicked(MouseEvent e){

                linhaSelecionada = tabelaProduto.rowAtPoint(e.getPoint());

                if(linhaSelecionada != -1) {

                    System.out.println(STR."Linha selecionada: \{linhaSelecionada}.");
                }

                printaConteudoLinha(linhaSelecionada, tabelaProduto);
            }
        });
    }

    public int getLinhaSelecionada(){

        return linhaSelecionada;
    }

    public void deletaCampo(){

        if(linhaSelecionada != -1){

            int idProduto = (int) modelo.getValueAt(linhaSelecionada, 0);
            modelo.removeRow(linhaSelecionada);
            System.out.println(STR."Linha \{linhaSelecionada} removida.");

            OperacoesDB.removeProduto(idProduto); //Apaga registro no banco.
        }
    }

}
