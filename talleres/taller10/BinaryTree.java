/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller_10;

/**
* La clase BinaryTree intenta dar un conocimiento a los
* estudiantes acerca del manejo de un arbol binario de enteros.  
* Aquí se espera crear una estrcutura concreta del árbol binario,
* cabe aclarar que esta estrucutra ya esta implementada.
* @see <a href="https://docs.oracle.com/javase/9/docs/api/jdk/nashorn/api/tree/BinaryTree.html"> Árbol Binario</a>
* @author Mauricio Toro, Andres Paez
*
*/

public class BinaryTree {
	
	// Sirve como raíz del árbol
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
        // T(n)=T(n/2) + C Si está balanceado
        // O(log n)
        // T(n) = T(n-1) + C, es O(n)
    }

    /**
	* @param n el dato del nodo que se busca.
	* Metodo auxiliar de buscarAux.
	* @return true si el metodo buscarAux es true
	*/
    public boolean buscar(int n) {
        return buscarAux(root, n);
    }
    
	/**
	* @param node es la raíz del arbol
	* @param n el data del nodo que se busca
	* nota: metodo recursivo.
	* Inserta un dato respetando claro las desigualdades en el árbol
	* @return true si se encuentra el elemento en el árbol, false de lo contrario
	*/ 

	private boolean buscarAux(Node node, int n) {
	   if(node == null){
               return false;
           }
           if(node.data == n){
               return true;
           }
           if(n < node.data){
               return buscarAux(node.left,n);   // tgyudf55tfr5edasdfe2wT(n/2)
           }
           return buscarAux(node.right,n); // T(n/2)
           // T(n) = T(n/2) + C
           // La complejidad de este algoritmo es O(log n)
        }



    /*
	 
	 Los metodos posteriores son para imprimir el arbol de manera
	 que sirven para debuggeo
    */

	/**
	* @param node el nodo desde el cual se imprimirá
	* imprime el arbol desde el nodo node
	*/
	private void recursivePrintAUX(Node node)
	{
		if (node != null)
		{
			recursivePrintAUX(node.left);
			recursivePrintAUX(node.right);
			System.out.println(node.data);
		}
		
	}

	/**
	* Metodo auxiliar de recursivePrintAUX
	*
	*/
	public void recursivePrint()
	{
		recursivePrintAUX(root);
	}
		

	
 
}
