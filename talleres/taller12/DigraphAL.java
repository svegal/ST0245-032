/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 

import java.util.ArrayList;
import java.util.LinkedList;
import javafx.util.Pair;
/**
 * Implementacion de un grafo dirigido usando listas de adyacencia
 *
 * @author Mauricio Toro, Mateo Agudelo, <su nombre>
 */
public class DigraphAL extends Digraph {
	
    ArrayList<LinkedList<Pair<Integer,Integer>>> listaDeListas;

	/**
	* Constructor para el grafo dirigido
	* @param size el numero de vertices del grafo
	*
	*/
	public DigraphAL(int size) {
		super(size);
		listaDeListas = new ArrayList<LinkedList<Pair<Integer,Integer>>>();
	}

	/**
	* Metodo para añadir un arco nuevo, donde se representa cada nodo con un entero
	* y se le asigna un peso a la longitud entre un nodo fuente y uno destino	
	* @param source desde donde se hara el arco
	* @param destination hacia donde va el arco
	* @param weight el peso de la longitud entre source y destination
	*/
        @Override
	public void addArc(int source, int destination, int weight) {
                listaDeListas.get(source).add(source,new Pair(destination, weight));
	}

	/**
	* Metodo para obtener una lista de hijos desde un nodo, es decir todos los nodos
	* asociados al nodo pasado como argumento
	* @param vertex nodo al cual se le busca los asociados o hijos
	* @return todos los asociados o hijos del nodo vertex, listados en una ArrayList
	* Para más información de las clases:
 	* @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html"> Ver documentacion ArrayList </a>
	*/
	public ArrayList<Integer> getSuccessors(int vertex) {
            ArrayList<Integer> ans = new ArrayList<>(); 
            LinkedList<Pair<Integer,Integer>> hijos = listaDeListas.get(vertex);
            hijos.forEach((p) -> {
                ans.add(p.getValue());
            });    
            return ans;
	}

	/**
	* Metodo para obtener el peso o longitud entre dos nodos
	* 
	* @param source desde donde inicia el arco
	* @param destination  donde termina el arco
	* @return un entero con dicho peso
	*/	
	public int getWeight(int source, int destination) {
                int w = 0;
                for(Pair<Integer,Integer> p: listaDeListas.get(source)){
                    if(p.getKey() == destination){
                        w = p.getValue();
                    }
                }
                return w;
	}
}