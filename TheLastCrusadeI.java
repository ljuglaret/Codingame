import java.util.*;
import java.io.*;
import java.math.*;

import java.util.ArrayList;

import java.util.HashMap;

import java.util.List;

import java.util.Map;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Player {


    public static String dirige(Map<Integer,List<String>>dirSuiv, String Pos,int key){
            String c = "D";
            for (Map.Entry<Integer, List<String>> entry : dirSuiv.entrySet()) {
            //Integer key = entry.getKey();
            List<String> values = entry.getValue();
                if ((key == 2 &&  Pos.equals("LEFT")) ||
                    (key == 5 &&  Pos.equals("TOP"))||
                    (key == 6 &&  Pos.equals("LEFT"))|| 
                    (key == 11)
                    ) {
                        c = "R";
                    }
                else if ((key == 2 &&  Pos.equals("RIGHT") ||
                    (key == 4 &&  Pos.equals("TOP"))||
                    (key == 6 &&  Pos.equals("RIGHT")))||
                    (key == 10)
                    ) {
                        c = "L";
                    }
                    
            else if ((key == 4 &&  Pos.equals("RIGHT"))||
                    (key == 5 &&  Pos.equals("LEFT"))
                    ) {
                        c = "D";
                    }
            
        
            }
        return c;
        }

    
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int W = in.nextInt(); // number of columns.
        int H = in.nextInt(); // number of rows.
        if (in.hasNextLine()) {
            in.nextLine();
        }
        
        
            int LINE[][] = new int[H][W];
            for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                try {LINE[i][j] = in.nextInt();} 
                catch (Exception e) {}
            }
        }
        

        int EX = in.nextInt(); // the coordinate along the X axis of the exit (not useful for this first mission, but must be read).
        
        Map<Integer,List<String>>dirSuiv  = new HashMap<Integer, List<String>>();
                
        List<String> valSet1 = new ArrayList<String>();
        valSet1.add("N");
        dirSuiv.put(0, valSet1);
        
        
        List<String> valSet2 = new ArrayList<String>();
        valSet2.add("D");
        dirSuiv.put(1, valSet2);
        
        
        List<String> valSet3 = new ArrayList<String>();
        valSet3.add("R");
        valSet3.add("L");
        dirSuiv.put(2, valSet3);

        List<String> valSet4 = new ArrayList<String>();
        valSet4.add("D");
        dirSuiv.put(3, valSet4);
        
        List<String> valSet5 = new ArrayList<String>();
        valSet5.add("D");
        valSet5.add("L");
        dirSuiv.put(4, valSet5);

        List<String> valSet6 = new ArrayList<String>();        
        valSet6.add("D");
        valSet6.add("R");
        dirSuiv.put(5, valSet6);
        
        List<String> valSet7 = new ArrayList<String>();
        valSet7.add("R");
        valSet7.add("L");
        dirSuiv.put(6, valSet7);


        List<String> valSet8 = new ArrayList<String>();
        valSet8.add("D");
        dirSuiv.put(7, valSet8);
        
        
        List<String> valSet9 = new ArrayList<String>();
        valSet9.add("D");
        dirSuiv.put(8, valSet9);
                
        List<String> valSet10 = new ArrayList<String>();
        valSet10.add("D");
        dirSuiv.put(9, valSet10);

        List<String> valSet11 = new ArrayList<String>();
        valSet11.add("L");
        dirSuiv.put(10, valSet11);
        
        List<String> valSet12 = new ArrayList<String>();
        valSet12.add("R");
        dirSuiv.put(11, valSet12);


        List<String> valSet13 = new ArrayList<String>();
        valSet13.add("D");
        dirSuiv.put(12, valSet13);
        
        List<String> valSet14 = new ArrayList<String>();
        valSet14.add("D");
        dirSuiv.put(13, valSet14);
        

 
        
        // game loop
        while (true) {
            int XI = in.nextInt();
            int YI = in.nextInt();
            String POS = in.next();

            String x = dirige(dirSuiv,POS,LINE[YI][XI]);
            switch (x) {
                case "D": YI++; break;
                case "L": XI--; break;
                case "R": XI++; break;
            }
           
            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");


            // One line containing the X Y coordinates of the room in which you believe Indy will be on the next turn.
            System.out.println(XI+" "+YI);

        }
    }
}