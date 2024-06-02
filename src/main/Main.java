package main;

import db.ConectaDB;
import inferface_grafica.MyFrame;

public class Main {

    private static inferface_grafica.MyFrame MyFrame;

    public static void main(String[] args){

        //Inicia a conexão com o banco de dados

        ConectaDB.setConnection();

        //Inicia a interface gráfica

        MyFrame = new MyFrame();
    }

    public static MyFrame getMyFrame(){ //Retorna inferface_grafica.MyFrame inicializado em main.Main.

        return MyFrame;
    }
}
