public class Funcionario {
    private String nome;
    private Double salario;
    private boolean isNivelSuperior;

    public Funcionario(String nome, Double salario, boolean isNivelSuperior) {
        this.nome = nome;
        this.salario = salario;
        this.isNivelSuperior = isNivelSuperior;
    }
    public String toString(){
        return "[Nome: " + nome + " Salário: " + salario + " Nível superior: " + isNivelSuperior + "]";
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

    public boolean isNivelSuperior() {
        return isNivelSuperior;
    }

    public void setNivelSuperior(boolean nivelSuperior) {
        isNivelSuperior = nivelSuperior;
    }

    public void reajustarSalario(Double reajuste, Double bonificacao) {

        salario += salario * reajuste /100;

        if(isNivelSuperior){
            salario += salario * bonificacao /100 ;
        }
    }
}
