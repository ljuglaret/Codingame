import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {
    

        
    public static int transforme(String s,int a , int b , int c , int d){
         int x = 0 ; 
         if(s.equals("a")){
            x =  a;
                }
            else if(s.equals("b")){
                x = b;
                }

            else if(s.equals("c")){
              x = c;
                }

            else if(s.equals("d")){
                x = d;
                }
            else  {
                x = Integer.parseInt(s);
                }
            return x;
        }
    

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        int d = in.nextInt();
        int n = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }
        
        List<String> l = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            String instruction = in.nextLine();
            l.add(instruction);
        }
        
        for(int i = 0 ;  i < n ; i++) {
            String[]t = l.get(i).split(" ");
            String op = t[0];
            String destS = t[1] ;
            int dest = 0 ;

            if (op.equals("MOV")){
                int src = transforme(t[2],a,b,c,d);    
                dest = src; 
                }
                
            else if(op.equals("ADD")){
                int src1 = transforme(t[2],a,b,c,d);
                int src2 = transforme(t[3],a,b,c,d);
                dest = src1+src2;

                }
            else if (op.equals("SUB")){
               int src1 = transforme(t[2],a,b,c,d);
                int src2 = transforme(t[3],a,b,c,d);
                dest = src1 - src2;
                }
            else if (op.equals("JNE")){
                int src1 = transforme(t[2],a,b,c,d);
                int src2 = transforme(t[3],a,b,c,d);
                if (src1!=src2){
                     i = Integer.parseInt(t[1]) - 1 ;
                 
                    }
                
                }
            if(destS.equals("a")){
                a = dest;
               l.add(dest + " " + b + " "+ c+ " " + d);
                }
            else if(destS.equals("b")){
                b = dest;
                l.add(a + " " + dest + " "+ c+ " " + d);
                }

            else if(destS.equals("c")){
                c = dest;
                l.add(a + " " + b + " "+ dest + " " + d);
                }

            else if(destS.equals("d")){
                d = dest;
                l.add(a + " " + b + " "+ c+ " " + dest);
                }
        System.err.println(a + " " + b + " "+ c+ " " + d);
        }
        
        int taille =l.size() - 1;
        System.out.print(l.get(taille));

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

    }
}