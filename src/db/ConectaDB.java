package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static java.lang.StringTemplate.STR;

public class ConectaDB {

    private static Connection conn = null;

    public static void setConnection() {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver"); /* Carrega classe dinamicamente, buscando arquivo JAR
            nos diretórios de classes no aplicativo que encontra driver */

            System.out.println("Driver encontrado com sucesso.");

        } catch (ClassNotFoundException e) {

            System.err.println(STR."Erro ao encontrar o driver. \{e.getMessage()}");
        }

        try {

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/recantodb", "root", "");
            System.out.println("Conexão realizada com sucesso.");

            //Finaliza a conexão caso programa seja encerrado.

            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                if (conn != null) {
                    try {
                        conn.close();
                        System.out.println("Conexão fechada com sucesso.");
                    } catch (SQLException e) {
                        System.err.println(STR."Erro ao fechar a conexão: \{e.getMessage()}");
                    }
                }
            }));

        } catch (SQLException e) {

            System.err.println(STR."Erro ao conectar ao banco de dados. \{e.getMessage()}");
        }

    }

    public static Connection getConnection() {

        try {

            if(conn == null || conn.isClosed()) {

                setConnection(); //Se conexão for nula ou fechada, realiza uma nova conexão.
            }

        }

        catch (SQLException e) {

            System.err.println(STR."Conexão não foi verificada corretamente. \{e.getMessage()}");
        }

        return conn; //Retorna conexão já existente ou iniciada caso não existisse.
    }

}