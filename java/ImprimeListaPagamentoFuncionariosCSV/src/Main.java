import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        String path = "c:\\csv\\pagamento.txt";
        List<Pagamento> listPagamentos = new ArrayList<Pagamento>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine(); // Cabeçalho, despreza
            line = br.readLine();

            while (line != null) {
                atribuirPagamento(line, listPagamentos);
                line = br.readLine();

            }
        } catch (IOException e) {
            System.out.println("Erro:" + e.getMessage());
        }

        listarPagamentos(listPagamentos);

    }

    static void atribuirPagamento(String line, List<Pagamento> listPagamentos) {
        String[] vetor = line.split("#");
        Integer id = Integer.parseInt(vetor[0]);
        String nome = vetor[1];
        Double salario = Double.parseDouble(vetor[2]);
        Integer quantidadeFilhos = Integer.parseInt(vetor[3]);
        Double quantidadeHoraExtra = Double.parseDouble(vetor[4]);
        String email = vetor[5];

        Pagamento pagamento = new Pagamento(id, nome, salario, quantidadeFilhos, quantidadeHoraExtra, email);
        listPagamentos.add(pagamento);

        pagamento.calculoSalario();

    }

    static void listarPagamentos(List<Pagamento> listPagamentos) {


        System.out.println("Lista de pagamentos: ");


         listPagamentos.sort(Comparator.comparing(Pagamento::getNome));


        for (Pagamento p : listPagamentos) {

            System.out.println("-------------------------------------------");
            System.out.println("ID: " + p.getId() + " " + p.getNome());
            System.out.println("-------------------------------------------");
            System.out.println("SALARIO: " + p.getSalario());
            System.out.println("HORA EXTRA: " + p.getQuantidadeHoraExtra() + " " + p.getTotalHoraExtra());
            System.out.println("SALARIO FAMILIA: " + p.getQuantidadeFilhos() + " " + p.getTotalSalarioFamilia());
            System.out.println("INSS: " + p.getValorInss());
            System.out.println("IR: " + p.getValorIR());
            System.out.println("PROVENTOS: " + p.getProvento());
            System.out.println("DESCONTOS: " + p.getDesconto());
            System.out.println("SALARIO LÍQUIDO: " + p.getSalarioLiquido());
        }
    }
}
