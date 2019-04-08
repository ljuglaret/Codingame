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
        ArrayList<Integer> l = new ArrayList<Integer>();

        for (int i = 0; i < N; i++) {
            int pi = in.nextInt();
            l.add(pi);
        }  
        Collections.sort(l);
        int mini = Integer.MAX_VALUE;
        int ecart = 0 ;
        for (int i = 0 ; i < N - 1  ; i ++){
          
                ecart =l.get(i + 1 ) - l.get(i);
                if (ecart <= mini){
                    mini = ecart ; 
                }
            }
        
        System.out.println(mini);
    }
}
