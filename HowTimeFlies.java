import java.util.*;
import java.io.*;
import java.math.*;
import java.text.SimpleDateFormat;  

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class HowTimeFlies  {
    
        
    public static String affichageA(int nbA){
        if (nbA == 0){
            return "";
        }
        else {
            if (nbA == 1){
                return "1 year, ";
            }
            else{
                return nbA + " years, ";
            }
        }
    }



    public static String affichageM(int nbM){
        if (nbM == 0){
            return "";
        }
        else {
            if (nbM == 1){
                return "1 month, ";
            }
            else{
                return nbM + " months, ";
            }
        }
    }


    
    
    public static String transforme(String s ){
        char s2[] = new char[s.length()];
        for (int i = 0 ; i < s.length() ; i++){
            if (s.charAt(i) == '.'){
                s2[i]= '/';
            }
            else{
                    
                    s2[i] = s.charAt(i);
                }
            
            }
        String str = new String(s2);
        return str;
        }

    public static void main(String args[]) throws Exception  {
        Scanner in = new Scanner(System.in);
        String BEGIN = in.next();
        String END = in.next();
        SimpleDateFormat formatter1=new SimpleDateFormat("dd/MM/yyyy");  
        Date date1=formatter1.parse(transforme(BEGIN));  
        Date date2=formatter1.parse(transforme(END));  
        
        GregorianCalendar gc1 = new GregorianCalendar();
        gc1.setTime(date1);
        
        
        GregorianCalendar gc2 = new GregorianCalendar();
        gc2.setTime(date2);
        
        
         long difference = gc2.getTime().getTime() - gc1.getTime().getTime();

          int diffgc = (int)(difference/(24*60*60*1000.0));
 

         int nbMois = 0;
         int DOUZE = 12;
         int UN = 1;
         while (gc1.before(gc2)) {
         gc1.add(GregorianCalendar.MONTH, UN);
         if (gc1.before(gc2) || gc1.equals(gc2)) {
         nbMois++;
     
         }
         }
         int nbAnnees = (nbMois / DOUZE);
         nbMois = (nbMois - (nbAnnees * 12));
        
  

         String sf = affichageA(nbAnnees) +affichageM(nbMois)+"total "+diffgc+" days";
         System.out.println(sf);
        }
}