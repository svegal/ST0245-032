/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package talleres.ed1;

/**
 * La clase MiArrayList tiene la intención de representar un objeto que simule el comportamiento
 * de la clase ya implementada "ArrayList"
 * es claro que no se puede utilizar dicha estructura ya utilizada dentro de este ejercicio. 
 * Para más información de la clase ArrayList:
 * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html"> Ver documentacion ArrayList </a>
 * 
 * 
 * @author Mauricio Toro, Andres Paez
 * @version 1
 */
import java.util.Arrays;

public class MiArrayList {
    private int size;
    private static final int DEFAULT_CAPACITY = 10;
    private int elements[]; 
    
    /**
    * El metodo constructor se utiliza para incializar
    * variables a valores neutros como 0 o null.
    * El contructor no lleva parámetros en este caso.
    */
    public MiArrayList() {
        size = 0;
        elements = new int[DEFAULT_CAPACITY];
    }     

    
    /**
    * Tiene la intención de retornar la longitud del objeto
    * @return longitud del objeto
    *
    * El size esta influenciado por las funciones add y del
    */
    public int size() {
        return size;
    }   
    
    /** 
    * @param e el elemento a guardar
    * Agrega un elemento e a la última posición de la lista
    *
    */
    public void add(int e) {
        add(size,e);
    }    
    
    
    /** 
    * @param i es un íncide donde se encuentra el elemento posicionado
    * Retorna el elemento que se encuentra en la posición i de la lista.
    * @return elemento en la posicion ingresada por el usuario
    */
    public int get(int i) {
        if(i < size && i > 0){
        return elements[i];
        }
        else{
            throw new IndexOutOfBoundsException("Index: " + i);
        }
    }
    
    
    /**
    * @param index es la posicion en la cual se va agregar el elemento
    * @param e el elemento a guardar
    * Agrega un elemento e en la posición index de la lista
    *
    */
    public void add(int index, int e) {
        int [] nuevo = new int[size+1]; //O(1)
       for(int i = 0 ; i < index ; i++){    //O(n)
            nuevo[i] = elements[i];      //O(n)
        }
        nuevo[index] = e;               //O(1)
        for(int j = index+1 ; j < size ; j++){  //O(n)
            nuevo[j] = elements[j-1];           //O(n)
        }
        elements = nuevo;               //O(1)
    }                               //______________
                                    // T(n) es O(n)
                                
    /**
    * @param index es la posicion de la cual se va a eliminar el elemento
    *
    * ELimina el elemento  en la posición index de la lista
    *
    */
    public void del(int index){
        int [] nuevo = new int[size-1];
        int i = 0;
        while(i<index){
            nuevo[i] = elements[i];
            i++;
        }
        for(int j = index+1 ; j < size ; j++){
            nuevo[j-1] = elements[j];
        }
        elements = nuevo;
    }
}