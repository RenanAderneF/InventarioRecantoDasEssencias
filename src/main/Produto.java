package main;

/**
 * Classe que representa o produto, com seus atributos a serem preenchidos durante a execução. O objeto "main.Produto" tem
 * seus atributos preenchidos via passagem de parâmetro, processo realizado na classe "OperaçõesDB" no método
 * "CadastraProduto". Tendo sua inicialização feita corretamente, com seus atributos preenchidos, é feito o get dos
 * mesmos para serem utilizados na query de inserção de dados.
 * */

public class Produto {

    private final String nome, tamanho, codigoBarras;
    private final float preco;
    private final int quantidade;

    public Produto(String nome, String tamanho, float preco, int quantidade, String codigoBarras){

        this.nome = nome;
        this.tamanho = tamanho;
        this.preco = preco;
        this.quantidade = quantidade;
        this.codigoBarras = codigoBarras;

    }

    public String getNome() {
        return nome;
    }

    public String getTamanho() {
        return tamanho;
    }

    public String getcodigoBarras() {
        return codigoBarras;
    }

    public float getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

}
