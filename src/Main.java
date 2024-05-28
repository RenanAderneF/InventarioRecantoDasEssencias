public class Main {

    public static void main(String[] args){

        //Inicia a conexão com o banco de dados

        ConectaDB.setConnection("jdbc:mysql://localhost:3306/recantodb", "root", "");
        ConectaDB.getConnection();

        //Inicia a interface gráfica

        new MyFrame();
    }
}
