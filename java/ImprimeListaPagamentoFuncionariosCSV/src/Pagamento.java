import java.text.DecimalFormat;

public class Pagamento{
    private Integer id;
    private String nome;
    private Double salario;
    private Integer quantidadeFilhos;
    private Double quantidadeHoraExtra;
    private String email;
    private Double totalSalarioFamilia;
    private Double totalHoraExtra;
    private Double valorHora;;
    private Double provento ;
    private Double valorInss ;
    private Double valorIR ;
    private Double desconto ;
    private Double salarioLiquido;

    public Pagamento(Integer id, String nome, Double salario, Integer quantidadeFilhos, Double quantidadeHoraExtra, String email) {
        this.id = id;
        this.nome = nome;
        this.salario = salario;
        this.quantidadeFilhos = quantidadeFilhos;
        this.quantidadeHoraExtra = quantidadeHoraExtra;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public Integer getQuantidadeFilhos() {
        return quantidadeFilhos;
    }

    public void setQuantidadeFilhos(Integer quantidadeFilhos) {
        this.quantidadeFilhos = quantidadeFilhos;
    }

    public Double getQuantidadeHoraExtra() {
        return quantidadeHoraExtra;
    }

    public void setQuantidadeHoraExtra(Double quantidadeHoraExtra) {
        this.quantidadeHoraExtra = quantidadeHoraExtra;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getTotalSalarioFamilia() {
        return totalSalarioFamilia;
    }

    public void setTotalSalarioFamilia(Double totalSalarioFamilia) {
        this.totalSalarioFamilia = totalSalarioFamilia;
    }

    public Double getTotalHoraExtra() {
        return totalHoraExtra;
    }

    public void setTotalHoraExtra(Double totalHoraExtra) {
        this.totalHoraExtra = totalHoraExtra;
    }

    public Double getValorHora() {
        return valorHora;
    }

    public void setValorHora(Double valorHora) {
        this.valorHora = valorHora;
    }

    public Double getProvento() {
        return provento;
    }

    public void setProvento(Double provento) {
        this.provento = provento;
    }

    public Double getValorInss() {
        return valorInss;
    }

    public void setValorInss(Double valorInss) {
        this.valorInss = valorInss;
    }

    public Double getValorIR() {
        return valorIR;
    }

    public void setValorIR(Double valorIR) {
        this.valorIR = valorIR;
    }

    public Double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }

    public Double getSalarioLiquido() {
        return salarioLiquido;
    }

    public void setSalarioLiquido(Double salarioLiquido) {
        this.salarioLiquido = salarioLiquido;
    }

    public void calculoSalario() {

         valorHora = salario / 160;

         totalHoraExtra = valorHora * 1.5 * quantidadeHoraExtra;

         totalSalarioFamilia = quantidadeFilhos * 172.00;

         provento = salario + totalSalarioFamilia + totalHoraExtra;

         valorInss = calculoInss(provento);

         valorIR = calculoIR(provento);

         desconto = valorInss + valorIR;

         salarioLiquido = provento - desconto;
    }
    public double calculoIR(Double provento) {

        if (provento < 2000.0) {
            valorIR = 0.0;
        } else if (provento > 2000.01 || provento < 4000.00) {
            valorIR = provento * 0.15;
        } else if (provento > 4000.01 || provento < 8000.00) {
            valorIR = provento * 0.25;
        } else {
            valorIR = provento * 0.35;
        }

        return valorIR;
    }

    public double calculoInss(Double provento) {

        if (provento < 2000.01) {
            valorInss = provento * 0.09;
        } else if (provento > 2000.01 || provento < 6000.00) {
            valorInss = provento * 0.10;
        } else {
            valorInss = provento * 0.11;
        }

        return valorInss;

    }

    @Override
    public String toString() {
       return     "[id: " + id + " nome:" + nome + "salário: " + salario +
        "quantidadeFilhos: " +  quantidadeFilhos +
        "quantidadeHoraExtra: " +  quantidadeHoraExtra +
        "email: " + email +
        "totalSalarioFamilia: " +  totalSalarioFamilia +
        "totalHoraExtra: " + totalHoraExtra +
        "valorHora: " + valorHora +
        "provento: " + provento +
        "valorInss: " + valorInss +
        "valorIR: " + valorIR +
        "desconto:" + desconto +
        "salarioLiquido: " +  salarioLiquido +
        "]";
    }

}
