public class Main {

    public static void main(String[] args){

        //Inicia a conexão com o banco de dados

        ConectaDB.setConnection();

        //Inicia a interface gráfica

        new MyFrame();
    }
}
