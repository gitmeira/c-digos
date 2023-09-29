import java.util.Arrays;

public class BuscaBinariaRecursiva {

    public static void main(String[] args) {
        int[] array = { 1, 8, 34, 67, 9, 6, 78, 12, 56, 41, 90 };
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        int valorProcurado = 67;
        System.out.println("Procurando o valor " + valorProcurado);
        if(busca(array,valorProcurado)==-1){
            System.out.println("O valor procurado não foi encontrado :(");
        }
        else{
        System.out.println("O valor procurado está na posição " + busca(array, valorProcurado));
       }
    }
    private static int busca(int[] array, int valorProcurado) {
        return buscaBinaria(array, 0, array.length - 1, valorProcurado);
    }

    private static int buscaBinaria(int[] array, int inicio, int fim,
                                    int valorProcurado) {
        int meio = (fim + inicio) / 2;
        int valorMeio = array[meio];

        if (inicio > fim)
            return -1;
        else if(valorMeio == valorProcurado)
            return meio;
        else if (valorMeio < valorProcurado)
            return buscaBinaria(array, meio+1, fim, valorProcurado);
        else
            return buscaBinaria(array, inicio, meio-1, valorProcurado);
    }
}