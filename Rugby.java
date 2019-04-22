class Rugby {

    public static void main(String[] args){
        int N = 88;
        for (int i = 0 ; i<= N/5 ; i++){
          for (int j = 0 ; j <= i; j++){
            for(int  k = 0 ; k <= N/3 ; k++){
                if(5*i + 2*j + 3*k == N){
                    System.out.println(i+" "+j+ " "+k);
                }
                    
            }

        }
    }
}

}



