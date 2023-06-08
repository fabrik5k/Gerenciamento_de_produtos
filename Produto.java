public class Produto {

    private String nome;
    private String descricao;
    private float preco;
    private int quantidade;

    public Produto(String nome, String descricao, float preco, int quantidade){
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidade = quantidade;
    }
    public Produto(){}
    

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setPreco(float preco) {
        this.preco = preco;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getDescricao() {
        return descricao;
    }
    public String getNome() {
        return nome;
    }
    public float getPreco() {
        return preco;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public int compareTo(Produto produto) {
        return 0;
    }
    
}