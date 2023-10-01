import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        int valoresLidos[] = {9,9,5,3,3,8,2,4,2,3,1,1};


        int k = 0;

        int l = valoresLidos.length -1;

        while ((l - k) > 0) {
            atribuirMaiorMenor(valoresLidos, k, l);

            k = k+1;
           // l = l-1;
        }

        for (int i = 0; i < valoresLidos.length ; i++) {
            System.out.println(valoresLidos[i]);
        }
    }

    public static void atribuirMaiorMenor(int valoresLidos[], int k, int l) {

        int menor = valoresLidos[k];
        int maior = valoresLidos[k];

        int pmenor = -1;
        int pmaior = -1;

        for (int i = k; i <= l ; i++) { //este for esta correto? no fluxo esta for i = k, l-1 ...
            if (valoresLidos[i] < menor) {
                menor = valoresLidos[i];
                pmenor = i;
            } else if (valoresLidos[i] > maior) {
                maior = valoresLidos[i];
                pmaior = i;
            }
        }
        if (pmenor != -1) {
            trocarValoresMenor(valoresLidos, pmenor, k);
        }                                           //aqui tive que adicionar todas as variaveis se n teria
        //que criar 2 metodos diferentes
        if (pmaior != -1) {
            trocarValoresMaior(valoresLidos, pmaior, l);
        }
    }

    public static void trocarValoresMenor(int valoresLidos[], int pmenor, int k) {

        int x = valoresLidos[pmenor];                   ///no fluxograma consta envio da variavel menor
        valoresLidos[pmenor] = valoresLidos[k];           //porem desconsiderei aqui pois n foi utilizada
        valoresLidos[k] = x;
    }

    public static void trocarValoresMaior(int valoresLidos[], int pmaior, int l) {

        int x = valoresLidos[pmaior];                   ///no fluxograma consta envio da variavel maior
        valoresLidos[pmaior] = valoresLidos[l];           //porem desconsiderei aqui pois n foi utilizada
        valoresLidos[l] = x;
    }
}
