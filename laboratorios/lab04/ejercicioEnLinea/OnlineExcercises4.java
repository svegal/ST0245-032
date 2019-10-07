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
import java.util.*;
import java.io.*;
public class OnlineExcercises4 {
    public static void main(String [] args){
        try{
            String loc = "PreorderTree.txt";
            Scanner console = new Scanner(new File(loc));
            Tree example = new Tree();
            while(console.hasNextLine()){
                int d = Integer.valueOf(console.nextLine());
                example.insertar(d);
            }
            print(example.root);
            System.out.println();
            posOrder(example.root);
            
        }
        catch(FileNotFoundException e){
            System.out.println("el archivo no existe");
        }
    }
    public static void print(Node n){
        if(n != null){
            System.out.println(n.data);
            print(n.left);
            print(n.right);
        }
    } 
    public static void posOrder(Node n){
        if(n != null){
            posOrder(n.left);
            posOrder(n.right);
            System.out.println(n.data);
        }
    }
}
