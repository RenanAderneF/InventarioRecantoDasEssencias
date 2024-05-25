import javax.swing.*;
import java.awt.*;

/* TelaInicial: Classe responsável por configurar e retornar o painel inicial, que oferece instruções de como utilizar a
aplicação. Ele é instanciado em MyFrame, tendo seu método get chamado para acessar o JPanel em si. */

public class TelaInicial {

    GridBagConstraints c = new GridBagConstraints();
    JPanel painelInicial;

    TelaInicial() {

        painelInicial = new JPanel(new GridBagLayout());
        painelInicial.setPreferredSize(new Dimension(500,500));
        painelInicial.setBackground(new Color(255, 255, 255));
        painelInicial.setVisible(true);

        //Adicionando título, seguido de ícone com logo da empresa.

        c.insets = new Insets(0,10,0,10);
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        c.gridy = 0;
        c.weighty = 1;
        c.weightx = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        ImageIcon iconApp = new ImageIcon("src/assets/recantoLogo.png");
        JLabel titleApp = new JLabel("UTILIZANDO O INVENTÁRIO: ", iconApp, JLabel.CENTER);
        titleApp.setIconTextGap(50);
        titleApp.setHorizontalTextPosition(SwingConstants.CENTER);
        titleApp.setVerticalTextPosition(SwingConstants.BOTTOM);
        painelInicial.add(titleApp, c);


        //Adicionando área de texto com explicação de como usar a aplicação:

        String descricao = """
                 
                - Início: Retorna à tela inicial.
                
                - Cadastrar Produto: Abre um formulário. Ao preenchê-lo e pressionar "Enviar", o produto
                será armazenado no banco de dados.
                
                - Listar Produto: Busca os produtos no banco de dados, exibindo todos os registros em
               uma janela.
                
                - Ajuda: Abre uma janela com informações sobre o desenvolvimento da aplicação, com um
                link para o projeto no Github, para explicações mais detalhadas sobre o processo de
                construção da aplicação.
                
                """;

        c.anchor = GridBagConstraints.CENTER;
        c.fill = GridBagConstraints.BOTH;
        c.weighty = 1;
        c.gridy = 1;
        JTextArea descricaoApp = new JTextArea(descricao);
        descricaoApp.setEditable(false);
        descricaoApp.setFocusable(false);

        painelInicial.add(descricaoApp, c);


    }

    public JPanel getPainelInicial(){

        return painelInicial;
    }
}
