import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Temperatures {

    public static int mini(List<Integer> t) {
        int m = t.get(0);
        for(int i= 1 ; i< t.size() ; i++) {
            if (t.get(i)<m){
                m=t.get(i);
            }
        }
        return m;
    }

    
   public static int maxi(List<Integer> t) {
        int m = t.get(0);
        for(int i= 1 ; i< t.size(); i++) {
            if (t.get(i)>m){
                m=t.get(i);
            }
        }
        return m;
    }

    public static void aff(List<Integer> t) {
        for(int e : t) {
            System.out.print(e + " ");
        }
        System.out.println();
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // the number of temperatures to analyse
        int [] x = new int[n];
        for (int i = 0; i < n; i++) {
            int t = in.nextInt(); // a temperature expressed as an integer ranging from -273 to 5526
            x[i] = t;
        }
        
             int res = 0;
        
        List<Integer> pos =  new ArrayList<Integer>(0) ;
        List<Integer> neg =  new ArrayList<Integer>(0) ;
		
		if(x.length ==  0) {
            pos.add(0);
            neg.add(0);
        }

        else {
			for (int i = 0 ; i< n ; i ++) {
				if (x[i]>=0) {
					pos.add(x[i]);
				}
				else {
					neg.add(x[i]);
				}
			}
		}
        
    
     
		if (pos.size()!=0 && neg.size()!=0){

            int gn = maxi(neg);
            int pp = mini(pos);
            
            if( gn - pp == 0){
                res = pp;
            }

            else{
                if (pp+gn>0){
                    res = maxi(neg);
                }
                else {
                    res = mini(pos);
                }
            }
        }

        else {
            if (pos.size()==0) {res = maxi(neg); }
            if (neg.size()==0) {res = mini(pos);}
     
        }
            System.out.println(res);
        }
    }  