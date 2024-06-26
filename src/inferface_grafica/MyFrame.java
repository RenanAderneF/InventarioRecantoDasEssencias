package inferface_grafica;
import javax.swing.*;
import java.awt.event.*;
import db.OperacoesDB;
import main.Main;

/**
 * Classe responsável por inicializar o frame da interface gráfica, contendo a inicialização da barra de menu, painel de
 * registro de produtos e painel de listagem de produtos do banco de dados. Além de métodos get para a inicialização
 * desses painéis, ela conta com a implementação da interface "ActionListener" para interação com os menus.
 */

public class MyFrame extends JFrame implements ActionListener {

    /* Menus declarados fora do construtor para serem acessados no método
    "actionPerformed" da interface ActionListener. */

    JMenuBar menuBar;
    JMenu menuOpcoes;
    JMenuItem itemInicio, itemCadastrar, itemListar;


    /* Painéis declarados fora do construtor para serem
   manipulados pelos métodos da classe. */

    TelaInicial painelInicial;
    TelaCadastro painelCadastro;
    TelaLista painelLista;
    TelaEditaRegistro painelEditaRegistro;


    public MyFrame(){

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

        painelInicial = new TelaInicial(); //Inicia construtor
        contentPane.add(painelInicial);

        //painelCadastro: Contém o formulário de cadastro de item.

        painelCadastro = new TelaCadastro();
        contentPane.add(painelCadastro);

        //painelLista: Contém a saída para os itens registrados no banco de dados.

        painelLista = new TelaLista();
        contentPane.add(painelLista);


        painelEditaRegistro = new TelaEditaRegistro();
        contentPane.add(painelEditaRegistro);

        //JFrame:

        setTitle("Recanto das Essências: Inventário ");
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();

        setLocationRelativeTo(null); //Faz JFrame surgir no centro da tela.

    }


    //MÉTODOS DE INSTÂNCIA DA CLASSE:

    public void exibeTelaInicio(){

        MyFrame myFrame = Main.getMyFrame();
        painelEditaRegistro = myFrame.getPainelEditaRegistro();
        painelEditaRegistro.setVisible(false);

        painelInicial.setVisible(true);
        painelCadastro.setVisible(false);
        painelLista.setVisible(false);
        painelLista.limpaLista();
    }

    public void exibeTelaCadastro() {

        MyFrame myFrame = Main.getMyFrame();
        painelEditaRegistro = myFrame.getPainelEditaRegistro();
        painelEditaRegistro.setVisible(false);

        painelCadastro.setVisible(true);
        painelInicial.setVisible(false);
        painelLista.setVisible(false);

        painelLista.limpaLista();
    }

    public void exibeTelaLista() {

        MyFrame myFrame = Main.getMyFrame();
        painelEditaRegistro = myFrame.getPainelEditaRegistro();
        painelEditaRegistro.setVisible(false);

        painelLista.setVisible(true);
        painelInicial.setVisible(false);
        painelCadastro.setVisible(false);

    }

    public TelaLista getPainelLista(){ //Retorna a instância de TelaLista iniciada em
        // MyFrame, e atribuída a "painelLista".

        return painelLista;
    }

    public TelaEditaRegistro getPainelEditaRegistro(){

        return painelEditaRegistro;
    }

    @Override //Sobrescreve o método ActionPerformed da interface ActionListener, definindo eventos dos menus.

    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == itemCadastrar) {

            exibeTelaCadastro();
        }

        else if(e.getSource() == itemListar) {

            exibeTelaLista();
            OperacoesDB.listaProdutos();

        }

        else if(e.getSource() == itemInicio) {

            exibeTelaInicio();

        }

    }

}
