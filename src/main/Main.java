package main;
import db.ConectaDB;
import inferface_grafica.MyFrame;

public class Main {

    private static MyFrame myFrame;

    public static void main(String[] args){

        //Inicia a conexão com o banco de dados

        ConectaDB.setConnection();

        //Inicia a interface gráfica

        myFrame = new MyFrame();

    }

    public static MyFrame getMyFrame(){ //Retorna MyFrame inicializado em Main.

        return myFrame;
    }
}
