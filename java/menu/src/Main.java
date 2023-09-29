import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        while(true) {
            imprimirMenu();

            int opcao = lerOpcao();

            switch (opcao) {
                case 1:
                    calcularRaizes();
                    break;
                case 2:
                    lerRegistroCSV();
                    break;
                case 3:
                    reajusteSalario();
                    break;
                case 4:
                    System.out.println("bye bye!");
                    System.exit(0);
                default:
                    System.out.println("Escolha uma opção de 1 a 4: ");
            }
        }
    }

    static void imprimirMenu(){

        System.out.println("Selecione a opção desejada para execução:");
        System.out.println("-----------------------------------------");
        System.out.println("1: Calcular raízes equação do 1º e 2º grau");
        System.out.println("2: Ler um registro CSV e imprimir o array (separado por #)");
        System.out.println("3: Imprimir o reajuste salarial de funcionários");
        System.out.println("4: Fechar o programa");

    }
    static int lerOpcao(){

        Scanner ler = new Scanner(System.in);

        int opcao = ler.nextInt();

        return opcao;
    }
    static void calcularRaizes(){

        Scanner ler = new Scanner(System.in);

        imprimirCabecalho();

        System.out.println("Qual o primeiro valor?");
        double a = ler.nextDouble();

        System.out.println("Qual o segundo valor?");
        double b = ler.nextDouble();

        System.out.println("Qual o terceiro valor?");
        double c = ler.nextDouble();


        if ( a == 0 || b == 0) {
            System.out.println("Nao e possivel calcular a raiz!");
        }

        else if (a == 0 ){ //a equacao e bx + c = 0 que e do primeiro grau.
            System.out.println("Exercicio para resolver equacao de 1 grau");
            System.out.println("----------------------------");

            double x ;

            x = - c / b ;

            System.out.println("x = " + x);

        }

        else{

            System.out.println("Exercicio para resolver equacao de 2 grau");
            System.out.println("----------------------------");

            imprimirRaizes(a,b,c);

        }
    }

    static void imprimirRaizes(double a, double b, double c) {

        double delta = ((b*b) - (4*a*c));

        double x1,x2;

        if (delta == 0) {

            x1 = ((-b)  / 2 * a);

            System.out.println("x1 e x2 = " + x1);

        }
        if (delta > 0)	{

            x1 = ((-(b) + Math.sqrt(delta) / 2 * a));
            x2 = ((-(b) - Math.sqrt(delta) / 2 * a));

            System.out.println("x1 = " + x1);
            System.out.println("x2 = " + x2);
        }
        else {
            System.out.println("Delta nao possui raiz!");
        }
    }

    private static void imprimirCabecalho() {
        System.out.println("Exercicio para resolver equacao de 1 e 2 grau");
        System.out.println("----------------------------");
    }

    static void lerRegistroCSV(){

        String path = "c:\\csv\\teste.txt";
        List<ProdutoCSV> listProdutos = new ArrayList<ProdutoCSV>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine(); // Cabeçalho, despreza
            line = br.readLine();

            while(line != null){
                atribuirProduto(line, listProdutos);
                line = br.readLine();

            }
        }
        catch(IOException e){
            System.out.println("Erro:" + e.getMessage());
        }
        listarProdutos(listProdutos);
    }
    static void atribuirProduto(String line, List<ProdutoCSV> listProdutos){
        String[] vetor = line.split("#");
        String nome = vetor[0];
        Double preco = Double.parseDouble(vetor[1]);
        Integer quantidade = Integer.parseInt(vetor[2]);

        ProdutoCSV produto = new ProdutoCSV(nome, preco, quantidade);
        listProdutos.add(produto);
    }

    static void listarProdutos(List<ProdutoCSV> listProdutos){
        System.out.println("Lista de produtos: ");
        for(ProdutoCSV p : listProdutos){
            System.out.println(p);
        }
    }
    static void reajusteSalario(){

        Double bonificacao = 5.0;
        Double reajuste = 10.3;

        Funcionario primeiroFuncionario = new Funcionario("João Pedro",1200.20, true);
        Funcionario segundoFuncionario = new Funcionario("Augusto Paulo",1500.00, false);

        System.out.println("Funcionários antes do reajuste");
        System.out.println(primeiroFuncionario);
        System.out.println(segundoFuncionario);

        primeiroFuncionario.reajustarSalario(reajuste, bonificacao);
        segundoFuncionario.reajustarSalario(reajuste, bonificacao);

        System.out.println("\nFuncionários depois do reajuste");
        System.out.println(primeiroFuncionario);
        System.out.println(segundoFuncionario);

    }
}