/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorios;
import java.util.TreeSet;
/**
 *
 * @author isabellaqv
 */
public class Tree {
        public Node root;
        
    /**
     * @param n el dato del nodo que se busca buscar
     * Metodo auxiliar de insetarAux.
     *
     */
    public void insertar(int n) {
        if (root == null) root = new Node(n);
        else
          insertarAux(root, n);
    }
    
    /**
	* @param node es la raíz del arbol
	* @param n el data del nodo que se busca insertar
	* nota: metodo recursivo.
	* Inserta un dato respetando claro las desigualdades en el árbol
	*/
    private void insertarAux(Node node, int n) {
      
        if(node.data == n) return;
        if(n < node.data){
            if(node.left != null){
                insertarAux(node.left, n);
            }
            else{ // Es null
                node.left = new Node(n);
            }
        }
        if(n > node.data){
             if(node.right != null){
                insertarAux(node.right, n);
            }
            else{
            node.right  = new Node(n);
            }
        }
    }
}
