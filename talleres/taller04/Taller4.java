package talleres.ed1;


/**
 *La clase Taller5 dos tiene como objetivo dar solución al taller5
 *
 *@autor Mauricio Toro, Camilo Paez
 *@version 1
 */
public class Taller4 {
    public static void main(String[] args){
        System.out.println("Fibonnacci");
        for(int i = 25; i < 45; i++){
            long startTime = System.currentTimeMillis();
            fibonacci(i);
            long tiempo = System.currentTimeMillis() - startTime;
            System.out.println( i + "    " + tiempo);
        }
        System.out.println("Suma Arreglo");
        for(int i = 800000; i < 800020; i++){
            int[] array = crearArreglo(i, 0, 1000);
            long startTime = System.currentTimeMillis();
            arraySum(array);
            long tiempo = System.currentTimeMillis() - startTime;
            System.out.println( i + "    " + tiempo);
        }
        System.out.println("GroupSum");
        for(int i = 22; i < 42; i++){
            int[] array = crearArreglo(i, 10, 200);
            long startTime = System.currentTimeMillis();
            groupSum(0,array, (int) (Math.random()*2500));
            long tiempo = System.currentTimeMillis() - startTime;
            System.out.println( i + "    " + tiempo);
        }
    }

    public static int[] crearArreglo(int tamaño,int limInf, int limSup){
        int[] array = new int[tamaño];
        for(int i = 0 ; i < tamaño ; i++){
           array[i] = (int) (Math.random() * (limInf-limSup)+limSup);
        }
        return array;
    }
    
    /**
     * @param array es un arreglo de numeros enteros
     * @param n la longitud del array anterior 
     *
     *en este método se busca hacer la suma de los numeros en un
     *arreglo de forma recursiva.
     *
     * @return la suma
     */
    public static int arraySum(int[] array) {
        return sum(array,0);
    }

    public static int sum(int[] array, int n){
        if(n == array.length) return 0;

        return array[n] + sum(array,n+1);
    }

    /**
     * @param start es un contador, nos sirve para saber cuando debemos parar
     * @param array es un arreglo de numeros enteros, representan volumen
     * @param target es la meta, el numero que debe alacanzar la suma 
     *
     * en este método se busca hacer la suma de los volumnes posibles
     * de modo que se acomode de tal forma que se alcance el valor target
     * pista: la clave esta en el numero de elementos y que no siempre se toman
     * los elementos, en ocaciones pasan por ejemplo en un conjuntos [5,6,7,8] para un
     * target 12 se toman el 5 y el 7 pasando por 6 sin cogerlo.
     *
     *
     * @return verdadero si hay una combinación que suponga el valor target, falso de lo contrario
     */
    public static boolean groupSum(int start, int[] nums, int target) {
        if(start>=nums.length) return target==0;
        return groupSum(start+1,nums,target-nums[start]) || groupSum(start+1,nums,target);
    }

    /**
     * @param n numero entero, hasta que numero se hace la serie
     *
     * el metodo se encarga de devolvernos el valor fibonacci en la enesima posicion
     * @see <a href="https://es.wikipedia.org/wiki/Sucesi%C3%B3n_de_Fibonacci"> fibonnaci <a/>
     * @return el valor encontrado en long dada la posible cantidad de bits
     */
    public static long fibonacci(int n) { 
        if(n<=1) return n;
        return fibonacci(n-1) + fibonacci(n-2);
    }
}
