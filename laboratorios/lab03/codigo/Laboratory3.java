/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorios;
import java.util.*;
/**
 *
 * @author Isabella Quintero
 * @author Sofia Vega
 */
public class Laboratory3 {
    
    public static void main (String [] args){
       Stack<String> neveras = new Stack();
       for(int i = 1 ; i < 11 ; i++){
           neveras.push(String.valueOf(i));
       }
       Queue<Cliente> clientes = new LinkedList<>();
       Cliente i = new Cliente("Isabella",3);
       clientes.offer(i);
       Cliente j = new Cliente("Juan",5);
       clientes.offer(j);
       Cliente s = new Cliente("Sofia",4);
       clientes.offer(s);
       try{
       solicitudes(clientes,neveras);
       }catch(EmptyStackException e){
       }
    }
    /**
     * @param clientes
     * @param neveras
     * El método calcula las solicitudes y entrega a neveras desde una pila segun el 
     * orden de llegada de los clientes
     * Punto 1.3
     */
    public static void solicitudes(Queue<Cliente> clientes, Stack<String> neveras){
        while(!(neveras.isEmpty())){
            int ped = clientes.peek().pedido;
            String cli = clientes.poll().Nombre;
            for(int i = 0 ; i < ped ; i++){
                String nev = neveras.pop();
                System.out.println("A: "+ cli + " se entrega nevera: " + nev);
            }
        }
    }
    
}
