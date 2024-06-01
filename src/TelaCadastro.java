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

    JTextField inputNome, inputTamanho, inputQuantidade, inputPreco, inputcodigoBarras;
    JButton btnEnviar;
    GridBagConstraints c = new GridBagConstraints();
    JPanel painelCadastro;

    TelaCadastro() {

        painelCadastro = new JPanel(new GridBagLayout());
        painelCadastro.setPreferredSize(new Dimension(300, 500));
        painelCadastro.setOpaque(true);
        painelCadastro.setVisible(false);

        //Declarando tipos dos componentes:

        JLabel labelNome, labelTamanho, labelQuantidade, labelPreco, labelcodigoBarras;
        ButtonGroup tamanhosProduto;
        JRadioButton inputTamanhoP, inputTamanhoM, inputTamanhoG;

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



        btnEnviar = new JButton("Enviar");
        btnEnviar.addActionListener(this);

        //POSICIONANDO E DIMENSIONANDO ELEMENTOS NO PAINEL DE ENTRADA:

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.weighty = 1;


        c.gridx = 0;
        c.gridy = 0;
        painelCadastro.add(labelNome, c);

        c.insets = new Insets(0,-70,0,0);
        c.gridx = 1;
        c.gridy = 0;
        painelCadastro.add(inputNome, c);
        c.insets = new Insets(0,0,0,0);

        ///

        c.gridx = 0;
        c.gridy = 1;
        painelCadastro.add(labelTamanho, c);

        c.insets = new Insets(0,-70,0,0);
        c.gridx = 1;
        c.gridy = 1;
        painelCadastro.add(inputTamanho, c);
        c.insets = new Insets(0,0,0,0);

        ///

        c.gridx = 0;
        c.gridy = 2;
        painelCadastro.add(labelPreco, c);

        c.insets = new Insets(0,-70,0,0);
        c.gridx = 1;
        c.gridy = 2;
        painelCadastro.add(inputPreco, c);
        c.insets = new Insets(0,0,0,0);

        ///

        c.gridx = 0;
        c.gridy = 3;
        painelCadastro.add(labelQuantidade, c);

        c.insets = new Insets(0,-70,0,0);
        c.gridx = 1;
        c.gridy = 3;
        painelCadastro.add(inputQuantidade, c);
        c.insets = new Insets(0,0,0,0);

        ///

        c.gridx = 0;
        c.gridy = 4;
        painelCadastro.add(labelcodigoBarras, c);

        c.insets = new Insets(0,-70,0,0);
        c.gridx = 1;
        c.gridy = 4;
        c.gridwidth = 3;
        painelCadastro.add(inputcodigoBarras, c);
        c.insets = new Insets(0,0,0,0);


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
        String codigoBarras = inputcodigoBarras.getText();

        //TODO Realizar verificação dos campos antes da criação do produto e sua query insert.

        Produto produto = new Produto(nome, tamanho, preco, quantidade, codigoBarras);

        OperacoesDB.registraProduto(produto); //Realiza o INSERT dos campos.

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == btnEnviar) {

            cadastrarProduto();

        }

    }


}
