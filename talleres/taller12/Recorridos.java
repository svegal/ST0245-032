import java.util.ArrayList;
import java.util.LinkedList;
import javafx.util.Pair;
/**
 * Write a description of class Recorridos here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Recorridos
{
    public boolean has(ArrayList<Integer> a, int b)
    {
        for(int i = 0; i<a.size(); i++){
            if (a.get(i)==b) return true;
        }
        return false;
    }

    public boolean profundidad(DigraphAL a, int b, int c){
        ArrayList<Integer> d = a.getSuccessors(b);
        if(d.size()==0)
        {
            return false; 
        }
        else if(has(d,c)) {
            return true;
        }
        else{
            for(int i = 0; i<d.size(); i++){
                profundidad(a,d.get(i),c);
            }

        }
        return false;
    }

    public boolean aux(DigraphAL a,ArrayList<Integer> b )
    {
        ArrayList<Integer> d = new ArrayList();
        boolean c = false;
        for( int i = 0; i<b.size(); i++)
        {
            d=a.getSuccessors(b.get(i));
            for(int j=0;j<b.size();j++)
            {
                if(d.contains(b.get(j))){
                    c=true;   
                }

            }
        }
        return c;
    }

    public boolean amplitud(DigraphAL a, int b, int c){
        ArrayList<Integer> d = a.getSuccessors(b);
        if(d.size()==0)
        {
            return false; 
        }
        else if(aux(a,d)) {
            return aux(a,d);
        }
        else{
          for(int i = 0; i<d.size();i++){
              amplitud(a,d.get(i),c);
            }
        }

        return false;
    }
}