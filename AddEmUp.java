import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {


    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        ArrayList<Integer> t= new ArrayList<Integer>();
        ArrayList<Integer> acc= new ArrayList<Integer>();
        ArrayList<Integer> tri = new ArrayList<Integer>();
        int s = 0 ; 
        for (int i = 0; i < N; i++) {
            int x = in.nextInt();
            t.add(x);
        }
        
        Collections.sort(t);        
        s = t.get(0) + t.get(1);
        acc.add(s);
        
       for (int j = 2; j < N ; j++ ){
            acc.add(t.get(j ));
        }
        
        Collections.sort(acc);        

            
        for (int i = 1 ; i < N - 1   ; i++) {

                acc.set(0,acc.get(1 )+ acc.get(0 ));
                s = s + acc.get(0 );

                acc.remove(acc.get(1));
                Collections.sort(acc);


         
            }

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println(s);
    }
}