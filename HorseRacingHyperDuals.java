import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static int dist(int v1 , int e1 , int v2, int e2){
        int x =  Math.abs(v2 - v1) + Math.abs(e2 - e1);
        return x;
        }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int mini = Integer.MAX_VALUE;
       
        int[] te = new int[N];
        int[] tv = new int[N];
        
        for (int i = 0; i < N; i++) {
            int V = in.nextInt();
            int E = in.nextInt();
            tv[i] = V;
            te[i] = E;
                    
        }
        
        int ind = 0;
        
        for (int i = 0 ; i < N - 1 ; i ++) {
            for (int j = i + 1 ; j < N ; j++){
            int temp = dist(tv[i], te[i], tv[j], te[j]);
            
            if (temp < mini){
                mini = temp;
            }
            
            }
        }

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println(mini);
    }
}
