public class butterfly {
     public static void main(String[] args) {
        int n=9;
        int m= n*2;

        for( int i=1 ;i<=n;i++){
            for (int j=1 ;j<=m;j++){
                if(j<=i || j>m-i)
                    System.out.print("* ");
                else 
                    System.out.print("  ");
            }
            System.out.println();
        }
        for( int i=n ;i>=1;i--){
            for (int j=1 ;j<=m;j++){
                if(j<=i || j>m-i)
                    System.out.print("* ");
                else 
                    System.out.print("  ");
            }
            System.out.println();
        }
     }
}

   