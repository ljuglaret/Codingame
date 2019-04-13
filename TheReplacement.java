import java.util.*;
import java.io.*;
import java.math.*;
import java.lang.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {


    public static void aff(List<String> l){
            for(String s : l){
                System.out.println(s);
                }
        }

    
    public static List<String> sansDoublons(List<String>l){
         Set set = new HashSet() ;
        set.addAll(l) ;
        List distinctList = new ArrayList(set) ;
        return distinctList ;
        }
    

    public static List<String> comparer(List<String> l1 , List<String> l2){
       List<String> l3 = new ArrayList<String>();
        for (int i = 0 ; i < l1.size();i++){
            if (l2.contains(l1.get(i))){
                l3.add(l1.get(i));
                String a = l1.get(i);
                l1.removeIf(x -> x.equals(a));
                }
            }
            return l3;
        }


    public static boolean pasUneFonction(List<Character> invar, List<Character>vari){
        boolean b = false;
            for (char elt : invar){
                for(char elt2 :vari){
                if(elt == elt2){
                    b = true;
                    }
                }
            }
            
        return b;
        
        }


    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        
        
        String X = in.nextLine();
        String Y = in.nextLine();
        
        char[] tX = new char[X.length()];
        char[] tY = new char[Y.length()];
        
        List<String> rep = new ArrayList<String>();
        
        boolean lettresEnCommun = false;
        List<Character> invar = new ArrayList<Character>();
        List<Character> vari = new ArrayList<Character>();
        List<Character> tAvant = new ArrayList<Character>();
        List<Character> tApres = new ArrayList<Character>();
        
        int differences = 0 ;
        
        for (int i = 0 ; i < X.length();i++){
            tX[i] = X.charAt(i);
            tY[i] = Y.charAt(i);
            if (tX[i] == tY[i]){invar.add(tX[i]);}
            else {vari.add(tX[i]);differences++;}

                char lettreAvant = tX[i];
                char lettreApres = tY[i];
                tAvant.add(lettreAvant);
                tApres.add(lettreApres);
                

            }
        
    
            if (X.equals(Y)){
                System.out.println("NONE");    
            }
            else if (pasUneFonction(invar,vari)){System.out.println("CAN'T");}
            else  {
               boolean chgtCorrect = false;
                for (int j = 0 ; j < tAvant.size();j++){
                    for(int i = 0 ; i < X.length() ; i++){
                        if (tX[i] != tY[i] && tApres.get(j)!=tAvant.get(j)){
                           chgtCorrect = tY[i]==tApres.get(j);
                          rep.add(tAvant.get(j) + "->"+tApres.get(j));
                           }
                       }
                   
                   }
                  
                   aff(comparer(rep,sansDoublons(rep)));
            }

        
        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

    }
}
