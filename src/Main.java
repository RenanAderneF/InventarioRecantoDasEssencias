public class Main {

    public static void main(String[] args){

        //Inicia a conexão com o banco de dados

        new ConectaDB("jdbc:mysql://localhost:3306/recantodb", "root", "");

        //Inicia a interface gráfica

        new MyFrame();
    }
}
