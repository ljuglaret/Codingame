import java.util.*;
import java.io.*;
import java.math.*;




/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {


public static int sum(ArrayList<Integer> l){
    int s = 0 ; 
    for (int e : l){
        s= s+e;
        }
    return s;
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int sc  = (n * n)*(n*n + 1) / (2 * n );
        int somme;
        ArrayList<Integer> lignes=new ArrayList<Integer>();
       int diag1 =  0;
       int diag2 =  0;
       int[]colonnes= new int[n];
        for (int i = 0; i < n; i++) {
            somme = 0  ;
            for (int j = 0; j < n; j++) {
                int c = in.nextInt();
                somme = somme + c;
               if(i == j ){
                   diag1 = diag1 + c; 
                   }
            
                if(j == n - i - 1){
                    diag2= diag2 + c;
                           

                }
                
           
               
                colonnes[j] =colonnes[j]+  c ; 
                }
            
            
            

             lignes.add(somme);
        }
        




boolean mag = (diag1 == sc) && (diag2 == sc);

   for (int l : lignes){
       if (l !=sc){
               mag =  false;
             }
       }
   for (int c : colonnes){
       if (c !=sc){
               mag =   false;
             }
       }
       
       
        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        if (mag){
        System.out.println("MAGIC");
        }
        else {
            System.out.println("MUGGLE");
            }
    }
}
