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
public class NodeDirectory {
    public String file;
    public double size;
    public String author;
    public ArrayList<NodeDirectory> elements;
    public NodeDirectory(String f, double s, String a){
        this.file = f;
        this.size = s;
        this.author = a;
    }

    @Override
    public String toString() {
        return file + "[" + size + " - " + author + "]}";
    }
    
}
