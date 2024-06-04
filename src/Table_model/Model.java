package Table_model;
import javax.swing.table.DefaultTableModel;

public class Model extends DefaultTableModel{

    private static final String[] colunas = {"ID", "Nome", "Código de Barras", "Tamanho", "Preço", "Quantidade"};

    public Model() {

        //Criação da tabela por inicialização padrão (sem linhas ou colunas):
        super();

        //Configura as colunas na tabela:
        setColumnIdentifiers(colunas);

    }

    @Override
    public boolean isCellEditable(int row, int column){

        return false;
    }
}
