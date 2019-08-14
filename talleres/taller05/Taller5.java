/**
 * La clase Taller5 tiene la intención de resolver el taller número 5.
 *
 * @author Mauricio Toro, Andres Paez
 * @version 1
 */

public class Taller5 {  
    
    public static void main(String[] args){
        System.out.println("Suma Arreglo");
        for(int i = 1000000000; i < 1020000000; i+=10000000){
            int [] arr = crearArreglo(i,0,300);
            long startTime = System.currentTimeMillis();
            suma(arr);
            long tiempo = System.currentTimeMillis() - startTime;
            System.out.println( i + "    " + tiempo);
        }
        System.out.println("Tablas de multiplicar");
        for(int i = 70000; i < 90000; i+=1000){
            long startTime = System.currentTimeMillis();
            mul(i);
            long tiempo = System.currentTimeMillis() - startTime;
            System.out.println( i + "    " + tiempo);
        }
        System.out.println("Insertion Sort");
        for(int i = 15000; i < 15020; i++){
            int [] arr = crearArreglo(i,0,300);
            long startTime = System.currentTimeMillis();
            insertionSort(arr);
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
    * @param array es una arreglo de numeros enteros.
    * El método suma tiene la intención de hacer el proceso de suma
    * mediante una funcion cíclica (while/for/...)
    * @return la suma de todos los numeros sumados.
    */
    public static int suma (int[]array){
      int suma = 0;
      for(int i = 0 ; i < array.length ; i++){
          suma += array[i];
      }
      return suma;
    }
    
    
    /**
    * @param num es el numero el cual se utiliza para ser multiplicado.
    * El método mul tiene la intención de hacer la multiplicación
    * de 1 a n por el numero mul
    * mediante una funcion cíclica (while/for/...)
    * 
    */
    public static int mul (int num){
      int p = 0;
        for(int i = 1 ; i <= num ; i++){
          for(int j = 1 ; j <=num ; j++){
              p += i*j;
          }
      }
        return p;
    }
    
    
    /**
    * @param array es un arreglo de números desordenados
    * El método insertionSort tiene la intención ordenar los números
    * del arreglo array por el método insertion:
    * @see <a href="https://www.youtube.com/watch?v=OGzPmgsI-pQ"> Insertion Sort <a/>
    * mediante la anidación de funciones cíclicas (while/for/...)
    * 
    */
    public static int[] insertionSort (int[] array){
        int i,j,key,temp;
        for (i = 1 ; i < array.length ; i++){
            key = array[i];
            j = i-1;
            while (j >= 0 && array[j] > key){
                temp = array[j];
                array[j] = array[j+1];
                array[j+1] = temp;
                j--;
            }
         }    
        return array;
    }
}