/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorios;

/**
 *
 * @author isabellaqv
 */
import java.io.*;
import java.util.*;
public class OnlineExercises5 {
    
    public static void main (String [] args){
        OnlineExercises5 ex = new OnlineExercises5();
        DigraphAM graph1 = new DigraphAM(3);
        graph1.addArc(0, 1, 1);
        graph1.addArc(1, 2, 1);
        graph1.addArc(2, 0, 1);
        boolean ans1 = ex.isBipartite(graph1, 0, 3);
        if(ans1) System.out.println("BICOLORABLE");
        else System.out.println("NOT BICOLORABLE");
        DigraphAM graph2 = new DigraphAM(3);
        graph2.addArc(0, 1, 1);
        graph2.addArc(1, 2, 1);
        boolean ans2 = ex.isBipartite(graph2, 0, 3);
        if(ans2) System.out.println("BICOLORABLE");
        else System.out.println("NOT BICOLORABLE");
        DigraphAM graph3 = new DigraphAM(9);
        graph3.addArc(0, 1, 1);
        graph3.addArc(0, 2, 1);
        graph3.addArc(0, 3, 1);
        graph3.addArc(0, 4, 1);
        graph3.addArc(0, 5, 1);
        graph3.addArc(0, 6, 1);
        graph3.addArc(0, 7, 1);
        graph3.addArc(0, 8, 1);
        boolean ans3 = ex.isBipartite(graph3, 0, 9);
        if(ans3) System.out.println("BICOLORABLE");
        else System.out.println("NOT BICOLORABLE");
    }
    
    // This function returns true if  
    // graph G[V][V] is Bipartite, else false 
    boolean isBipartite(DigraphAM g,int src, int V) 
    { 
        // Create a color array to store  
        // colors assigned to all veritces. 
        // Vertex number is used as index  
        // in this array. The value '-1' 
        // of colorArr[i] is used to indicate  
        // that no color is assigned 
        // to vertex 'i'. The value 1 is  
        // used to indicate first color 
        // is assigned and value 0 indicates  
        // second color is assigned. 
        int colorArr[] = new int[V]; 
        for (int i=0; i<V; ++i) 
            colorArr[i] = -1; 
  
        // Assign first color to source 
        colorArr[src] = 1; 
  
        // Create a queue (FIFO) of vertex numbers  
        // and enqueue source vertex for BFS traversal 
        LinkedList<Integer>q = new LinkedList<Integer>(); 
        q.add(src); 
  
        // Run while there are vertices in queue (Similar to BFS) 
        while (q.size() != 0) 
        { 
            // Dequeue a vertex from queue 
            int u = q.poll(); 
  
            // Return false if there is a self-loop  
            if (g.getWeight(u, u) == 1) 
                return false;  
  
            // Find all non-colored adjacent vertices 
            for (int v=0; v<V; ++v) 
            { 
                // An edge from u to v exists  
                // and destination v is not colored 
                if (g.getWeight(u, v)==1 && colorArr[v]==-1) 
                { 
                    // Assign alternate color to this adjacent v of u 
                    colorArr[v] = 1-colorArr[u]; 
                    q.add(v); 
                } 
  
                // An edge from u to v exists and destination 
                //  v is colored with same color as u 
                else if (g.getWeight(u, v)==1 && colorArr[v]==colorArr[u]) 
                    return false; 
            } 
        } 
        // If we reach here, then all adjacent vertices can 
        // be colored with alternate color 
        return true; 
    } 
}
