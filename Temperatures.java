import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Temperatures {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // the number of temperatures to analyse
        int [] x = new int[n];
        for (int i = 0; i < n; i++) {
            int t = in.nextInt(); // a temperature expressed as an integer ranging from -273 to 5526
            x[i] = t;
        }
        
       int res = 0;
        if(n == 0){
            res = 0 ; 
        }   
        else{
            if (n==1){
                res = x[0];
            }
            else{
                int mini = 6000 ; 
                for(int i = 0 ; i < x.length  ; i++){
                    int temp = Math.abs(x[i]);
                    if(temp<Math.abs(mini)){
                          mini=x[i];
                    }      
                  else if(temp==Math.abs(mini)){ 
                      mini=Math.max(x[i],mini);
                }
                    
                }res=mini;
            }
        }
        System.out.println(res);
     }
}
