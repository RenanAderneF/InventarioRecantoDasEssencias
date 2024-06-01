public class Produto {

    private String nome, tamanho, codigoBarras;
    private float preco;
    private int quantidade;

    Produto(String nome, String tamanho, float preco, int quantidade, String codigoBarras){

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
