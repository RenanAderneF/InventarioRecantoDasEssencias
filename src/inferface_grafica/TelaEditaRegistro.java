package inferface_grafica;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;

import main.Main;
import main.Produto;
import db.OperacoesDB;


/**
 * Classe responsável por inicializar o painel de cadastro, que receberá a entrada de dados
 * do usuário. Seu principal método "cadastraProduto" recebe os valores inseridos nos campos de texto, e os passa como
 * parâmetros durante a inicialização do objeto "main.Produto" correspondente.
 */

public class TelaEditaRegistro extends JPanel implements ActionListener {

    JTextField inputNome, inputTamanho, inputQuantidade, inputPreco, inputcodigoBarras;
    JButton btnAtualizar;
    GridBagConstraints c = new GridBagConstraints();

    int linhaSelecionada;

    public JTextField getInputNome() {
        return inputNome;
    }

    public JTextField getInputTamanho() {
        return inputTamanho;
    }

    public JTextField getInputQuantidade() {
        return inputQuantidade;
    }

    public JTextField getInputPreco() {
        return inputPreco;
    }

    public JTextField getInputcodigoBarras() {
        return inputcodigoBarras;
    }

    TelaEditaRegistro() {

        setLayout(new GridBagLayout());
        setPreferredSize(new Dimension(300, 500));
        setOpaque(true);
        setVisible(false);

        //Declarando tipos dos componentes:

        JLabel labelNome, labelTamanho, labelQuantidade, labelPreco, labelcodigoBarras;

        //Inicializando componentes:

        labelNome = new JLabel("Nome do Produto: ");
        labelTamanho = new JLabel("Tamanho: ");
        labelPreco = new JLabel("Preço: ");
        labelQuantidade = new JLabel("Quantidade: ");
        labelcodigoBarras = new JLabel("Código de barras: ");

        inputNome = new JTextField();
        inputTamanho = new JTextField();
        inputPreco = new JTextField();
        inputQuantidade = new JTextField();
        inputcodigoBarras = new JTextField();

        btnAtualizar = new JButton("Atualizar");
        btnAtualizar.addActionListener(this);

        //POSICIONANDO E DIMENSIONANDO ELEMENTOS NO PAINEL DE ENTRADA:

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.weighty = 1;


        c.gridx = 0;
        c.gridy = 0;
        this.add(labelNome, c);

        c.insets = new Insets(0,-70,0,0);
        c.gridx = 1;
        c.gridy = 0;
        this.add(inputNome, c);
        c.insets = new Insets(0,0,0,0);

        ///

        c.gridx = 0;
        c.gridy = 1;
        this.add(labelTamanho, c);

        c.insets = new Insets(0,-70,0,0);
        c.gridx = 1;
        c.gridy = 1;
        this.add(inputTamanho, c);
        c.insets = new Insets(0,0,0,0);

        ///

        c.gridx = 0;
        c.gridy = 2;
        this.add(labelPreco, c);

        c.insets = new Insets(0,-70,0,0);
        c.gridx = 1;
        c.gridy = 2;
        this.add(inputPreco, c);
        c.insets = new Insets(0,0,0,0);

        ///

        c.gridx = 0;
        c.gridy = 3;
        this.add(labelQuantidade, c);

        c.insets = new Insets(0,-70,0,0);
        c.gridx = 1;
        c.gridy = 3;
        this.add(inputQuantidade, c);
        c.insets = new Insets(0,0,0,0);

        ///

        c.gridx = 0;
        c.gridy = 4;
        this.add(labelcodigoBarras, c);

        c.insets = new Insets(0,-70,0,0);
        c.gridx = 1;
        c.gridy = 4;
        c.gridwidth = 3;
        this.add(inputcodigoBarras, c);
        c.insets = new Insets(0,0,0,0);


        //Label e Input Nome:

        c.gridwidth = 3;
        c.gridy = 5;
        c.gridx = 0;
        this.add(btnAtualizar, c);

    }

    public void editaCampo() {

        MyFrame myFrame = Main.getMyFrame();
        TelaLista painelLista = myFrame.getPainelLista();

        String nome = inputNome.getText();
        String codigoBarras = inputcodigoBarras.getText();
        String tamanho = inputTamanho.getText();
        float preco = parseFloat(inputPreco.getText());
        int quantidade = parseInt(inputQuantidade.getText());


        linhaSelecionada = painelLista.getLinhaSelecionada();

        if(linhaSelecionada != -1){

            DefaultTableModel modelo = painelLista.getMdlPersonalizado();

            int idProduto = (int) modelo.getValueAt(linhaSelecionada, 0);

            OperacoesDB.editaProduto(idProduto, nome, codigoBarras, tamanho, preco, quantidade); //Edita registro no banco.
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == btnAtualizar) {

            this.editaCampo(); //Captura os valores nos campos e o id da coluna selecionada, para ser usada na query.

            MyFrame myFrame = Main.getMyFrame();
            myFrame.exibeTelaInicio();

        }

    }

}
