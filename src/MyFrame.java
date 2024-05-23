import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyFrame extends JFrame implements ActionListener {

    /* Menus declarados fora do construtor para serem acessados no método
    "actionPerformed" da interface ActionListener. */

    JMenuBar menuBar;
    JMenu menuOpcoes;
    JMenuItem itemInicio, itemCadastrar, itemListar;


    /* Painéis declarados fora do construtor para serem
   manipulados pelos métodos da classe. */

    JPanel painelInicial, painelCadastro, painelLista;


    MyFrame(){

        // Content Pane: Painel com todo o conteúdo da aplicação.

        JPanel contentPane = new JPanel(); //BorderLayout
        contentPane.setOpaque(true);
        setContentPane(contentPane);

        // MenuBar: Barra de navegação com botão de cadastro de itens e exibir lista.

        menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        menuOpcoes = new JMenu("Opções");
        menuBar.add(menuOpcoes);

        itemInicio = new JMenuItem("Início");
        itemCadastrar = new JMenuItem("Cadastrar produto");
        itemListar = new JMenuItem("Listar produtos cadastrados");

        menuOpcoes.add(itemInicio);
        menuOpcoes.add(itemCadastrar);
        menuOpcoes.add(itemListar);

        // Associando ouvinte de ação nos itens de menu:

        itemInicio.addActionListener(this);
        itemCadastrar.addActionListener(this);
        itemListar.addActionListener(this);

        //painelInicial: Painel descrevendo a aplicação, oferecendo instruções de como utilizar a aplicação.

        painelInicial = new JPanel();
        painelInicial.setPreferredSize(new Dimension(500,500));
        painelInicial.setVisible(true);
        contentPane.add(painelInicial);

        JTextArea descricao = new JTextArea();


        /* painelCadastro: Será o painel que receberá a entrada de dados do usuário.
        Ele terá o layout GridBag, visto que nesse painel requer maior liberdade de tamanho e
        posicionamento independente para os componentes.*/

        painelCadastro = new JPanel(new GridBagLayout());
        painelCadastro.setPreferredSize(new Dimension(250, 500));
        painelCadastro.setOpaque(true);
        painelCadastro.setVisible(false);
        contentPane.add(painelCadastro);

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

        GridBagConstraints c = new GridBagConstraints(); //Constante para componentes


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

        /* painelLista: Será o painel contendo a saída para os itens da
        lista de produtos armazenados. */

        painelLista = new JPanel(); //Flow Layout por padrão
        painelLista.setPreferredSize(new Dimension(500,500));
        painelLista.setOpaque(true);
        painelLista.setVisible(false);

        JLabel outputLabel = new JLabel("Ouput Panel (Painel de saída).");
        painelLista.add(outputLabel);

        contentPane.add(painelLista, BorderLayout.LINE_END); //Posiciona o painel de saída na direita.

        //JFrame:

        setTitle("Recanto das Essências: Inventário ");
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();

    }


    //MÉTODOS DE INSTÂNCIA DA CLASSE:

    public void exibeTelaInicio(){

        painelInicial.setVisible(true);
        painelCadastro.setVisible(false);
        painelLista.setVisible(false);
    }

    public void exibeTelaCadastro() {

        painelCadastro.setVisible(true);
        painelInicial.setVisible(false);
        painelLista.setVisible(false);

    }


    public void exibeTelaLista() {

        painelLista.setVisible(true);
        painelInicial.setVisible(false);
        painelCadastro.setVisible(false);
    }


    @Override //Sobrescreve o método ActionPerformed da interface ActionListener

    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == itemCadastrar) {

            /* Chama método de exibir o painel de Cadastro e
            esconder a tela principal */

            exibeTelaCadastro();
        }

        else if(e.getSource() == itemListar) {

            exibeTelaLista();
        }

        else if(e.getSource() == itemInicio) {

            exibeTelaInicio();

        }

    }


}
