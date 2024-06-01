import javax.swing.*;

public class Main {

    private static MyFrame MyFrame;

    public static void main(String[] args){

        //Inicia a conexão com o banco de dados

        ConectaDB.setConnection();

        //Inicia a interface gráfica

        MyFrame = new MyFrame();
    }

    public static MyFrame getMyFrame(){ //Retorna MyFrame inicializado em Main.

        return MyFrame;
    }
}
