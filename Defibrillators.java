  import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

//l  : longitude
// L : latitude

    public static double distance( double  la , double lb , double  La, double  Lb){
        double  x = (lb - la) * Math.cos((La + Lb) /2);
        double  y = (Lb - La);
        return (double)(Math.sqrt(x*x + y*y)*6371);
        }
    
    public static void main(String args[]) {

        Scanner in = new Scanner(System.in);
        String LON = in.next();
        String LAT = in.next();
        int N = in.nextInt();
        double mini = Double.MAX_VALUE;
        String lieu = "";
        if (in.hasNextLine()) {
            in.nextLine();
        }
        for (int i = 0; i < N; i++) {
            String s = in.nextLine();   
      
            double  l = Double.parseDouble( (s.split(";")[4]).replace(',', '.') )  ;
            double  L = Double.parseDouble( (s.split(";")[5]).replace(',', '.') )  ;
			double Lon = Double.parseDouble(LON.replace(',', '.'))   ;
            double Lat = Double.parseDouble(LAT.replace(',', '.'))  ;
             double  ecart = distance(Lon,l,Lat,L);
                if (ecart < mini){
                    mini = ecart ; 
                    lieu = s.split(";")[1];
                }
           }
        System.out.println(lieu);
    }
}

    

        
