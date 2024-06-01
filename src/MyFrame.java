import javax.swing.*;
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
    TelaLista telaLista;

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

        TelaInicial telaInicial = new TelaInicial(); //Inicia construtor
        painelInicial = telaInicial.getPainelInicial(); //Retorna painel da classe.

        contentPane.add(painelInicial);

        /* painelCadastro: Será o painel que receberá a entrada de dados do usuário.
        Ele terá o layout GridBag, visto que nesse painel requer maior liberdade de tamanho e
        posicionamento independente para os componentes.*/

        TelaCadastro telaCadastro = new TelaCadastro();
        painelCadastro = telaCadastro.getPainelCadastro();

        contentPane.add(painelCadastro);

        /* painelLista: Será o painel contendo a saída para os itens da
        lista de produtos armazenados. */

        telaLista = new TelaLista();
        painelLista = telaLista.getPainelLista();

        contentPane.add(painelLista);

        //JFrame:

        setTitle("Recanto das Essências: Inventário ");
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();

        setLocationRelativeTo(null); //Faz JFrame surgir no centro da tela.

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

    public JPanel getInitPLista(){

        return painelLista;
    }


    @Override //Sobrescreve o método ActionPerformed da interface ActionListener

    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == itemCadastrar) {

            exibeTelaCadastro();
        }

        else if(e.getSource() == itemListar) {

            exibeTelaLista();
            telaLista.listaProduto();

        }

        else if(e.getSource() == itemInicio) {

            exibeTelaInicio();

        }

    }


}
