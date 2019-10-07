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
import java.util.ArrayList;
public class Laboratory4 {
    public static NodeDirectory root;
    
    public Laboratory4(NodeDirectory r){
        Laboratory4.root = r;
    }
    
    public void addFile(NodeDirectory d, NodeDirectory n){
         if(d==null){
             d = n;
         }
         else{
             addFileAux(d, n);
         }
    }
    private void addFileAux(NodeDirectory n, NodeDirectory toAdd){
            n.elements.add(toAdd);
    }
    
    public void search(String name){
        if(searchAux(root, name) != null){
            System.out.println(searchAux(root,name).file);
        }else{
            System.out.println("No such file or directory");
        }
    }
    public NodeDirectory searchAux(NodeDirectory n, String name){
        while(n != null){
            if(n.file.equals(name)){
                return n;
            }else if(!n.elements.isEmpty()){
                n.elements.forEach((s) -> {
                    searchAux(s, name);
                });
            }
        }
        return null;
    }
    
    public ArrayList<String> searchByAuthor(NodeDirectory n, String a){
        ArrayList<String> answer = new ArrayList();
        while(n != null){
            if(n.author.equals(a)){
                answer.add(n.file);
            }
            else if(!n.elements.isEmpty()){
                n.elements.forEach((i) -> {
                    searchByAuthor(i,a);
                });
            }
        }
        return answer;
    }
    
    public ArrayList<String> searchBySize(NodeDirectory n, double s){
        ArrayList<String> answer = new ArrayList();
        while(n != null){
            if(n.size >= s){
                answer.add(n.file);
            }
            else if(!n.elements.isEmpty()){
                n.elements.forEach((i) -> {
                    searchBySize(i,s);
                });
            }
        }
        return answer;
    }
    
    public void printFiles(NodeDirectory a){
        System.out.println(a.toString());
        if(!a.elements.isEmpty()){
            a.elements.forEach((n) -> {
                printFiles(n);
            });
        }
    }
}
