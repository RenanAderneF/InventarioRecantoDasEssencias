import java.sql.DriverManager;
import java.sql.SQLException;

import static java.lang.StringTemplate.STR;

public class ConectaDB {

    /* Antes de tudo, é necessário instalar o Driver adequado do JDBC,
       inserir seu arquivo JAR nas dependências do projeto e utilizar "Class.forName"
       para encontrá-lo.
    */

    public ConectaDB(String url, String user, String password) {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver"); /* Carrega classe dinamicamente, buscando arquivo JAR
            nos diretórios de classes no aplicativo que encontra driver */

            System.out.println("Driver encontrado com sucesso");
        } catch (ClassNotFoundException e) {

            System.err.println(STR."Erro ao encontrar o driver. \{e.getMessage()}");
        }

        try {

            DriverManager.getConnection(url, user, password);
            System.out.println("Banco de dados conectado com sucesso");

        } catch (SQLException e) {

            System.err.println(STR."Erro ao conectar ao banco de dados. \{e.getMessage()}");
        }

    }
}