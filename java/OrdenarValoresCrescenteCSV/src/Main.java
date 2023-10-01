import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        String path = "c:\\csv\\CVS.txt";

        int valoresLidos[] = new int[30];

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine(); //cabeçalho foi desprezado
            line = br.readLine();

            atribuirOrdenar(line, valoresLidos);

        } catch (IOException e) {
            System.out.println("Erro:" + e.getMessage());
        }

        Boolean trocou = true;

        while (trocou) {
           trocou = compararValores(valoresLidos);
        }

        for (int i = 0; i < 30; i++) {
            System.out.println(valoresLidos[i]);
        }
    }

    public static void atribuirOrdenar(String line, int[] valoresLidos) {

        String[] vetor = line.split(";");

        for (int i = 0; i < 30; i++) {
            valoresLidos[i] = Integer.parseInt(vetor[i]);
        }
    }

    public static boolean compararValores(int[] valoresLidos) {

        boolean trocou = false;

        for (int i = 0; i < 29; i++) {
            while (valoresLidos[i] > valoresLidos[i + 1]) {

                trocarValores(valoresLidos, i);

                trocou = true;
            }
        }

        return trocou;
    }

    public static int[] trocarValores(int[] valoresLidos, int i) {

        int temp = valoresLidos[i];

        valoresLidos[i] = valoresLidos[i + 1];

        valoresLidos[i + 1] = temp;

        return valoresLidos;
    }
}

