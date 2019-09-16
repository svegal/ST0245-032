/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorios;
import java.util.*;
import java.io.*;
/**
 *
 * @author isabellaqv
 */
public class OnlineExercises3 {
    
    public static void main(String[] args){
        //Punto 2.1
        try{
        //Archivo de texto que será modificado
        String loc = "BrokenKeyboard.txt";
        Scanner cns = new Scanner(new File(loc));
        do{
            String line = cns.nextLine();
            keyboard(line);
            System.out.println();
        }while(cns.hasNextLine());
        }catch(FileNotFoundException e){
            System.out.println("El archivo no existe");
        }
        //Punto 2.4
        String s1 = "{[()]}";
        System.out.println(s1 + " " + balanceBrackets(s1));
        String s2 = "{[(])}";
        System.out.println(s2 + " " + balanceBrackets(s2));
        String s3 = "{{[[(())]]}}";
        System.out.println(s3 + " " + balanceBrackets(s3));
    }

    //Punto 2.1
    public static void keyboard(String a){
        LinkedList<Character> text = new LinkedList<>();
        boolean e = false;
        int cont = 0;
        for(int i = 0 ; i < a.length() ; i++){
            char c = a.charAt(i);
                if(c == '[' && i < a.length()-1){
                    e = true;
                    i++;
                    cont=0;
                }if(c == ']' && i < a.length()-1){
                    e = false;
                    i++;
                }
            if(e){
                text.add(cont, a.charAt(i));
                cont++;
            }else{
                text.add(a.charAt(i));
            }
        }
        LinkedList<Character> ans = new LinkedList<>();
        int i = 0;
        while(text.size()>0){
            char c = text.remove(i);
            if(c != '[' && c != ']') ans.add(c);
        }
        for(char c: ans){
            System.out.print(c);
        }
    }
    //Punto 2.4
    public static String balanceBrackets(String word){
        boolean b = true;
        Queue<Character> word2 = new LinkedList();
        for(int i = 0 ; i < word.length()/2 ; i++){
            if(word.charAt(i) == '{') word2.offer('}');
            if(word.charAt(i) == '[') word2.offer(']');
            if(word.charAt(i) == '(') word2.offer(')');
        }
        int j = word.length()-1;
        while(word2.size()>0){
            char c = word2.poll();
            if(word.charAt(j) != c){
                b = false;
                break;
            }
            j--;
        }
        if(b){
            return "YES";
        }
            return "NO";
        
    }
}
