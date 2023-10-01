public class Ordenar {

    private Integer valor;

    public Ordenar(Integer valor) {
        this.valor = valor;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Ordenar{" +
                "valor=" + valor +
                '}';
    }
}
