public class ProdutoCSV{
    private String nome;
    private Double valor;
    private Integer quantidade;

    public ProdutoCSV(String descricaoProduto, Double valorProduto, Integer quantidadeEstoque){

        this.nome = descricaoProduto;
        this.valor = valorProduto;
        this.quantidade = quantidadeEstoque;
    }

    public String toString(){
        return "[Descrição do produto: " + nome + " Valor do Produto: " + valor + " Quantidade do estoque: " +
                quantidade + "]";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}