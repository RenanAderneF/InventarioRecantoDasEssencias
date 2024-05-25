import javax.swing.*;
import java.awt.*;

public class TelaLista {

    JPanel painelLista = new JPanel();

    TelaLista() {

        painelLista = new JPanel(); //Flow Layout por padrão
        painelLista.setPreferredSize(new Dimension(500,500));
        painelLista.setOpaque(true);
        painelLista.setVisible(false);

        JLabel outputLabel = new JLabel("Ouput Panel (Painel de saída).");
        painelLista.add(outputLabel);

    }

    public JPanel getPainelLista(){

        return painelLista;

    }
}
