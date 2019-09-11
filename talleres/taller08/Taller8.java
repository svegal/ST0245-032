/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package talleres;
import java.util.*;
/**
 * La clase Taller8 tiene la intención de
 * enfatizar en el uso de pilas y colas ya 
 * implementadas en java
 * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/util/Queue.html"> Ver más acerca de colas<a/>
 * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/util/Stack.html"> Ver más acerca de pilas <a/> 
 * @author Mauricio Toro, Andrés Páez 
 */
public class Taller8 {
    
    public static void main(String [] args){
    }
 
    
    /**
    * @param stack es una pila ya implementada que se crea en el test
    * Este método se encarga de poner la pila stack en orden inverso
    * Nota: recuerde que la funcion pop() no solo expulsa la última 
    * posición de una pila si no que tambien devuelve su valor.
    * @return una pila que haga el inverso de stack
    */
    public static Stack<Integer> inversa (Stack<Integer> stack){
        Stack<Integer> inversa = new Stack();
        do{
            inversa.push(stack.pop());
        }while(!(stack.isEmpty()));
        return inversa;
    }
    
    
    /**
    * @param queue es una cola ya implementada que se crea en el test
    * Este método se encarga de atender a personas.
    * Nota: Se debe imprimir en consola a quién atiende y sacarlo de la cola
    * existe una función "pull" que hace el trabajo más fácil
    * 
    */
    public static void cola (Queue<String> queue){
        do{
            System.out.println(queue.poll());
        }while(!(queue.isEmpty()));
    }
    public static void imprimir (Stack<Integer> s){
        for(int e: s ){
            System.out.println(e);
        }
    }
    /**
    * @param cadena
    * Dado un string, este método retorna si es posible convertirlo a un número
    * @return resultado booleano.
    */
    
    public static boolean isNumeric(String cadena) {

        boolean resultado;

        try {
            Integer.parseInt(cadena);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }

        return resultado;
    }
    /**
    * @param string es una cadena de texto que viene de este modo 3 4 5 * + o de esta manera 2 3 * 5 +
    * todo viene separado por espacios por lo que la funcion split.("") vendría muy bien para separarlos
    * Se intenta hacer el calculo por medio del metodo polaco posfijo
    * @return un entero resultado de la operación
    */
    public static int polaca (String string){
        String [] p;
        p = string.split(" ");
        Stack<Integer> pila = new Stack();
        for(int i = 0 ; i < p.length ; i++){
            if(isNumeric(p[i])){
                pila.push(Integer.parseInt(p[i]));
            }else{
                String s = p[i];
                int a = pila.pop();
                int b = pila.pop();
                switch(s){
                    case "+":
                        pila.push(a+b);
                        break;
                    case "-":
                        pila.push(b-a);
                        break;
                    case "*":
                        pila.push(a*b);
                        break;
                    case "/":
                        pila.push(a/b);
                        break;
                }
            }
        }
        return pila.pop();
    }
    /**
     * @param clientes
     * @param neveras
     * El método calcula las solicictudes y entrega a neveras desde una pila segun el 
     * orden de llegada de los clientes
     */
    public static void solicitudes(Queue<String> clientes, Stack<String> neveras){
        while(!(neveras.isEmpty()) && !(clientes.isEmpty())){
            String nevera = neveras.pop();
            String cliente = clientes.poll();
            System.out.println("Entregar la nevera: " + nevera + " a: " + cliente);
        }
    }
}
