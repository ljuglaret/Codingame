import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {
    public static String ISBN10(String s){
        int somme = 0 ;
        int base = 10;
        for (int i = 0 ; i< s.length();i++){
            char temp = s.charAt(i);
            int x = Character.getNumericValue(temp);
            somme  = somme  + x*base;

            base = base - 1 ;
        }
        String fin =""; 
        if(somme%11 == 0){
            fin="0";
        }
         else if(11 - (somme % 11)==10){
            fin="X";
        }
        else{
            fin = Integer.toString(11 - (somme % 11));
        }
    return s+fin;
    }


    public static String ISBN13(String s){
        int somme = 0 ;
        for (int i = 0 ; i< s.length();i++){
            char temp = s.charAt(i);
            int x = Character.getNumericValue(temp);
            if(i%2==0){
                somme = somme + x;
            }
            else{
                somme  = somme  + x*3;
            }
        }
String fin = "";
        if(somme%10 == 0){
            fin="0";
        }
        
        else{
            fin = Integer.toString(10 - somme % 10);
        }

    return s+fin;
    }


    public static boolean valide(String s ){
        boolean rep = true;
        for (int i = 0; i<s.length() - 1 ; i++){
            if(!Character.isDigit(s.charAt(i))){
                rep  = false;
            }
        }
        return rep;
    }

    

    public static void main(String args[]) {
        List<String> Tabisb= new ArrayList<String>();

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }
        for (int i = 0; i < N; i++) {
            String ISBN = in.nextLine();
            Tabisb.add(ISBN);
        }
        List<String> listInvalide = new ArrayList<String>();
        int invalide = 0 ; 
        for(String isb : Tabisb){
        boolean cond1 =isb.equals(ISBN10(isb.substring(0, isb.length()-1)))&& isb.length() == 10;
        
        boolean cond2 = isb.equals(ISBN13(isb.substring(0, isb.length()-1)))&& isb.length() == 13;
        boolean cond3 = valide(isb);


        if(!cond1 && !cond2 || !cond3 ) {
            listInvalide.add(isb);
            invalide ++;
        }
        }
    
    System.out.println(invalide+ " invalid:" );
    for(String s : listInvalide){
        System.out.println(s);

    }
        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

    }
}