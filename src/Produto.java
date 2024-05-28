public class Produto {

    private String nome, tamanho, descricao;
    private float preco;
    private int quantidade;

    Produto(String nome, String tamanho, float preco, int quantidade, String descricao){

        this.nome = nome;
        this.tamanho = tamanho;
        this.preco = preco;
        this.quantidade = quantidade;
        this.descricao = descricao;

    }

    public String getNome() {
        return nome;
    }


    public String getTamanho() {
        return tamanho;
    }


    public String getDescricao() {
        return descricao;
    }

    public float getPreco() {
        return preco;
    }


    public int getQuantidade() {
        return quantidade;
    }

}
