
/**
 * 
 * @author (Isabella Quintero, Sofia Vega) 
 * @version (27/08/19)
 */
public class Lista {
  public Nodo elPrimerElementoDeLaLista; //head 
  public int size;
  public Lista(){
     elPrimerElementoDeLaLista = null;
     size = 0;
  }
  private String toString(Nodo nodo){
     if (nodo == null) return "]"; 
     else return nodo.dato + "," + 
          toString(nodo.elSiguienteDespuesDeMi);
  }
  @Override
  public String toString(){
     return "["+toString(elPrimerElementoDeLaLista);
  }
  public void  insertarAlPrincipio(int e){
    Nodo nuevo = new Nodo(e);
    nuevo.elSiguienteDespuesDeMi = elPrimerElementoDeLaLista;
    elPrimerElementoDeLaLista = nuevo;
    size++;
  }
  public void eliminarAlPrincipio( ){
      elPrimerElementoDeLaLista = elPrimerElementoDeLaLista.elSiguienteDespuesDeMi;
      
  }
    private Nodo get(int i){
    Nodo temporal = elPrimerElementoDeLaLista;
    for (int j = 1; j <= i; j++)
      temporal = temporal.elSiguienteDespuesDeMi;
    return temporal;
  }
    private int posicion (Nodo n, int loQueBusco){
        int i=0;
        while(n != null){
            if (n.dato == loQueBusco){
                return i;
            }
            n = n.elSiguienteDespuesDeMi;
            i++;
        }
        return -1;
    }
    /**
     * La complejidad de agregar un elemento en una posición dada es de O(n)
     */
   public void insertar(int e, int p){
       
       if(p == 0){
           insertarAlPrincipio(e);
       }
       Nodo nuevo = new Nodo(e);
       Nodo Imenos1 = get(p-1);
       nuevo.elSiguienteDespuesDeMi = Imenos1.elSiguienteDespuesDeMi;
       Imenos1.elSiguienteDespuesDeMi  = nuevo;
   }
   public void eliminar(int p){
       if(p == 0){
           eliminarAlPrincipio();
       }
       Nodo aEliminar = get(p-1);
       aEliminar.elSiguienteDespuesDeMi = get(p+1);
   }
}