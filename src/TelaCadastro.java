import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;

/* TelaCadastro: Classe responsável por configurar e retronar o painel de cadastro, que receberá a entrada de dados
do usuário. Ele terá o layout GridBag, visto que nesse painel requer maior liberdade de tamanho e posicionamento
independente para os componentes.*/

public class TelaCadastro implements ActionListener {

    JTextField inputNome, inputTamanho, inputQuantidade, inputPreco, inputDescricao;
    JButton btnEnviar;
    GridBagConstraints c = new GridBagConstraints();
    JPanel painelCadastro;

    TelaCadastro() {

        painelCadastro = new JPanel(new GridBagLayout());
        painelCadastro.setPreferredSize(new Dimension(500, 500));
        painelCadastro.setOpaque(true);
        painelCadastro.setVisible(false);

        //Declarando tipos dos componentes:

        JLabel labelNome, labelTamanho, labelQuantidade, labelPreco, labelDescricao;
        ButtonGroup tamanhosProduto;
        JRadioButton inputTamanhoP, inputTamanhoM, inputTamanhoG;

        //Inicializando componentes:

        labelNome = new JLabel("Nome do Produto: ");
        labelTamanho = new JLabel("Tamanho: ");
        labelPreco = new JLabel("Preço: ");
        labelQuantidade = new JLabel("Quantidade: ");
        labelDescricao = new JLabel("Descrição do Produto: ");

        inputNome = new JTextField();
        inputTamanho = new JTextField();
        inputPreco = new JTextField();
        inputQuantidade = new JTextField();
        inputDescricao = new JTextField();



        btnEnviar = new JButton("Enviar");
        btnEnviar.addActionListener(this);

        //POSICIONANDO E DIMENSIONANDO ELEMENTOS NO PAINEL DE ENTRADA:

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.weighty = 1;


        c.gridx = 0;
        c.gridy = 0;
        painelCadastro.add(labelNome, c);

        c.gridx = 1;
        c.gridy = 0;
        c.gridwidth = 3;
        painelCadastro.add(inputNome, c);
        c.gridwidth = 1;

        ///

        c.gridx = 0;
        c.gridy = 1;
        painelCadastro.add(labelTamanho, c);

        c.gridx = 1;
        c.gridy = 1;
        painelCadastro.add(inputTamanho, c);

        ///

        c.gridx = 0;
        c.gridy = 2;
        painelCadastro.add(labelPreco, c);

        c.gridx = 1;
        c.gridy = 2;
        c.gridwidth = 3;
        painelCadastro.add(inputPreco, c);
        c.gridwidth = 1;

        ///

        c.gridx = 0;
        c.gridy = 3;
        painelCadastro.add(labelQuantidade, c);

        c.gridx = 1;
        c.gridy = 3;
        c.gridwidth = 3;
        painelCadastro.add(inputQuantidade, c);
        c.gridwidth = 1;

        ///

        c.gridx = 0;
        c.gridy = 4;
        painelCadastro.add(labelDescricao, c);

        c.gridx = 1;
        c.gridy = 4;
        c.gridwidth = 3;
        painelCadastro.add(inputDescricao, c);


        //Label e Input Nome:

        c.gridwidth = 3;
        c.gridy = 5;
        c.gridx = 0;
        painelCadastro.add(btnEnviar, c);

    }

    public JPanel getPainelCadastro(){

        return painelCadastro;

    }

    public void cadastrarProduto(){

        String nome = inputNome.getText();
        String tamanho = inputTamanho.getText();
        float preco = parseFloat(inputPreco.getText());
        int quantidade = parseInt(inputQuantidade.getText());
        String descricao = inputDescricao.getText();

        Produto produto = new Produto(nome, tamanho, preco, quantidade, descricao);
        System.out.println(produto.getNome());

        OperacoesDB.registraProduto(produto); //Realiza o INSERT dos campos.

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == btnEnviar) {

            cadastrarProduto();

        }

    }


}
