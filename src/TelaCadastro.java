import javax.swing.*;
import java.awt.*;

/* TelaCadastro: Classe responsável por configurar e retronar o painel de cadastro, que receberá a entrada de dados
do usuário. Ele terá o layout GridBag, visto que nesse painel requer maior liberdade de tamanho e posicionamento
independente para os componentes.*/

public class TelaCadastro {

    GridBagConstraints c = new GridBagConstraints();
    JPanel painelCadastro;

    TelaCadastro() {

        painelCadastro = new JPanel(new GridBagLayout());
        painelCadastro.setPreferredSize(new Dimension(500, 500));
        painelCadastro.setOpaque(true);
        painelCadastro.setVisible(false);

        //Declarando tipos dos componentes:

        JLabel labelNome, labelTamanho, labelQuantidade, labelPreco, labelDescricao;
        JTextField inputNome, inputQuantidade, inputPreco, inputDescricao;
        ButtonGroup tamanhosProduto;
        JRadioButton inputTamanhoP, inputTamanhoM, inputTamanhoG;


        //Inicializando componentes:

        labelNome = new JLabel("Nome do Produto: ");
        labelTamanho = new JLabel("Tamanho: ");
        labelPreco = new JLabel("Preço: ");
        labelQuantidade = new JLabel("Quantidade: ");
        labelDescricao = new JLabel("Descrição do produto (opcional): ");

        inputNome = new JTextField();
        inputPreco = new JTextField();
        inputQuantidade = new JTextField();
        inputDescricao = new JTextField();

        tamanhosProduto = new ButtonGroup();
        inputTamanhoP = new JRadioButton("P");
        inputTamanhoM = new JRadioButton("M");
        inputTamanhoG = new JRadioButton("G");


        tamanhosProduto.add(inputTamanhoP);
        tamanhosProduto.add(inputTamanhoM);
        tamanhosProduto.add(inputTamanhoG);


        //POSICIONANDO E DIMENSIONANDO ELEMENTOS NO PAINEL DE ENTRADA:

        painelCadastro.add(labelNome, c);
        painelCadastro.add(inputNome, c);
        painelCadastro.add(labelTamanho, c);
        painelCadastro.add(inputTamanhoP, c);
        painelCadastro.add(inputTamanhoM, c);
        painelCadastro.add(inputTamanhoG, c);
        painelCadastro.add(labelQuantidade, c);
        painelCadastro.add(inputQuantidade, c);
        painelCadastro.add(labelQuantidade, c);
        painelCadastro.add(inputQuantidade, c);




        /*
        c.gridx = 0;
        c.gridy = 1;
        c.fill = GridBagConstraints.NONE;
        painelCadastro.add(labelTamanho, c);
        c.gridx = 1;
        painelCadastro.add(inputTamanhoP, c);
        c.gridx = 2;
        painelCadastro.add(inputTamanhoM, c);
        c.gridx = 3;
        painelCadastro.add(inputTamanhoG, c);


        c.gridx = 0;
        c.gridy = 2;
        painelCadastro.add(labelPreco, c);
        c.gridx = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        painelCadastro.add(inputPreco, c);

        c.gridx = 0;
        c.gridy = 3;
        c.fill = GridBagConstraints.NONE;
        painelCadastro.add(labelQuantidade, c);
        c.gridx = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        painelCadastro.add(inputQuantidade, c);

        */

    }

    public JPanel getPainelCadastro(){

        return painelCadastro;

    }
}
